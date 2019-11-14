package ejercicio8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

/**
 *
 * @author oracle
 */
public class Ejercicio8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

        Product po1 = new Product();

        String[] cod = {"p1", "p2", "p3"};
        String[] desc = {"parafusos", "cravos", "tachas"};
        Double[] prezo = {3.0, 4.0, 5.0};

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("Productos.txt"))));

        for (int i = 0; i < 3; i++) {
            out.println(cod[i] + "\t" + desc[i] + "\t" + String.valueOf(prezo[i]));
        }
        out.close();

        BufferedReader in = new BufferedReader(new FileReader(new File("Productos.txt")));
        for (int i = 0; i < 3; i++) {
            String[] productos = in.readLine().split("\t");
            po1.setCodigo(productos[0]);
            po1.setDescipcion(productos[1]);
            po1.setPrecio(Double.parseDouble(productos[2]));
            System.out.println(po1.toString());
        }

        in.close();

    }

}
