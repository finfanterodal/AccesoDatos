package ejercicio14;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author oracle
 */
public class Ejercicio14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, XMLStreamException {
        XMLOutputFactory a2 = XMLOutputFactory.newInstance();
        XMLStreamWriter a1 = a2.createXMLStreamWriter(new FileWriter(new File("exercicio14.xml")));

        a1.writeStartDocument("1.0");
        a1.writeStartElement("autores");
        a1.writeStartElement("autor");
        a1.writeAttribute("codigo", "a1");
        a1.writeStartElement("nome");
        a1.writeCharacters("Alexandre Dumas");
        a1.writeEndElement();
        a1.writeStartElement("titulo");
        a1.writeCharacters("El conde de montecristo");
        a1.writeEndElement();
        a1.writeStartElement("titulo");
        a1.writeCharacters("Los miserables");
        a1.writeEndElement();
        a1.writeEndElement();
        a1.writeStartElement("autor");
        a1.writeAttribute("codigo", "a2");
        a1.writeStartElement("nome");
        a1.writeCharacters("Fiodor Dostoyevski");
        a1.writeEndElement();
        a1.writeStartElement("titulo");
        a1.writeCharacters("El idiota");
        a1.writeEndElement();
        a1.writeStartElement("titulo");
        a1.writeCharacters("Noches blancas");
        a1.writeEndElement();
        a1.writeEndElement();
        a1.writeEndElement();
            
        /*     <?xm version="1.0"?>
         <autores>
         <autor codigo ="a1">
         <nome>Alexandre Dumas </nome>
         <titulo> El conde de montecristo</titulo>
         <titulo> Los miserables </titulo>
         </autor>
         <autor codigo ="a2">
         <nome>Fiodor Dostoyevski</nome>
         <titulo> El idiota</titulo>
         <titulo> Noches blancas </>
         </autor>
         <autores>
         */
        a1.close();

        XMLInputFactory pol = XMLInputFactory.newInstance();
        XMLStreamReader out = pol.createXMLStreamReader(new FileReader(new File("exercicio14.xml")));

        while (out.hasNext()) {
            if (out.getEventType() == XMLStreamConstants.START_ELEMENT) {
                if ("autor".equals(out.getLocalName())) {
                    System.out.println("Cod: "+out.getAttributeValue(0));
                } else if ("nome".equals(out.getLocalName())) {
                    System.out.println("Nome: "+out.getElementText());
                } else if ("titulo".equals(out.getLocalName())) {
                    System.out.println("Título: "+out.getElementText());
                }
            } else {

            }
            out.next();
        }


        

    }

}
