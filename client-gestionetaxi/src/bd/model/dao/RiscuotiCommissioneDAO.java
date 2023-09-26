package bd.model.dao;

import bd.exception.DAOException;
import bd.model.domain.SelezionaCorsa;
import bd.view.GestoreView;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class RiscuotiCommissioneDAO implements GenericProcedureDAO {
    public SelezionaCorsa execute(Object... params) throws DAOException, SQLException {
        int codice = (int) params[0];
        boolean fail = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call riscuoti_commissione(?)}");
            cs.setInt(1, codice);
            cs.executeQuery();
        } catch (SQLException e) {
            GestoreView.printFailRiscossione(e);
            fail = true;
        }
        if (!fail) {
            GestoreView.printSuccRiscossione();
        }
        return new SelezionaCorsa(null, codice);
    }
}
