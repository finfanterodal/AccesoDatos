package arquivos;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class Methods {
    /*	 1) crear o directorio 'arquivosdir' 
     na ruta '/home/oracle/NetBeansProjects/arquivos/'
     sempre e cando dito directorio non exista.
     comprobar que a ruta foi creada ou existe mediante o comandos do sistema operativo
     */

    public boolean crearDirectorio(File directory) {
        boolean check = false;
        if (!directory.exists()) {
            check = directory.mkdirs();
            System.out.println("Directorio Creado");
        } else {
            System.out.println("Este directorio ya existe");
            check = false;
        }
        return check;
    }
    /*2) crear  o arquivo Products1.txt no directorio 
     mencionado anteriormente (arquivosdir) sempre e cando 
     dito arquivo non exista. 
     comprobar que o arquivo foi creado ou existe mediante comandos do sistema operativo
     */

    public boolean crearArquivos(File directory) {
        boolean check = false;
        if (!directory.exists()) {
            try {
                check = directory.createNewFile();
                System.out.println("Fichero Creado");
            } catch (IOException ex) {
                Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Este fichero ya existe");
            check = false;
        }
        return check;
    }
    /*
     3) comprobar que a ruta foi creada mediante o metodo da clase File axeitado 
        comprobar que o arquivo foi creado mediante o metodo da clase File axeitado
    */
    /*
     4)crear o directorio 'subdir'  
       na ruta '/home/oracle/NetBeansProjects/arquivos/arquivosdir/' 
       creada anteriormente crear o arquivo Products2.txt no 
       directorio mencionado anteriormente (subdir) 
       sempre e cando dito arquivo non exista.
    */
    
    /*
     5)amosar arquivos e subdirectorios do directorio 
     creado '/home/oracle/NetBeansProjects/arquivos/arquivosdir/'
     utilizar para elo o metodo da clase File axeitado : debería verse o seguinte resultado:

		Products1.txt
		subdir
    */
    public String mostrar(File cad){
        String cadena="";
        
        return cadena;
    }
}
