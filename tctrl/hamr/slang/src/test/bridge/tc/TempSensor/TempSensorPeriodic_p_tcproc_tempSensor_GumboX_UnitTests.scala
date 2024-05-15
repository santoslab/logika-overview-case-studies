package tc.TempSensor

import org.sireum._
import tc.GumboXUtil.GumboXResult
import tc.util.{Container, Profile, UnitTestConfigurationBatch}
import tc.TempSensor.TempSensorPeriodic_p_tcproc_tempSensor_UnitTestConfiguration_Util._

// This file will not be overwritten so is safe to edit

class TempSensorPeriodic_p_tcproc_tempSensor_GumboX_UnitTests extends TempSensorPeriodic_p_tcproc_tempSensor_GumboX_TestHarness_ScalaTest {

  val verbose: B = F
  val failOnUnsatPreconditions: B = F

  def configs: MSZ[UnitTestConfigurationBatch] = {
    return MSZ(
      defaultInitializeConfig(verbose = verbose, failOnUnsatPreconditions = failOnUnsatPreconditions),
      defaultComputeConfig(verbose = verbose, failOnUnsatPreconditions = failOnUnsatPreconditions)
    )
  }


  for (c <- configs) {
    def next: Option[Container] = {
      try {
        return Some(c.profile.next)
      } catch {
        case e: AssertionError => // SlangCheck was unable to satisfy a datatype's filter
          return None()
      }
    }

    for (i <- 0 until c.numTests) {
      val testName = s"${c.name}_$i"

      this.registerTest(testName) {
        var retry: B = T

        var j: Z = 0
        while (j < c.numTestVectorGenRetries && retry) {
          next match {
            case Some(o) =>

              if (verbose && j > 1) {
                println(s"Retry $j:")
              }

              val results = c.test(o)

              if (verbose) {
                c.genReplay(o, results) match {
                  case Some(s) =>
                    val tq = "\"\"\""
                    println(st"""Replay Unit Test:
                                |  test("Replay: $testName") {
                                |    val results = tc.GumboXUtil.GumboXResult.$results
                                |    val json = st${tq}${tc.JSON.fromutilContainer(o, T)}${tq}.render
                                |    $s
                                |  }""".render)
                  case _ =>
                }
              }

              results match {
                case GumboXResult.Pre_Condition_Unsat =>
                case GumboXResult.Post_Condition_Fail =>
                  fail("Post condition did not hold")
                  retry = F
                case GumboXResult.Post_Condition_Pass =>
                  if (verbose) {
                    println("Success!")
                  }
                  retry = F
              }
            case _ =>

          }
          j = j + 1
        }

        if (retry) {
          if (c.failOnUnsatPreconditions) {
            fail("Unable to satisfy precondition")
          } else if (verbose) {
            cprintln(T, "Unable to satisfy precondition")
          }
        }
      }
    }
  }

  def configsToJson: String = {
    return st"[ ${(for (c <- configs) yield s"\"${c.name}|${c.description}\"", ", ")} ]".render
  }
}
