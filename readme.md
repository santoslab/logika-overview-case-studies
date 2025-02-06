# Logika Overview Case Studies

This repository contains the projects that were used as Logika case studies. The experiments were conducted using Sireum version 4.20240508.f1c262c so that version should be used when attempting to replicate the reported results. That version can be obtained as follows:

For Linux or macOS

```
(DIR=Sireum && export SIREUM_V=4.20250124.83153a7 && rm -fR $DIR && mkdir -p $DIR/bin && cd $DIR/bin && curl -JLso init.sh https://raw.githubusercontent.com/sireum/kekinian/$SIREUM_V/bin/init.sh && bash init.sh)
export SIREUM_HOME=$(pwd)/Sireum
export PATH=$SIREUM_HOME/bin:$PATH
```

or for Windows
```
⧉
cmd /V /C "set DIR=Sireum&& set SIREUM_V=4.20250121.1d0c4b2 && (if exist !DIR! rd /S /Q !DIR!) && md !DIR!\bin && cd !DIR!\bin && curl -JLso init.bat https://raw.githubusercontent.com/sireum/kekinian/!SIREUM_V!/bin/init.bat && init.bat"
set SIREUM_HOME=%cd%\Sireum
set PATH=%SIREUM_HOME%\bin;%PATH%
```

What follows assumes the SIREUM_HOME environmental variable has been set and that Sireum's bin directory has been added to the path.  To verify a correct installation, run Sireum from the command line by typing `sireum`.  The output should indicate a build date of `4.20240508.f1c262c`.

## Replicating the Experiments

First clone this repository

```
git clone --recursive https://github.com/santoslab/logika-overview-case-studies
cd logika-overview-case-studies
```

The following details how to run Logika on each project using the different configuration options for parallelizing **P**rogam and their contract cases, **B**ranches, and **S**MT suit calls. (+) indicates a parallelization option is enabled and (-) indicates it is disabled. Assumption satisfiability checking is enabled via ``--sat``. Reporting of verification statistics (e.g. time spent verifying the project) is enabled via ``--stats``.  Logika's default values are used for its other options (i.e. SMT validity checking configuration: cvc4,–full-quant;z3;cvc5,–full-quant; SMT satisfiability checking configuration: z3; SMT validity time/satisfiability time/resource limits: 2 sec./0.5 sec./2,000,000).


<!--entries-start-->
### SLANGRT
**-P-B-S**
```
sireum proyek logika --smt2-seq --sat --stats runtime runtime/library/shared/src/main/scala/org/sireum/AssocS.scala runtime/library/shared/src/main/scala/org/sireum/Either.scala runtime/library/shared/src/main/scala/org/sireum/IndexMap.scala runtime/library/shared/src/main/scala/org/sireum/MEither.scala runtime/library/shared/src/main/scala/org/sireum/MOption.scala runtime/library/shared/src/main/scala/org/sireum/Map.scala runtime/library/shared/src/main/scala/org/sireum/Option.scala runtime/library/shared/src/main/scala/org/sireum/Set.scala runtime/library/shared/src/main/scala/org/sireum/justification.scala
```

**+P-B-S**
```
sireum proyek logika --par --smt2-seq --sat --stats runtime runtime/library/shared/src/main/scala/org/sireum/AssocS.scala runtime/library/shared/src/main/scala/org/sireum/Either.scala runtime/library/shared/src/main/scala/org/sireum/IndexMap.scala runtime/library/shared/src/main/scala/org/sireum/MEither.scala runtime/library/shared/src/main/scala/org/sireum/MOption.scala runtime/library/shared/src/main/scala/org/sireum/Map.scala runtime/library/shared/src/main/scala/org/sireum/Option.scala runtime/library/shared/src/main/scala/org/sireum/Set.scala runtime/library/shared/src/main/scala/org/sireum/justification.scala
```

**+P-B+S**
```
sireum proyek logika --par --sat --stats runtime runtime/library/shared/src/main/scala/org/sireum/AssocS.scala runtime/library/shared/src/main/scala/org/sireum/Either.scala runtime/library/shared/src/main/scala/org/sireum/IndexMap.scala runtime/library/shared/src/main/scala/org/sireum/MEither.scala runtime/library/shared/src/main/scala/org/sireum/MOption.scala runtime/library/shared/src/main/scala/org/sireum/Map.scala runtime/library/shared/src/main/scala/org/sireum/Option.scala runtime/library/shared/src/main/scala/org/sireum/Set.scala runtime/library/shared/src/main/scala/org/sireum/justification.scala
```

