package com.portfolio.portfolio_backendap.services;

import com.portfolio.portfolio_backendap.models.Habilidades;
import com.portfolio.portfolio_backendap.models.HabilidadesProyectos;
import com.portfolio.portfolio_backendap.models.Proyectos;
import com.portfolio.portfolio_backendap.utils.ModelHabPro;

import java.util.List;

public interface IProyectosService {
    List<Proyectos> getProyectos();

    Proyectos getProyecto(Integer id);

    Integer agregarProyecto(Proyectos proyectos);

    void eliminarProyecto(Integer id);

    void agregarHabilidadProyecto(ModelHabPro modelHabPro);

    List<Habilidades> getHabilidadesProyecto(Integer id);

    void eliminarHabilidadProyecto(Integer id);
}
