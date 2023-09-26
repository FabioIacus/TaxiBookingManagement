package bd.model.domain;

public class Tassista {
    private final String nome;
    private final String cognome;
    private final String carta;
    private final Role ruolo;
    private final String username;
    private final String password;
    private final int posti;
    private final String patente;
    private final String taxi;

    public Tassista(String nome, String cognome, String carta, String patente, String taxi, int posti, String username, String password, Role ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.patente = patente;
        this.carta = carta;
        this.taxi = taxi;
        this.posti = posti;
        this.username = username;
        this.password = password;
        this.ruolo = ruolo;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCarta() {
        return carta;
    }

    public Role getRuolo() {
        return ruolo;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPosti() {
        return posti;
    }

    public String getPatente() {
        return patente;
    }
    public String getTaxi() {
        return taxi;
    }

}
