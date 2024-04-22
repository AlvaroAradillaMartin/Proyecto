/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dao.ServicioJpaController;
import dao.TrabajoJpaController;
import dao.UsuariosJpaController;
import static java.lang.Long.parseLong;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import static modelo.ModeloUsuario.PU;
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
    
    public static String crearTrabajo( Usuarios usuario, String Idservicio, List<Parcela> parcelas) {
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
                error = "Ya existe el Trabajo " ;
            } else {
                error = "Se ha producido un error inesperado";
            }
        }
        emf.close();
        return error;
    }
}
