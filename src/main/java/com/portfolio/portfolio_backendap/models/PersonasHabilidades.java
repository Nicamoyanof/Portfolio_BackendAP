package com.portfolio.portfolio_backendap.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "personas_habilidades", schema = "fullstack_ap", catalog = "")
public class PersonasHabilidades {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_per_hab", nullable = false)
    private int idPerHab;
    @Basic
    @Column(name = "porcentaje", nullable = true)
    private Integer porcentaje;
    @ManyToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Personas personasByIdPersona;
    @ManyToOne
    @JoinColumn(name = "id_habilidad", referencedColumnName = "id_habilidad")
    private Habilidades habilidadesByIdHabilidad;

    public int getIdPerHab() {
        return idPerHab;
    }

    public void setIdPerHab(int idPerHab) {
        this.idPerHab = idPerHab;
    }


    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }



    public Personas getPersonasByIdPersona() {
        return personasByIdPersona;
    }

    public void setPersonasByIdPersona(Personas personasByIdPersona) {
        this.personasByIdPersona = personasByIdPersona;
    }

    public Habilidades getHabilidadesByIdHabilidad() {
        return habilidadesByIdHabilidad;
    }

    public void setHabilidadesByIdHabilidad(Habilidades habilidadesByIdHabilidad) {
        this.habilidadesByIdHabilidad = habilidadesByIdHabilidad;
    }
}
