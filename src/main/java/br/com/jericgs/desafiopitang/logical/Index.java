/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jericgs.desafiopitang.logical;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jerick.gs
 */
public class Index implements Logic {

    @Override
    public String running(HttpServletRequest req, HttpServletResponse res) throws Exception {

        return "index.jsp";

    }
}
