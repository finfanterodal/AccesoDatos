package exam_example2;

import java.io.Serializable;

/**
 *
 * @author oracle
 */
public class Plato2 extends Platos implements Serializable{

    //Variable a mayores
    private float graxaTotal;

    //Constructor
    public Plato2(String codigo, String nome, float graxaTotal) {
        super(codigo, nome);
        this.graxaTotal = graxaTotal;
    }

    public Plato2() {
    }
    
    

    public float getGraxaTotal() {
        return graxaTotal;
    }

    public void setGraxaTotal(float graxaTotal) {
        this.graxaTotal = graxaTotal;
    }

    @Override
    public String toString() {
        return "codp: " + super.getCodigop() + " nomePlato: " + super.getNomep() + " graxaTotal: " + graxaTotal;
    }

}
