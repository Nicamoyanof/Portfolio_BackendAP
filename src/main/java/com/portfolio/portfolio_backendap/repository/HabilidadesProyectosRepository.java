package com.portfolio.portfolio_backendap.repository;


import com.portfolio.portfolio_backendap.models.HabilidadesProyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadesProyectosRepository extends JpaRepository<HabilidadesProyectos,Integer> {
}
