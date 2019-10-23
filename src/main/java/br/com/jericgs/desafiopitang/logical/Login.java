/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jericgs.desafiopitang.logical;

import br.com.jericgs.desafiopitang.daos.UsernameDAO;
import br.com.jericgs.desafiopitang.models.Alert;
import br.com.jericgs.desafiopitang.models.User;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jerick.gs
 */
public class Login implements Logic {

    @Override
    public String running(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        PrintWriter out = res.getWriter();

        if (username.equalsIgnoreCase("L") && password.equalsIgnoreCase("S")) {
            return "login.jsp";
        } else {
            if ((((username.equalsIgnoreCase("")) && (password.equalsIgnoreCase(""))) || username.equalsIgnoreCase("") || password.equalsIgnoreCase(""))) {

                Alert alert = new Alert();
                alert.setTipyAlert("info");
                alert.setMsnAlert("Campos em Branco!");
                req.setAttribute("result", alert);
                return "login.jsp";
            } else {

                Connection connection = (Connection) req.getAttribute("connection");

                UsernameDAO usernameDAO = new UsernameDAO(connection);
                User userS = usernameDAO.getLogin(username, password);

                if (userS == null) {
                    Alert alert = new Alert();
                    alert.setTipyAlert("error");
                    alert.setMsnAlert("Acesso Negado!");
                    req.setAttribute("result", alert);
                    connection.close();
                    return "login.jsp";
                } else {

                    HttpSession session = req.getSession();
                    session.setAttribute("status", "logged");
                    session.setAttribute("username", userS);
                    connection.close();
                    return "areaUser.jsp";

                }
            }
        }        
    }
}
