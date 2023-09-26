package bd.model.domain;

public class CorseAccettate {
    private int codice;
    private float importo;
    private String commissione;

    public CorseAccettate(int codice, float importo, String commissione){
        this.codice=codice;
        this.importo=importo;
        this.commissione=commissione;
    }

    public float getImporto(){
        return this.importo;
    }
    public String getCommissione(){
        return this.commissione;
    }
    public int getCodice(){
        return this.codice;
    }
}
