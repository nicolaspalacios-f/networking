# Taller networking ARSW

## Nicolas Palacios

## 14/06/2022

### En que consiste el proyecto?

El proyecto consiste en la creacion de un programa el cual permita obtener la media y la desviacion estandar de un archivo especificado mediante el uso de linked list, este proyecto fue realizado en 3 horas con un total de 224 lineas.

_LOC/H = 74.67_

Este programa solo admite 1 argumento, indicando la direccion del archivo a utilizar.

Comando utilizado: java -cp "target/classes" co.edu.escuelaing.Lector src\main\java\co\edu\escuelaing\prueba\prueba.txt

### Diagrama de Clases

<img src="imagen\imagen.png">  
 
 En el diagrama de clases vemos la clase Lector, en esta estan los metodos Lector_archivos, agregarALista, media, desviacion y el main.

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
