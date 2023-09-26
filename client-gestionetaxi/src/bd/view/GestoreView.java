package bd.view;

import bd.model.domain.ListaCorseAccettate;
import bd.model.domain.Report;
import bd.model.domain.SelezionaCorsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

public class GestoreView {
    public static int showMenu() throws IOException {
        System.out.println("*********************************");
        System.out.println("*    DASHBOARD GESTORE   *");
        System.out.println("*********************************");
        System.out.println("*** Cosa vorresti fare? ***");
        System.out.println("1) Riscuoti commissione");
        System.out.println("2) Report");
        System.out.println("3) Esci");


        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.print("Inserisci la tua scelta: ");
            choice = input.nextInt();
            if (choice >= 1 && choice <= 3) {
                break;
            }
            System.out.println("Scelta non valida");
        }

        return choice;
    }

    public static SelezionaCorsa selezione() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Inserisci il codice della corsa da cui riscuotere la commissione: ");
        int codice = Integer.parseInt(reader.readLine());

        return new SelezionaCorsa(null, codice);
    }

    public static void printFail() {
        System.out.println("Non ci sono commissioni da riscuotere");
    }
    public static void printFailReport() {
        System.out.println("Non ci sono tassisti all'interno del sistema");
    }
    public static void printFailRiscossione(SQLException e) {
        System.out.println("Errore: " + e.getMessage());
    }
    public static void printSuccRiscossione() {
        System.out.println("Commissione riscossa correttamente!");
    }
    public static void printLista(ListaCorseAccettate lista) {
        System.out.println(lista);
    }
    public static void printReport(Report report) {
        System.out.println(report);
    }

}
