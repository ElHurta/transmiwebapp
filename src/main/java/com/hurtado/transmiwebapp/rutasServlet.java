package com.hurtado.transmiwebapp;

import com.google.gson.Gson;
import data.DAO.ParadaDAO;
import data.DAO.RutaDAO;
import data.DAO.RutaParadaDAO;
import model.Cliente;
import model.Parada;
import model.Ruta;
import model.RutaParada;
import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;


@WebServlet(name = "rutasServlet", value = "/rutasServlet")
public class rutasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession misession = request.getSession();

        if(misession.getAttribute("Logged") != null){
            if(misession.getAttribute("Logged").equals("true")){
                RutaDAO rutaDAO = new RutaDAO();

                if(request.getParameter("rutaId")!=null){

                    String rutaObtained = new Gson().toJson(rutaDAO.queryOneruta(request.getParameter("rutaId")));
                    PrintWriter out = response.getWriter();
                    response.setContentType("application/json");

                    out.print(rutaObtained);
                } else if(request.getParameter("paradasBy")!=null){
                    RutaParadaDAO rutaParadaDAO = new RutaParadaDAO();
                    String paradasObtained = new Gson().toJson(rutaParadaDAO.queryAllRutaParadasByRuta(request.getParameter("paradasBy")));
                    PrintWriter out = response.getWriter();
                    response.setContentType("application/json");

                    out.print(paradasObtained);
                } else {
                    ArrayList<Ruta> rutasList = rutaDAO.queryAllRutas();
                    request.setAttribute("rutasList", rutasList);
                    RequestDispatcher rd = request.getRequestDispatcher("/rutas.jsp");

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

                RutaDAO rutaDAO = new RutaDAO();

                Ruta rutaInsert = new Ruta(
                        request.getParameter("ruta_nom_ins"),
                        request.getParameter("ruta_ini_ins"),
                        request.getParameter("ruta_fin_ins")
                );

                String[] paradasRuta = request.getParameter("ruta_paradas_ids_ins").split(",");

                response.getWriter().write("<h1>"+rutaDAO.insertRuta(rutaInsert, paradasRuta)+"</h1>");
                response.getWriter().write("<a href='/rutasServlet'>Regresar al Sitio</a>");

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