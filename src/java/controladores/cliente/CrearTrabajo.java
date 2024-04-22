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
import modelo.ModeloServicio;
import modelo.entidades.Parcela;
import modelo.entidades.Servicio;
import modelo.entidades.Usuarios;

/**
 *
 * @author hp
 */
@WebServlet(name = "CrearTrabajo", urlPatterns = {"/cliente/CrearTrabajo"})
public class CrearTrabajo extends HttpServlet {

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
        String vista = "/cliente/crearTrabajo.jsp";
        String id = request.getParameter("id");
        request.setAttribute("servicio", id);
        HttpSession sesion = request.getSession();
        Usuarios u = (Usuarios) sesion.getAttribute("usuario");
        System.out.println("************** CrearTrabajo.java Usuario:");
        System.out.println(u);
        System.out.println("************** CrearTrabajo.java Usuario:");
        List<Parcela> parcelas = u.getParcelas();
        request.setAttribute("parcelas", parcelas);
        request.setAttribute("u", u);
        
        
        String[] parcelasSeleccionadas = request.getParameterValues("parcelasSeleccionadas[]");
        if(validarParcelasSeleccionadas(parcelasSeleccionadas)){
            String error = modelo.ModeloTrabajo.crearTrabajo( u, id, parcelas);
            if(error == null){
                sesion.setAttribute("error", false);
            }else{
                sesion.setAttribute("error", true);
            }
           

            response.sendRedirect(request.getContextPath() + "/Labores");

        }else{
            getServletContext().getRequestDispatcher(vista).forward(request, response);
        }
            
        
        
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

    public static boolean validarParcelasSeleccionadas(String[] parcelasSeleccionadas) {
        if (parcelasSeleccionadas == null || parcelasSeleccionadas.length == 0) {
            return false;
        }
        for (String parcelaId : parcelasSeleccionadas) {
            try {
                Long.parseLong(parcelaId);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

}
