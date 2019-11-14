package ad_19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class AD_19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        //insertProdutos("p4","coche",5.0);
        listarProdutos();
      // updateProdutos(10.0,"p4");
        deleteProdutos("p4");
        System.out.println("-----------------------");
        listarProdutos();
    }

    //LISTAR
    public static void listarProdutos() throws SQLException {
        Connection conn = null;
        conn = Conection.getConnection();
        PreparedStatement statement = conn.prepareStatement("select produtos.* from produtos", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;
        rs = statement.executeQuery();
        while (rs.next()) {
            Product p1 = new Product(rs.getString("codigo"), rs.getString("descricion"), rs.getDouble("prezo"));
            System.out.println(p1.toString());
        }
        rs.close();
        statement.close();
        conn.close();
    }

        //LISTAR
    public static void insertProdutos(String codigo, String descricion, Double prezo) throws SQLException {
        Connection conn = null;
        conn = Conection.getConnection();
        PreparedStatement statement = conn.prepareStatement("select produtos.* from produtos", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;
        rs = statement.executeQuery();
        rs.moveToInsertRow();
        rs.updateString("codigo", codigo);
        rs.updateString("descricion", descricion);
        rs.updateDouble("prezo", prezo);
        rs.insertRow();
        rs.close();
        statement.close();
        conn.close();
    }

    public static void updateProdutos(Double prezo, String codigo) throws SQLException {
        Connection conn = null;
        conn = Conection.getConnection();
        PreparedStatement statement = conn.prepareStatement("select produtos.* from produtos", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;
        rs = statement.executeQuery();
        while (rs.next()) {
            if (rs.getString("codigo").equals(codigo)) {
                rs.updateDouble("prezo", prezo);
                rs.updateRow();
            }

        }
        rs.close();
        statement.close();
        conn.close();

    }

    public static void deleteProdutos(String codigo) throws SQLException {
        Connection conn = null;
        conn = Conection.getConnection();
        PreparedStatement statement = conn.prepareStatement("select produtos.* from produtos", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;
        rs = statement.executeQuery();
        
        while (rs.next()) {
            if (rs.getString("codigo").equals(codigo)) {
                rs.deleteRow();
            }

        }
        rs.close();
        statement.close();
        conn.close();

    }

}
