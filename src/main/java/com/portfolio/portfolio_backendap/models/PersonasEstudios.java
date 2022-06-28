package com.portfolio.portfolio_backendap.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "personas_estudios", schema = "fullstack_ap", catalog = "")
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
    private Personas personasByIdPersona;
    @ManyToOne
    @JoinColumn(name = "id_instituto", referencedColumnName = "id_instituto")
    private Educaciones educacionesByIdInstituto;

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

    public Personas getPersonasByIdPersona() {
        return personasByIdPersona;
    }

    public void setPersonasByIdPersona(Personas personasByIdPersona) {
        this.personasByIdPersona = personasByIdPersona;
    }

    public Educaciones getEducacionesByIdInstituto() {
        return educacionesByIdInstituto;
    }

    public void setEducacionesByIdInstituto(Educaciones educacionesByIdInstituto) {
        this.educacionesByIdInstituto = educacionesByIdInstituto;
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
}
