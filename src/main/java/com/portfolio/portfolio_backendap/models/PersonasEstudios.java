package com.portfolio.portfolio_backendap.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "personas_estudios", schema = "u937354102_portfolio", catalog = "")
public class PersonasEstudios {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_personas_estudios", nullable = false)
    private int idPersonasEstudios;
    @Basic
    @Column(name = "anio_inicio", nullable = true)
    private Integer anioInicio;
    @Basic
    @Column(name = "anio_final", nullable = true)
    private Integer anioFinal;
    @ManyToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Personas personasByIdPersona_0;
    @ManyToOne
    @JoinColumn(name = "id_instituto", referencedColumnName = "id_instituto")
    private Educaciones educacionesByIdInstituto_0;

    public Integer getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(Integer anioInicio) {
        this.anioInicio = anioInicio;
    }

    public Integer getAnioFinal() {
        return anioFinal;
    }

    public void setAnioFinal(Integer anioFinal) {
        this.anioFinal = anioFinal;
    }

    public int getIdPersonasEstudios() {
        return idPersonasEstudios;
    }

    public void setIdPersonasEstudios(int idPersonasEstudios) {
        this.idPersonasEstudios = idPersonasEstudios;
    }

    public Integer getAnioInicio(Integer anioInicio) {
        return this.anioInicio;
    }

    public Integer getAnioFinal(Integer anioFinal) {
        return this.anioFinal;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonasEstudios that = (PersonasEstudios) o;
        return idPersonasEstudios == that.idPersonasEstudios && Objects.equals(anioInicio, that.anioInicio) && Objects.equals(anioFinal, that.anioFinal) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersonasEstudios,  anioInicio, anioFinal);
    }


    public Personas getPersonasByIdPersona() {
        return personasByIdPersona_0;
    }

    public void setPersonasByIdPersona(Personas personasByIdPersona_0) {
        this.personasByIdPersona_0 = personasByIdPersona_0;
    }

    public Educaciones getEducacionesByIdInstituto() {
        return educacionesByIdInstituto_0;
    }

    public void setEducacionesByIdInstituto(Educaciones educacionesByIdInstituto_0) {
        this.educacionesByIdInstituto_0 = educacionesByIdInstituto_0;
    }
}
