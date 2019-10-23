package br.com.jericgs.desafiopitang.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author jerick.gs
 */
public class ConnectionBD {

    public Connection getConnection() throws ClassNotFoundException {        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/pbd?useTimezone=true&serverTimezone=America/Fortaleza", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
