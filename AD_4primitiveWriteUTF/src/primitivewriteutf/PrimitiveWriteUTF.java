package primitivewriteutf;

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
public class PrimitiveWriteUTF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        File fichero=new File("texto3.txt");
        FileOutputStream destino = new FileOutputStream(fichero);
        BufferedOutputStream bufout = new BufferedOutputStream(destino);
        DataOutputStream dout = new DataOutputStream(bufout);
        int total=0;
        for (int i = 0; i < 2; i++) {
            dout.writeUTF("o tempo está xélido");
            System.out.println("Escribió: "+(dout.size()-total));
            total=dout.size();
        }
        System.out.println("Total escrito: "+total);
        
        dout.close();
        bufout.close();
        destino.close();

        FileInputStream origen = new FileInputStream(fichero);
        BufferedInputStream bufin = new BufferedInputStream(origen);
        DataInputStream din = new DataInputStream(bufin);
        
        while (din.available()>0){
        System.out.println(din.readUTF()); 
        if(din.available()>0){
              System.out.println("quedan por leer "+din.available()+" bytes");
        }
        }
        din.close();
        bufin.close();
        origen.close();

        
        

    }
}
