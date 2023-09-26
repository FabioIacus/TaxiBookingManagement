package bd.controller;

import bd.exception.DAOException;
import bd.model.dao.*;
import bd.model.domain.ListaCorseAccettate;
import bd.model.domain.Report;
import bd.model.domain.Role;
import bd.model.domain.SelezionaCorsa;
import bd.view.GestoreView;

import java.io.IOException;
import java.sql.SQLException;

public class GestoreController implements Controller {
    @Override
    public void start() {
        try {
            ConnectionFactory.changeRole(Role.GESTORE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            int choice;
            try {
                choice = GestoreView.showMenu();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            switch (choice) {
                case 1 -> riscuotiCommissione();
                case 2 -> report();
                case 3 -> System.exit(0);
                default -> throw new RuntimeException("Scelta non valida");
            }
        }
    }
    SelezionaCorsa selezione = null;
    public void riscuotiCommissione() {
        ListaCorseAccettate lista;
        boolean fail = false;
        try {
            lista = new ListaCorseAccettateDAO().execute();
        } catch (DAOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(lista.toString().isEmpty()) {
            GestoreView.printFail();
            fail = true;
        }
        GestoreView.printLista(lista);
        if (!fail) {
            try {
                selezione = GestoreView.selezione();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                selezione = new RiscuotiCommissioneDAO().execute(selezione.getCodice());
            } catch (DAOException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void report() {
        Report report;
        try {
            report = new ReportDAO().execute();
        } catch (DAOException | SQLException e) {
            throw new RuntimeException(e);
        }
        if(report.toString().isEmpty()) {
            GestoreView.printFailReport();
        }
        GestoreView.printReport(report);
    }
}
