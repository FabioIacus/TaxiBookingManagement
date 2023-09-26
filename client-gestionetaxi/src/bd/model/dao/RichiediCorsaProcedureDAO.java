package bd.model.dao;

import bd.exception.DAOException;
import bd.model.domain.RichiediCorsa;
import bd.view.ClienteView;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class RichiediCorsaProcedureDAO implements GenericProcedureDAO<RichiediCorsa> {
    public RichiediCorsa execute(Object... params) throws DAOException {
        String indPartenza = (String) params[0];
        String indDestinazione = (String) params[1];
        String codFiscale = (String) params[2];
        boolean fail = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call richiedi_corsa(?,?,?)}");
            cs.setString(1, indPartenza);
            cs.setString(2, indDestinazione);
            cs.setString(3, codFiscale);
            cs.executeQuery();
        } catch (SQLException e) {
            ClienteView.printError(e);
            fail = true;
        }
        if (!fail) {
            ClienteView.printRichiesta();
        }
        return new RichiediCorsa(indPartenza, indDestinazione, codFiscale);
    }
}