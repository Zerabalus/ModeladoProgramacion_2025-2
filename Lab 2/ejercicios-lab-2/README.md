Modelado y Programación
====================

Ejercicios de Laboratorio II
------------------

### Fecha de entrega: 27 de Marzo de 2025

| Ejercicios de Laboratorio II | ![Miku](resources/miku.gif) |
|------------------------------|-----------------------------|


Utilicé Maven instalando:

```
$ sudo apt install maven
```

Uso
------------------
Compilar al hacer:

```
$ mvn compile
```

Pasa las pruebas unitarias al hacer:

```
$ mvn test
```

Por último, ejecutar correctamente el programa de la clase
`Main` al ejecutar:

```
$ mvn install
...
$ java -jar target/ejercicios-lab-2-1.0-SNAPSHOT.jar
```
### Interfaz gráfica
- Ejecutar usando:

```
mvn exec:java -Dexec.mainClass="com.lab2.MainGUI"
```
![Interfaz](/resources/app.png)
*Transparencia por la personalización del escritorio de Linux que tengo, pero es la idea 😅


### Documentación

La documentación generada por JavaDoc puede ser consultada aquí:
- [Documentación Javadoc](./doc/index.html)

Generada usando:

```
javadoc -d doc/ src/main/java/com/lab2/*.java
```

### Consideraciones Generales

El formato, estructuración y presentación de la entrega es libre, siempre se cumplan las
siguientes condiciones:
- Los ejercicios tienen que estar representados en una función dentro de un lenguaje de
programación a su elección, respetando la tipificación de entrada y salida de acuerdo a
su descripción. En función de seguir buenas prácticas de programación, documenta/
comenta la función que realiza el ejercicio, con una descripción, y complejidad en
tiempo y espacio (en términos de la gran O).

- El programa tiene que ser compilable y/o ejecutable dónde se llame a ejecución cada
una de las funciones representativas utilizando dos ejemplos, pueden ser los dados en
este documento o totalmente independientes, mientras cumplan con las limitaciones
dadas. Si la ejecución de dichos ejemplos se realiza en pruebas unitarias, se otorgará
calificación adicional.

- El lenguaje de programación utilizado es completamente libre, por lo que será
necesario incluir en un archivo de texto, las instrucciones de compilación y/o ejecución
respectivas al programa entregado.