**+P+B-S**
```
sireum proyek logika --par --par-branch --smt2-seq --sat --stats runtime runtime/library/shared/src/main/scala/org/sireum/AssocS.scala runtime/library/shared/src/main/scala/org/sireum/Either.scala runtime/library/shared/src/main/scala/org/sireum/IndexMap.scala runtime/library/shared/src/main/scala/org/sireum/MEither.scala runtime/library/shared/src/main/scala/org/sireum/MOption.scala runtime/library/shared/src/main/scala/org/sireum/Map.scala runtime/library/shared/src/main/scala/org/sireum/Option.scala runtime/library/shared/src/main/scala/org/sireum/Set.scala runtime/library/shared/src/main/scala/org/sireum/justification.scala
```

**+P+B+S**
```
sireum proyek logika --par --par-branch --sat --stats runtime runtime/library/shared/src/main/scala/org/sireum/AssocS.scala runtime/library/shared/src/main/scala/org/sireum/Either.scala runtime/library/shared/src/main/scala/org/sireum/IndexMap.scala runtime/library/shared/src/main/scala/org/sireum/MEither.scala runtime/library/shared/src/main/scala/org/sireum/MOption.scala runtime/library/shared/src/main/scala/org/sireum/Map.scala runtime/library/shared/src/main/scala/org/sireum/Option.scala runtime/library/shared/src/main/scala/org/sireum/Set.scala runtime/library/shared/src/main/scala/org/sireum/justification.scala
```

