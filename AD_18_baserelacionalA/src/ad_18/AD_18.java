package ad_18;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/*     
 - crear un metodo de nome 'conexion'  que permita conectarse a base orcl mediante o usuario hr password hr 
 driver = "jdbc:oracle:thin:";
 host = "localhost.localdomain"; // tambien puede ser una ip como "192.168.1.14"
 porto = "1521";
 sid = "orcl";
 usuario = "hr";
 password = "hr";
 url = driver + usuario + "/" + password + "@" + host + ":" + porto + ":" + sid;
 //para conectar co native protocal all java driver: creamos un obxecto Connection usando o metodo getConnection da clase  DriverManager            
 Connection conn = DriverManager.getConnection(url);

 -crear un metodo de nome 'insireProduto'  que permita inserir na taboa produtos unha fila pasandolle como parametros o codigo o nome e o prezo dun produto

 - crear un metodo chamdo 'listaProdutos' que amose o contido dos rexistros que hai na base  (debe usarse crearse un resulSet e volcar o contido do mesmo ) 

 - Crear un método de nome 'actualizaPre' tal que pasandolle o codigo e prezo dun rexistro actualize o campo  prezo do rexistro  que corresponde a dito  codigo. 

 - Crear un método de nome ‘borrarfila’ tal que pasandolle o codigo dunha fila elimine dita fila da taboa produtos.

 - Crear un método de nome ‘amosarFila’ tal que pasandolle o codigo dunha fila amose o contido dos seus campos
 */

/**
 *
 * @author oracle
 */
public class AD_18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Conection.getConnection();
        Product p1 = new Product("p1", "parafusosasdasd", 34.0);
        //  Product p2 = new Product("p2", "cravos", 4.0);
        // Product p3 = new Product("p3", "tachas", 7.0);
        // insertProducto(p3);
        //deleteProducto("p1");
        // updateProducto(p1);
        //selectProduct("p2");
        listarProductos();
        
        
    }

    //INSERTAR
    public static int insertProducto(Product producto) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        String sql_INSERT = "INSERT INTO produtos(codigo,descricion,prezo) VALUES(?,?,?)";
        conn = Conection.getConnection();
        stmt = conn.prepareStatement(sql_INSERT);
        stmt.setString(1, producto.getCodigo());
        stmt.setString(2, producto.getDescipcion());
        stmt.setDouble(3, producto.getPrecio());
        rows = stmt.executeUpdate();
        Conection.close(stmt);
        Conection.close(conn);
        return rows;
    }

    //BORRAR
    public static int deleteProducto(String cod) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        String sql_DELETE = "DELETE FROM produtos WHERE codigo = ?";
        conn = Conection.getConnection();
        stmt = conn.prepareStatement(sql_DELETE);
        stmt.setString(1, cod);
        rows = stmt.executeUpdate();
        Conection.close(stmt);
        Conection.close(conn);
        return rows;
    }

    //UPDATE
    public static int updateProducto(Product producto) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        String sql_UPDATE = "UPDATE produtos SET prezo = ?,"
                + "WHERE codigo = ?";
  
        conn = Conection.getConnection();
        stmt = conn.prepareStatement(sql_UPDATE);
        stmt.setString(2, producto.getCodigo());
        stmt.setDouble(1, producto.getPrecio());
        rows = stmt.executeUpdate();
        Conection.close(stmt);
        Conection.close(conn);
        return rows;
    }

    //SELECT UNA FILA
    public static void selectProduct(String valor) {
        try {
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs;
            String vconsulta = "";
            conn = Conection.getConnection();
            String sql_SELECT = "SELECT * FROM produtos WHERE codigo = ?";
            stmt = conn.prepareStatement(sql_SELECT);
            stmt.setString(1, valor);
            rs = stmt.executeQuery();
            // loop through the result set
            while (rs.next()) {
                Product p1 = new Product(rs.getString("codigo"), rs.getString("descricion"), rs.getDouble("prezo"));
                vconsulta = vconsulta + "\n" + p1.toString();
            }
            System.out.println(vconsulta);
            Conection.close(rs);
            Conection.close(stmt);
            Conection.close(conn);

        } catch (NullPointerException ex) {
            System.out.println("NULLL");
        } catch (SQLException ex) {
            Logger.getLogger(AD_18.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    //LISTAR TODAS LAS FILAS
    
        public static void listarProductos( ) {
        try {
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs;
            String vconsulta = "";
            conn = Conection.getConnection();
            String sql_SELECT = "SELECT * FROM produtos";
            stmt = conn.prepareStatement(sql_SELECT);
            rs = stmt.executeQuery();
            // loop through the result set
            while (rs.next()) {
                Product p1 = new Product(rs.getString("codigo"), rs.getString("descricion"), rs.getDouble("prezo"));
                System.out.println(p1.toString()    );
            }
            Conection.close(rs);
            Conection.close(stmt);
            Conection.close(conn);

        } catch (NullPointerException ex) {
            System.out.println("NULLL");
        } catch (SQLException ex) {
            Logger.getLogger(AD_18.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
}
