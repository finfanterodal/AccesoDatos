package exam_example3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author oracle
 */
public class Exam_Example3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException {
        insertProducto();

    }

    //INSERTAR
    public static void insertProducto() throws SQLException, FileNotFoundException, IOException {
        //DECALARACIONES
        Uva u1;
        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;
        PreparedStatement stmt4 = null;
        ResultSet rs = null;
        conn = Connect.getConexion();
        BufferedReader in = new BufferedReader(new FileReader(new File("analisis.txt")));
        String cadena;
        String sql_SELECT1 = "SELECT * FROM uvas where tipo=?";
        stmt = conn.prepareStatement(sql_SELECT1);
        String sql_INSERT = "INSERT INTO xerado(num,nomeuva,tratacidez,total) VALUES(?,?,?,?)";
        stmt2 = conn.prepareStatement(sql_INSERT);

        String sql_SELECT2 = "SELECT * FROM clientes where dni=?";
        stmt3 = conn.prepareStatement(sql_SELECT2);
        String sql_UPDATE = "UPDATE clientes SET numerodeanalisis=? WHERE dni=?";
        stmt4 = conn.prepareStatement(sql_UPDATE);
        //
        String nomeUva;
        int minAcid, maxAcid, total, numAnalisisActual;
        String trataAcid = "";

        //LECTURA TXT
        while ((cadena = in.readLine()) != null) {
            numAnalisisActual = 0;
            String[] datos = cadena.split(",");
            u1 = new Uva(datos[0], Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), Integer.parseInt(datos[3]), datos[4], Integer.parseInt(datos[5]), datos[6]);
            System.out.println(u1.toString());

            stmt.setString(1, u1.getTipo_uva());
            rs = stmt.executeQuery();
            // BUSQUEDA EN LA TABLA UVAS
            while (rs.next()) {

                if (rs.getString("tipo").equals(u1.getTipo_uva())) {
                    //variables temp GUARDAMOS LOS DATOS
                    nomeUva = rs.getString("nomeu");
                    minAcid = rs.getInt("acidezmin");
                    maxAcid = rs.getInt("acidezMax");
                    if (u1.getAcidez() < minAcid) {
                        trataAcid = "Subir Acidez";
                    } else if (u1.getAcidez() > maxAcid) {
                        trataAcid = "Bajar Acidez";
                    }
                    total = u1.getCantidade() * 15;
                    //ESCIRTURA en la tabla XERADOS
                    stmt2.setString(1, u1.getCodiagoa());
                    stmt2.setString(2, nomeUva);
                    stmt2.setString(3, trataAcid);
                    stmt2.setInt(4, total);
                    stmt2.executeUpdate();
                    System.out.println("codigo a:" + u1.getCodiagoa() + " Nome Uva: " + nomeUva + " trataAcidez: " + trataAcid + " total: " + total);
                }
            }
            stmt3.setString(1, u1.getDni());
            rs = stmt3.executeQuery();
            while (rs.next()) {
                numAnalisisActual = rs.getInt("numerodeanalisis");
                numAnalisisActual = numAnalisisActual + 1;
            }

            stmt4.setInt(1, numAnalisisActual);
            stmt4.setString(2, u1.getDni());
            stmt4.executeUpdate();

        }
        in.close();

        //Cerramos todo ORACLE
        stmt.close();
        conn.close();
    }


}
