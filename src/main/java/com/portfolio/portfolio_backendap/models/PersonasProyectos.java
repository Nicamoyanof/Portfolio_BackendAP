package com.portfolio.portfolio_backendap.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "personas_proyectos", schema = "u937354102_portfolio", catalog = "")
public class PersonasProyectos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_per_hab", nullable = false)
    private int idPerHab;
    @ManyToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Personas personasByIdPersona_0;
    @ManyToOne
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    private Proyectos proyectosByIdProyecto_0;

    public int getIdPerHab() {
        return idPerHab;
    }

    public void setIdPerHab(int idPerHab) {
        this.idPerHab = idPerHab;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonasProyectos that = (PersonasProyectos) o;
        return idPerHab == that.idPerHab ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerHab);
    }


    public Personas getPersonasByIdPersona() {
        return personasByIdPersona_0;
    }

    public void setPersonasByIdPersona(Personas personasByIdPersona_0) {
        this.personasByIdPersona_0 = personasByIdPersona_0;
    }

    public Proyectos getProyectosByIdProyecto() {
        return proyectosByIdProyecto_0;
    }

    public void setProyectosByIdProyecto(Proyectos proyectosByIdProyecto_0) {
        this.proyectosByIdProyecto_0 = proyectosByIdProyecto_0;
    }
}
