package com.hurtado.transmiwebapp;

import com.google.gson.Gson;
import data.DAO.ClienteDAO;
import data.DAO.ParadaDAO;
import data.DAO.TarjetaDAO;
import model.Cliente;
import model.Parada;
import model.Tarjeta;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "paradasServlet", value = "/paradasServlet")
public class paradasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession misession = request.getSession();

        if(misession.getAttribute("Logged") != null){
            if(misession.getAttribute("Logged").equals("true")){

                ParadaDAO paradaDAO = new ParadaDAO();

                if(request.getParameter("paradaId")!=null){

                    String paradaObtained = new Gson().toJson(paradaDAO.queryOneParada(request.getParameter("paradaId")));
                    PrintWriter out = response.getWriter();
                    response.setContentType("application/json");

                    out.print(paradaObtained);
                } else {
                    ArrayList<Parada> paradasList = paradaDAO.queryAllParadas();
                    request.setAttribute("paradasList", paradasList);
                    RequestDispatcher rd = request.getRequestDispatcher("/paradas.jsp");

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

                ParadaDAO paradaDAO = new ParadaDAO();

                Parada paradaInsert = new Parada(
                        request.getParameter("parada_nom_ins"),
                        request.getParameter("parada_type_ins"));

                response.getWriter().write("<h1>"+paradaDAO.insertParada(paradaInsert)+"</h1>");
                response.getWriter().write("<a href='/paradasServlet'>Regresar al Sitio</a>");
            } else if(request.getParameter("operation_type").equals("update")){

                ParadaDAO paradaDAO = new ParadaDAO();

                Parada paradaUpdate = new Parada(
                        request.getParameter("parada_nom_upd"),
                        request.getParameter("parada_type_upd"));

                response.getWriter().write("<h1>"+paradaDAO.updateParada(paradaUpdate, request.getParameter("parada_id_upd"))+"</h1>");
                response.getWriter().write("<a href='/paradasServlet'>Regresar al Sitio</a>");
            }
        } else{
            response.sendRedirect("/mainView.jsp");
        }
    }
}
