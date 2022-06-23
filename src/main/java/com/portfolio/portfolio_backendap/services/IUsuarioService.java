package com.portfolio.portfolio_backendap.services;

import com.portfolio.portfolio_backendap.models.Usuarios;

import java.util.List;

public interface IUsuarioService {
    List<Usuarios> getUsuarios();


    Usuarios getUsuario(Integer id);

    void agregarUsuario(Usuarios usuarios);

}
