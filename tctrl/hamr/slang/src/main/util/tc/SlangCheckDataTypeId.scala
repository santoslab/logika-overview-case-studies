// #Sireum

package tc

import org.sireum._
import org.sireum.Random.Gen64

/*
GENERATED FROM

Temperature_i.scala

FanCmd.scala

FanAck.scala

SetPoint_i.scala

Base_Types.scala

GUMBO__Library.scala

GUMBO__Library.scala

TempSensorPeriodic_p_tcproc_tempSensor__Containers.scala

FanPeriodic_p_tcproc_fan__Containers.scala

TempControlPeriodic_p_tcproc_tempControl__Containers.scala

OperatorInterfacePeriodic_p_tcproc_operatorInterface__Containers.scala

Container.scala

DataContent.scala

Aux_Types.scala

*/

@enum object _artDataContent_DataTypeId {
   "_artEmpty_Id"
   "Base_TypesBits_Payload_Id"
   "Base_TypesBoolean_Payload_Id"
   "Base_TypesCharacter_Payload_Id"
   "Base_TypesFloat_32_Payload_Id"
   "Base_TypesFloat_64_Payload_Id"
   "Base_TypesFloat_Payload_Id"
   "Base_TypesInteger_16_Payload_Id"
   "Base_TypesInteger_32_Payload_Id"
   "Base_TypesInteger_64_Payload_Id"
   "Base_TypesInteger_8_Payload_Id"
   "Base_TypesInteger_Payload_Id"
   "Base_TypesString_Payload_Id"
   "Base_TypesUnsigned_16_Payload_Id"
   "Base_TypesUnsigned_32_Payload_Id"
   "Base_TypesUnsigned_64_Payload_Id"
   "Base_TypesUnsigned_8_Payload_Id"
   "CoolingFanFanAck_Payload_Id"
   "CoolingFanFanCmd_Payload_Id"
   "CoolingFanFanPeriodic_p_tcproc_fan_PostState_Container_P_Id"
   "CoolingFanFanPeriodic_p_tcproc_fan_PostState_Container_PS_Id"
   "CoolingFanFanPeriodic_p_tcproc_fan_PreState_Container_P_Id"
   "CoolingFanFanPeriodic_p_tcproc_fan_PreState_Container_PS_Id"
   "TempControlSoftwareSystemOperatorInterfacePeriodic_p_tcproc_operatorInterface_PostState_Container_P_Id"
   "TempControlSoftwareSystemOperatorInterfacePeriodic_p_tcproc_operatorInterface_PostState_Container_PS_Id"
   "TempControlSoftwareSystemOperatorInterfacePeriodic_p_tcproc_operatorInterface_PreState_Container_P_Id"
   "TempControlSoftwareSystemOperatorInterfacePeriodic_p_tcproc_operatorInterface_PreState_Container_PS_Id"
   "TempControlSoftwareSystemSetPoint_i_Payload_Id"
   "TempControlSoftwareSystemTempControlPeriodic_p_tcproc_tempControl_PostState_Container_P_Id"
   "TempControlSoftwareSystemTempControlPeriodic_p_tcproc_tempControl_PostState_Container_PS_Id"
   "TempControlSoftwareSystemTempControlPeriodic_p_tcproc_tempControl_PreState_Container_P_Id"
   "TempControlSoftwareSystemTempControlPeriodic_p_tcproc_tempControl_PreState_Container_PS_Id"
   "TempSensorTempSensorPeriodic_p_tcproc_tempSensor_PostState_Container_P_Id"
   "TempSensorTempSensorPeriodic_p_tcproc_tempSensor_PostState_Container_PS_Id"
   "TempSensorTempSensorPeriodic_p_tcproc_tempSensor_PreState_Container_P_Id"
   "TempSensorTempSensorPeriodic_p_tcproc_tempSensor_PreState_Container_PS_Id"
   "TempSensorTemperature_i_Payload_Id"
   "utilEmptyContainer_Id"
}

@enum object CoolingFanFanPeriodic_p_tcproc_fan_PreState_Container_DataTypeId {
   "CoolingFanFanPeriodic_p_tcproc_fan_PreState_Container_P_Id"
   "CoolingFanFanPeriodic_p_tcproc_fan_PreState_Container_PS_Id"
}

@enum object CoolingFanFanPeriodic_p_tcproc_fan_PostState_Container_DataTypeId {
   "CoolingFanFanPeriodic_p_tcproc_fan_PostState_Container_P_Id"
   "CoolingFanFanPeriodic_p_tcproc_fan_PostState_Container_PS_Id"
}

