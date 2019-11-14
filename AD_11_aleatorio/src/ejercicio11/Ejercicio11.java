package ejercicio11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author oracle
 */
public class Ejercicio11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        String[] codes = {"p1", "p2", "p3"};
        String[] descripcion = {"parafusos", "cravos ", "tachas"};
        int[] prices = {3, 4, 5};
        
        File productosAleatorio = new File("ProductosAleatorio.txt");
        RandomAccessFile productos = new RandomAccessFile(productosAleatorio, "rw");
        
        for (int i = 0; i < 3; i++) {
            
            String cod = String.format("%-" + 3 + "s", codes[i]);
            String desc = String.format("%-" + 10 + "s", descripcion[i]);
            productos.writeChars(cod);
            productos.writeChars(desc);
            productos.writeInt(prices[i]);
        }
        
        productos.close();
        
        RandomAccessFile productos1 = new RandomAccessFile(productosAleatorio, "rw");
        Product p2 = new Product();
        
        productos1.seek(0);
        
        String[] pro = productos1.readLine().split(" ");
        for (int i = 0; i < pro.length; i++) {
            System.out.println(pro[i]);
        }
        
        int puntero = 26;
        for (int i = 0; i < 3; i++) {
            productos1.seek(puntero);
            System.out.println(productos1.readInt());
            puntero = puntero + 30;            
        }
        
        productos1.close();
        
    }
    
}
