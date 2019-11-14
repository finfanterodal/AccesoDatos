package ejercicio12;

import java.io.Serializable;

/**
 *
 * @author oracle
 */
public class Mclase implements Serializable {

    //
    String nome;
    int numero1;
    double numero2;

    //
    public Mclase(String nome, int numero1, double numero2) {
        this.nome = nome;
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public Mclase() {
    }

    @Override
    public String toString() {
        return "Mclase{" + "nome=" + nome + ", numero1=" + numero1 + ", numero2=" + numero2 + '}';
    }
    
    
}
