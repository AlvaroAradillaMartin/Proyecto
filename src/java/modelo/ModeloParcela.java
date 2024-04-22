/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dao.ParcelaJpaController;
import dao.UsuariosJpaController;
import dao.exceptions.NonexistentEntityException;
import static java.lang.Double.parseDouble;
import static java.lang.Long.parseLong;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import static modelo.ModeloUsuario.PU;
import modelo.entidades.Parcela;
import modelo.entidades.Usuarios;

/**
 *
 * @author hp
 */
public class ModeloParcela {

    public static final String PU = "proyectoFinalPU";

    public static Parcela anadirParcela(String nombre, String localizacion, String tamano) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        ParcelaJpaController pjc = new ParcelaJpaController(emf);
        Parcela p = new Parcela();
        p.setLocalizacion(localizacion);
        p.setNombre(nombre);
        p.setTamano(Double.parseDouble(tamano));
        try {
            pjc.create(p);
        } catch (RollbackException e) {
            if (e.getMessage().contains("Duplicate")) {
                System.out.println("------------------------");
                System.out.println("Duplicate");
            } else {
                System.out.println("*************************");
                System.out.println("inesperado");
            }
        }
        emf.close();
        return p;
    }

    public static void eliminarParcela(long a) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        ParcelaJpaController pjc = new ParcelaJpaController(emf);
        try {
            pjc.destroy(a);
        } catch (NonexistentEntityException ex) {
            System.out.println("******************************eliminarParcela metodo");
            Logger.getLogger(ModeloParcela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Parcela getParcelaPorId(long a) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        ParcelaJpaController pjc = new ParcelaJpaController(emf);
        Parcela p = pjc.findParcela(a);
        return p;
    }
    
    public static String actualizarParcela(String id, String nombre, String localizacion, String tamano) {
        String error = null;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        ParcelaJpaController ajc = new ParcelaJpaController(emf);        
        Parcela p = ajc.findParcela(parseLong(id));
        p.setNombre(nombre);
        p.setLocalizacion(localizacion);
        p.setTamano(parseDouble(tamano));
        try {

            ajc.edit(p);
        } catch (NonexistentEntityException ex) {
            error = "NonexistentEntityException";
        } catch (Exception e) {
            error = "Exception";
        }
        emf.close();

        return error;
    }

}
