package com.portfolio.portfolio_backendap.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "habilidades_proyectos", schema = "u937354102_portfolio", catalog = "")
public class HabilidadesProyectos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_hab_pro", nullable = false)
    private int idHabPro;
    @ManyToOne
    @JoinColumn(name = "id_habilidad", referencedColumnName = "id_habilidad")
    private Habilidades habilidadesByIdHabilidad_0;
    @ManyToOne
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    private Proyectos proyectosByIdProyecto_0;

    public int getIdHabPro() {
        return idHabPro;
    }

    public void setIdHabPro(int idHabPro) {
        this.idHabPro = idHabPro;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HabilidadesProyectos that = (HabilidadesProyectos) o;
        return idHabPro == that.idHabPro ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHabPro);
    }


    public Habilidades getHabilidadesByIdHabilidad() {
        return habilidadesByIdHabilidad_0;
    }

    public void setHabilidadesByIdHabilidad(Habilidades habilidadesByIdHabilidad_0) {
        this.habilidadesByIdHabilidad_0 = habilidadesByIdHabilidad_0;
    }

    public Proyectos getProyectosByIdProyecto() {
        return proyectosByIdProyecto_0;
    }

    public void setProyectosByIdProyecto(Proyectos proyectosByIdProyecto_0) {
        this.proyectosByIdProyecto_0 = proyectosByIdProyecto_0;
    }
}
