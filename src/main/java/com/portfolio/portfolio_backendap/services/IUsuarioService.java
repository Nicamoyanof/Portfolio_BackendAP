package com.portfolio.portfolio_backendap.services;

import com.portfolio.portfolio_backendap.models.Usuarios;

import java.util.List;

public interface IUsuarioService {
    List<Usuarios> getUsuarios();


    Usuarios getUsuario(Integer id);

    Usuarios getUsuartioByUsername(String username);

    void agregarUsuario(Usuarios usuarios);

    Integer personaLogeada(String username);
}
