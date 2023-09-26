package bd.view;

import bd.model.domain.Cliente;
import bd.model.domain.Role;
import bd.model.domain.Tassista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RegistraView {

    public static Cliente regCliente() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Role ruolo = Role.CLIENTE;
        System.out.print("Nome: ");
        String nome = reader.readLine();
        System.out.print("Cognome: ");
        String cognome = reader.readLine();
        System.out.print("Carta di credito: ");
        String carta = reader.readLine();
        System.out.print("Numero di telefono: ");
        String telefono = reader.readLine();
        System.out.print("Codice fiscale: ");
        String cfiscale = reader.readLine();
        System.out.print("Username: ");
        String username = reader.readLine();
        System.out.print("Password: ");
        String password = reader.readLine();
        return new Cliente(nome, cognome, carta, telefono, cfiscale, username, password, ruolo);
    }

    public static Tassista regTassista() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Role ruolo = Role.TASSISTA;
        System.out.print("Nome: ");
        String nome = reader.readLine();
        System.out.print("Cognome: ");
        String cognome = reader.readLine();
        System.out.print("Carta di credito: ");
        String carta = reader.readLine();
        System.out.print("Patente: ");
        String patente = reader.readLine();
        System.out.print("Targa del taxi: ");
        String targa = reader.readLine();
        System.out.print("Numero posti: ");
        int posti = 0;
        try {
            posti = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        System.out.print("Username: ");
        String username = reader.readLine();
        System.out.print("Password: ");
        String password = reader.readLine();
        return new Tassista(nome, cognome, carta, patente, targa, posti, username, password, ruolo);
    }

    public static String registrazione() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Sei un cliente o un tassista? ");
        String ruolo = reader.readLine().toUpperCase();
        return ruolo;
    }

    public static void printSuccess() { System.out.println("Utente registrato correttamente!"); }

}
