package utilidades;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ManejoArchivosXML {

    public ManejoArchivosXML() {
    }//constructor

    public boolean duplicarDocumentos(String[] parametros) {
        /* parametros = 
                    0 iteraciones,1 tipo documento, 2 ruta archivo, 3 ruta salida, 4 emisor, 5 receptor, 
                    6 número documento, 7 fecha del documento, 8 drf_1, 9 drf_2, 10 drf_3, 11 drf_4, 12 drf_5 y 13 drf_6
         */

        try {

            if (parametros[1].equalsIgnoreCase("nc") || parametros[1].equalsIgnoreCase("nd") || parametros[1].equalsIgnoreCase("invoic")) {

                int numero_iteraciones = Integer.parseInt(parametros[0]);
                int numero_documento = Integer.parseInt(parametros[6]);
                String tipo_documento;

                if (parametros[1].equalsIgnoreCase("invoic")) {
                    tipo_documento = "FACTURA";
                } else {
                    tipo_documento = "NOTA";
                }

                for (int h = 0; h < numero_iteraciones; h++) {

                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();

                    Document documento = builder.parse(parametros[2]);//se abre el documento base

                    NodeList listaElementosXML = documento.getElementsByTagName(tipo_documento);//obtiene todos los elementos contenidos de acuerdo al tag padre indicado 

                    //se recorre la lista obtenida de acuerdo al tag de inicio indicado 
                    for (int i = 0; i < listaElementosXML.getLength(); i++) {
                        Node nodo = listaElementosXML.item(i);//elemento por elemento que se encuentre en el primer nivel

                        if (nodo.getNodeType() == Node.ELEMENT_NODE) {

                            Element elementoPrimerNivel = (Element) nodo;
                            NodeList hijosPrimerNivel = elementoPrimerNivel.getChildNodes();//lista primer nivel 

                            for (int j = 0; j < hijosPrimerNivel.getLength(); j++) {

                                Node subHijoPrimerNivel = hijosPrimerNivel.item(j);

                                if (subHijoPrimerNivel.getNodeType() == Node.ELEMENT_NODE) {

                                    Element elementoSegundoNivel = (Element) subHijoPrimerNivel;
                                    NodeList hijosSegundoNivel = elementoSegundoNivel.getChildNodes();;//lista segundo nivel

                                    for (int k = 0; k < hijosSegundoNivel.getLength(); k++) {

                                        Node subHijoSegundoNivel = hijosSegundoNivel.item(k);

                                        if (subHijoSegundoNivel.getNodeType() == Node.ELEMENT_NODE) {
                                            //Incia los cambios en los campos del documento    
                                            if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("ENC_2")) {
                                                subHijoSegundoNivel.setTextContent(parametros[4]);//Emisor
                                            }
                                            if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("ENC_3")) {
                                                subHijoSegundoNivel.setTextContent(parametros[5]);//Receptor
                                            }
                                            if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("ENC_6")) {
                                                subHijoSegundoNivel.setTextContent(parametros[11] + numero_documento);//prefijo más número de documento 
                                            }
                                            if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("ENC_7")) {
                                                subHijoSegundoNivel.setTextContent(parametros[7]);//fecha del documento
                                            }
                                            if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("ENC_16")) {
                                                subHijoSegundoNivel.setTextContent(parametros[7]);//fecha del documento para caducidad del documento
                                            }
                                            if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("EMI_2")) {
                                                subHijoSegundoNivel.setTextContent(parametros[4]);//Emisor
                                            }
                                            if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("ADQ_2")) {
                                                subHijoSegundoNivel.setTextContent(parametros[5]);//Receptor
                                            }
                                            if (tipo_documento.equalsIgnoreCase("FACTURA")) {

                                                if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("DRF_1")) {
                                                    subHijoSegundoNivel.setTextContent(parametros[8]);//drf_1 número de autorización DIAN
                                                }
                                                if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("DRF_2")) {
                                                    subHijoSegundoNivel.setTextContent(parametros[9]);//drf_2 fecha incio vigencia del rango de numeración
                                                }
                                                if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("DRF_3")) {
                                                    subHijoSegundoNivel.setTextContent(parametros[10]);//drf_3 fecha fin vigencia del rango de numeración
                                                }
                                                if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("DRF_4")) {
                                                    subHijoSegundoNivel.setTextContent(parametros[11]);//drf_4 prefijo autorizado 
                                                }
                                                if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("DRF_5")) {
                                                    subHijoSegundoNivel.setTextContent(parametros[12]);//drf_5 incio del rango de numeración
                                                }
                                                if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("DRF_6")) {
                                                    subHijoSegundoNivel.setTextContent(parametros[13]);//drf_6 fin del rango de numeración
                                                }
                                            } else {
                                                if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("DRF_4")) {
                                                    subHijoSegundoNivel.setTextContent(parametros[11]);//drf_4 prefijo autorizado 
                                                }
                                                if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("DRF_5")) {
                                                    subHijoSegundoNivel.setTextContent(parametros[12]);//drf_5 incio del rango de numeración
                                                }
                                                if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("DRF_6")) {
                                                    subHijoSegundoNivel.setTextContent(parametros[13]);//drf_6 fin del rango de numeración
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    crearDocumentos(parametros[3] + "\\" + parametros[1].toUpperCase() + "_" + parametros[11] + numero_documento + ".xml", documento);//Después de ajustar el documento este pasa como parámetro para crear el documento nuevo 
                    numero_documento++;//incrementa el valor del número de documento 
                }
            } else {
                System.err.println("El tipo de documento no es válido, los valores permitidos son: NC, ND e INVOIC)");
                return false;
            }
            return true;
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error en el método duplicarDocumentos()");
            return false;
        }
    }

    public void crearDocumentos(String path_documento, Document documento) {

        try {
            Source source = new DOMSource(documento);//creamos el fichero 
            Result result = new StreamResult(new File(path_documento));//se crear el archivo en la ruta deseada y nombre deseado

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

        } catch (TransformerException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error en el método crearDocumentos()");
        }
    }
}
