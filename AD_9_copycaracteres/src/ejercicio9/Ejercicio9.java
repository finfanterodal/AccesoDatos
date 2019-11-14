package ejercicio9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author oracle
 */
public class Ejercicio9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        //
        FileReader din = new FileReader(new File("texto10.txt"));
        ArrayList<Integer> caracteres = new ArrayList();
        int valor = din.read();
        while (valor > 0) {
            System.out.println((char)valor+"="+valor);
            caracteres.add(valor);
            valor = din.read();
        }
        din.close();
        
        FileWriter dout = new FileWriter(new File("texto11.txt"));
        for (int i = 0; i < caracteres.size();i++) {
            dout.write(caracteres.get(i));
        }
        dout.close();
    }

}
