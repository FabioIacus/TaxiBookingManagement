package bd.view;

import bd.model.domain.Credentials;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LoginView {

    public static int showMenu() throws IOException {
        System.out.println("---- Benvenuto ----");
        System.out.println("---- Cosa vorresti fare? ----");
        System.out.println("1) Accedi");
        System.out.println("2) Registrati");
        System.out.println("3) Termina");
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
    public static Credentials authenticate() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Username: ");
        String username = reader.readLine();
        System.out.print("Password: ");
        String password = reader.readLine();
        return new Credentials(username, password, null);
    }

}
