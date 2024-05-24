/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dao.TrabajoJpaController;
import dao.UsuariosJpaController;
import dao.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import static modelo.ModeloTrabajo.PU;
import modelo.entidades.Parcela;
import modelo.entidades.Trabajo;
import modelo.entidades.Usuarios;

/**
 *
 * @author hp
 */
public class ModeloUsuario {

    public static final String PU = "proyectoFinalPU";

    public static String crearUsuario(String usuario, String email, String contrasena) {
        String error = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        UsuariosJpaController ujc = new UsuariosJpaController(emf);
        Usuarios u = new Usuarios();
        u.setNombre(usuario);
        u.setContrasena(contrasena);
        u.setCorreo(email);
        u.setRol(TipoUsuario.CLIENTE);
        try {
            ujc.create(u);
        } catch (RollbackException e) {
            if (e.getMessage().contains("Duplicate")) {
                error = "Ya existe el usuario " + usuario;
            } else {
                error = "Se ha producido un error inesperado";
            }
        }
        emf.close();
        return error;
    }

    public static Usuarios comprobarRegistrado(String nombre, String contrasena) {
        Usuarios u = new Usuarios();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        UsuariosJpaController ujc = new UsuariosJpaController(emf);
        List<Usuarios> usuarios = ujc.findUsuariosEntities();
        for (Usuarios usuario : usuarios) {
            if (usuario.getNombre().equals(nombre) && usuario.getContrasena().equals(contrasena)) {
                u = usuario;
            }
        }
        return u;
    }

    public static String actualizarUsuario(Usuarios u, String nombreUsuario, String contrasena, String correo) {
        String error = null;
        u.setNombre(nombreUsuario);
        u.setContrasena(contrasena);
        u.setCorreo(correo);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        UsuariosJpaController ujc = new UsuariosJpaController(emf);
        try {

            ujc.edit(u);
        } catch (NonexistentEntityException ex) {
            error = "NonexistentEntityException";
        } catch (Exception e) {
            error = "Exception";
        }
        emf.close();
        if (error == null) {
            error = "Actualizado con exito";
        }

        return error;
    }

    public static String anadirParcela(Usuarios u, List<Parcela> parcelas) {
        String error = "";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        UsuariosJpaController ujc = new UsuariosJpaController(emf);
        u.setParcelas(parcelas);
        try {
            ujc.edit(u);
        } catch (NonexistentEntityException ex) {
            error = "NonexistentEntityException";
        } catch (Exception e) {
            error = "Exception";
        }
        emf.close();
        if (error == null) {
            error = "Actualizado con exito";
        }

        return error;
    }

    public static Usuarios getUsuarioPorId(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        UsuariosJpaController ujc = new UsuariosJpaController(emf);
        Usuarios u = ujc.findUsuarios(id);
        return u;
    }
    
    public static List<Usuarios> getUsuarios() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        UsuariosJpaController ujc = new UsuariosJpaController(emf);
        List<Usuarios> usuarios = ujc.findUsuariosEntities();
        emf.close();
        return usuarios;
    }

}
