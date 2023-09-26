package bd.view;

import bd.model.domain.ListaCorse;
import bd.model.domain.SelezionaCorsa;
import bd.model.domain.TerminaCorsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

public class TassistaView {

    public static int showMenu() throws IOException {
        System.out.println("*********************************");
        System.out.println("*    DASHBOARD TASSISTA   *");
        System.out.println("*********************************");
        System.out.println("*** Cosa vorresti fare? ***");
        System.out.println("1) Visualizza richieste di corsa");
        System.out.println("2) Seleziona corsa");
        System.out.println("3) Termina corsa");
        System.out.println("4) Esci");


        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.print("Inserisci la tua scelta: ");
            choice = input.nextInt();
            if (choice >= 1 && choice <= 4) {
                break;
            }
            System.out.println("Scelta non valida");
        }

        return choice;
    }

    public static SelezionaCorsa selezione() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Inserisci il tuo username: ");
        String username = reader.readLine();

        System.out.print("Inserisci il codice della corsa: ");
        int codice = Integer.parseInt(reader.readLine());

        return new SelezionaCorsa(username, codice);
    }

    public static TerminaCorsa termina() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Inserisci il tuo username: ");
        String username = reader.readLine();

        System.out.print("Inserisci l'importo della corsa: ");
        float importo = Float.parseFloat(reader.readLine());

        return new TerminaCorsa(username, importo, 0);
    }

    public static void printFail() { System.out.println("Non ci sono richieste di corsa al momento"); }
    public static void printLista(ListaCorse lista) {
        System.out.println(lista);
    }
    public static void printError(SQLException e) {
        System.out.println("Errore: " + e.getMessage());
    }
    public static void printSelezione() {
        System.out.println("Corsa selezionata correttamente!");
    }
    public static void printTermina() {
        System.out.println("Corsa terminata!");
    }

}