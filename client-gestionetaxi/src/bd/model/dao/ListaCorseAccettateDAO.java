package bd.model.dao;

import bd.exception.DAOException;
import bd.model.domain.CorseAccettate;
import bd.model.domain.ListaCorseAccettate;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListaCorseAccettateDAO implements GenericProcedureDAO {
    public ListaCorseAccettate execute(Object... params) throws DAOException, SQLException {
        ListaCorseAccettate corseAccettate = new ListaCorseAccettate();
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call visualizza_commissioni()}");
            cs.execute();
            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                CorseAccettate corsa = new CorseAccettate(rs.getInt(1), rs.getFloat(2), rs.getString(3));
                corseAccettate.addCorseAccettate(corsa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return corseAccettate;
    }
}
