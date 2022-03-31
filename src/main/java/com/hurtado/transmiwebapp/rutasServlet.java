package com.hurtado.transmiwebapp;

import com.google.gson.Gson;
import data.DAO.ParadaDAO;
import data.DAO.RutaDAO;
import data.DAO.RutaParadaDAO;
import model.Parada;
import model.Ruta;
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
                    String paradasObtained = new Gson().toJson(rutaParadaDAO.queryAllParadasByRuta(request.getParameter("paradasBy")));
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
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) { /*report an error*/ }

        try {
            JSONObject jsonObject =  HTTP.toJSONObject(jb.toString());
            System.out.println(jsonObject);
        } catch (JSONException e) {
            // crash and burn
            throw new IOException("Error parsing JSON request string");
        }
    }
}
