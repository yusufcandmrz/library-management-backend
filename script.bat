@echo off
setlocal

REM >>>>> ENTER YOUR KAFKA PATH BELOW <<<<<
set "KAFKA_PATH=C:\kafka_2.13-3.9.1"

REM >>>>> SET ZOOKEEPER PORT BELOW <<<<<
set "ZOOKEEPER_PORT=2181"

REM Start Zookeeper
start "" cmd /k "%KAFKA_PATH%\bin\windows\zookeeper-server-start.bat %KAFKA_PATH%\config\zookeeper.properties"

REM Wait for Zookeeper to be available on the specified port
:WAIT_FOR_ZOOKEEPER
>nul 2>&1 (
    powershell -command "try { (New-Object Net.Sockets.TcpClient('localhost', $env:ZOOKEEPER_PORT)).Close(); exit 0 } catch { exit 1 }"
)
if errorlevel 1 (
    timeout /t 1 >nul
    goto WAIT_FOR_ZOOKEEPER
)

REM Start Kafka
start "" cmd /k "%KAFKA_PATH%\bin\windows\kafka-server-start.bat %KAFKA_PATH%\config\server.properties"

endlocal
