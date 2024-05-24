/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dao.ParcelaJpaController;
import dao.ServicioJpaController;
import dao.exceptions.NonexistentEntityException;
import static java.lang.Double.parseDouble;
import static java.lang.Long.parseLong;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import static modelo.ModeloParcela.PU;
import modelo.entidades.Parcela;
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

    public static String actualizarServicioConFoto(String id, String nombre, String precio, String foto) {
        String error = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        ServicioJpaController sjc = new ServicioJpaController(emf);
        Servicio s = sjc.findServicio(parseLong(id));
        s.setNombre(nombre);
        s.setPrecio(parseDouble(precio));
        s.setImagen(foto);
        try {

            sjc.edit(s);
        } catch (NonexistentEntityException ex) {
            error = "NonexistentEntityException";
        } catch (Exception e) {
            error = "Exception";
        }
        emf.close();

        return error;
    }

    public static String actualizarServicio(String id, String nombre, String precio) {
        String error = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        ServicioJpaController sjc = new ServicioJpaController(emf);
        Servicio s = sjc.findServicio(parseLong(id));
        s.setNombre(nombre);
        s.setPrecio(parseDouble(precio));
        System.out.println("////////////////////////////////////////////////////");
        System.out.println(s);
        try {
            sjc.edit(s);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Actualizndo");
        } catch (NonexistentEntityException ex) {
            error = "NonexistentEntityException";
        } catch (Exception e) {
            error = "Exception";
        }
        emf.close();

        return error;
    }

}
