package ejercicio13;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author oracle
 */
public class Product implements Serializable{

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

}
