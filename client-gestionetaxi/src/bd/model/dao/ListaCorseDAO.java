package bd.model.dao;

import bd.exception.DAOException;
import bd.model.domain.Corse;
import bd.model.domain.ListaCorse;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListaCorseDAO implements GenericProcedureDAO {
    @Override
    public ListaCorse execute(Object... params) throws DAOException, SQLException {
        ListaCorse corse = new ListaCorse();
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call visualizza_corse()}");
            cs.execute();
            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                Corse corsa = new Corse(rs.getInt(1), rs.getString(2), rs.getString(3));
                corse.addCorse(corsa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return corse;
    }
}
