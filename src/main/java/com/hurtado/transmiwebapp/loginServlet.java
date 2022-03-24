package com.hurtado.transmiwebapp;

import com.google.gson.Gson;
import data.DAO.UsuarioDAO;
import data.Operaciones;
import model.Parada;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet {

    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.write("Hola");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if(usuarioDAO.iniciarSesion(req.getParameter("username_login"), req.getParameter("password_login"))){
            System.out.println("Loggeado Master");
        } else {
            System.out.println("F");
        }
    }

    public void destroy() {
    }
}