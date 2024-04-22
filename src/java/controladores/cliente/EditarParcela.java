/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores.cliente;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Long.parseLong;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.ModeloParcela;
import modelo.ModeloUsuario;
import modelo.entidades.Parcela;
import modelo.entidades.Usuarios;

/**
 *
 * @author hp
 */
@WebServlet(name = "EditarParcela", urlPatterns = {"/cliente/EditarParcela"})
public class EditarParcela extends HttpServlet {

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
        String vista = "/cliente/editarParcela.jsp";
        String id = request.getParameter("id");
        Parcela p = ModeloParcela.getParcelaPorId(parseLong(id));
        request.setAttribute("parcela", p);
        HttpSession sesion = request.getSession();
        
        String nombre = request.getParameter("nombreParcela");
        String localizacion = request.getParameter("localizacionParcela");
        String tamanoStr = request.getParameter("tamanoParcela");
        
        if(validarNombre(nombre) && validarLocalizacion(localizacion) && validarTamano(tamanoStr)){
            ModeloParcela.actualizarParcela(id, nombre, localizacion, tamanoStr);
            Usuarios usuario =(Usuarios)sesion.getAttribute("usuario");
            Long idUsuario = usuario.getId();
            Usuarios usuarioModeificado= ModeloUsuario.getUsuarioPorId(idUsuario);
            sesion.setAttribute("usuario", usuarioModeificado);
            vista="/cliente/GestionParcelas";
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

// Método para validar el usuario
    private boolean validarNombre(String nombre) {
        String patronNombre = "^[A-Z][a-z]+$";
        return nombre != null && nombre.matches(patronNombre);
    }

    // Método para validar la contraseña
    private boolean validarLocalizacion(String localizacion) {
        // Patrón para validar la contraseña
        String patronLocalizacion = "^[A-Z][a-zA-Z\\s-]+$";
        return localizacion != null && localizacion.matches(patronLocalizacion);
    }

    // Método para validar el correo
    private boolean validarTamano(String tamano) {
        // Patrón para validar el correo
        String patronTamano = "^\\d+(\\.\\d+)?$";
        return tamano != null && tamano.matches(patronTamano);
    }
}
