// #Sireum

package tc.TempControlSoftwareSystem

import org.sireum._
import tc.util.Profile
import tc.util.EmptyContainer
import tc.RandomLib

// Do not edit this file as it will be overwritten if HAMR codegen is rerun

// Profile for initialise entrypoint
@msig trait OperatorInterfacePeriodic_p_tcproc_operatorInterface_Profile_Trait extends Profile

@record class OperatorInterfacePeriodic_p_tcproc_operatorInterface_Profile (
  val name: String,
  val numTests: Z //number of tests to generate
) extends OperatorInterfacePeriodic_p_tcproc_operatorInterface_Profile_Trait {

  override def next: EmptyContainer = {
    return EmptyContainer()
  }
}

// Profile with generators for incoming ports
@msig trait OperatorInterfacePeriodic_p_tcproc_operatorInterface_Profile_P_Trait extends Profile {
  def api_currentTemp: RandomLib // random lib for generating TempSensor.Temperature_i
}

@record class OperatorInterfacePeriodic_p_tcproc_operatorInterface_Profile_P(
  val name: String,
  val numTests: Z, // number of tests to generate
  var numTestVectorGenRetries: Z, // number of test vector generation retries
  var api_currentTemp: RandomLib // random lib for generating TempSensor.Temperature_i
  ) extends OperatorInterfacePeriodic_p_tcproc_operatorInterface_Profile_P_Trait {

  override def next: OperatorInterfacePeriodic_p_tcproc_operatorInterface_PreState_Container_P = {
    return (OperatorInterfacePeriodic_p_tcproc_operatorInterface_PreState_Container_P (
      api_currentTemp = api_currentTemp.nextTempSensorTemperature_i()))
  }
}

// Profile with generators for state variables and incoming ports
@msig trait OperatorInterfacePeriodic_p_tcproc_operatorInterface_Profile_PS_Trait extends Profile {
  def api_currentTemp: RandomLib // random lib for generating TempSensor.Temperature_i
}

@record class OperatorInterfacePeriodic_p_tcproc_operatorInterface_Profile_PS(
  val name: String,
  val numTests: Z, // number of tests to generate
  var numTestVectorGenRetries: Z, // number of test vector generation retries
  var api_currentTemp: RandomLib // random lib for generating TempSensor.Temperature_i
  ) extends OperatorInterfacePeriodic_p_tcproc_operatorInterface_Profile_PS_Trait {

  override def next: OperatorInterfacePeriodic_p_tcproc_operatorInterface_PreState_Container_PS = {
    return (OperatorInterfacePeriodic_p_tcproc_operatorInterface_PreState_Container_PS (
      api_currentTemp = api_currentTemp.nextTempSensorTemperature_i()))
  }
}