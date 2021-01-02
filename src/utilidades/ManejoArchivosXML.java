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

    public void duplicarDocumentos() {
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document documento = builder.parse("C:\\Users\\jmedinac\\Desktop\\Insumos_XML_Estandar_Carvajal_2.1\\Sin_Extensiones_por_Sector\\Nota_Credito.xml");//se abre el documento base

            NodeList listaElementosXML = documento.getElementsByTagName("FACTURA");//obtiene todos los elementos contenidos de acuerdo al tag padre indicado 

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
                                        subHijoSegundoNivel.setTextContent("prueba");
                                    }
                                    if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("ENC_3")) {
                                        subHijoSegundoNivel.setTextContent("prueba");
                                    }
                                    if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("ENC_6")) {
                                        subHijoSegundoNivel.setTextContent("prueba");
                                    }
                                    if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("ENC_7")) {
                                        subHijoSegundoNivel.setTextContent("prueba");
                                    }
                                    if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("ENC_16")) {
                                        subHijoSegundoNivel.setTextContent("prueba");
                                    }
                                    if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("EMI_2")) {
                                        subHijoSegundoNivel.setTextContent("prueba");
                                    }
                                    if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("ADQ_2")) {
                                        subHijoSegundoNivel.setTextContent("prueba");
                                    }
                                    if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("DRF_1")) {
                                        subHijoSegundoNivel.setTextContent("prueba");
                                    }
                                    if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("DRF_2")) {
                                        subHijoSegundoNivel.setTextContent("prueba");
                                    }
                                    if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("DRF_3")) {
                                        subHijoSegundoNivel.setTextContent("prueba");
                                    }
                                    if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("DRF_4")) {
                                        subHijoSegundoNivel.setTextContent("prueba");
                                    }
                                    if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("DRF_5")) {
                                        subHijoSegundoNivel.setTextContent("prueba");
                                    }
                                    if (subHijoSegundoNivel.getNodeName().equalsIgnoreCase("DRF_6")) {
                                        subHijoSegundoNivel.setTextContent("prueba");
                                    }
                                }
                            }
                        }
                    }
                }
            }
            crearDocumentos(documento);//Después de ajustar el documento este pasa como parámetro para crear el documento nuevo 
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void crearDocumentos(Document documento) {

        try {
            Source source = new DOMSource(documento);//creamos el fichero 
            Result result = new StreamResult(new File("C:\\Users\\jmedinac\\Desktop\\nombre_archivo2.xml"));//se crear el archivo en la ruta deseada y nombre deseado

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            System.out.println("Documento creado!!");
        } catch (TransformerException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
