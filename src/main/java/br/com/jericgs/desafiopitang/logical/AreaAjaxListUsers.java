/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jericgs.desafiopitang.logical;

import br.com.jericgs.desafiopitang.daos.UserDAO;
import br.com.jericgs.desafiopitang.models.Individual;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jerick.gs
 */
public class AreaAjaxListUsers implements AjaxLogic {

    @Override
    public String runningAjax(HttpServletRequest req, HttpServletResponse res) throws Exception {

        List<Individual> individuals;               

        //DB CONNECTION
        Connection connection = (Connection) req.getAttribute("connection");
                
        //INSTALLING USERDAO AND PERFORMING SEARCH
        UserDAO userDAO = new UserDAO(connection);
        individuals = userDAO.getUsers();
        
        //CLOSE BD
        connection.close();

        //INVERSION OF CONTROL (IOC) - JACKSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(individuals);

        return json;

    }

}
