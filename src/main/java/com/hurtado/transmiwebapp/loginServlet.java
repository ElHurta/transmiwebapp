package com.hurtado.transmiwebapp;

import data.DAO.UsuarioDAO;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if(req.getParameter("username_login").isEmpty() && req.getParameter("password_login").isEmpty()){
            resp.sendRedirect(req.getContextPath() + "/mainView.jsp");
            HttpSession misession= req.getSession(true);
            misession.setAttribute("Logged", "no_credentials");
        } else {
            if(usuarioDAO.iniciarSesion(req.getParameter("username_login"), req.getParameter("password_login"))){
                resp.sendRedirect(req.getContextPath() + "/mainView.jsp");
                HttpSession misession= req.getSession(true);
                misession.setAttribute("Logged", "true");

            } else {
                resp.sendRedirect(req.getContextPath() + "/mainView.jsp");
                HttpSession misession= req.getSession(true);
                misession.setAttribute("Logged", "false");
            }
        }
    }

    public void destroy() {
    }
}