package com.portfolio.portfolio_backendap.services;

import com.portfolio.portfolio_backendap.models.Educaciones;

import java.util.List;

public interface IEducaciopnesService {
    List<Educaciones> getEducaciones();

    Educaciones getEducacion(Integer id);

    void agregarEducacion(Educaciones educaciones);

    void eliminarEducacion(Integer id);
}
