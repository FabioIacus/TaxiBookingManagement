package bd.model.dao;

import bd.exception.DAOException;
import bd.model.domain.Role;
import bd.model.domain.Tassista;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class RegTassistaProcedureDAO implements GenericProcedureDAO<Tassista>{
    public Tassista execute(Object... params) throws DAOException {
        Role role = (Role) params[0];
        String nome = (String) params[1];
        String cognome = (String) params[2];
        String carta = (String) params[3];
        String username = (String) params[4];
        String password = (String) params[5];
        int posti = (int) params[6];
        String patente = (String) params[7];
        String targa = (String) params[8];

        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call registra_tassista(?,?,?,?,?,?,?,?)}");
            cs.setString(1, nome);
            cs.setString(2, cognome);
            cs.setString(3, carta);
            cs.setString(4, patente);
            cs.setString(5, targa);
            cs.setInt(6, posti);
            cs.setString(7, username);
            cs.setString(8, password);
            cs.executeQuery();
        } catch(SQLException e) {
            throw new DAOException("Registration error: " + e.getMessage());
        }


        return new Tassista(nome, cognome, carta, patente, targa, posti, username, password, role);
    }
}
