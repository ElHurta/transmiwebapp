package com.hurtado.transmiwebapp;

import com.google.gson.Gson;
import com.mysql.cj.xdevapi.Client;
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

                if(request.getParameter("tarjetaId")!=null){

                    String tarjetaObtained = new Gson().toJson(tarjetaDAO.queryOneTarj(request.getParameter("tarjetaId")));
                    PrintWriter out = response.getWriter();
                    response.setContentType("application/json");

                    out.print(tarjetaObtained);
                } else {
                    ArrayList<Tarjeta> tarjetasList = tarjetaDAO.queryAllCards();
                    ArrayList<Cliente> clientesSinTar = clienteDAO.queryAllClientsWithoutCard();

                    request.setAttribute("tarjetasList", tarjetasList);
                    request.setAttribute("clientesSinTar", clientesSinTar);
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

        if(misession.getAttribute("Logged") != null){
            if(request.getParameter("operation_type").equals("insert")){
                ClienteDAO clienteDAO = new ClienteDAO();
                TarjetaDAO tarjetaDAO = new TarjetaDAO();

                Tarjeta tarjetaInsert = new Tarjeta(
                        Double.parseDouble(request.getParameter("tarjeta_sald_ins")),
                        request.getParameter("tarjeta_est_ins"),
                        clienteDAO.queryOneClient(request.getParameter("tarjeta_cli_ins")));

                response.getWriter().write("<h1>"+tarjetaDAO.insertTarjeta(tarjetaInsert)+"</h1>");
                response.getWriter().write("<a href='/tarjetaServlet'>Regresar al Sitio</a>");
            } else if(request.getParameter("operation_type").equals("update")){

                ClienteDAO clienteDAO = new ClienteDAO();

                Tarjeta tarjetaUpdate = new Tarjeta(
                        Double.parseDouble(request.getParameter("tarjeta_sald_upd")),
                        request.getParameter("tarjeta_est_upd"),
                        clienteDAO.queryOneClient(request.getParameter("tarjeta_cli_upd"))
                );

                TarjetaDAO tarjetaDAO = new TarjetaDAO();

                response.getWriter().write("<h1>"+tarjetaDAO.updateTarjeta(tarjetaUpdate, request.getParameter("tarjeta_id_upd"))+"</h1>");
                response.getWriter().write("<a href='/tarjetaServlet'>Regresar al Sitio</a>");
            }
        } else{
            response.sendRedirect("/mainView.jsp");
        }
    }
}
