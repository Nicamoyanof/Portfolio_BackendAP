package com.portfolio.portfolio_backendap.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Proyectos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_proyecto", nullable = false)
    private int idProyecto;
    @Basic
    @Column(name = "nombre", nullable = true, length = 50)
    private String nombre;
    @Basic
    @Column(name = "img_proyecto", nullable = true, length = 1000)
    private String imgProyecto;
    @Basic
    @Column(name = "link_github", nullable = true, length = 400)
    private String linkGithub;

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImgProyecto() {
        return imgProyecto;
    }

    public void setImgProyecto(String imgProyecto) {
        this.imgProyecto = imgProyecto;
    }

    public String getLinkGithub() {
        return linkGithub;
    }

    public void setLinkGithub(String linkGithub) {
        this.linkGithub = linkGithub;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proyectos proyectos = (Proyectos) o;
        return idProyecto == proyectos.idProyecto && Objects.equals(nombre, proyectos.nombre) && Objects.equals(imgProyecto, proyectos.imgProyecto) && Objects.equals(linkGithub, proyectos.linkGithub);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProyecto, nombre, imgProyecto, linkGithub);
    }

}