@enum object TempControlSoftwareSystemOperatorInterfacePeriodic_p_tcproc_operatorInterface_PreState_Container_DataTypeId {
   "TempControlSoftwareSystemOperatorInterfacePeriodic_p_tcproc_operatorInterface_PreState_Container_P_Id"
   "TempControlSoftwareSystemOperatorInterfacePeriodic_p_tcproc_operatorInterface_PreState_Container_PS_Id"
}

@enum object TempControlSoftwareSystemOperatorInterfacePeriodic_p_tcproc_operatorInterface_PostState_Container_DataTypeId {
   "TempControlSoftwareSystemOperatorInterfacePeriodic_p_tcproc_operatorInterface_PostState_Container_P_Id"
   "TempControlSoftwareSystemOperatorInterfacePeriodic_p_tcproc_operatorInterface_PostState_Container_PS_Id"
}

@enum object TempControlSoftwareSystemTempControlPeriodic_p_tcproc_tempControl_PreState_Container_DataTypeId {
   "TempControlSoftwareSystemTempControlPeriodic_p_tcproc_tempControl_PreState_Container_P_Id"
   "TempControlSoftwareSystemTempControlPeriodic_p_tcproc_tempControl_PreState_Container_PS_Id"
}

@enum object TempControlSoftwareSystemTempControlPeriodic_p_tcproc_tempControl_PostState_Container_DataTypeId {
   "TempControlSoftwareSystemTempControlPeriodic_p_tcproc_tempControl_PostState_Container_P_Id"
   "TempControlSoftwareSystemTempControlPeriodic_p_tcproc_tempControl_PostState_Container_PS_Id"
}

@enum object TempSensorTempSensorPeriodic_p_tcproc_tempSensor_PreState_Container_DataTypeId {
   "TempSensorTempSensorPeriodic_p_tcproc_tempSensor_PreState_Container_P_Id"
   "TempSensorTempSensorPeriodic_p_tcproc_tempSensor_PreState_Container_PS_Id"
}

@enum object TempSensorTempSensorPeriodic_p_tcproc_tempSensor_PostState_Container_DataTypeId {
   "TempSensorTempSensorPeriodic_p_tcproc_tempSensor_PostState_Container_P_Id"
   "TempSensorTempSensorPeriodic_p_tcproc_tempSensor_PostState_Container_PS_Id"
}

@enum object utilContainer_DataTypeId {
   "CoolingFanFanPeriodic_p_tcproc_fan_PostState_Container_P_Id"
   "CoolingFanFanPeriodic_p_tcproc_fan_PostState_Container_PS_Id"
   "CoolingFanFanPeriodic_p_tcproc_fan_PreState_Container_P_Id"
   "CoolingFanFanPeriodic_p_tcproc_fan_PreState_Container_PS_Id"
   "TempControlSoftwareSystemOperatorInterfacePeriodic_p_tcproc_operatorInterface_PostState_Container_P_Id"
   "TempControlSoftwareSystemOperatorInterfacePeriodic_p_tcproc_operatorInterface_PostState_Container_PS_Id"
   "TempControlSoftwareSystemOperatorInterfacePeriodic_p_tcproc_operatorInterface_PreState_Container_P_Id"
   "TempControlSoftwareSystemOperatorInterfacePeriodic_p_tcproc_operatorInterface_PreState_Container_PS_Id"
   "TempControlSoftwareSystemTempControlPeriodic_p_tcproc_tempControl_PostState_Container_P_Id"
   "TempControlSoftwareSystemTempControlPeriodic_p_tcproc_tempControl_PostState_Container_PS_Id"
   "TempControlSoftwareSystemTempControlPeriodic_p_tcproc_tempControl_PreState_Container_P_Id"
   "TempControlSoftwareSystemTempControlPeriodic_p_tcproc_tempControl_PreState_Container_PS_Id"
   "TempSensorTempSensorPeriodic_p_tcproc_tempSensor_PostState_Container_P_Id"
   "TempSensorTempSensorPeriodic_p_tcproc_tempSensor_PostState_Container_PS_Id"
   "TempSensorTempSensorPeriodic_p_tcproc_tempSensor_PreState_Container_P_Id"
   "TempSensorTempSensorPeriodic_p_tcproc_tempSensor_PreState_Container_PS_Id"
   "utilEmptyContainer_Id"
}

