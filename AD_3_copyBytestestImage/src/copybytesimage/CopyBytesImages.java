package copybytesimage;

import java.io.File;

/**
 *
 * @author oracle
 */
public class CopyBytesImages {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File origen = new File("foto.jpg");
        File destino = new File("foto2.jpg");
        copyBytes cp= new copyBytes();
        //cp.copy(origen, destino);
        cp.copyBuffer(origen, destino);
    }

}
