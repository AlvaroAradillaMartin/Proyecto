/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dao.MaquinariaJpaController;
import dao.ParcelaJpaController;
import dao.ServicioJpaController;
import dao.TrabajoJpaController;
import dao.UsuariosJpaController;
import dao.exceptions.NonexistentEntityException;
import static java.lang.Double.parseDouble;
import static java.lang.Long.parseLong;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import static modelo.ModeloParcela.PU;
import static modelo.ModeloServicio.PU;
import static modelo.ModeloUsuario.PU;
import modelo.entidades.Maquinaria;
import modelo.entidades.Parcela;
import modelo.entidades.Servicio;
import modelo.entidades.Trabajo;
import modelo.entidades.Usuarios;

/**
 *
 * @author hp
 */
public class ModeloTrabajo {

    public static final String PU = "proyectoFinalPU";

    public static String crearTrabajo(Usuarios usuario, String Idservicio, List<Parcela> parcelas) {
        String error = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        TrabajoJpaController tjc = new TrabajoJpaController(emf);
        ServicioJpaController sjc = new ServicioJpaController(emf);
        Servicio s = sjc.findServicio(parseLong(Idservicio));
        Trabajo t = new Trabajo();
        t.setCliente(usuario);
        t.setServicio(s);
        t.setParcela(parcelas);
        t.setPrecioBase(s.getPrecio());
        try {
            tjc.create(t);
        } catch (RollbackException e) {
            if (e.getMessage().contains("Duplicate")) {
                error = "Ya existe el Trabajo ";
            } else {
                error = "Se ha producido un error inesperado";
            }
        }
        emf.close();
        return error;
    }

    public static List<Trabajo> getPeticiones() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        TrabajoJpaController tjc = new TrabajoJpaController(emf);
        List<Trabajo> peticiones = tjc.findTrabajoEntities();
        emf.close();
        return peticiones;
    }

    public static Trabajo getTrabajoPorId(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        TrabajoJpaController tjc = new TrabajoJpaController(emf);
        Trabajo trabajo = tjc.findTrabajo(id);
        emf.close();
        return trabajo;
    }

    public static String actualizarTrabajo(String id, String precioEspecifico, String observaciones,LocalDate fecha, String[] maquinas) {
        String error = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        TrabajoJpaController tjc = new TrabajoJpaController(emf);
        MaquinariaJpaController mjc = new MaquinariaJpaController(emf);
        Trabajo t = tjc.findTrabajo(parseLong(id));
        t.setPrecioEspecifico(parseDouble(precioEspecifico));
        t.setObservaciones(observaciones);
        t.setFechaRealizacion(fecha);
        List<Parcela> parcelas = t.getParcela();
        Double numeroHectareas = 0.0;
        for (Parcela parcela : parcelas) {
            numeroHectareas+=parcela.getTamano();
        }
        t.setPrecioTotal((t.getPrecioBase()+parseDouble(precioEspecifico))*numeroHectareas);
        List<Maquinaria> maquinaria = new ArrayList();
        for (String m : maquinas) {
            Maquinaria maq = mjc.findMaquinaria(parseLong(m));
            maquinaria.add(maq);
        }
        t.setMaquinaria(maquinaria);
        try {

            tjc.edit(t);
        } catch (NonexistentEntityException ex) {
            error = "NonexistentEntityException";
        } catch (Exception e) {
            error = "Exception";
        }
        emf.close();

        return error;
    }
    
    public static void eliminarTrabajo(long a) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        TrabajoJpaController tjc = new TrabajoJpaController(emf);
        try {
            tjc.destroy(a);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ModeloTrabajo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
