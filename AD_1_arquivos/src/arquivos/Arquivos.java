package arquivos;

import java.io.File;

/**
 *
 * @author oracle
 */
public class Arquivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Methods metodos=new Methods();
        //1.Directorio arquivosdir
        File arquivosdir=new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir");
        metodos.crearDirectorio(arquivosdir);
       
        //2.Fchero Products.txt
        File products = new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir/Products1.txt");
        metodos.crearArquivos(products);
       
            //4.
        File subdir = new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir/subdir");
        File products2 = new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir/subdir/Products2.txt");
        metodos.crearDirectorio(subdir);
        metodos.crearArquivos(products2);
        
        
    }
}
