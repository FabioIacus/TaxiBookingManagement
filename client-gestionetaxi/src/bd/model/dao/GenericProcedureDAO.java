package bd.model.dao;

import bd.exception.DAOException;

import java.sql.SQLException;

public interface GenericProcedureDAO<P> {

    P execute(Object... params) throws DAOException, SQLException;

}
