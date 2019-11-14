package ad_16;

import ejercicio13.Product;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author oracle
 */
public class AD_16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, XMLStreamException {

        XMLOutputFactory a2 = XMLOutputFactory.newInstance();
        XMLStreamWriter a1 = a2.createXMLStreamWriter(new FileWriter(new File("products.xml")));
        ObjectInputStream dout = new ObjectInputStream(new FileInputStream(new File("/home/oracle/Desktop/NetBeans/AD_13_serializacion2/products.txt")));

        Product p2 = (Product) dout.readObject();
        a1.writeStartDocument("1.0");
        a1.writeStartElement("Productos");
        while (p2 != null) {
            a1.writeStartElement("Product");
            a1.writeAttribute("codigo", p2.getCodigo());
            a1.writeStartElement("descripcion");
            a1.writeCharacters(p2.getDescipcion());
            a1.writeEndElement();
            a1.writeStartElement("precio");
            a1.writeCharacters(String.valueOf(p2.getPrecio()));
            a1.writeEndElement();
            a1.writeEndElement();
            System.out.println(p2.toString());
            p2 = (Product) dout.readObject();
        }
        a1.writeEndElement();
        a1.close();
        dout.close();
    }

}
