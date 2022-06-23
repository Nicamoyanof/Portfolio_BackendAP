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

    public int getIdPersonasEstudios() {
        return idPersonasEstudios;
    }

    public void setIdPersonasEstudios(int idPersonasEstudios) {
        this.idPersonasEstudios = idPersonasEstudios;
    }

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
}
