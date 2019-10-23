/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jericgs.desafiopitang.servlets;

import br.com.jericgs.desafiopitang.logical.Logic;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jerick.gs
 */
@WebServlet(name = "control", urlPatterns = {"/control"})
public class Control extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String parameter = request.getParameter("logic");
        String className = "br.com.jericgs.desafiopitang.logical." + parameter;
        try {
            Class classe = Class.forName(className);
            Logic logic = (Logic) classe.newInstance();
            String page = logic.running(request, response);
            request.getRequestDispatcher(page).forward(request, response);
        } catch (Exception e) {
            throw new ServletException(
                    "Business logic caused an exception", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String parameter = request.getParameter("logic");
        String className = "br.com.jericgs.desafiopitang.logical." + parameter;
        try {
            Class classe = Class.forName(className);
            Logic logic = (Logic) classe.newInstance();
            String page = logic.running(request, response);
            request.getRequestDispatcher(page).forward(request, response);
        } catch (Exception e) {
            throw new ServletException(
                    "Business logic caused an exception", e);
        }
    }

}
