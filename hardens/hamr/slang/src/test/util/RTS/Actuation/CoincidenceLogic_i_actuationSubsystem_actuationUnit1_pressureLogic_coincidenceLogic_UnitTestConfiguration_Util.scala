// #Sireum

package RTS.Actuation

// Do not edit this file as it will be overwritten if HAMR codegen is rerun

import org.sireum._
import RTS.GumboXUtil.GumboXResult
import RTS.util.{Container, Profile, UnitTestConfigurationBatch}
import RTS.RandomLib
import org.sireum.Random.Impl.Xoshiro256

object CoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_UnitTestConfiguration_Util {

  def freshRandomLib: RandomLib = {
    return RandomLib(Random.Gen64Impl(Xoshiro256.create))
  }

  def defaultComputeConfig: CoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_Compute_UnitTestConfiguration = {
    return (CoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_Compute_UnitTestConfiguration (
      verbose = F,
      name = "Default_Compute_Config",
      description = "Default Compute Configuration",
      numTests = 100,
      numTestVectorGenRetries = 100,
      failOnUnsatPreconditions = F,
      profile = CoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_Profile_P (
        name = "Compute_Default_Profile", // needed for old framework
        numTests = 100, // needed for old framework
        numTestVectorGenRetries = 100, // needed for old framework,
        api_channel1 = freshRandomLib,
        api_channel2 = freshRandomLib,
        api_channel3 = freshRandomLib,
        api_channel4 = freshRandomLib
      ),
      genReplay = (c: Container, r: GumboXResult.Type) => Some(
        st"""val testVector = RTS.JSON.toActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_PreState_Container_P(json).left
            |assert (testComputeCBV(testVector) == results)""".render))
    )
  }
}

@record class CoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_Compute_UnitTestConfiguration (
  var verbose: B,
  var name: String,
  var description: String,
  var numTests: Z,
  var numTestVectorGenRetries: Z,
  var failOnUnsatPreconditions: B,
  var profile: CoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_Profile_P_Trait,
  var genReplay: (Container, GumboXResult.Type) => Option[String])
  extends UnitTestConfigurationBatch with CoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_GumboX_TestHarness {

  override def test(c: Container): GumboXResult.Type = {
    return testComputeCBV(c.asInstanceOf[CoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_PreState_Container_P])
  }
}
