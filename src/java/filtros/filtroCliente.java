/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package filtros;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.TipoUsuario;
import modelo.entidades.Usuarios;
import modelo.entidades.Usuarios;

/**
 *
 * @author hp
 */
@WebFilter(filterName = "filtroCliente", urlPatterns = {"/cliente/*"}, dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ERROR, DispatcherType.INCLUDE})
public class filtroCliente implements Filter {
   public filtroCliente() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession sesion = req.getSession();
        Usuarios u = (Usuarios) sesion.getAttribute("usuario");
        if (u == null || u.getRol() != TipoUsuario.ADMINISTRADOR || u.getRol() != TipoUsuario.CLIENTE) {
            res.sendRedirect(req.getContextPath() + "/MenuPrincipal");
            return;
        } else {

            chain.doFilter(request, response);
        }

    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {

    }
}
