package copybytestexto;

import java.io.File;

/**
 *
 * @author oracle
 */
public class CopyBytesTestexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File origen = new File("texto1.txt");
        File destino = new File("texto2.txt");
        copyBytes cp= new copyBytes();
        cp.copy(origen, destino);
    }

}
