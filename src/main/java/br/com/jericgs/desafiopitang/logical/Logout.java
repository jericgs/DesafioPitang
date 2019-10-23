/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jericgs.desafiopitang.logical;

import br.com.jericgs.desafiopitang.daos.UsernameDAO;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jerick.gs
 */
public class Logout implements Logic {

    @Override
    public String running(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String status = req.getParameter("status");
        String username = req.getParameter("username");

        if (status.equalsIgnoreCase("logged")) {

            //Invalidate session
            HttpSession sessao = req.getSession();
            sessao.invalidate();

            //Change status to offline
            Connection connection = (Connection) req.getAttribute("connection");

            UsernameDAO usernameDAO = new UsernameDAO(connection);
            usernameDAO.getLogout(username);
            return "login.jsp";
        }
        return null;

    }

}
