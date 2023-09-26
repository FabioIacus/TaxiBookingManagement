package bd.model.domain;

public class Commissioni {
    private String patente;
    private int numCorse;
    private float importo;
    private float commissione;

    public Commissioni(String patente, int numCorse, float importo, float commissione) {
        this.patente = patente;
        this.numCorse = numCorse;
        this.importo = importo;
        this.commissione = commissione;
    }

    public String getPatente() {
        return patente;
    }

    public int getNumCorse() {
        return numCorse;
    }

    public float getImporto() {
        return importo;
    }

    public float getCommissione() {
        return commissione;
    }
}
