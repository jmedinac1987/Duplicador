package duplicador;

import utilidades.*;

public class Duplicador {

    public static void main(String[] args) {
       ManejoArchivosXML objManejoArchivosXML = new ManejoArchivosXML();
       //objManejoArchivosXML.crearDocumentos();
       objManejoArchivosXML.duplicarDocumentos();
      /*  try {
            ManejoArchivosTXT objManejoArchivosTXT = new ManejoArchivosTXT();
            if (args == null || args.equals("")) {
                System.err.println("Es necesaario ingresar los siguientes parámetros: \n"
                        + "0 número de iteraciones \n"
                        + "1 tipo documento (NC, ND,INVOIC) \n"
                        + "2 ruta archivo base \n"
                        + "3 ruta para archivo de salida \n"
                        + "4 separador (Ejemplos: ,; ';'; ^) \n"
                        + "5 emisor \n"
                        + "6 receptor \n"
                        + "7 número documento \n"
                        + "8 fecha del documento (Ejemplo: 2020-12-01) \n"
                        + "9 drf_1 número de autorización DIAN \n"
                        + "10 drf_2 fecha incio vigencia del rango de numeración (Ejemplo: 2020-12-01) \n"
                        + "11 drf_3 fecha fin vigencia del rango de numeración (Ejemplo: 2021-10-31) \n"
                        + "12 drf_4 prefijo autorizado \n"
                        + "13 drf_5 incio del rango de numeración\n"
                        + "14 drf_6 fin del rango de numeración \n \n"
                        + "Nota: si el tipo de documento es NC o ND se descartan los parámetros 9, 10 y 11 se diligencian con espacio o vacío");
            } else {
                if (objManejoArchivosTXT.duplicarDocumentos(args)) {
                    System.out.println("Documento(s) creado(s) satisfactoriamente\n"
                            + "Número de documentos creados: " + args[0]);
                }
            }

        } catch (Exception e) {
            System.err.println("Excepción: " + e.getMessage());
            System.err.println("Es necesaario ingresar los siguientes parámetros: \n"
                    + "0 número de iteraciones \n"
                    + "1 tipo documento (NC, ND,INVOIC) \n"
                    + "2 ruta archivo base \n"
                    + "3 ruta para archivo de salida \n"
                    + "4 separador (Ejemplos: ,; ';'; ^) \n"
                    + "5 emisor \n"
                    + "6 receptor \n"
                    + "7 número documento \n"
                    + "8 fecha del documento (Ejemplo: 2020-12-01) \n"
                    + "9 drf_1 número de autorización DIAN \n"
                    + "10 drf_2 fecha incio vigencia del rango de numeración (Ejemplo: 2020-12-01) \n"
                    + "11 drf_3 fecha fin vigencia del rango de numeración (Ejemplo: 2021-10-31) \n"
                    + "12 drf_4 prefijo autorizado \n"
                    + "13 drf_5 incio del rango de numeración\n"
                    + "14 drf_6 fin del rango de numeración \n \n"
                    + "Nota: si el tipo de documento es NC o ND se descartan los parámetros 9, 10 y 11 se diligencian con espacio ' ' o 'NA'");
        }*/
    }

}
