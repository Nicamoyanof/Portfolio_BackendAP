package com.portfolio.portfolio_backendap.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Educaciones {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_instituto", nullable = false)
    private int idInstituto;
    @Basic
    @Column(name = "nombre_instituto", nullable = true, length = 100)
    private String nombreInstituto;
    @Basic
    @Column(name = "titulo_instituto", nullable = true, length = 100)
    private String tituloInstituto;
    @Basic
    @Column(name = "logo", nullable = true, length = 500)
    private String logo;

    public int getIdInstituto() {
        return idInstituto;
    }

    public void setIdInstituto(int idInstituto) {
        this.idInstituto = idInstituto;
    }

    public String getNombreInstituto() {
        return nombreInstituto;
    }

    public void setNombreInstituto(String nombreInstituto) {
        this.nombreInstituto = nombreInstituto;
    }

    public String getTituloInstituto() {
        return tituloInstituto;
    }

    public void setTituloInstituto(String tituloInstituto) {
        this.tituloInstituto = tituloInstituto;
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
        Educaciones that = (Educaciones) o;
        return idInstituto == that.idInstituto && Objects.equals(nombreInstituto, that.nombreInstituto) && Objects.equals(tituloInstituto, that.tituloInstituto) && Objects.equals(logo, that.logo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInstituto, nombreInstituto, tituloInstituto, logo);
    }

}
