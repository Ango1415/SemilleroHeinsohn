@echo off
::Realizado por: Javier Arias (v 1)
::Editado por Angel Gomez (v 2)
echo "*****COMPILACION MAVEN SEMILLERO-PADRE******"
start cmd /k mvn clean install
echo Si el proyecto compilo con exito, presiona cualquier tecla...
pause >nul

cd /D "C:\wildfly-15.0.1.Final\standalone\deployments"
echo Limpiando directorio...
del /F /S /Q *.ear
del /F /S /Q *.deployed
echo Copiando .ear ...

cd C:\Users\angel\OneDrive\Escritorio\Semillero Heinsohn\semillero-hbt\semillero-padre\semillero-ear\target
copy semillero-ear-1.0-SNAPSHOT.ear C:\wildfly-15.0.1.Final\standalone\deployments
echo Ejecutando .bat ...

cd /D "C:\wildfly-15.0.1.Final\bin\"  
call standalone.bat
pause
:exit
