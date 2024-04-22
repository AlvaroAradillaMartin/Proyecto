/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.ModeloUsuario;
import modelo.TipoUsuario;
import modelo.entidades.Usuarios;

/**
 *
 * @author hp
 */
@WebServlet(name = "LoginAdmin", urlPatterns = {"/LoginAdmin"})
public class LoginAdmin extends HttpServlet {

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
       String vista = "Administracion/loginAdmin.jsp"; 
       // Obtener los parámetros del formulario
        String usuario = request.getParameter("usuarioLogin");
        String contrasena = request.getParameter("contrasenaLogin");

        if (!validarUsuario(usuario) || !validarContrasena(contrasena)) {
            response.sendRedirect(vista);
            return;
        }
        
        Usuarios usuarioRegistrado = ModeloUsuario.comprobarRegistrado(usuario, contrasena);
        HttpSession sesion = request.getSession();
        if (usuarioRegistrado.getRol() == TipoUsuario.ADMINISTRADOR) {
            sesion.setAttribute("usuario", usuarioRegistrado);
            vista = "/admin/GestionarPrincipal";
            
        } else {
            sesion.setAttribute("error", true);
            vista="/Administracion/loginAdmin.jsp";
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
    private boolean validarUsuario(String usuario) {
        String patronUsuario = "^[A-Z][a-z]+$";
        return usuario != null && !usuario.isEmpty(); //&& usuario.matches(patronUsuario);
    }

    // Método para validar la contraseña
    private boolean validarContrasena(String contrasena) {
        // Patrón para validar la contraseña
        String patronContraseña = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-={}\\[\\]:;<>?,./])[A-Za-z\\d!@#$%^&*()_+\\-={}\\[\\]:;<>?,./]{8,20}$";
        return contrasena != null && contrasena.matches(patronContraseña);
    }
}
