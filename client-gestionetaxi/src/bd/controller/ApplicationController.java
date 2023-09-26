package bd.controller;

import bd.model.domain.Credentials;
import bd.view.LoginView;
import bd.view.RegistraView;

import java.io.IOException;

public class ApplicationController implements Controller {
    Credentials cred;

    @Override
    public void start() throws IOException {
        while (true) {
            int choice;
            try {
                choice = LoginView.showMenu();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            switch (choice) {
                case 1 -> accedi();
                case 2 -> registrati();
                case 3 -> System.exit(0);
                default -> throw new RuntimeException("Scelta non valida");
            }
        }
    }

    public void accedi() {
        LoginController loginController = new LoginController();
        loginController.start();
        cred = loginController.getCred();

        if (cred.getRole() == null) {
            throw new RuntimeException("Credenziali non valide");
        }
        switch (cred.getRole()) {
            case CLIENTE -> new ClienteController().start();
            case TASSISTA -> new TassistaController().start();
            case GESTORE -> new GestoreController().start();
            default -> throw new RuntimeException("Ruolo non identificato");
        }
    }

    public void registrati() throws IOException {
        RegistraController registraController = new RegistraController();
        registraController.start();
        RegistraView.printSuccess();
    }
}
