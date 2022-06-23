package com.portfolio.portfolio_backendap.services;

import com.portfolio.portfolio_backendap.models.Habilidades;

import java.util.List;

public interface IHabilidadesService {
    List<Habilidades> getHabilidades();

    Habilidades getHabilidad(Integer id);

    void agregarHabilidad(Habilidades habilidades);

    void eliminarHabilidad(Integer id);
}
