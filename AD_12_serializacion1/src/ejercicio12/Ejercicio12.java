package ejercicio12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author oracle
 */
public class Ejercicio12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Mclase serializablef = new Mclase("ola", -7, 2.7E10);
        ObjectOutputStream din = new ObjectOutputStream(new FileOutputStream(new File("serial.txt")));
        din.writeObject(serializablef);
        din.close();
        
        Mclase serializablef2=new Mclase();
        ObjectInputStream dout = new ObjectInputStream(new FileInputStream(new File("serial.txt")));
        serializablef2= (Mclase) dout.readObject();
        dout.close();
        
        System.out.println(serializablef2.toString());
    }

}
