package bd.model.dao;

import bd.exception.DAOException;
import bd.model.domain.Commissioni;
import bd.model.domain.Report;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportDAO implements GenericProcedureDAO {
    public Report execute(Object... params) throws DAOException, SQLException {
        Report report = new Report();
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call report()}");
            cs.execute();
            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                Commissioni commissione = new Commissioni(rs.getString(1), rs.getInt(2), rs.getFloat(3), rs.getFloat(4));
                report.addCommissioni(commissione);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return report;
    }
}
