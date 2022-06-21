# Taller networking ARSW

## Nicolas Palacios

## 18/06/2022

### En que consiste el proyecto?

El proyecto consiste en la creacion un servidor web que soporte multiples solicitudes seguidas concurrentes. El servidor debe retornar todos los archivos solicitados, incluyendo
paginas html e imagenes. este proyecto fue realizado en 6 horas con un total de 240 lineas.

LOC/H = 24

Comando utilizado: java -cp "target/classes" edu.escuelaing.arsw.ASE.app.HttpServerController

java -cp "target\classes" edu.escuelaing.arsw.ASE.app.ClienteMultiHilos 2 en el caso de usar concurrencia.

Para ingresar a la pagina principal se ingresara a http://localhost:35000/gana/index.html
El link de heroku es el siguiente:
https://servidorwebarsw.herokuapp.com/gana/index.html
<img src= imagen\imagen2.png>

Por cada peticion saldra el hilo en el que se realiza, junto con la informacion de la peticion.

<img src= imagen\imagen3.png>

En el caso del cliente multihilos dara lo siguiente.

<img src= imagen\imagen4.png>

### Diagrama de Clases

<img src="imagen\imagen.png">  
 
 En el diagrama de clases vemos la clase httpServer, httpServer controller.

httpServer es el funcionamiento del server y controller la que la invoca

De igual manera vemos requestProcessor MultiHilosProcessor y ClienteMultiHilos, estos enfocados netamente en concurrencia.

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
| | | | | | | | |ClienteMultiHilos.java  
| | | | | | | | |MultiHilosProcessor.java  
| | | | | | | | |RequestProcessor.java  
| |\_\_**test  
| | |\_**\_java  
| | | |\_\_**edu  
| | | | |\_**\_escuelaing  
| | | | | |\_\_**app  
| | | | | | |\_\_\_\_AppTest.java
