package bd.model.dao;

import bd.exception.DAOException;
import bd.model.domain.TerminaCorsa;
import bd.view.TassistaView;

import java.sql.*;

public class TerminaCorsaProcedureDAO implements GenericProcedureDAO<TerminaCorsa> {
    public TerminaCorsa execute(Object... params) throws DAOException {
        String username = (String) params[0];
        float importo = (float) params[1];
        int codice = 0;
        boolean fail = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call ricava_codice(?)}");
            cs.setString(1, username);
            cs.executeQuery();
            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                codice = rs.getInt(1);
            }
            cs = conn.prepareCall("{call inserisci_importo(?,?)}");
            cs.setFloat(1, importo);
            cs.setInt(2, codice);
            cs.executeQuery();
        } catch(SQLException e) {
            TassistaView.printError(e);
            fail = true;
        }
        if (!fail) {
            TassistaView.printTermina();
        }

        return new TerminaCorsa(username, importo, codice);
    }
}
