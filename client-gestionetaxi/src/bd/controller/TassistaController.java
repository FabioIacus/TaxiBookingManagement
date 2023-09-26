package bd.controller;

import bd.exception.DAOException;
import bd.model.dao.ConnectionFactory;
import bd.model.dao.ListaCorseDAO;
import bd.model.dao.SelezionaCorsaProcedureDAO;
import bd.model.dao.TerminaCorsaProcedureDAO;
import bd.model.domain.*;
import bd.view.TassistaView;

import java.io.IOException;
import java.sql.SQLException;

public class TassistaController implements Controller {
    @Override
    public void start() {
        try {
            ConnectionFactory.changeRole(Role.TASSISTA);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            int choice;
            try {
                choice = TassistaView.showMenu();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            switch (choice) {
                case 1 -> visualizzaCorse();
                case 2 -> selezionaCorsa();
                case 3 -> terminaCorsa();
                case 4 -> System.exit(0);
                default -> throw new RuntimeException("Scelta non valida");
            }
        }
    }

    TerminaCorsa termina = null;
    private void terminaCorsa() {
        try {
            termina = TassistaView.termina();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            termina = new TerminaCorsaProcedureDAO().execute(termina.getUsername(), termina.getImporto());
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }

    SelezionaCorsa selezione = null;
    private void selezionaCorsa() {
        try {
            selezione = TassistaView.selezione();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            selezione = new SelezionaCorsaProcedureDAO().execute(selezione.getUsername(), selezione.getCodice());
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }

    public void visualizzaCorse() {
        ListaCorse lista;
        try {
            lista = new ListaCorseDAO().execute();
        } catch (DAOException | SQLException e) {
            throw new RuntimeException(e);
        }
        if(lista.toString().isEmpty()) {
            TassistaView.printFail();
        }
        TassistaView.printLista(lista);
    }

}