**Sources**

 - [AssocS.scala](https://github.com/sireum/runtime/tree/e873a59f7dfbbef4b3172d3b99766eea5fafe68f/library/shared/src/main/scala/org/sireum/AssocS.scala)
 - [Either.scala](https://github.com/sireum/runtime/tree/e873a59f7dfbbef4b3172d3b99766eea5fafe68f/library/shared/src/main/scala/org/sireum/Either.scala)
 - [IndexMap.scala](https://github.com/sireum/runtime/tree/e873a59f7dfbbef4b3172d3b99766eea5fafe68f/library/shared/src/main/scala/org/sireum/IndexMap.scala)
 - [MEither.scala](https://github.com/sireum/runtime/tree/e873a59f7dfbbef4b3172d3b99766eea5fafe68f/library/shared/src/main/scala/org/sireum/MEither.scala)
 - [MOption.scala](https://github.com/sireum/runtime/tree/e873a59f7dfbbef4b3172d3b99766eea5fafe68f/library/shared/src/main/scala/org/sireum/MOption.scala)
 - [Map.scala](https://github.com/sireum/runtime/tree/e873a59f7dfbbef4b3172d3b99766eea5fafe68f/library/shared/src/main/scala/org/sireum/Map.scala)
 - [Option.scala](https://github.com/sireum/runtime/tree/e873a59f7dfbbef4b3172d3b99766eea5fafe68f/library/shared/src/main/scala/org/sireum/Option.scala)
 - [Set.scala](https://github.com/sireum/runtime/tree/e873a59f7dfbbef4b3172d3b99766eea5fafe68f/library/shared/src/main/scala/org/sireum/Set.scala)
 - [justification.scala](https://github.com/sireum/runtime/tree/e873a59f7dfbbef4b3172d3b99766eea5fafe68f/library/shared/src/main/scala/org/sireum/justification.scala)

### OPSEM-R
**-P-B-S**
```
sireum logika verifier --smt2-seq --sat --stats logika/jvm/src/test/scala/org/sireum/logika/example/opsem.sc
```

**+P-B-S**
```
sireum logika verifier --par --smt2-seq --sat --stats logika/jvm/src/test/scala/org/sireum/logika/example/opsem.sc
```

**+P-B+S**
```
sireum logika verifier --par --sat --stats logika/jvm/src/test/scala/org/sireum/logika/example/opsem.sc
```

**+P+B-S**
```
sireum logika verifier --par --par-branch --smt2-seq --sat --stats logika/jvm/src/test/scala/org/sireum/logika/example/opsem.sc
```

**+P+B+S**
```
sireum logika verifier --par --par-branch --sat --stats logika/jvm/src/test/scala/org/sireum/logika/example/opsem.sc
```

**Sources**

 - [opsem.sc](https://github.com/sireum/logika/tree/4ca6499baa09fa9f17dfb97f6db4fbaad20cb093/jvm/src/test/scala/org/sireum/logika/example/opsem.sc)

### HAMR-R
**-P-B-S**
```
sireum logika verifier --smt2-seq --sat --stats Hamr-R/HAMR-R.sc
```

**+P-B-S**
```
sireum logika verifier --par --smt2-seq --sat --stats Hamr-R/HAMR-R.sc
```

**+P-B+S**
```
sireum logika verifier --par --sat --stats Hamr-R/HAMR-R.sc
```

**+P+B-S**
```
sireum logika verifier --par --par-branch --smt2-seq --sat --stats Hamr-R/HAMR-R.sc
```

**+P+B+S**
```
sireum logika verifier --par --par-branch --sat --stats Hamr-R/HAMR-R.sc
```

**Sources**

 - [HAMR-R.sc](Hamr-R/HAMR-R.sc)

### TCTRL
[Overview](tctrl/readme.md)


**-P-B-S**
```
sireum proyek logika --smt2-seq --sat --stats tctrl/hamr/slang tctrl/hamr/slang/src/main/component/tc/TempControlSoftwareSystem/TempControlPeriodic_p_tcproc_tempControl.scala tctrl/hamr/slang/src/main/component/tc/TempSensor/TempSensorPeriodic_p_tcproc_tempSensor.scala
```

**+P-B-S**
```
sireum proyek logika --par --smt2-seq --sat --stats tctrl/hamr/slang tctrl/hamr/slang/src/main/component/tc/TempControlSoftwareSystem/TempControlPeriodic_p_tcproc_tempControl.scala tctrl/hamr/slang/src/main/component/tc/TempSensor/TempSensorPeriodic_p_tcproc_tempSensor.scala
```

**+P-B+S**
```
sireum proyek logika --par --sat --stats tctrl/hamr/slang tctrl/hamr/slang/src/main/component/tc/TempControlSoftwareSystem/TempControlPeriodic_p_tcproc_tempControl.scala tctrl/hamr/slang/src/main/component/tc/TempSensor/TempSensorPeriodic_p_tcproc_tempSensor.scala
```

**+P+B-S**
```
sireum proyek logika --par --par-branch --smt2-seq --sat --stats tctrl/hamr/slang tctrl/hamr/slang/src/main/component/tc/TempControlSoftwareSystem/TempControlPeriodic_p_tcproc_tempControl.scala tctrl/hamr/slang/src/main/component/tc/TempSensor/TempSensorPeriodic_p_tcproc_tempSensor.scala
```

**+P+B+S**
```
sireum proyek logika --par --par-branch --sat --stats tctrl/hamr/slang tctrl/hamr/slang/src/main/component/tc/TempControlSoftwareSystem/TempControlPeriodic_p_tcproc_tempControl.scala tctrl/hamr/slang/src/main/component/tc/TempSensor/TempSensorPeriodic_p_tcproc_tempSensor.scala
```

**Sources**

 - [TempControlPeriodic_p_tcproc_tempControl.scala](tctrl/hamr/slang/src/main/component/tc/TempControlSoftwareSystem/TempControlPeriodic_p_tcproc_tempControl.scala)
 - [TempSensorPeriodic_p_tcproc_tempSensor.scala](tctrl/hamr/slang/src/main/component/tc/TempSensor/TempSensorPeriodic_p_tcproc_tempSensor.scala)
 - [TempControlPeriodic_p_Api.scala](tctrl/hamr/slang/src/main/bridge/tc/TempControlSoftwareSystem/TempControlPeriodic_p_Api.scala)
 - [TempSensorPeriodic_p_Api.scala](tctrl/hamr/slang/src/main/bridge/tc/TempSensor/TempSensorPeriodic_p_Api.scala)
 - [GUMBO__Library.scala](tctrl/hamr/slang/src/main/component/tc/TempSensor/GUMBO__Library.scala)
 - [SetPoint_i.scala](tctrl/hamr/slang/src/main/data/tc/TempControlSoftwareSystem/SetPoint_i.scala)
 - [Temperature_i.scala](tctrl/hamr/slang/src/main/data/tc/TempSensor/Temperature_i.scala)
 - [GUMBO__Library.scala](tctrl/hamr/slang/src/main/component/tc/GUMBO_Definitions/GUMBO__Library.scala)

### ISOLETTE
[Overview](isolette/readme.md)


**-P-B-S**
```
sireum proyek logika --smt2-seq --sat --stats isolette/hamr/slang isolette/hamr/slang/src/main/component/isolette/Monitor/Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm.scala isolette/hamr/slang/src/main/component/isolette/Monitor/Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface.scala isolette/hamr/slang/src/main/component/isolette/Monitor/Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode.scala isolette/hamr/slang/src/main/component/isolette/Regulate/Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source.scala isolette/hamr/slang/src/main/component/isolette/Regulate/Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface.scala isolette/hamr/slang/src/main/component/isolette/Regulate/Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode.scala
```

**+P-B-S**
```
sireum proyek logika --par --smt2-seq --sat --stats isolette/hamr/slang isolette/hamr/slang/src/main/component/isolette/Monitor/Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm.scala isolette/hamr/slang/src/main/component/isolette/Monitor/Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface.scala isolette/hamr/slang/src/main/component/isolette/Monitor/Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode.scala isolette/hamr/slang/src/main/component/isolette/Regulate/Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source.scala isolette/hamr/slang/src/main/component/isolette/Regulate/Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface.scala isolette/hamr/slang/src/main/component/isolette/Regulate/Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode.scala
```

**+P-B+S**
```
sireum proyek logika --par --sat --stats isolette/hamr/slang isolette/hamr/slang/src/main/component/isolette/Monitor/Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm.scala isolette/hamr/slang/src/main/component/isolette/Monitor/Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface.scala isolette/hamr/slang/src/main/component/isolette/Monitor/Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode.scala isolette/hamr/slang/src/main/component/isolette/Regulate/Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source.scala isolette/hamr/slang/src/main/component/isolette/Regulate/Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface.scala isolette/hamr/slang/src/main/component/isolette/Regulate/Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode.scala
```

**+P+B-S**
```
sireum proyek logika --par --par-branch --smt2-seq --sat --stats isolette/hamr/slang isolette/hamr/slang/src/main/component/isolette/Monitor/Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm.scala isolette/hamr/slang/src/main/component/isolette/Monitor/Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface.scala isolette/hamr/slang/src/main/component/isolette/Monitor/Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode.scala isolette/hamr/slang/src/main/component/isolette/Regulate/Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source.scala isolette/hamr/slang/src/main/component/isolette/Regulate/Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface.scala isolette/hamr/slang/src/main/component/isolette/Regulate/Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode.scala
```

**+P+B+S**
```
sireum proyek logika --par --par-branch --sat --stats isolette/hamr/slang isolette/hamr/slang/src/main/component/isolette/Monitor/Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm.scala isolette/hamr/slang/src/main/component/isolette/Monitor/Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface.scala isolette/hamr/slang/src/main/component/isolette/Monitor/Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode.scala isolette/hamr/slang/src/main/component/isolette/Regulate/Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source.scala isolette/hamr/slang/src/main/component/isolette/Regulate/Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface.scala isolette/hamr/slang/src/main/component/isolette/Regulate/Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode.scala
```

**Sources**

 - [Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm.scala](isolette/hamr/slang/src/main/component/isolette/Monitor/Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm.scala)
 - [Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface.scala](isolette/hamr/slang/src/main/component/isolette/Monitor/Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface.scala)
 - [Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode.scala](isolette/hamr/slang/src/main/component/isolette/Monitor/Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode.scala)
 - [Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source.scala](isolette/hamr/slang/src/main/component/isolette/Regulate/Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source.scala)
 - [Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface.scala](isolette/hamr/slang/src/main/component/isolette/Regulate/Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface.scala)
 - [Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode.scala](isolette/hamr/slang/src/main/component/isolette/Regulate/Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode.scala)
 - [Manage_Alarm_impl_Api.scala](isolette/hamr/slang/src/main/bridge/isolette/Monitor/Manage_Alarm_impl_Api.scala)
 - [Manage_Monitor_Interface_impl_Api.scala](isolette/hamr/slang/src/main/bridge/isolette/Monitor/Manage_Monitor_Interface_impl_Api.scala)
 - [Manage_Monitor_Mode_impl_Api.scala](isolette/hamr/slang/src/main/bridge/isolette/Monitor/Manage_Monitor_Mode_impl_Api.scala)
 - [Manage_Heat_Source_impl_Api.scala](isolette/hamr/slang/src/main/bridge/isolette/Regulate/Manage_Heat_Source_impl_Api.scala)
 - [Manage_Regulator_Interface_impl_Api.scala](isolette/hamr/slang/src/main/bridge/isolette/Regulate/Manage_Regulator_Interface_impl_Api.scala)
 - [Manage_Regulator_Mode_impl_Api.scala](isolette/hamr/slang/src/main/bridge/isolette/Regulate/Manage_Regulator_Mode_impl_Api.scala)

### HARDENS
[Overview](hardens/readme.md)


**-P-B-S**
```
sireum proyek logika --smt2-seq --sat --stats hardens/hamr/slang hardens/hamr/slang/src/main/component/RTS/Actuation/Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator.scala hardens/hamr/slang/src/main/component/RTS/Actuation/Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic.scala
```

**+P-B-S**
```
sireum proyek logika --par --smt2-seq --sat --stats hardens/hamr/slang hardens/hamr/slang/src/main/component/RTS/Actuation/Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator.scala hardens/hamr/slang/src/main/component/RTS/Actuation/Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic.scala
```

**+P-B+S**
```
sireum proyek logika --par --sat --stats hardens/hamr/slang hardens/hamr/slang/src/main/component/RTS/Actuation/Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator.scala hardens/hamr/slang/src/main/component/RTS/Actuation/Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic.scala
```

**+P+B-S**
```
sireum proyek logika --par --par-branch --smt2-seq --sat --stats hardens/hamr/slang hardens/hamr/slang/src/main/component/RTS/Actuation/Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator.scala hardens/hamr/slang/src/main/component/RTS/Actuation/Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic.scala
```

**+P+B+S**
```
sireum proyek logika --par --par-branch --sat --stats hardens/hamr/slang hardens/hamr/slang/src/main/component/RTS/Actuation/Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator.scala hardens/hamr/slang/src/main/component/RTS/Actuation/Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic.scala hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic.scala
```

**Sources**

 - [Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator.scala](hardens/hamr/slang/src/main/component/RTS/Actuation/Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator.scala)
 - [Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator.scala](hardens/hamr/slang/src/main/component/RTS/Actuation/Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator.scala)
 - [CoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic.scala](hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic.scala)
 - [CoincidenceLogic_i_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic.scala](hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic.scala)
 - [CoincidenceLogic_i_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic.scala](hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic.scala)
 - [CoincidenceLogic_i_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic.scala](hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic.scala)
 - [CoincidenceLogic_i_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic.scala](hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic.scala)
 - [CoincidenceLogic_i_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic.scala](hardens/hamr/slang/src/main/component/RTS/Actuation/CoincidenceLogic_i_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic.scala)
 - [OrLogic_i_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic.scala](hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic.scala)
 - [OrLogic_i_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic.scala](hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic.scala)
 - [OrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic.scala](hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic.scala)
 - [OrLogic_i_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic.scala](hardens/hamr/slang/src/main/component/RTS/Actuation/OrLogic_i_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic.scala)
 - [Actuator_i_Api.scala](hardens/hamr/slang/src/main/bridge/RTS/Actuation/Actuator_i_Api.scala)
 - [CoincidenceLogic_i_Api.scala](hardens/hamr/slang/src/main/bridge/RTS/Actuation/CoincidenceLogic_i_Api.scala)
 - [OrLogic_i_Api.scala](hardens/hamr/slang/src/main/bridge/RTS/Actuation/OrLogic_i_Api.scala)

### LMAADLQ
**-P-B-S**
```
sireum logika verifier --smt2-seq --sat --stats LmAadlQ/LMAadlQ.sc
```

**+P-B-S**
```
sireum logika verifier --par --smt2-seq --sat --stats LmAadlQ/LMAadlQ.sc
```

**+P-B+S**
```
sireum logika verifier --par --sat --stats LmAadlQ/LMAadlQ.sc
```

**+P+B-S**
```
sireum logika verifier --par --par-branch --smt2-seq --sat --stats LmAadlQ/LMAadlQ.sc
```

**+P+B+S**
```
sireum logika verifier --par --par-branch --sat --stats LmAadlQ/LMAadlQ.sc
```

**Sources**

 - [LMAadlQ.sc](LmAadlQ/LMAadlQ.sc)
<!--entries-end-->
