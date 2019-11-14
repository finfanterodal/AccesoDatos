package primitiveutfchars;

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
public class Primitiveutfchars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        File fichero = new File("texto6.txt");
        FileOutputStream destino = new FileOutputStream(fichero);
        BufferedOutputStream bufout = new BufferedOutputStream(destino);
        DataOutputStream dout = new DataOutputStream(bufout);
        int total = 0;
        for (int i = 0; i < 3; i++) {
            if (i == 0 || i == 2) {
                dout.writeUTF("Está en casa");
                System.out.println("Escribió: " + (dout.size() - total));
            } else {
                dout.writeChars("Está en casa");
                System.out.println("Escribió: " + (dout.size() - total));
            }
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

        for (int j = 0; j < 3; j++) {
            if (54 == din.available()) {
                System.out.println("1" + din.readUTF());

            } else if (39 == din.available()) {
                for (int i = 0; i < 12; i++) {
                    cadea = cadea + din.readChar();
                }
                System.out.println("2:" + cadea);
            } else if (15 == din.available()) {
                System.out.println("3:" + cadea);
            }
        }

        
         
         
        din.close();
        bufin.close();
        origen.close();

    }

}
