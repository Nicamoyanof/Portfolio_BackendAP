package com.portfolio.portfolio_backendap.services;

import com.portfolio.portfolio_backendap.models.*;
import com.portfolio.portfolio_backendap.utils.ModelPerEst;
import com.portfolio.portfolio_backendap.utils.ModelPerHab;
import com.portfolio.portfolio_backendap.utils.ModelPerPro;

import java.util.List;

public interface IPersonaService {
    List<Personas> getPersonas();

    Personas getPersona(Integer id);

    void agregarPersona(Personas personas);

    void eliminarPersona(Integer id);

    List<PersonasEstudios> getPersonasEstudios();

    void agregarPersonaEstudio(ModelPerEst perEst);

    List<Educaciones> getEstudiosPersona(Integer id);

    void eliminarPersonaEstudio(Integer id);

    List<PersonasHabilidades> getPersonasHabilidades();

    void agregarPersonaHabilidad(ModelPerHab perHab);

    List<Habilidades> getHabilidadesPersona(Integer id);

    void eliminarPersonaHabilidad(Integer id);

    List<PersonasProyectos> getPersonasProyectos();

    void agregarPersonaProyecto(ModelPerPro perPro);

    List<Proyectos> getProyectosPersona(Integer id);

    void eliminarPersonaProyecto(Integer id);

    List<Educaciones> getPersonasEstudiosId(Integer id);

    List<Habilidades> getPersonaHabilidades(Integer id);


    boolean editarPersona(Integer id, Personas personas);

    PersonasEstudios getEstudioPersona(int id);

    void editarEstudioPersona(int id, ModelPerEst personasEstudios);
}
