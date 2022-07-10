package com.portfolio.portfolio_backendap.repository;


import com.portfolio.portfolio_backendap.models.Habilidades;
import com.portfolio.portfolio_backendap.models.PersonasHabilidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HabilidadesRepository extends JpaRepository<Habilidades,Integer> {

    @Query( "SELECT ph FROM PersonasHabilidades ph JOIN Habilidades  h ON h.idHabilidad = ph.habilidadesByIdHabilidad_0.idHabilidad JOIN Personas p ON p.idPersona = ph.personasByIdPersona_0.idPersona WHERE p.idPersona=:idPersona")
    public List<PersonasHabilidades> findAllSkillForPerson(@Param("idPersona") Integer idPersona);

}
