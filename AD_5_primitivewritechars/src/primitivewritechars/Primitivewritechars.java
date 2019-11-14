package primitivewritechars;

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
public class Primitivewritechars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        File fichero = new File("texto4.txt");
        FileOutputStream destino = new FileOutputStream(fichero);
        BufferedOutputStream bufout = new BufferedOutputStream(destino);
        DataOutputStream dout = new DataOutputStream(bufout);
        int total = 0;
        for (int i = 0; i < 2; i++) {
            dout.writeChars("o tempo está xélido");
            System.out.println("Escribió: " + (dout.size() - total));
            total = dout.size();
        }
        System.out.println("Total escrito: " + total);

        dout.close();
        bufout.close();
        destino.close();

        FileInputStream origen = new FileInputStream(fichero);
        BufferedInputStream bufin = new BufferedInputStream(origen);
        DataInputStream din = new DataInputStream(bufin);
        String cadea = "";

        while (din.available() > 0) {
            cadea = cadea + din.readChar();
            if (cadea.length() == 19) {
                System.out.println("Primera cadena: " + cadea);
                System.out.println("Bytes Leidos: " + cadea.length() * 2);
                System.out.println("Quedan por leer: " + din.available());
                cadea = "";

            } else if (cadea.length() == 38) {
                System.out.println("Segunda cadena: " + cadea);
                System.out.println("Bytes Leidos: " + cadea.length() * 2);
                System.out.println("Quedan por leer: "+din.available());
            }
            }

        din.close();
        bufin.close();
        origen.close();

      
        
    }
    
}
