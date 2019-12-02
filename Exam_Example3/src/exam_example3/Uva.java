package exam_example3;

/**
 *
 * @author oracle
 */
public class Uva {
    //v
    private String codiagoa;
    private int acidez;
    private int grao;
    private int taninos;
    private String tipo_uva;
    private int cantidade;
    private String dni;
    
    
    //c

    public Uva(String codiagoa, int acidez, int grao, int taninos, String tipo_uva, int cantidade, String dni) {
        this.codiagoa = codiagoa;
        this.acidez = acidez;
        this.grao = grao;
        this.taninos = taninos;
        this.tipo_uva = tipo_uva;
        this.cantidade = cantidade;
        this.dni = dni;
    }

  public Uva(){
      
  }
    //gt

    public String getCodiagoa() {
        return codiagoa;
    }

    public void setCodiagoa(String codiagoa) {
        this.codiagoa = codiagoa;
    }

    public int getAcidez() {
        return acidez;
    }

    public void setAcidez(int acidez) {
        this.acidez = acidez;
    }

    public int getGrao() {
        return grao;
    }

    public void setGrao(int grao) {
        this.grao = grao;
    }

    public int getTaninos() {
        return taninos;
    }

    public void setTaninos(int taninos) {
        this.taninos = taninos;
    }

    public String getTipo_uva() {
        return tipo_uva;
    }

    public void setTipo_uva(String tipo_uva) {
        this.tipo_uva = tipo_uva;
    }

    public int getCantidade() {
        return cantidade;
    }

    public void setCantidade(int cantidade) {
        this.cantidade = cantidade;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
  //toS

    @Override
    public String toString() {
        return "Uva{" + "codiagoa=" + codiagoa + ", acidez=" + acidez + ", grao=" + grao + ", taninos=" + taninos + ", tipo_uva=" + tipo_uva + ", cantidade=" + cantidade + ", dni=" + dni + '}';
    }
    

   
}   
