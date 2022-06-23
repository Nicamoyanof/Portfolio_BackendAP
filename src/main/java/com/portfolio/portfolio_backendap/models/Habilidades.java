package com.portfolio.portfolio_backendap.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Habilidades {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_habilidad", nullable = false)
    private int idHabilidad;
    @Basic
    @Column(name = "nombre", nullable = true, length = 100)
    private String nombre;
    @Basic
    @Column(name = "logo", nullable = true, length = 500)
    private String logo;

    public int getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(int idHabilidad) {
        this.idHabilidad = idHabilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habilidades that = (Habilidades) o;
        return idHabilidad == that.idHabilidad && Objects.equals(nombre, that.nombre) && Objects.equals(logo, that.logo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHabilidad, nombre, logo);
    }

}
