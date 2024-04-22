package modelo.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidades.Maquinaria;
import modelo.entidades.Parcela;
import modelo.entidades.Servicio;
import modelo.entidades.Usuarios;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-04-21T17:26:38")
@StaticMetamodel(Trabajo.class)
public class Trabajo_ { 

    public static volatile SingularAttribute<Trabajo, Usuarios> cliente;
    public static volatile SingularAttribute<Trabajo, Servicio> servicio;
    public static volatile SingularAttribute<Trabajo, Date> fechaRealizacion;
    public static volatile SingularAttribute<Trabajo, Double> precioBase;
    public static volatile SingularAttribute<Trabajo, Boolean> facturado;
    public static volatile SingularAttribute<Trabajo, String> observaciones;
    public static volatile SingularAttribute<Trabajo, Long> id;
    public static volatile SingularAttribute<Trabajo, Double> precioEspecifico;
    public static volatile SingularAttribute<Trabajo, Double> precioTotal;
    public static volatile ListAttribute<Trabajo, Parcela> parcela;
    public static volatile ListAttribute<Trabajo, Maquinaria> maquinaria;

}