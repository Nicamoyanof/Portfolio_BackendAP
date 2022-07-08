package com.portfolio.portfolio_backendap.services;

import com.portfolio.portfolio_backendap.services.EducacionesService;
import com.portfolio.portfolio_backendap.models.*;
import com.portfolio.portfolio_backendap.repository.PersonasEstudiosRepository;
import com.portfolio.portfolio_backendap.repository.PersonasHabilidadesRepository;
import com.portfolio.portfolio_backendap.repository.PersonasProyectosRepository;
import com.portfolio.portfolio_backendap.repository.PersonasRepository;
import com.portfolio.portfolio_backendap.utils.ModelPerEst;
import com.portfolio.portfolio_backendap.utils.ModelPerHab;
import com.portfolio.portfolio_backendap.utils.ModelPerPro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private PersonasRepository personasRepository;

    @Autowired
    private PersonasEstudiosRepository personasEstudiosRepository;

    @Autowired
    private EducacionesService educacionesService;

    @Autowired
    private HabilidadesService habilidadesService;

    @Autowired
    private PersonasHabilidadesRepository personasHabilidadesRepository;

    @Autowired
    private ProyectosService proyectosService;

    @Autowired
    private PersonasProyectosRepository personasProyectosRepository;

    @Override
    public boolean editarPersona(Integer id, Personas personas) {
        Personas personaEditar;
        personaEditar = personas;
        try{
            personaEditar.setIdPersona(id);
            personasRepository.save(personaEditar);

        }catch(Exception e){
            return false;
        }
        return true;
    }



    //<------ SERVICE PERSONAS ------>

    @Override
    public List<Personas> getPersonas() {
        return personasRepository.findAll();
    }

    @Override
    public Personas getPersona(Integer id) {
        return personasRepository.findById(id).orElse(null);
    }

    @Override
    public void agregarPersona(Personas personas) {
        personasRepository.save(personas);
    }


    @Override
    public void eliminarPersona(Integer id) {
        personasRepository.deleteById(id);
    }


    //<------ SERVICE PERSONAS ESTUDIOS ------>

    @Override
    public List<PersonasEstudios> getPersonasEstudios() {
        return personasEstudiosRepository.findAll();
    }

    @Override
    public void agregarPersonaEstudio(ModelPerEst perEst) {

        PersonasEstudios  personasEstudios = new PersonasEstudios();
        personasEstudios.setPersonasByIdPersona(getPersona(perEst.getPersonas()));
        personasEstudios.setEducacionesByIdInstituto(educacionesService.getEducacion(perEst.getEducaciones()));
        personasEstudios.setAnioInicio(perEst.getAnioInicio());
        personasEstudios.setAnioFinal(perEst.getAnioFinal());

        personasEstudiosRepository.save(personasEstudios);
    }

    @Override
    public List<Educaciones> getEstudiosPersona(Integer id) {

        List<PersonasEstudios> listaPersonasEstudios = getPersonasEstudios();

        List<Educaciones> listaEducacionesPer = new ArrayList<>();

        for (int i = 0; i < listaPersonasEstudios.size(); i++) {
            if(listaPersonasEstudios.get(i).getPersonasByIdPersona().getIdPersona()==id){
                listaEducacionesPer.add(listaPersonasEstudios.get(i).getEducacionesByIdInstituto());
            }
        }

        return listaEducacionesPer;
    }


    @Override
    public void eliminarPersonaEstudio(Integer id) {
        personasEstudiosRepository.deleteById(id);
    }

    @Override
    public List<PersonasEstudios> getPersonasEstudiosId(Integer id) {
        List<PersonasEstudios> listaPE = new ArrayList<>();
        for (int i = 0; i < getPersonasEstudios().size(); i++) {
            if (getPersonasEstudios().get(i).getPersonasByIdPersona().getIdPersona()==id){
                listaPE.add(getPersonasEstudios().get(i));
            }

        }
        return listaPE;
    }

    @Override
    public PersonasEstudios getEstudioPersona(int id) {
        return personasEstudiosRepository.findById(id).orElse(null);
    }

    @Override
    public void editarEstudioPersona(int id, ModelPerEst personasEstudios) {
        PersonasEstudios perEstudios = new PersonasEstudios();
        perEstudios.setIdPersonasEstudios(id);
        perEstudios.setPersonasByIdPersona(getPersona(personasEstudios.getPersonas()));
        perEstudios.setEducacionesByIdInstituto( educacionesService.getEducacion(personasEstudios.getEducaciones()));
        perEstudios.setAnioInicio(personasEstudios.getAnioInicio());
        perEstudios.setAnioFinal(personasEstudios.getAnioFinal());
        personasEstudiosRepository.save(perEstudios);
    }


    //<------ SERVICE PERSONAS HABILIDADES ------>

    @Override
    public List<PersonasHabilidades> getPersonasHabilidades() {
        return personasHabilidadesRepository.findAll();
    }


    @Override
    public void agregarPersonaHabilidad(ModelPerHab perHab) {

        PersonasHabilidades personasHabilidades = new PersonasHabilidades();
        personasHabilidades.setPersonasByIdPersona(getPersona(perHab.getPersona()));
        personasHabilidades.setHabilidadesByIdHabilidad(habilidadesService.getHabilidad(perHab.getHabilidad()));
        personasHabilidades.setPorcentaje(perHab.getPorcentaje());

        personasHabilidadesRepository.save( personasHabilidades);
    }

    @Override
    public List<Habilidades> getHabilidadesPersona(Integer id) {

        List<PersonasHabilidades> listaPersonasHabilidades = getPersonasHabilidades();
        List<Habilidades> listaHabilidades = new ArrayList<>();

        for (int i = 0; i < listaPersonasHabilidades.size(); i++) {
            if(listaPersonasHabilidades.get(i).getPersonasByIdPersona().getIdPersona()==id){
                listaHabilidades.add(listaPersonasHabilidades.get(i).getHabilidadesByIdHabilidad());
            }
        }

        return (listaHabilidades);
    }

    @Override
    public void eliminarPersonaHabilidad(Integer id) {
        personasHabilidadesRepository.deleteById(id);
    }

    @Override
    public List<PersonasHabilidades> getPersonaHabilidades(Integer id) {
        List<PersonasHabilidades> listaPersonasHabilidades = new ArrayList<>();
        for (int i = 0; i < getPersonasHabilidades().size(); i++) {

            if(getPersonasHabilidades().get(i).getPersonasByIdPersona().getIdPersona()==id){
                listaPersonasHabilidades.add(getPersonasHabilidades().get(i));
            }

        }
        return listaPersonasHabilidades;
    }




    //<------ SERVICE PERSONAS PROYECTOS ------>

    @Override
    public List<PersonasProyectos> getPersonasProyectos() {
        return personasProyectosRepository.findAll();
    }

    @Override
    public void agregarPersonaProyecto(ModelPerPro perPro) {
        PersonasProyectos personasProyectos = new PersonasProyectos();
        personasProyectos.setPersonasByIdPersona(getPersona(perPro.getPersona()));
        personasProyectos.setProyectosByIdProyecto(proyectosService.getProyecto(perPro.getProyecto()));

        personasProyectosRepository.save(personasProyectos);
    }

    @Override
    public List<Proyectos> getProyectosPersona(Integer id) {

        List<PersonasProyectos> listaPersonasProyectos = getPersonasProyectos();
        List<Proyectos> listaProyectos = new ArrayList<>();

        for (int i = 0; i < listaPersonasProyectos.size(); i++) {
            if(listaPersonasProyectos.get(i).getPersonasByIdPersona().getIdPersona()==id){
                listaProyectos.add(listaPersonasProyectos.get(i).getProyectosByIdProyecto());
            }
        }

        return listaProyectos;
    }

    @Override
    public void eliminarPersonaProyecto(Integer id) {
        List<PersonasProyectos> listaPersonasProyectos = getPersonasProyectos();
        for(int i=0;i<listaPersonasProyectos.size();i++) {
            if(listaPersonasProyectos.get(i).getProyectosByIdProyecto().getIdProyecto()==id){
                personasProyectosRepository.deleteById(listaPersonasProyectos.get(i).getIdPerHab());
            }
        }

    }




}
