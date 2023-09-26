package bd.model.dao;

import bd.exception.DAOException;
import bd.model.domain.Cliente;
import bd.model.domain.Role;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class RegCLienteProcedureDAO implements GenericProcedureDAO<Cliente> {
    public Cliente execute(Object... params) throws DAOException {
        Role role = (Role) params[0];
        String nome = (String) params[1];
        String cognome = (String) params[2];
        String carta = (String) params[3];
        String telefono = (String) params[4];
        String cfiscale = (String) params[5];
        String username = (String) params[6];
        String password = (String) params[7];

        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call registra_cliente(?,?,?,?,?,?,?)}");
            cs.setString(1, nome);
            cs.setString(2, cognome);
            cs.setString(3, carta);
            cs.setString(4, telefono);
            cs.setString(5, cfiscale);
            cs.setString(6, username);
            cs.setString(7, password);
            cs.executeQuery();
        } catch(SQLException e) {
            throw new DAOException("Registration error: " + e.getMessage());
        }


        return new Cliente(nome, cognome, carta, telefono, cfiscale, username, password,role);
    }
}
