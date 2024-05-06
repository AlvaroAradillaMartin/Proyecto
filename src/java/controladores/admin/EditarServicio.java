/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores.admin;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Long.parseLong;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ModeloServicio;
import modelo.entidades.Servicio;

/**
 *
 * @author hp
 */
@WebServlet(name = "EditarServicio", urlPatterns = {"/admin/EditarServicio"})
public class EditarServicio extends HttpServlet {

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
        String vista = "/admin/editarServicio.jsp";
        String id = request.getParameter("id");
        System.out.println("***********ID********");
        System.out.println(id);
         System.out.println("***********ID********");
        Servicio s = ModeloServicio.getServicioPorId(parseLong(id));
        request.setAttribute("servicio", s);
        request.getParameter(id);
        if(validarNombre(id))
       
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

    private boolean validarNombre(String nombre) {
        String patronNombre = "^[A-Za-z]+(?: [A-Za-z]+)*$";
        return nombre != null && nombre.matches(patronNombre);
    }

    private boolean validarPrecio(String precio) {
        String patronPrecio = "^\\d+(\\.\\d{1,2})?$";
        return precio != null && precio.matches(patronPrecio);
    }

    private static boolean validarFichero(String fichero) {
        if (fichero == null || fichero.isEmpty()) {
            return false;
        } else {
            String extension = fichero.substring(fichero.lastIndexOf('.') + 1).toLowerCase();
            return extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg");
        }
    }
}
