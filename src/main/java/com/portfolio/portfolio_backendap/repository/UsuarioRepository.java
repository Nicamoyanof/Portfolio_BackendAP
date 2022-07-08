package com.portfolio.portfolio_backendap.repository;


import com.portfolio.portfolio_backendap.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {
}
