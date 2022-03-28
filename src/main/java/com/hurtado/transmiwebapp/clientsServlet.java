package com.hurtado.transmiwebapp;

import com.google.gson.Gson;
import data.DAO.ClienteDAO;
import model.Cliente;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "clientsServlet", value = "/clientsServlet")
public class clientsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession misession = request.getSession();

        if(misession.getAttribute("Logged") != null){
            if(misession.getAttribute("Logged").equals("true")){

                ClienteDAO clienteDAO = new ClienteDAO();

                if(request.getParameter("clientId")!=null){
                    System.out.println("Obtenido: "+ request.getParameter("clientId"));


                    String clientObtained = new Gson().toJson(clienteDAO.queryOneClient(request.getParameter("clientId")));
                    PrintWriter out = response.getWriter();
                    response.setContentType("application/json");
                    System.out.println(clientObtained);
                    out.print(clientObtained);
                } else {
                    ArrayList<Cliente> clientesList = clienteDAO.queryAllClients();
                    request.setAttribute("clientesList", clientesList);
                    RequestDispatcher rd = request.getRequestDispatcher("/clientes.jsp");

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

        if(misession.getAttribute("Logged") != null){
            if(request.getParameter("operation_type").equals("insert")){
                Cliente clienteInsert = new Cliente(
                        request.getParameter("client_id_ins"),
                        request.getParameter("client_nom_ins"),
                        request.getParameter("client_apel_ins"));

                ClienteDAO clienteDAO = new ClienteDAO();
                clienteDAO.insertCliente(clienteInsert);
                response.getWriter().write("<h1>Inserción realizada</h1>");
                response.getWriter().write("<a href='/clientsServlet'>Regresar al Sitio</a>");
            }
        } else{
            response.sendRedirect("/mainView.jsp");
        }
    }
}
