package com.portfolio.portfolio_backendap.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "personas_proyectos", schema = "fullstack_ap", catalog = "")
public class PersonasProyectos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_per_hab", nullable = false)
    private int idPerHab;
    @ManyToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Personas personasByIdPersona;
    @ManyToOne
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    private Proyectos proyectosByIdProyecto;

    public int getIdPerHab() {
        return idPerHab;
    }

    public void setIdPerHab(int idPerHab) {
        this.idPerHab = idPerHab;
    }


    public Personas getPersonasByIdPersona() {
        return personasByIdPersona;
    }

    public void setPersonasByIdPersona(Personas personasByIdPersona) {
        this.personasByIdPersona = personasByIdPersona;
    }

    public Proyectos getProyectosByIdProyecto() {
        return proyectosByIdProyecto;
    }

    public void setProyectosByIdProyecto(Proyectos proyectosByIdProyecto) {
        this.proyectosByIdProyecto = proyectosByIdProyecto;
    }
}
