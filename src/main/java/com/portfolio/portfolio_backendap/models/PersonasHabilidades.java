package com.portfolio.portfolio_backendap.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "personas_habilidades", schema = "u937354102_portfolio", catalog = "")
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
    private Personas personasByIdPersona_0;
    @ManyToOne
    @JoinColumn(name = "id_habilidad", referencedColumnName = "id_habilidad")
    private Habilidades habilidadesByIdHabilidad_0;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonasHabilidades that = (PersonasHabilidades) o;
        return idPerHab == that.idPerHab && Objects.equals(porcentaje, that.porcentaje) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerHab,  porcentaje);
    }


    public Personas getPersonasByIdPersona() {
        return personasByIdPersona_0;
    }

    public void setPersonasByIdPersona(Personas personasByIdPersona_0) {
        this.personasByIdPersona_0 = personasByIdPersona_0;
    }

    public Habilidades getHabilidadesByIdHabilidad() {
        return habilidadesByIdHabilidad_0;
    }

    public void setHabilidadesByIdHabilidad(Habilidades habilidadesByIdHabilidad_0) {
        this.habilidadesByIdHabilidad_0 = habilidadesByIdHabilidad_0;
    }

}
