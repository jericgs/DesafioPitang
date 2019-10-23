/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jericgs.desafiopitang.daos;

import br.com.jericgs.desafiopitang.models.Individual;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jerick.gs
 */
public class UserDAO {

    private final Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Individual> getUsers() {

        List<Individual> individuals = new ArrayList<Individual>();

        try {

            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM users");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                
                Individual Individual = new Individual();
                Individual.setIdUser(rs.getInt("idUser"));
                Individual.setName(rs.getString("name"));
                Individual.setGenre(rs.getString("genre"));                
                
                individuals.add(Individual);

            }
            
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return individuals;
    }
}
