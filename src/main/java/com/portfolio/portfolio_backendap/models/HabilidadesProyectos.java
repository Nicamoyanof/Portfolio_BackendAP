package com.portfolio.portfolio_backendap.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "habilidades_proyectos", schema = "fullstack_ap", catalog = "")
public class HabilidadesProyectos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_hab_pro", nullable = false)
    private int idHabPro;
    @ManyToOne
    @JoinColumn(name = "id_habilidad", referencedColumnName = "id_habilidad")
    private Habilidades habilidadesByIdHabilidad;
    @ManyToOne
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    private Proyectos proyectosByIdProyecto;

    public int getIdHabPro() {
        return idHabPro;
    }

    public void setIdHabPro(int idHabPro) {
        this.idHabPro = idHabPro;
    }

    public Habilidades getHabilidadesByIdHabilidad() {
        return habilidadesByIdHabilidad;
    }

    public void setHabilidadesByIdHabilidad(Habilidades habilidadesByIdHabilidad) {
        this.habilidadesByIdHabilidad = habilidadesByIdHabilidad;
    }

    public Proyectos getProyectosByIdProyecto() {
        return proyectosByIdProyecto;
    }

    public void setProyectosByIdProyecto(Proyectos proyectosByIdProyecto) {
        this.proyectosByIdProyecto = proyectosByIdProyecto;
    }
}
