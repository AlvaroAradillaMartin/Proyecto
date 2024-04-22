/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.ModeloUsuario;

/**
 *
 * @author hp
 */
@WebServlet(name = "Registro", urlPatterns = {"/Registro"})
public class Registro extends HttpServlet {

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
        String vista = "/menuPrincipal.jsp";

        // Obtener los parámetros del formulario
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        String correo = request.getParameter("email");

        
        if (!validarUsuario(usuario) || !validarContrasena(contrasena) || !validarCorreo(correo)) {
            response.sendRedirect(vista); 
            return;
        }

        String usuarioCreado = ModeloUsuario.crearUsuario(usuario, correo, contrasena);
        //System.out.println("----------------------------------------------------------");
        //System.out.println(usuarioCreado);
        HttpSession sesion = request.getSession();        
        if (usuarioCreado == null) {
            sesion.setAttribute("registroExitoso", true);
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
    private boolean validarUsuario(String usuario) {
        return usuario != null && !usuario.isEmpty();
    }

    // Método para validar la contraseña
    private boolean validarContrasena(String contrasena) {
        // Patrón para validar la contraseña
        String patronContraseña = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-={}\\[\\]:;<>?,./])[A-Za-z\\d!@#$%^&*()_+\\-={}\\[\\]:;<>?,./]{8,20}$";
        return contrasena != null && contrasena.matches(patronContraseña);
    }

    // Método para validar el correo
    private boolean validarCorreo(String correo) {
        // Patrón para validar el correo
        String patronCorreo = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$";
        return correo != null && correo.matches(patronCorreo);
    }

}
