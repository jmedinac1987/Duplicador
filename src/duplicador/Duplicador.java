package duplicador;

import utilidades.*;

public class Duplicador {

    public static void main(String[] args) {
        
        try {

            if (args[0].equalsIgnoreCase("txt")) {                               
                String[] parametros = {args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11], args[12], args[13], args[14], args[15]};
                ManejoArchivosTXT objManejoArchivosTXT = new ManejoArchivosTXT();

                if (objManejoArchivosTXT.duplicarDocumentos(parametros)) {
                    System.out.println("Documento(s) .txt creado(s) satisfactoriamente\n"
                            + "Número de documentos creados: " + parametros[0]);
                }else{
                    System.out.println("El documento no fue creado");
                }
            } else if (args[0].equalsIgnoreCase("xml")) {
                                  
                String[] parametros = {args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11], args[12], args[13], args[14]};
                ManejoArchivosXML objManejoArchivosXML = new ManejoArchivosXML();

                if (objManejoArchivosXML.duplicarDocumentos(parametros)) {
                    System.out.println("Documento(s) .xml creado(s) satisfactoriamente\n"
                            + "Número de documentos creados: " + parametros[0]);
                }else{
                    System.out.println("El documento no fue creado");
                }
                
            } else {
                System.out.println("La extensión de archivo no es válida, solo se admiten extensiones txt y xml");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.err.println("Por favor verifique si ingreso los siguientes parámetros: \n"
                    + "0 extensión del documento a crear (txt o xml)\n"
                    + "1 número de iteraciones \n"
                    + "2 tipo documento (NC, ND,INVOIC) \n"
                    + "3 ruta archivo base \n"
                    + "4 ruta para archivo de salida \n"
                    + "5 separador indicado entre comillas dobles (Ejemplos: \",\", \";\", \"^\") solo para documentos con extensión txt\n"
                    + "6 emisor \n"
                    + "7 receptor \n"
                    + "8 número documento \n"
                    + "9 fecha del documento (Ejemplo: 2020-12-01) \n"
                    + "10 drf_1 número de autorización DIAN \n"
                    + "11 drf_2 fecha incio vigencia del rango de numeración (Ejemplo: 2020-12-01) \n"
                    + "12 drf_3 fecha fin vigencia del rango de numeración (Ejemplo: 2021-10-31) \n"
                    + "13 drf_4 prefijo autorizado \n"
                    + "14 drf_5 incio del rango de numeración\n"
                    + "15 drf_6 fin del rango de numeración \n \n"
                    + "Nota: si el tipo de documento es NC o ND se descartan los parámetros 9, 10 y 11 se diligencian con espacio ' ' o 'NA'");
        }
    }

}
