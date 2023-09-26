package bd.model.domain;

public class TerminaCorsa {
    String username;
    float importo;
    int codice;

    public TerminaCorsa(String username, float importo, int codice) {
        this.username = username;
        this.importo = importo;
        this.codice = codice;
    }

    public float getImporto() {
        return importo;
    }
    public int getCodice() {
        return codice;
    }
    public String getUsername() {return username; }
}
