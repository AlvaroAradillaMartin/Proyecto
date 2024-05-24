/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores.admin;

import static controladores.admin.AnadirServicio.TAM_BUFFER;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import static java.lang.Long.parseLong;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import modelo.ModeloServicio;
import modelo.entidades.Servicio;

/**
 *
 * @author hp
 */
@WebServlet(name = "EditarServicio", urlPatterns = {"/admin/EditarServicio"})
@MultipartConfig
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
        HttpSession sesion = request.getSession();
        String vista = "/admin/editarServicio.jsp";
        String id = request.getParameter("id");
        System.out.println("88888888888888888888888888888");
        System.out.println(id);
        System.out.println("88888888888888888888888888888");
        Servicio s = ModeloServicio.getServicioPorId(parseLong(id));
        request.setAttribute("servicio", s);

        String nombre = request.getParameter("nombreServicio");
        String precio = request.getParameter("precio");
        Part parte = null;
        //Si no venimos del formulario no hay multipart
        try {
            parte = request.getPart("fichero");
        } catch (Exception e) {
            System.out.println(e.getCause());
        }

        if (validarNombre(nombre) && validarPrecio(precio) ) {
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + parte);
            if (parte!= null && validarFichero(parte.getSubmittedFileName())) {
                String nombreFichero = parte.getSubmittedFileName();
                InputStream entrada = parte.getInputStream();
                String ruta = getServletContext().getRealPath("/imagenes/") + nombreFichero;
                FileOutputStream salida = new FileOutputStream(ruta);
                try {
                    byte[] buffer = new byte[TAM_BUFFER];
                    int bytesRead;
                    while ((bytesRead = entrada.read(buffer)) != -1) {
                        salida.write(buffer, 0, bytesRead);
                    }
                } finally {
                    if (salida != null) {
                        salida.close();
                    }
                    if (entrada != null) {
                        entrada.close();
                    }
                }
                String error = ModeloServicio.actualizarServicioConFoto(id, nombre, precio, "imagenes/" + nombreFichero);

                if (error == null) {
                    sesion.setAttribute("Edicion", true);
                } else {
                    System.out.println("++++++++++++++++++++++++++Error++++++++++++++++++++++++++");
                    System.out.println(error);
                    sesion.setAttribute("Edicion", false);
                }

            } else {
                String error = ModeloServicio.actualizarServicio(id, nombre, precio);

                if (error == null) {
                    sesion.setAttribute("Edicion", true);
                } else {
                    System.out.println("------------------------------Error------------------------------");
                    System.out.println(error);
                    sesion.setAttribute("Edicion", false);
                }
            }
            vista = "/GestionServicios";
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

    private boolean validarNombre(String nombre) {
        String patronNombre = "^[A-Za-z]+(?: [A-Za-z]+)*$";
        return nombre != null && nombre.matches(patronNombre);
    }

    private boolean validarPrecio(String precio) {
        String patronPrecio = "^\\d+(\\.\\d{1,2})?$";
        return precio != null && precio.matches(patronPrecio);
    }

    private static boolean validarFichero(String fichero) {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$" + fichero);
        String extension = fichero.substring(fichero.lastIndexOf('.') + 1).toLowerCase();
        return extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg");

    }
}
