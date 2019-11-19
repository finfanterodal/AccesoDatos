package exam_example2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author oracle
 */
public class Exam_Example2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, XMLStreamException, ClassNotFoundException, SQLException {
        
        listarProductos();
        System.out.println("******************************LECTURA SERIALIZADO**********************************");
        Plato2 platosSerializado = new Plato2();
        ObjectInputStream dout = new ObjectInputStream(new FileInputStream(new File("PlatosSerializado.txt")));
        platosSerializado = (Plato2) dout.readObject();
        while (platosSerializado != null) {
            System.out.println(platosSerializado.toString());
            platosSerializado = (Plato2) dout.readObject();
        }
        dout.close();

    }

    public static void listarProductos() throws IOException, ClassNotFoundException, SQLException, XMLStreamException {

        //Conexion y primera consulta
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ObjectOutputStream din = null;
        conn = Connect.getConexion();
        //Variables
        int peso = 0;
        float grasasTotales = 0f;
        String nomePlato = "";
        String codPlato = "";
        String componentePlato = "";
        //int graxa = 0;

        String sql_SELECT = "SELECT * FROM componentes where codc=?";
        stmt = conn.prepareStatement(sql_SELECT);

        //Lectura XML (Sacamos los platos y su nombre)
        XMLInputFactory pol = XMLInputFactory.newInstance();
        XMLStreamReader out = pol.createXMLStreamReader(new FileReader(new File("platos.xml")));
        din = new ObjectOutputStream(new FileOutputStream(new File("PlatosSerializado.txt")));
        while (out.hasNext()) {

            if (out.getEventType() == XMLStreamConstants.START_ELEMENT) {
                if ("Plato".equals(out.getLocalName())) {
                    //OBTENGO EL CODIGO DEL PLATO
                    codPlato = out.getAttributeValue(0);

                    BufferedReader in = new BufferedReader(new FileReader(new File("composicion.txt")));
                    String cadena;
                    while ((cadena = in.readLine()) != null) {
                        String[] productos = cadena.split("#");
                        if (productos[0].equals(codPlato)) {
                            componentePlato = productos[1];
                            peso = Integer.parseInt(productos[2]);
                            //ORACLE CALCULAMOS CON LOS DATOS
                            stmt.setString(1, componentePlato);
                            rs = stmt.executeQuery();
                            while (rs.next()) {
                                grasasTotales = (float) ((peso * rs.getInt("graxa")) / 100) + grasasTotales;
                            }
                        }
                    }
                    in.close();

                } else if ("nomep".equals(out.getLocalName())) {
                    nomePlato = out.getElementText();
                    Plato2 p1 = new Plato2(codPlato, nomePlato, grasasTotales);
                    System.out.println(p1.toString());
                    //Escribimos el serializado
                    din.writeObject(p1);
                    grasasTotales = 0;
                }
            }
            out.next();
        }
        din.writeObject(null);
        din.close();
        out.close();
        rs.close();
        stmt.close();
        conn.close();

    }

}
