package copybytesimage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class copyBytes {

    public void copy(File origen, File destino) {
        InputStream inp = null;
        OutputStream outp = null;
        try {
            inp = new FileInputStream(origen);
            outp = new FileOutputStream(destino, true);

            int valor = inp.read();
            while (valor != -1) {
                outp.write(valor);
                valor = inp.read();
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                inp.close();
            } catch (IOException ex) {
                Logger.getLogger(copyBytes.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                outp.close();
            } catch (IOException ex) {
                Logger.getLogger(copyBytes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void copyBuffer(File origen, File destino) {
        InputStream inp = null;
        OutputStream outp = null;

        try {
            inp = new FileInputStream(origen);
            outp = new FileOutputStream(destino, true);
            BufferedInputStream bufin = new BufferedInputStream(inp);
            BufferedOutputStream bufout= new BufferedOutputStream(outp);

            int valor = bufin.read();
            while (valor != -1) {
                bufout.write(valor);
                valor = bufin.read();
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                inp.close();
            } catch (IOException ex) {
                Logger.getLogger(copyBytes.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                outp.close();
            } catch (IOException ex) {
                Logger.getLogger(copyBytes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
