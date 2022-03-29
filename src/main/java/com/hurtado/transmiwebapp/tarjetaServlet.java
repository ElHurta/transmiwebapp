package com.hurtado.transmiwebapp;

import com.google.gson.Gson;
import data.DAO.ClienteDAO;
import data.DAO.TarjetaDAO;
import model.Cliente;
import model.Tarjeta;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "tarjetaServlet", value = "/tarjetaServlet")
public class tarjetaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession misession = request.getSession();

        if(misession.getAttribute("Logged") != null){
            if(misession.getAttribute("Logged").equals("true")){

                ClienteDAO clienteDAO = new ClienteDAO();
                TarjetaDAO tarjetaDAO = new TarjetaDAO();

                if(request.getParameter("clientId")!=null){

                    String clientObtained = new Gson().toJson(clienteDAO.queryOneClient(request.getParameter("clientId")));
                    PrintWriter out = response.getWriter();
                    response.setContentType("application/json");

                    out.print(clientObtained);
                } else {
                    ArrayList<Tarjeta> tarjetasList = tarjetaDAO.queryAllCards();
                    System.out.println(tarjetasList);
                    request.setAttribute("tarjetasList", tarjetasList);
                    RequestDispatcher rd = request.getRequestDispatcher("/tarjetas.jsp");

                    rd.forward(request, response);
                }

            } else{
                response.sendRedirect("/mainView.jsp");
            }
        } else{
            response.sendRedirect("/mainView.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession misession = request.getSession();
    }
}
