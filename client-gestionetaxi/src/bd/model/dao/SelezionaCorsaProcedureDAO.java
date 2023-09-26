package bd.model.dao;

import bd.exception.DAOException;
import bd.model.domain.SelezionaCorsa;
import bd.view.TassistaView;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class SelezionaCorsaProcedureDAO implements GenericProcedureDAO<SelezionaCorsa> {
    public SelezionaCorsa execute(Object... params) throws DAOException {
        String username = (String) params[0];
        int codice = (int) params[1];
        boolean fail = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call seleziona_corsa(?,?)}");
            cs.setString(1, username);
            cs.setInt(2, codice);
            cs.executeQuery();
        } catch (SQLException e) {
            TassistaView.printError(e);
            fail = true;
        }
        if (!fail) {
            TassistaView.printSelezione();
        }
        return new SelezionaCorsa(username, codice);
    }
}
