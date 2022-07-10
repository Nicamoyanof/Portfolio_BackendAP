package com.portfolio.portfolio_backendap.repository;


import com.portfolio.portfolio_backendap.models.Habilidades;
import com.portfolio.portfolio_backendap.models.PersonasHabilidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonasHabilidadesRepository  extends JpaRepository<PersonasHabilidades,Integer> {}
