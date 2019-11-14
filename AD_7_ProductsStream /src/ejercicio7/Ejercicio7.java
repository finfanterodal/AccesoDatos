package ejercicio7;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author oracle
 */
public class Ejercicio7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
       
        Product po1 = new Product("cod1", "parafusos", 3d);
        Product po2 = new Product("cod2", "cravos", 4d);
        Product po3= new Product();

        File fichero = new File("Productos.txt");
        FileOutputStream destino = new FileOutputStream(fichero, true);
        BufferedOutputStream bufout = new BufferedOutputStream(destino);
        DataOutputStream dout = new DataOutputStream(bufout);

        po1.writeProduct(po1, dout);
        po2.writeProduct(po2, dout);
        
        dout.close();
        bufout.close();
        destino.close();
        
        
        
        
        
        FileInputStream origen = new FileInputStream(fichero);
        BufferedInputStream bufin = new BufferedInputStream(origen);
        DataInputStream din = new DataInputStream(bufin);
        
        po3.readProducts(po3, din);
         
        
        din.close();
        bufin.close();
        origen.close();

    }



}
