package utilidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ManejoArchivosTXT {

    //Atributos 
    private FileInputStream openFile = null;
    private DataInputStream inputData = null;

    public ManejoArchivosTXT() {
    }//Constructor 

    public boolean duplicarDocumentos(String[] parametros) {

        /* parametros = 
                    0 iteraciones,1 tipo documento, 2 ruta archivo, 3 ruta salida, 4 separador, 5 emisor, 6 receptor, 
                    7 número documento, 8 fecha del documento, 9 drf_1, 10 drf_2, 11 drf_3, 12 drf_4, 13 drf_5 y 14 drf_6
         */
        try {

            if (parametros[1].equalsIgnoreCase("nc") || parametros[1].equalsIgnoreCase("nd") || parametros[1].equalsIgnoreCase("invoic")) {

                int numero_iteraciones = Integer.parseInt(parametros[0]);
                int numero_documento = Integer.parseInt(parametros[7]);

                for (int j = 0; j < numero_iteraciones; j++) {

                    String separador;
                    BufferedReader bufferReader = bufferLecturaDocumento(parametros[2]);//buffer para lectura del archivo plano
                    separador = parametros[4];
                    String line;
                    String informacion_nuevo_documento = "";

                    while ((line = bufferReader.readLine()) != null) {

                        //Separa la línea leída con el separador definido en los parámetros de entrada
                        String[] fields = line.split(String.valueOf(separador));

                        for (int i = 0; i < fields.length; i++) {

                            if (fields[0].equals("ENC")) {
                                fields[2] = parametros[5];//Emisor
                                fields[3] = parametros[6];//Receptor
                                fields[6] = parametros[12] + numero_documento;//prefijo más número de documento 
                                fields[7] = parametros[8];//fecha del documento
                                fields[16] = parametros[8];//fecha del documento para caducidad del documento

                            }

                            if (fields[0].equals("EMI")) {
                                fields[2] = parametros[5];//emisor            		   
                            }

                            if (fields[0].equals("ADQ")) {
                                fields[2] = parametros[6];//receptor            		   
                            }

                            if (fields[0].equals("DRF")) {

                                if (parametros[1].equalsIgnoreCase("nc") || parametros[1].equalsIgnoreCase("nd")) {

                                    fields[4] = parametros[12];//drf_4 prefijo autorizado 
                                    fields[5] = parametros[13];//drf_5 incio del rango de numeración
                                    fields[6] = parametros[14];//drf_6 fin del rango de numeración

                                } else {
                                    fields[1] = parametros[9];//drf_1 número de autorización DIAN
                                    fields[2] = parametros[10];//drf_2 fecha incio vigencia del rango de numeración
                                    fields[3] = parametros[11];//drf_3 fecha fin vigencia del rango de numeración
                                    fields[4] = parametros[12];//drf_4 prefijo autorizado 
                                    fields[5] = parametros[13];//drf_5 incio del rango de numeración
                                    fields[6] = parametros[14];//drf_6 fin del rango de numeración
                                }
                            }

                            informacion_nuevo_documento += fields[i] + separador;//nuevamente concatena la información de cada campo de la línea leída con una coma
                        }

                        informacion_nuevo_documento = informacion_nuevo_documento.replaceAll(",$", "");//se elimina la coma del final de cada línea
                        informacion_nuevo_documento += "\n";//se agrega un salto de línea al final de cada línea                             

                    }//end while

                    cerrarParametrosBufferedLectura();//cierra openFile e inputFile            
                    crearDocumentos(parametros[3] + "\\" + parametros[1].toUpperCase() + "_" + parametros[12] + numero_documento + ".txt", informacion_nuevo_documento);//se llama a la función que crea el documento
                    numero_documento++;//incrementa el número de documento en uno

                }

            } else {
                System.err.println("El tipo de documento no es válido, los valores permitidos son: NC, ND e INVOIC)");
                return false;
            }

            return true;
        } catch (IOException e) {
            System.err.println("Excepción: " + e.getMessage());
            return false;
        }

    }

    public void crearDocumentos(String path_documento, String informacion) {
        File file = new File(path_documento);//crea el archivo archivo si no existe de lo contrario lo sobreescribe

        try {

            BufferedWriter bufferWritter = new BufferedWriter(new FileWriter(file));//abre el documento para luego ingresar la información que se recibe en los parámetros del método
            bufferWritter.write(informacion);//ingresa la información al archivo 
            bufferWritter.close();//cierra la edición             

        } catch (IOException e) {
            System.err.println("Excepción: " + e.getMessage());
            return;
        }

    }

    public BufferedReader bufferLecturaDocumento(String path) {
        try {
            // Abre el archivo
            this.openFile = new FileInputStream(path);

            // Crea el objeto de entrada
            this.inputData = new DataInputStream(this.openFile);

            // Crea el Buffer de lectura
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(this.inputData));

            return bufferReader;//retorna el buffer de lectura 

        } catch (FileNotFoundException e) {
            System.err.println("Excepción: " + e.getMessage());
            return null;
        }
    }

    public void cerrarParametrosBufferedLectura() {
        try {
            openFile.close();
            inputData.close();
        } catch (IOException e) {
            System.err.println("Excepción: " + e.getMessage());
            return;
        }
    }

}
