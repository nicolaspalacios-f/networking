# Taller networking ARSW

## Nicolas Palacios

## 14/06/2022

### En que consiste el proyecto?

El proyecto consiste en la creacion un servidor web que soporte multiples solicitudes seguidas (no concurrentes). El servidor debe retornar todos los archivos solicitados, incluyendo
paginas html e imagenes. este proyecto fue realizado en 10 horas con un total de 190 lineas.

LOC/H = 19



Comando utilizado: java -cp "target/classes" edu.escuelaing.arsw.ASE.app.HttpServerController

### Diagrama de Clases

<img src="imagen\imagen.png">  
 
 En el diagrama de clases vemos la clase httpServer, en esta estan los metodos Lector_archivos, agregarALista, media, desviacion y el main.

agregarALista agrega a una linked list las lineas del archivo y devuelve este linked list, Lector_archivos es el metodo que lee el archivo, este invoca a agregarALista y la linkedlist de este, media calcula la media de la linked list dada, y desviacion calcula la desviacion de la linked list y finalmente main es el metodo que invoca a lector_archivos.

### Tests

Se realizan test por los 4 metodos principales, media, desviacion, lector_archivos y agregarALista.
<img src="imagen\tests.png">

### Documentacion

Para ver la documentacion, se debe realizar el comando mvn javadoc:javadoc, luego en target/../index.html se visualizara esta.

### Estructura de archivos

|\_**\_pom.xml
|\_\_**src
| |\_**\_main
| | |\_\_**java
| | | |\_**\_edu
| | | | |\_\_**escuelaing
| | | | | |\_**\_app
| | | | | | |App.java
| |\_\_**test
| | |\_**\_java
| | | |\_\_**edu
| | | | |\_**\_escuelaing
| | | | | |\_\_**app
| | | | | | |\_\_\_\_AppTest.java
