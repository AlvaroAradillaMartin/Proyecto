/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores.admin;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Long.parseLong;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.ModeloMaquinaria;
import modelo.ModeloServicio;
import modelo.ModeloTrabajo;
import modelo.entidades.Maquinaria;
import modelo.entidades.Parcela;
import modelo.entidades.Servicio;
import modelo.entidades.Trabajo;

/**
 *
 * @author hp
 */
@WebServlet(name = "GestionPeticion", urlPatterns = {"/admin/GestionPeticion"})
public class GestionPeticion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vista = "/admin/gestionPeticion.jsp";
        String id = request.getParameter("id");
        Trabajo t = ModeloTrabajo.getTrabajoPorId(parseLong(id));
        List<Maquinaria> maquinaria = ModeloMaquinaria.getmaquinaria();
        List<Maquinaria> maquinariaTrabajo = t.getMaquinaria();
        
        request.setAttribute("trabajo", t);
        request.setAttribute("maquinaria", maquinaria);
        request.setAttribute("maquinariaTrabajo", maquinariaTrabajo);

        String precioEspecifico = request.getParameter("especifico");
        String observaciones = request.getParameter("observaciones");
        String fechaStr = request.getParameter("fecha");
        String[] maquinariaSeleccionada = request.getParameterValues("maquinaria[]");
        LocalDate hoy = LocalDate.now();
        if (observaciones != null /*&& observaciones.length() < 240 && fechaStr != null && LocalDate.parse(fechaStr).isBefore(hoy) && validarPrecio(precioEspecifico) && maquinariaSeleccionada != "seleccione"*/) {
            String error = ModeloTrabajo.actualizarTrabajo(id, precioEspecifico, observaciones, LocalDate.parse(fechaStr),  maquinariaSeleccionada);
            HttpSession sesion = request.getSession();
            if (error == null) {
                sesion.setAttribute("Gestion", true);
            } else {
                sesion.setAttribute("Gestion", false);
            }
            vista = "/admin/GestionarPeticiones";
        }

        getServletContext().getRequestDispatcher(vista).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean validarPrecio(String precio) {
        String patronPrecio = "^\\d+(\\.\\d{1,2})?$";
        return precio != null && precio.matches(patronPrecio);
    }
}
