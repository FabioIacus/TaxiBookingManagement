package bd.controller;

import bd.exception.DAOException;
import bd.model.dao.RegCLienteProcedureDAO;
import bd.model.dao.RegTassistaProcedureDAO;
import bd.model.domain.Cliente;
import bd.model.domain.Tassista;
import bd.view.RegistraView;

import java.io.IOException;
public class RegistraController implements Controller {
    Cliente cred = null;
    Tassista cred2 = null;
    String ruolo = null;
    @Override
    public void start() throws IOException {
        ruolo = RegistraView.registrazione();
        if (ruolo.equals("CLIENTE")) {
            try {
                cred = RegistraView.regCliente();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                cred = new RegCLienteProcedureDAO().execute(cred.getRuolo(), cred.getNome(), cred.getCognome(), cred.getCartadicredito(), cred.getTelefono(), cred.getCodicefiscale(), cred.getUsername(), cred.getPassword());
            } catch (DAOException e) {
                throw new RuntimeException(e);
            }
        }
        else if (ruolo.equals("TASSISTA")) {
            try {
                cred2 = RegistraView.regTassista();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                cred2 = new RegTassistaProcedureDAO().execute(cred2.getRuolo(), cred2.getNome(), cred2.getCognome(), cred2.getCarta(), cred2.getUsername(), cred2.getPassword(), cred2.getPosti(), cred2.getPatente(), cred2.getTaxi());
            } catch (DAOException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException("Scelta non valida");
        }
    }
}
