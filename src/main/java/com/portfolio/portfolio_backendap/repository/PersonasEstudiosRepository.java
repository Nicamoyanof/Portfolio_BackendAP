package com.portfolio.portfolio_backendap.repository;


import com.portfolio.portfolio_backendap.models.PersonasEstudios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonasEstudiosRepository  extends JpaRepository<PersonasEstudios, Integer> {
}
