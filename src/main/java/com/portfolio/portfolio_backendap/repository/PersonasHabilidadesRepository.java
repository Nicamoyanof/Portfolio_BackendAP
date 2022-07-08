package com.portfolio.portfolio_backendap.repository;


import com.portfolio.portfolio_backendap.models.PersonasHabilidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonasHabilidadesRepository  extends JpaRepository<PersonasHabilidades,Integer> {
}
