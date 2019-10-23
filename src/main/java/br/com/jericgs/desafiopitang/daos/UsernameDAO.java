/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jericgs.desafiopitang.daos;

import br.com.jericgs.desafiopitang.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jerick.gs
 */
public class UsernameDAO {

    private Connection connection;

    public UsernameDAO(Connection connection) {
        this.connection = connection;
    }

    public User getLogin(String user, String password) {

        try {
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM usernames WHERE  user = ? AND password = ?");
            stmt.setString(1, user);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            String sql = "UPDATE usernames SET status = ? WHERE user = ? AND password = ?";
            PreparedStatement ps = this.connection.prepareStatement(sql);

            //Set the values
            ps.setString(1, "Online");
            ps.setString(2, user);
            ps.setString(3, password);

            ps.execute();

            while (rs.next()) {
                // Creat the Objet User
                User userL = new User();
                userL.setUser(rs.getString("user"));
                userL.setPassword(rs.getString("password"));
                userL.setStatus(rs.getString("status"));

                rs.close();
                stmt.close();

                return userL;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsernameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void getLogout(String user) {

        try {
            
            String sql = "UPDATE usernames SET status = ? WHERE user = ?";

            PreparedStatement ps = this.connection.prepareStatement(sql);

            ps.setString(1, "Offline");
            ps.setString(2, user);
            
            ps.execute();
            
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsernameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
