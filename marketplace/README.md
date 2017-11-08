Proyecto Web marketplace-parent
========================
Author: Grupo 2 - 201720_MISO4204_01
Technologies: HTML5, ANGULAR JS, JPA, EJB, JAX-RS

Summary: Proyecto CORE para una Línea de Productos de Software 

Plataforma: WildFly

Source: https://github.com/MISO4204-201720/grupo-2.git

Descripción
-----------
Este proyecto es una aplicación web con Java EE 6 para Wildfly 10.0.1 o posterior. El proyecto usa HTML5, AngularJS, Bootstrap 3, JAX-RS 1.1, EJB 3.1 y JPA 2.0. Incluye una configuración de persistencia (ExampleDS:configuración predeterminada de ejemplo de Wildfly) con soporte básico de transacciones para ayudarlo a comenzar con el desarrollo de la aplicación.

Tecnologías utilizadas
========================

HTML5
-----
Se refiere tanto a la última versión del lenguaje HTML como al conjunto de tecnologías asociadas que permiten la creación de aplicaciones web y sitios que dirigidas a varios dispositivos.

Más información en: https://developer.mozilla.org/es/docs/HTML/HTML5

Angular JS
----------
Es un framework web del lado cliente para escribir aplicaciones web dinámicas. Extiende la sintaxis HTML para eliminar la estructura del DOM, el CSS asociado y el comportamiento de los componentes que se muestran en una página. Le permite vincular eventos en los componentes declarados a la lógica de JavaScript a través del soporte de MVC en AngularJS.

Más información en: https://angularjs.org/

Bootstrap 3
-----------
Es un framework web del lado cliente para desarrollar proyectos para la web. Proporciona clases de CSS para proporcionar estilos globales y un sistema de cuadrícula, y componentes reutilizables basados en CSS y JavaScript que se pueden usar para un desarrollo web más rápido y sencillo.

Más información en: http://puntoabierto.net/blog/que-es-bootstrap-y-cuales-son-sus-ventajas

JAX-RS
------
Es la API de Java para los servicios web RESTful. Es una nueva especificación en Java EE 6. Permite a los desarrolladores de aplicaciones exponer fácilmente los servicios de Java como servicios web RESTful.


EJB 3.1
-------
Es una actualización de la especificación EJB para Java EE 6. Permite a los desarrolladores de aplicaciones crear componentes y servicios empresariales.

JPA 2.0
-------
Es una actualización de la especificación JPA para Java EE 6. Proporciona a los desarrolladores de aplicaciones una herramienta de mapeo relacional de objetos para administrar los datos relacionales.

Requerimientos de sistemas
--------------------------

 - Java 7.0 (Java SDK 1.7) o superior.
 - Maven 3.1 o superior.
 - Servidor de aplicaciones WildFly 10.1.0 o superior.

La aplicación está diseñada para ejecutarse en JBoss WildFly.
Video de instalación en Windows.
-- https://www.youtube.com/watch?v=8HUFaL--SwI

 
Configuración Maven
-------------------


1. Vaya a Apache [Maven Project - Descargue Maven](http://maven.apache.org/download.cgi)  y descargue la última distribución para su sistema operativo.
2. Consulte la documentación de Maven para obtener información sobre cómo descargar e instalar Apache Maven para su sistema operativo.


Despliegue y construccion de la aplicación
==========================================

Inicie JBoss WildFly con el perfil web
-------------------------
JBOSS_HOME: directorio raíz del servidor WildFly

1. Abra una lánea de comandos y navegue hasta la raíz del directorio del servidor JBoss.
2. A continuación, se muestra la lánea de comando para iniciar el servidor con el perfil web (Ejecutela):

        Para Linux:   JBOSS_HOME/bin/standalone.sh
        PAra Windows: JBOSS_HOME\bin\standalone.bat

 
Construcción de la aplicación
-------------------------

_NOTA: El siguiente comando de compilación supone que ha realizado la configuración de usuario de Maven. Si no lo ha hecho, debe hacer la configuración de Maven en la línea de comando. Ver 'Configuración Maven'._
_DIR-USER:hace referencia al dierectorio donde se descarga el proyecto marketplace._

1. Abra una línea de comandos y navegue hasta el directorio raíz de este proyecto: DIR-USER/marketplace.
2. Escriba este comando para compilar y construir el archivo marketplace.war:

        mvn clean install 

3. Tome el archivo  'target/marketplace.war' y copielo a la ruta JBOSS_HOME\standalone\deployments.
 

Acceso a la applicación
-----------------------

La aplicación se ejecutará en la siguiente URL: <http://localhost:8080/marketplace/>.


Remover el despliegue de la aplciación
--------------------

1. Borre el archivo  'marketplace.war' de la ruta JBOSS_HOME\standalone\deployments.
