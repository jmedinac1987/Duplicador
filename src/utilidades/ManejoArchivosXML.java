package utilidades;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class ManejoArchivosXML {

    public ManejoArchivosXML() {
    }

    public void duplicarDocumentos() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            Document documento = builder.parse("C:\\Users\\jmedinac\\Desktop\\Insumos_XML_Estandar_Carvajal_2.1\\Sin_Extensiones_por_Sector\\Factura_Contingencia.xml");//se abre el documento
            
            NodeList listaCoches = documento.getElementsByTagName("FACTURA");//obtiene todo lo que tenga el tag coche
            
            //se recorre los elementos que estan dentro del tag coche
            for (int i = 0; i < listaCoches.getLength(); i++) {
                Node nodo = listaCoches.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    NodeList hijos = elemento.getChildNodes();
                    for (int j = 0; j < hijos.getLength(); j++) {
                        Node hijo = hijos.item(j);
                        if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                            System.out.println("Propiedad: " + hijo.getNodeName() + "\n" + "Valor: " + hijo.getTextContent());                            
                        }
                    }
                }
            }
            
        } catch (Exception e) {
        }
    }

    public void crearDocumentos() {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();

            Document documento = implementation.createDocument(null, "tag_que_cierra_todo", null);
            documento.setXmlVersion("1.0");

            Element coches = documento.createElement("coches");//padre
            Element coche = documento.createElement("coche");//hijo 1

            Element matricula = documento.createElement("matricula");//hijo 2
            Text textMatrcula = documento.createTextNode("prueba");//texto que va dentro de la etiqueta matricula 
            matricula.appendChild(textMatrcula);//le agrega el valor del texto en la etiqueta 
            coche.appendChild(matricula);//agrega el tag matrcula dentro del tag hijo 1 denominado coche 

            coches.appendChild(coche);//agrega el tag coche dentro del tag padre denomnado coches 

            documento.getDocumentElement().appendChild(coches);//agrega toda la información de los elementos del xml como información 

            Source source = new DOMSource(documento);//creamos el fichero 
            Result result = new StreamResult(new File("C:\\Users\\jmedinac\\Desktop\\nombre_archivo.xml"));//se crear el archivo en la ruta deseada y nombre deseado

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
