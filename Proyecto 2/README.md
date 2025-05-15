# Proyecto 2 Modelado y Programacion 2025-2

**Profesor : L. en C.C. Francisco Alejandro Arganis Ramírez**

**Ayudante Teoria : Jesús Haans López Hérnandez**

**Ayudante Laboratorio : Eric Toporek Coca**

**Proyecto 2: Ray Tracer**
<p>
  
  <img src="img/sw.gif" alt="Silver" width="200" align="right">
</p>

## Tabla de Contenidos
- [1. Introducción](#1-introducción)
- [2. Objetivos](#2-objetivos)
- [3. Formato del Archivo de Entrada](#3-formato-del-archivo-de-entrada)
- [4. Archivos de Salida](#4-archivos-de-salida)
- [5. Uso](#5-uso)

## **1. Introducción**  
Los fractales son estructuras matemáticas con propiedades autosimilares que surgen de iteraciones complejas. En este proyecto, exploraremos la generación de fractales a partir de **polinomios complejos** utilizando **Programación Orientada a Objetos (POO)**.  

Implementaremos un programa que:
- Procesará polinomios definidos en el plano complejo.
- Iterará sobre cada punto del plano para evaluar su convergencia o divergencia.
- Generará una imagen en formato `PNG` o `JPG` que represente el fractal resultante.

## **2. Objetivos**
<img src="https://safebooru.org//images/4570/966189120dcefd82afd99149fa1ec27f.gif?4764823 " alt="<3" align="left" width="20%" height="20%">


```csharp

Este proyecto tiene como objetivos:
- Modelar un polinomio complejo y su evaluación iterativa.  
- Implementar una arquitectura basada en **POO** para encapsular los elementos del programa.
- leer un archivo de entrada con los parámetros necesarios para generar el fractal.
- Generar una imagen que represente el fractal resultante.
```

## **3. Formato del Archivo de Entrada**  
Para que el programa pueda generar correctamente el fractal, se utilizará un archivo de entrada con los parámetros necesarios. Este archivo tendrá un formato de texto **(input)** estructurado con los siguientes valores:  

```
width : 1024                            // Ancho de la imagen
height : 1024                           // Alto de la imagen
degree : 2                              // Grado del polinomio
polynomial : (1+0i)x^2+(-1+0i)          // Polinomio complejo
min : -2-2i                             // Valor mínimo del plano complejo
max : 2+2i                              // Valor máximo del plano complejo
iterations : 256                        // Número máximo de iteraciones
threshold : 2                           // Umbral de convergencia
color : (255,100,50)                    // Color base del fractal
nombre : fractal.png                    // Nombre del archivo de salida
```

## **4. Archivos de salida**
El programa deberá generar un archivo de salida en formato `PNG` o `JPG` que represente el fractal resultante. La imagen deberá tener las dimensiones especificadas en el archivo de entrada y los colores asignados según la convergencia o divergencia de los puntos en el plano complejo.

Estos son algunos ejemplos de fractales generados con polinomios complejos:


![fractal2.png](img/fractal2.png)

```
width : 1024
height : 1024
iterations : 10
threshold : 2
min : -2-2i
max : 2+2i
polynomial : (1+0i)x^2+(-1+0i)
nombre : fractal2.png
color : (255,100,50)
```

![fractal3.png](img/fractal3.png)

```
width : 1024
height : 1024
iterations : 10
threshold : 2
min : -2-2i
max : 2+2i
polynomial : (1+0i)x^3+(-1+0i)
nombre : fractal3.png
color : (228,0,120)
```


## **5. Uso**
1. **Requisitos**:
- Python 3.8+


2. **Uso**
- Generamos el entorno virtual

```bash
python3 -m venv venv
```
- Activamos el entorno
```bash
 source venv/bin/activate
```
- Paquetes
```bash
pip install -r requirements.txt
```
- Tests con el script
```bash
python3 run_tests.py
```
- Ejecutar con:
```bash
python3 src/main.py
```

Se pueden usar distintos archivos txt, deben ser archivos de configuración en `input/` con extensión `.txt`.

3. **Fractales generados**
- Las imágenes generadas aparecerán en `output/`

---
<p align="center">
  <a href="https://github.com/Zerabalus">☆ Mi Github ☆</a>
</p>

<p align="center">
<img src="https://i.pinimg.com/736x/e5/20/d5/e520d5fdf66615af98e523582d226bef.jpg" alt="<3" align="center"height="20%">
</p>