# DUPLICADOR

Este proyecto se crea con el ánimo de generar múltiples documentos con extensión .txt o .xml

## Pre-requisitos 📋

La máquina en donde se va ejecutar el proyecto debe contar con lo siguiente:

1. Versión de java "1.8.0_111" o superior
2. Netbeans 8.2 o superior
3. Contar con archivos .txt y .xml para probar el duplicador

## Instalación 🔧

1. Abrir la consola de comandos de su sistema operativo y clonar el proyecto con el comando `git clone https://github.com/jmedinac1987/Duplicador.git`
2. Abrir el proyecto con Netbeans
3. Dar clic derecho sobre el proyecto y seleccionar la opción "Clean and Build"

## Ejecución 🚀

Una vez se a creado el .jar del proyecto se debe proceder con los siguientes pasos:

1. Abrir la consola de comandos de su sistema operativo
2. Ir a la ruta donde se encuentra el .jar
3. Ejecutar los siguientes comandos:

* **Archivos (txt)**:
java -jar Duplicador.jar {extensión documento} {número de documentos a generar} {tipo de documento ND, NC o Invoice} {ruta documento base} {ruta documento salida} {separador de líneas} {emisor} {receptor} {número de documento} {fecha documento} {DRF_1} {DRF_2} {DRF_3} {DRF_4} {DRF_5} {DRF_6}

* **Ejemplo (txt):** `java -jar Duplicador.jar txt 1 Nd E:\0.0_SistemaGeneral\Escritorio\Insumos_Plano_Estandar_Carvajal_2.1\Sin_Extensiones_por_Sector\Nota_Credito.txt E:\0.0_SistemaGeneral\Escritorio\Insumos_Plano_Estandar_Carvajal_2.1\Sin_Extensiones_por_Sector\ "," jorge_Andrés 22222 5 2020-12-28 drf_1 drf_2 drf_3 FAC drf_5 drf_6`

* **Archivos (xml)**:
java -jar Duplicador.jar {extensión documento} {número de documentos a generar} {tipo de documento ND, NC o Invoice} {ruta documento base} {ruta documento salida} {emisor} {receptor} {número de documento} {fecha documento} {DRF_1} {DRF_2} {DRF_3} {DRF_4} {DRF_5} {DRF_6}

* **Ejemplo (xml):** xml: `java -jar Duplicador.jar xml 1 Nd E:\0.0_SistemaGeneral\Escritorio\Insumos_XML_Estandar_Carvajal_2.1\Sin_Extensiones_por_Sector\Nota_Credito.xml E:\0.0_SistemaGeneral\Escritorio\Insumos_XML_Estandar_Carvajal_2.1\Sin_Extensiones_por_Sector\ jorge_Andrés 22222 5 2020-12-28 drf_1 drf_2 drf_3 FAC drf_5 drf_6`

**Nota:** este proyecto esta creado para unos documentos específicos por lo tanto si su documento tiene que ser editados en otros campos debe ajustar las clases que manejan los archivos, las clases se encuentran en la carpeta utilidades del proyecto

## Autores ✒️

* **Jorge Andrés Medina Castro** - *Proyectos* - [GitHub](https://github.com/jmedinac1987)

## Licencia 📄

Es un software de código abierto con licencia [MIT licencia](https://opensource.org/licenses/MIT).