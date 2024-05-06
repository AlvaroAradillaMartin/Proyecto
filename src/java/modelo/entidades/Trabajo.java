/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author hp
 */
@Entity
public class Trabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //ManytoOne
    @OneToOne
    private Servicio servicio;
    //Many to One
    @ManyToOne
    private Usuarios cliente;
    @ManyToMany
    private List<Parcela> parcela;
    private double precioBase;
    private double precioEspecifico;
    private double precioTotal;
    private Boolean facturado;
    @ManyToMany
    private List<Maquinaria> maquinaria;    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaRealizacion;
    private String observaciones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Usuarios getCliente() {
        return cliente;
    }

    public void setCliente(Usuarios cliente) {
        this.cliente = cliente;
    }

    public List<Parcela> getParcela() {
        return parcela;
    }

    public void setParcela(List<Parcela> parcela) {
        this.parcela = parcela;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getPrecioEspecifico() {
        return precioEspecifico;
    }

    public void setPrecioEspecifico(double precioEspecifico) {
        this.precioEspecifico = precioEspecifico;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Boolean getFacturado() {
        return facturado;
    }

    public void setFacturado(Boolean facturado) {
        this.facturado = facturado;
    }

    public List<Maquinaria> getMaquinaria() {
        return maquinaria;
    }

    public void setMaquinaria(List<Maquinaria> maquinaria) {
        this.maquinaria = maquinaria;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

   

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajo)) {
            return false;
        }
        Trabajo other = (Trabajo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Trabajo[ id=" + id + " ]";
    }

}
