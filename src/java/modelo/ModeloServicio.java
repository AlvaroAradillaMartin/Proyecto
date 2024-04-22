/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dao.ServicioJpaController;
import static java.lang.Double.parseDouble;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import modelo.entidades.Servicio;

/**
 *
 * @author hp
 */
public class ModeloServicio {

    public static final String PU = "proyectoFinalPU";

    public static List<Servicio> getServicios() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        ServicioJpaController sjc = new ServicioJpaController(emf);
        List<Servicio> servicios = sjc.findServicioEntities();
        emf.close();
        return servicios;
    }

    public static Servicio getServicioPorId(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        ServicioJpaController sjc = new ServicioJpaController(emf);
        Servicio servicios = sjc.findServicio(id);
        emf.close();
        return servicios;
    }

    public static String crearservicio(String nombre, String precio, String foto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        ServicioJpaController sjc = new ServicioJpaController(emf);
        String error = null;
        Servicio s = new Servicio();
        s.setNombre(nombre);
        s.setPrecio(parseDouble(precio));
        s.setImagen(foto);
        try {
            sjc.create(s);
        } catch (RollbackException e) {
            if (e.getMessage().contains("Duplicate")) {
                error = "Ya existe el servicio " + nombre;
            } else {
                error = "Se ha producido un error inesperado";
            }
        }
        emf.close();
        return error;
        
    }

}
