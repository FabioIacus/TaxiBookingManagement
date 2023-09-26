package bd.model.domain;

public class Cliente {
    private final String nome;
    private final String cognome;
    private final String codicefiscale;
    private final String cartadicredito;
    private final String telefono;
    private final String username;
    private final String password;
    private final Role ruolo;


    public Cliente(String nome, String cognome, String cartadicredito, String telefono, String codicefiscale, String username, String password, Role ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.codicefiscale = codicefiscale;
        this.cartadicredito = cartadicredito;
        this.telefono = telefono;
        this.username = username;
        this.password = password;
        this.ruolo = ruolo;
    }

    @Override
    public String toString() {
        return this.nome + " " + this.cognome + " " + this.cartadicredito + " " + this.telefono + " " + this.codicefiscale + " " + this.username;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCodicefiscale() {
        return codicefiscale;
    }

    public String getCartadicredito() {
        return cartadicredito;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRuolo() {
        return ruolo;
    }
}
