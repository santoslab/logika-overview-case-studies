// #Sireum

package isolette.Monitor

import org.sireum._
import isolette.util.Profile
import isolette.util.EmptyContainer
import isolette.RandomLib

// Do not edit this file as it will be overwritten if HAMR codegen is rerun

// Profile for initialise entrypoint
@msig trait Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_Profile_Trait extends Profile

@record class Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_Profile (
  val name: String,
  val numTests: Z //number of tests to generate
) extends Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_Profile_Trait {

  override def next: EmptyContainer = {
    return EmptyContainer()
  }
}

// Profile with generators for incoming ports
@msig trait Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_Profile_P_Trait extends Profile {
  def api_current_tempWstatus: RandomLib // random lib for generating Isolette_Data_Model.TempWstatus_impl
  def api_interface_failure: RandomLib // random lib for generating Isolette_Data_Model.Failure_Flag_impl
  def api_internal_failure: RandomLib // random lib for generating Isolette_Data_Model.Failure_Flag_impl
}

@record class Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_Profile_P(
  val name: String,
  val numTests: Z, // number of tests to generate
  var numTestVectorGenRetries: Z, // number of test vector generation retries
  var api_current_tempWstatus: RandomLib, // random lib for generating Isolette_Data_Model.TempWstatus_impl
  var api_interface_failure: RandomLib, // random lib for generating Isolette_Data_Model.Failure_Flag_impl
  var api_internal_failure: RandomLib // random lib for generating Isolette_Data_Model.Failure_Flag_impl
  ) extends Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_Profile_P_Trait {

  override def next: Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_PreState_Container_P = {
    return (Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_PreState_Container_P (
      api_current_tempWstatus = api_current_tempWstatus.nextIsolette_Data_ModelTempWstatus_impl(),
      api_interface_failure = api_interface_failure.nextIsolette_Data_ModelFailure_Flag_impl(),
      api_internal_failure = api_internal_failure.nextIsolette_Data_ModelFailure_Flag_impl()))
  }
}

// Profile with generators for state variables and incoming ports
@msig trait Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_Profile_PS_Trait extends Profile {
  def In_lastMonitorMode: RandomLib // random lib for generating Isolette_Data_Model.Monitor_Mode
  def api_current_tempWstatus: RandomLib // random lib for generating Isolette_Data_Model.TempWstatus_impl
  def api_interface_failure: RandomLib // random lib for generating Isolette_Data_Model.Failure_Flag_impl
  def api_internal_failure: RandomLib // random lib for generating Isolette_Data_Model.Failure_Flag_impl
}

@record class Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_Profile_PS(
  val name: String,
  val numTests: Z, // number of tests to generate
  var numTestVectorGenRetries: Z, // number of test vector generation retries
  var In_lastMonitorMode: RandomLib, // random lib for generating Isolette_Data_Model.Monitor_Mode
  var api_current_tempWstatus: RandomLib, // random lib for generating Isolette_Data_Model.TempWstatus_impl
  var api_interface_failure: RandomLib, // random lib for generating Isolette_Data_Model.Failure_Flag_impl
  var api_internal_failure: RandomLib // random lib for generating Isolette_Data_Model.Failure_Flag_impl
  ) extends Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_Profile_PS_Trait {

  override def next: Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_PreState_Container_PS = {
    return (Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_PreState_Container_PS (
      In_lastMonitorMode = In_lastMonitorMode.nextIsolette_Data_ModelMonitor_ModeType(),
      api_current_tempWstatus = api_current_tempWstatus.nextIsolette_Data_ModelTempWstatus_impl(),
      api_interface_failure = api_interface_failure.nextIsolette_Data_ModelFailure_Flag_impl(),
      api_internal_failure = api_internal_failure.nextIsolette_Data_ModelFailure_Flag_impl()))
  }
}