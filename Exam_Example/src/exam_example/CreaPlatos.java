package exam_example;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author oracle
 */
public class CreaPlatos {

    public static void main(String args[]) throws SQLException, IOException, ClassNotFoundException, XMLStreamException {
        // Object serialization
        String[] codes = {"p1", "p2"};
        String[] descricion = {"platocarnico1", "platocarnico2 "};

        try {
            Platos pl = null;

            /*1 p - deben amosar  os valores correspondentes a cada plato (e dicir o seu codigo e nome do plato , que se len do ficheiro platoss). */
            FileOutputStream fos = new FileOutputStream("platoss");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (int i = 0; i < codes.length; i++) {
                pl = new Platos();
                pl.setCodigop(codes[i]);
                pl.setNomep(descricion[i]);
                System.out.println("object: " + pl.toString());
                oos.writeObject(pl);
                oos.flush();

            }
            oos.writeObject(null);
            oos.close();
            fos.close();
        } catch (Exception e) {
            System.out.println("Exception during serialization: " + e);
        }

        listarProductos();
    }

    public static void listarProductos() throws IOException, ClassNotFoundException, SQLException, XMLStreamException {
        //
        XMLOutputFactory a2 = XMLOutputFactory.newInstance();
        XMLStreamWriter a1 = a2.createXMLStreamWriter(new FileWriter(new File("platoss.xml")));
        a1.writeStartDocument("1.0");
        a1.writeStartElement("Platos");
        //Conexion y primera consulta
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        conn = Connect.getConexion();
        //Variables
        int peso = 0;
        float grasasTotales = 0f;
        String nomePlato = "";
        String codPlato = "";

        String sql_SELECT = "SELECT * FROM composicion where codp=?";
        stmt = conn.prepareStatement(sql_SELECT);

        System.out.println("LE PLATOSS");
        Platos object2;
        FileInputStream fis = new FileInputStream("platoss");
        ObjectInputStream ois = new ObjectInputStream(fis);
        //BUSCAMOS EN EL FICHERO EL CODP DEL PLATO
        while ((object2 = (Platos) ois.readObject()) != null) {
            grasasTotales = 0f;
            nomePlato = object2.getNomep();
            //BUSCAMOS EN LA TABLA COMPOSICION EL PLATO CUYO COP COINCIDA 
            stmt.setString(1, object2.getCodigop());
            rs = stmt.executeQuery();

            while (rs.next()) {
                codPlato = rs.getString("codp");
                peso = rs.getInt("peso");

                //BUSCAMOS EN LA TABLA COMPONENTES LA GRASA CON EL CODC DEL PLATO
                PreparedStatement stmt2 = null;
                ResultSet rs2 = null;
                String sql_SELECT2 = "SELECT * FROM componentes WHERE codc=?";
                stmt2 = conn.prepareStatement(sql_SELECT2);
                stmt2.setString(1, rs.getString("codc"));
                rs2 = stmt2.executeQuery();

                while (rs2.next()) {
                    grasasTotales = (float) ((peso * rs2.getInt("graxa")) / 100) + grasasTotales;
                }
                stmt2.close();
                rs2.close();
            }
            //ESCRIBIMOS XML
            //XML
            a1.writeStartElement("Plato");
            a1.writeAttribute("codp", codPlato);
            a1.writeStartElement("nomep");
            a1.writeCharacters(nomePlato);
            a1.writeEndElement();
            a1.writeStartElement("graxaTotal");
            a1.writeCharacters(String.valueOf(grasasTotales));
            a1.writeEndElement();
            a1.writeEndElement();
            System.out.println("CODP: " + codPlato + " NOMEPLATO: " + nomePlato + " GRASASTOTALES: " + grasasTotales);
        }
        a1.writeEndElement();
        a1.close();

        ois.close();
        fis.close();

        rs.close();
        stmt.close();
        conn.close();

    }
}
