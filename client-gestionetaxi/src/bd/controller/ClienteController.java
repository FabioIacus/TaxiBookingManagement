package bd.controller;

import bd.exception.DAOException;
import bd.model.dao.RichiediCorsaProcedureDAO;
import bd.model.dao.ConnectionFactory;
import bd.model.domain.RichiediCorsa;
import bd.model.domain.Role;
import bd.view.ClienteView;

import java.io.IOException;
import java.sql.SQLException;

public class ClienteController implements Controller {

    @Override
    public void start() {
        try {
            ConnectionFactory.changeRole(Role.CLIENTE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            int choice;
            try {
                choice = ClienteView.showMenu();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            switch (choice) {
                case 1 -> richiediCorsa();
                case 2 -> System.exit(0);
                default -> throw new RuntimeException("Scelta non valida");
            }
        }
    }
    RichiediCorsa richiesta = null;
    public void richiediCorsa() {
        try {
            richiesta = ClienteView.richiesta();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            richiesta = new RichiediCorsaProcedureDAO().execute(richiesta.getIndPart(), richiesta.getIndDest(), richiesta.getCodFisc());
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }



}
