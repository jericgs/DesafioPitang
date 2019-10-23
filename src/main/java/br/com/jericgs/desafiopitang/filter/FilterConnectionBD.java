/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jericgs.desafiopitang.filter;

import br.com.jericgs.desafiopitang.connection.ConnectionBD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @author jerick.gs
 */
@WebFilter(filterName = "FilterConnection", urlPatterns = {"/*"})
public class FilterConnectionBD implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        try {
            //Hanging request connection
            Connection connection;
            connection = new ConnectionBD().getConnection();
            request.setAttribute("connection", connection);
            chain.doFilter(request, response);            

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilterConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {
    }

    /**
     * Init method for this filter
     *
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {

    }
}
