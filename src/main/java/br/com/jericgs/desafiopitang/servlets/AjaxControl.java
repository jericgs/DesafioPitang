/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jericgs.desafiopitang.servlets;

import br.com.jericgs.desafiopitang.logical.AjaxLogic;
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
@WebServlet(name = "AjaxControl", urlPatterns = {"/AjaxControl"})
public class AjaxControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String dados = "{\"clientes\": [{\"id\":\"1\", \"nome\":\"Erick g\", \"email\":\"jerick.gs@gmail.com\"}, {\"id\":\"2\", \"nome\":\"Marcos\", \"email\":\"marcos.gs@gmail.com\"}, {\"id\":\"3\", \"nome\":\"José\", \"email\":\"jose.gs@gmail.com\"}]}";

        String parameter = request.getParameter("ajaxLogic");
        String className = "br.com.jericgs.desafiopitang.logical." + parameter;

        try {
            Class classe = Class.forName(className);
            AjaxLogic ajaxLogic = (AjaxLogic) classe.newInstance();
            String json = ajaxLogic.runningAjax(request, response);
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().println(json);
        } catch (Exception e) {
            throw new ServletException(
                    "Business logic caused an exception", e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String dados = "{\"clientes\": [{\"id\":\"1\", \"nome\":\"Erick g\", \"email\":\"jerick.gs@gmail.com\"}, {\"id\":\"2\", \"nome\":\"Marcos\", \"email\":\"marcos.gs@gmail.com\"}, {\"id\":\"3\", \"nome\":\"José\", \"email\":\"jose.gs@gmail.com\"}]}";

        String parameter = request.getParameter("ajaxLogic");
        String className = "br.com.jericgs.desafiopitang.logical." + parameter;

        try {
            Class classe = Class.forName(className);
            AjaxLogic ajaxLogic = (AjaxLogic) classe.newInstance();
            String json = ajaxLogic.runningAjax(request, response);
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().println(json);
        } catch (Exception e) {
            throw new ServletException(
                    "Business logic caused an exception", e);
        }

    }

}
