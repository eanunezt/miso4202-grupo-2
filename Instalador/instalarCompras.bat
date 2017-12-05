set WORKSPACE=D:\jairo\workspace\MISO\GitHub\grupo-2\marketplace
set WILDFLY=D:\jairo\programas\wildfly-11.0.0.CR1

copy /Y "./project.properties" %WORKSPACE%\marketplace-aspectos\src\main\resources\project.properties
copy /Y "./project.properties" %WORKSPACE%\marketplace-autenticacion\src\main\resources\project.properties
copy /Y "./project.properties" %WORKSPACE%\marketplace-compras\src\main\resources\project.properties

copy /Y "./project.xml" %WORKSPACE%\marketplace-aspectos\src\main\resources\project.xml
copy /Y "./project.xml" %WORKSPACE%\marketplace-autenticacion\src\main\resources\project.xml
copy /Y "./project.xml" %WORKSPACE%\marketplace-compras\src\main\resources\project.xml

call mvn clean -f   %WORKSPACE%\pom.xml
call mvn install -f %WORKSPACE%\pom.xml

timeout 5 > NUL

del /Q %WILDFLY%\standalone\deployments\producto-basico.war
copy /Y %WORKSPACE%\marketplace-producto-compras\target\producto-compras.war %WILDFLY%\standalone\deployments\producto-compras.war
copy /Y %WORKSPACE%\marketplace-autenticacion\target\marketplace-autenticacion.war %WILDFLY%\standalone\deployments\marketplace-autenticacion.war

start cmd.exe /k %WILDFLY%\bin\standalone.bat