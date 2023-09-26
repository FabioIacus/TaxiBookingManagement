package bd.view;

import bd.model.domain.RichiediCorsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

public class ClienteView {

    public static int showMenu() throws IOException {
        System.out.println("*********************************");
        System.out.println("*    DASHBOARD CLIENTE   *");
        System.out.println("*********************************");
        System.out.println("*** Cosa vorresti fare? ***");
        System.out.println("1) Richiedi corsa");
        System.out.println("2) Esci");


        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.print("Inserisci la tua scelta: ");
            choice = input.nextInt();
            if (choice >= 1 && choice <= 2) {
                break;
            }
            System.out.println("Scelta non valida");
        }

        return choice;
    }

    public static RichiediCorsa richiesta() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Indirizzo partenza: ");
        String indPartenza = reader.readLine();

        System.out.print("Indirizzo destinazione: ");
        String indDestinazione = reader.readLine();

        System.out.print("Inserisci il tuo codice fiscale: ");
        String CodFiscale = reader.readLine();

        return new RichiediCorsa(indPartenza, indDestinazione, CodFiscale);
    }

    public static void printError(SQLException e) {
        System.out.println("Errore: " + e.getMessage());
    }

    public static void printRichiesta() {
        System.out.println("Richiesta inviata correttamente!");
        System.out.println("Attendi che venga accettata, in caso contrario dovrai aspettare comunque 2 minuti prima di poter effettuare un'altra richiesta.");
    }

}
