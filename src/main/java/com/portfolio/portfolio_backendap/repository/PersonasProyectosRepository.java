package com.portfolio.portfolio_backendap.repository;


import com.portfolio.portfolio_backendap.models.PersonasProyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonasProyectosRepository extends JpaRepository<PersonasProyectos, Integer> {
}
