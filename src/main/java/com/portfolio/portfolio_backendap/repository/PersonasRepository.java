package com.portfolio.portfolio_backendap.repository;


import com.portfolio.portfolio_backendap.models.Personas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonasRepository extends JpaRepository<Personas,Integer> {

}
