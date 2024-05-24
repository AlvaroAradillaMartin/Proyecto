/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dao.MaquinariaJpaController;
import dao.ServicioJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.entidades.Maquinaria;
import modelo.entidades.Servicio;

/**
 *
 * @author hp
 */
public class ModeloMaquinaria {
    public static final String PU = "proyectoFinalPU";

    public static List<Maquinaria> getmaquinaria() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        MaquinariaJpaController mjc = new MaquinariaJpaController(emf);
        List<Maquinaria> maquinaria = mjc.findMaquinariaEntities();
        emf.close();
        return maquinaria;
    }
}
