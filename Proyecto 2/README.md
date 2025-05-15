# Proyecto 2 Modelado y Programacion 2025-2

**Profesor : L. en C.C. Francisco Alejandro Arganis Ramírez**

**Ayudante Teoria : Jesús Haans López Hérnandez**

**Ayudante Laboratorio : Eric Toporek Coca**

**Proyecto 2: Ray Tracer**
<p>
  
  <img src="img/xiao.gif" alt="Silver" width="200" align="right">
</p>

## Tabla de Contenidos
- [1. Información General](#1-información-general)
- [2. Objetivos](#2-objetivos)
- [3. Archivo de Entrada](#3-archivo-de-entrada)
- [4. Archivos de Salida](#4-archivos-de-salida)
- [5. Uso](#5-uso)

## **1. Información General**  
Un ray tracer es un componente de software que sintetiza imágenes en 3D. Recibe
como entrada la especificación de una escena, la cual está compuesta por diversos
objetos tridimensionales compuestos por modelos, texturas y materiales, así como
la configuración de iluminación y posición de una cámara a partir de donde se
visualiza la escena. La salida del programa es una imagen en archivo o memoria que
representa la visualización de la cámara en la escena correspondiente.
En la actualidad los raytracer son de un uso intenso en la industria (arquitectura,
diseño gráfico, publicidad, entretenimiento, entre otras) siendo el cine una
aplicación muy socorrida para el uso de esta tecnología.

## **2. Objetivos**
<img src="img/sw.gif" alt="<3" align="left" width="30%" height="20%">


```csharp

Este proyecto tiene como finalidad que el estudiante enfrente proyectos de
programación de alcance más amplio que requiera un nivel mayor de esfuerzo y
organización. El proyecto presenta las siguientes características:

- Está pensado para ser implementado en un lenguaje de programación
imperativo.
- Se espera que el código de los programas siga los principios de código
limpio.
- Tenga un README donde especifique cómo ejecutar su código.
```

## **3. Archivo de Entrada**  
Representaremos la escena a sintetizar como un documento XML que especificará de manera precisa la escena
que recibirá el algoritmo de ray tracing.

## **4. Archivos de salida**
El programa deberá generar un archivo de salida en formato `PNG` o `JPG` que represente el fractal resultante. La imagen deberá tener las dimensiones especificadas en el archivo de entrada y los colores asignados según la convergencia o divergencia de los puntos en el plano complejo.
En el archivo XML debe incluir los siguientes datos:
- Datos generales de la escena
- Definiciones de materiales usados en la escena
- Definiciones para la fuente de luz
- Objetos primitivos



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

---
<p align="center">
  <a href="https://github.com/Zerabalus">☆ Mi Github ☆</a>
</p>

<p align="center">
<img src="img/compsci.jpeg" alt="<3" align="center"height="20%">
</p>