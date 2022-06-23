package com.portfolio.portfolio_backendap.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Personas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_persona", nullable = false)
    private int idPersona;
    @Basic
    @Column(name = "nombre", nullable = true, length = 50)
    private String nombre;
    @Basic
    @Column(name = "apellido", nullable = true, length = 50)
    private String apellido;
    @Basic
    @Column(name = "profesion", nullable = true, length = 100)
    private String profesion;
    @Basic
    @Column(name = "ciudad", nullable = true, length = 100)
    private String ciudad;
    @Basic
    @Column(name = "pais", nullable = true, length = 50)
    private String pais;
    @Basic
    @Column(name = "descripcion", nullable = true, length = 500)
    private String descripcion;
    @Basic
    @Column(name = "img_perfil", nullable = true, length = 1000)
    private String imgPerfil;
    @Basic
    @Column(name = "img_banner", nullable = true, length = 1000)
    private String imgBanner;
    @Basic
    @Column(name = "img_banner_M", nullable = true, length = 1000)
    private String imgBannerM;
    @Basic
    @Column(name = "logo", nullable = true, length = 1000)
    private String logo;
    @Basic
    @Column(name = "email", nullable = true, length = 250)
    private String email;
    @Basic
    @Column(name = "linkedin", nullable = true, length = 500)
    private String linkedin;
    @Basic
    @Column(name = "github", nullable = true, length = 400)
    private String github;
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuarios usuariosByIdUsuario;

    public Personas(){
        nombre="";
        apellido="";
        profesion="";
        pais="";
        descripcion="";
        imgPerfil="";
        imgBanner="";
        imgBannerM="";
        logo="";
        email="";
        linkedin="";
        github="";
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    public String getImgBanner() {
        return imgBanner;
    }

    public void setImgBanner(String imgBanner) {
        this.imgBanner = imgBanner;
    }

    public String getImgBannerM() {
        return imgBannerM;
    }

    public void setImgBannerM(String imgBannerM) {
        this.imgBannerM = imgBannerM;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personas personas = (Personas) o;
        return idPersona == personas.idPersona && Objects.equals(nombre, personas.nombre) && Objects.equals(apellido, personas.apellido) && Objects.equals(profesion, personas.profesion) && Objects.equals(ciudad, personas.ciudad) && Objects.equals(pais, personas.pais) && Objects.equals(descripcion, personas.descripcion) && Objects.equals(imgPerfil, personas.imgPerfil) && Objects.equals(imgBanner, personas.imgBanner) && Objects.equals(imgBannerM, personas.imgBannerM) && Objects.equals(logo, personas.logo) && Objects.equals(email, personas.email) && Objects.equals(linkedin, personas.linkedin) && Objects.equals(github, personas.github);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersona, nombre, apellido, profesion, ciudad, pais, descripcion, imgPerfil, imgBanner, imgBannerM, logo, email, linkedin, github);
    }

    public Usuarios getUsuariosByIdUsuario() {
        return usuariosByIdUsuario;
    }

    public void setUsuariosByIdUsuario(Usuarios usuariosByIdUsuario) {
        this.usuariosByIdUsuario = usuariosByIdUsuario;
    }
}
