package ad_17;


import ejercicio13.Product;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author oracle
 */
public class AD_17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {

        ArrayList productosXML = new ArrayList<Product>();
        XMLInputFactory pol = XMLInputFactory.newInstance();
        XMLStreamReader out = pol.createXMLStreamReader(new FileReader(new File("/home/oracle/Desktop/NetBeans/AD_16_XMLwriter/products.xml")));
      
        while (out.hasNext()) {
              Product p1 = new Product();
            if (out.getEventType() == XMLStreamConstants.START_ELEMENT) {
                if ("Product".equals(out.getLocalName())) {
                    p1.setCodigo(out.getAttributeValue(0));
                } else if ("descripcion".equals(out.getLocalName())) {
                    p1.setDescipcion(out.getElementText());
                } else if ("precio".equals(out.getLocalName())) {
                    p1.setPrecio(Double.parseDouble(out.getElementText()));
                }
            }    
            out.next();
        }

        for (int i = 0; i < productosXML.size(); i++) {
            System.out.println(productosXML.get(i).toString());
        }
    }

}
