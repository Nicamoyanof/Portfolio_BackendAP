package com.portfolio.portfolio_backendap.repository;

import com.portfolio.portfolio_backendap.models.Educaciones;
import com.portfolio.portfolio_backendap.models.Habilidades;
import com.portfolio.portfolio_backendap.models.PersonasEstudios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EducacionesRepository extends JpaRepository<Educaciones, Integer> {

    @Query("SELECT e FROM PersonasEstudios pe JOIN Educaciones e ON e.idInstituto=pe.educacionesByIdInstituto_0.idInstituto JOIN Personas p ON p.idPersona = pe.personasByIdPersona_0.idPersona WHERE p.idPersona=(:idPersona)")
    public List<PersonasEstudios> findAllEducationsForPerson(@Param("idPersona") Integer idPersona);

}
