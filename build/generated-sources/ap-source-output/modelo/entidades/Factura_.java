package modelo.entidades;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidades.Trabajo;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-05-24T10:15:19")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, LocalDate> fecha;
    public static volatile SingularAttribute<Factura, Long> id;
    public static volatile ListAttribute<Factura, Trabajo> trabajos;
    public static volatile SingularAttribute<Factura, Double> precioTotal;

}