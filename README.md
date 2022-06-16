# Taller networking ARSW

## Nicolas Palacios

## 14/06/2022

### En que consiste el proyecto?

El proyecto consiste en la creacion un servidor web que soporte multiples solicitudes seguidas (no concurrentes). El servidor debe retornar todos los archivos solicitados, incluyendo
paginas html e imagenes. este proyecto fue realizado en 10 horas con un total de 190 lineas.

LOC/H = 19



Comando utilizado: java -cp "target/classes" edu.escuelaing.arsw.ASE.app.HttpServerController

Para ingresar a la pagina principal se ingresara a http://localhost:35000/gana/index.html

### Diagrama de Clases

<img src="imagen\imagen.png">  
 
 En el diagrama de clases vemos la clase httpServer, y httpServer controller.

httpServer es el funcionamiento del server y controller la que la invoca


### Documentacion

Para ver la documentacion, se debe realizar el comando mvn javadoc:javadoc, luego en target/../index.html se visualizara esta.

### Estructura de archivos

|\_**\_pom.xml
|\_\_**src
| |\_**\_main
| | |\_\_**java
| | | |\_**\_edu
| | | | |\_\_**escuelaing
| | | | | |\_**\_arsw
| | | | | | |\_**\_ASE
| | | | | | | |\_**\_app
| | | | | | | | |HttpServer.java
| | | | | | | | |HttpServerController.java
| |\_\_**test
| | |\_**\_java
| | | |\_\_**edu
| | | | |\_**\_escuelaing
| | | | | |\_\_**app
| | | | | | |\_\_\_\_AppTest.java
