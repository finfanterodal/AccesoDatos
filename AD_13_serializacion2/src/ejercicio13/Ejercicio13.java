package ejercicio13;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author oracle
 */
public class Ejercicio13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, NullPointerException {
        //
        String[] cod = {"p1", "p2", "p3"};
        String[] desc = {"parafusos", "cravos ", "tachas"};
        Double[] prezo = {3.0, 4.0, 5.0};
        //

        ObjectOutputStream din = new ObjectOutputStream(new FileOutputStream(new File("products.txt")));
        for (int i = 0; i < 3; i++) {
            Product p1 = new Product(cod[i], desc[i], prezo[i]);
            din.writeObject(p1);
        }
        din.writeObject(null);
        din.close();

        ObjectInputStream dout = new ObjectInputStream(new FileInputStream(new File("products.txt")));
        Product p2 = (Product) dout.readObject();
        while (p2 != null) {
            System.out.println(p2.toString());
            p2 = (Product) dout.readObject();
        }
        dout.close();
    }

}
