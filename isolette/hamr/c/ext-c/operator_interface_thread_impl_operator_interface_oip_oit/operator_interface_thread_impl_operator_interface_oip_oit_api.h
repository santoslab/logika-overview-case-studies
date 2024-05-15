#ifndef OPERATOR_INTERFACE_THREAD_IMPL_OPERATOR_INTERFACE_OIP_OIT_API_H
#define OPERATOR_INTERFACE_THREAD_IMPL_OPERATOR_INTERFACE_OIP_OIT_API_H

#include <all.h>

// Do not edit this file as it will be overwritten if HAMR codegen is rerun

bool api_get_regulator_status__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit(
  STACK_FRAME
  isolette_Isolette_Data_Model_Status_Type *value);

bool api_get_monitor_status__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit(
  STACK_FRAME
  isolette_Isolette_Data_Model_Status_Type *value);

bool api_get_display_temperature__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit(
  STACK_FRAME
  isolette_Isolette_Data_Model_Temp_impl value);

bool api_get_alarm_control__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit(
  STACK_FRAME
  isolette_Isolette_Data_Model_On_Off_Type *value);

void api_put_lower_desired_tempWstatus__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit(
  STACK_FRAME
  isolette_Isolette_Data_Model_TempWstatus_impl value);

void api_put_upper_desired_tempWstatus__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit(
  STACK_FRAME
  isolette_Isolette_Data_Model_TempWstatus_impl value);

void api_put_lower_alarm_tempWstatus__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit(
  STACK_FRAME
  isolette_Isolette_Data_Model_TempWstatus_impl value);

void api_put_upper_alarm_tempWstatus__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit(
  STACK_FRAME
  isolette_Isolette_Data_Model_TempWstatus_impl value);

void api_logInfo__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit(
  STACK_FRAME
  String str);

void api_logDebug__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit(
  STACK_FRAME
  String str);

void api_logError__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit(
  STACK_FRAME
  String str);

#endif
