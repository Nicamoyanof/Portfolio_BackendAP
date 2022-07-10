package com.portfolio.portfolio_backendap.repository;


import com.portfolio.portfolio_backendap.models.Habilidades;
import com.portfolio.portfolio_backendap.models.PersonasProyectos;
import com.portfolio.portfolio_backendap.models.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProyectoRepository extends JpaRepository<Proyectos,Integer> {

    @Query("SELECT pr FROM PersonasProyectos pp JOIN Proyectos pr ON pr.idProyecto = pp.proyectosByIdProyecto_0.idProyecto JOIN Personas p ON p.idPersona = pp.personasByIdPersona_0.idPersona WHERE p.idPersona=(:idPersona)")
    public List<PersonasProyectos> findAllProjectsForPerson(@Param("idPersona") Integer idPersona);

}
