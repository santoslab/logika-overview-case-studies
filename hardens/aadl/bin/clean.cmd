::#! 2> /dev/null                                   #
@ 2>/dev/null # 2>nul & echo off & goto BOF         #
if [ -z ${SIREUM_HOME} ]; then                      #
  echo "Please set SIREUM_HOME env var"             #
  exit -1                                           #
fi                                                  #
exec ${SIREUM_HOME}/bin/sireum slang run "$0" "$@"  #
:BOF
setlocal
if not defined SIREUM_HOME (
  echo Please set SIREUM_HOME env var
  exit /B -1
)
%SIREUM_HOME%\\bin\\sireum.bat slang run "%0" %*
exit /B %errorlevel%
::!#
// #Sireum

import org.sireum._

val hamrDir = Os.slashDir.up.up / "hamr"
val slangDir = hamrDir / "slang"

val toKeep = ops.ISZOps(ISZ(
  (hamrDir / "camkes" / "settings.cmake"), // setting has custom stack sizes
  (slangDir / "bin" / "build.cmd"), // customized transpiler script
  (slangDir / "bin" / "run-logika.cmd"), // customized transpiler script
  (slangDir / "bin" / "transpile-sel4-cust.cmd"), // customized transpiler script
  (slangDir / ".idea"),
  (slangDir / "src" / "main" / "component"), // contains user code
  (slangDir / "src" / "test" / "bridge"), // contains user code
  (slangDir / "src" / "test" / "util" / "RTS" / "DSC_RecordUnsatPre.scala"),  
  (slangDir / "src" / "test" / "util" / "RTS" / "RecordUnsatPre.scala"),
  (slangDir / "src" / "test" / "util" / "RTS" / "Reporter_Ext.scala"),
))


def rec(p: Os.Path, onlyDelAutoGen: B): Unit = {
  if(p.isFile) {
    if ((!toKeep.contains(p) && !onlyDelAutoGen) || ops.StringOps(p.read).contains("Do not edit")) {
      p.remove()
      println(s"Removed file: $p")
    }
  } else {
    for (pp <- p.list) {
      rec(pp, toKeep.contains(p) || onlyDelAutoGen)
    }
    if (p.list.isEmpty) {
      p.removeAll()
      println(s"Removed empty directory: $p")
    }
  }
}
rec(hamrDir, F)

