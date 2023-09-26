package bd.model.domain;

public class SelezionaCorsa {
    String username;
    int codice;

    public SelezionaCorsa(String username, int codice) {
        this.username = username;
        this.codice = codice;
    }

    public String getUsername() {
        return username;
    }
    public int getCodice() {
        return codice;
    }
}
