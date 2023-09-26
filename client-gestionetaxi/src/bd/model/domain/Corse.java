package bd.model.domain;

public class Corse {
    private int codice;
    private String indPartenza;
    private String indDestinazione;

    public Corse(int codice, String indPartenza, String indDestinazione){
        this.codice=codice;
        this.indPartenza=indPartenza;
        this.indDestinazione=indDestinazione;
    }

    public String getIndPartenza(){
        return this.indPartenza;
    }
    public String getIndDestinazione(){
        return this.indDestinazione;
    }
    public int getCodice(){
        return this.codice;
    }
}
