package ad_18;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author oracle
 */
public class Product {

    //

    String codigo;
    String descipcion;
    Double precio;
    //

    public Product() {
        this.codigo = "";
        this.descipcion = "";
        this.precio = 0d;
    }

    public Product(String codigo, String descipcion, Double precio) {
        this.codigo = codigo;
        this.descipcion = descipcion;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
         NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
             
        return "Product{" + "codigo=" + codigo + ", descipcion=" + descipcion + ", precio=" + nf.format(precio) + '}';
    }

    public void writeProduct(Product po, DataOutputStream dout) throws IOException {
        dout.writeUTF(po.getCodigo() + "," + po.getDescipcion() + ",");
        dout.writeDouble(po.getPrecio());
    }

    public void readProducts(Product po, DataInputStream din) throws IOException {
        
        while(din.available()>0){
        String [] productos;
        String producto=din.readUTF()+din.readDouble();
        productos =producto.split(",");
        po.setCodigo(productos[0]);
        po.setDescipcion(productos[1]);
        po.setPrecio(Double.parseDouble(productos[2]));
        System.out.println(po.toString());
        }
    }
}
