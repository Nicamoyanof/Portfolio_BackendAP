package com.portfolio.portfolio_backendap.controllers;

import com.portfolio.portfolio_backendap.models.*;
import com.portfolio.portfolio_backendap.services.IPersonaService;
import com.portfolio.portfolio_backendap.utils.ModelPerEst;
import com.portfolio.portfolio_backendap.utils.ModelPerHab;
import com.portfolio.portfolio_backendap.utils.ModelPerPro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PersonasController {

    @Autowired
    private IPersonaService iPersonaService;

    @Secured("ROLE_ADMIN")
    @GetMapping("api/personas")
    public List<Personas> getPersonas(){
        return iPersonaService.getPersonas();
    }

    @GetMapping("api/persona/{id}")
    public Personas getPersona(@PathVariable Integer id){
        return iPersonaService.getPersona(id);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("api/persona")
    public void agregarPersona(@RequestBody Personas personas){
        iPersonaService.agregarPersona(personas);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("api/persona/{id}")
    public void eliminarPersona(@PathVariable Integer id){
        iPersonaService.eliminarPersona(id);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("api/persona/{id}")
    public boolean editarPersona(@PathVariable Integer id, @RequestBody Personas personas){
        return iPersonaService.editarPersona(id,personas);
    }

   //<-----  CONTROLLERS PERSONAS ESTUDIOS ----->

    @Secured("ROLE_ADMIN")
    @GetMapping("api/personas/estudios")
    public List<PersonasEstudios> getPersonasEstudios(){
        return iPersonaService.getPersonasEstudios();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("api/persona/estudio")
    public void agregarPersonaEstudio(@RequestBody ModelPerEst perEst){
        iPersonaService.agregarPersonaEstudio(perEst);
    }

    @GetMapping("api/persona/{id}/estudios")
    public List<PersonasEstudios> getPersonasEstudiosId(@PathVariable Integer id){
        return iPersonaService.getPersonasEstudiosId(id);
    }

    @GetMapping("api/persona/{id}/listaEstudios")
    public List<Educaciones> getEducacionesPersona(@PathVariable Integer id){
        return iPersonaService.getEstudiosPersona(id);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("api/persona/estudio/{id}")
    public void eliminarPersonaEstudio(@PathVariable Integer id){
        iPersonaService.eliminarPersonaEstudio(id);
    }

    @GetMapping("api/persona/estudio/{id}")
    public PersonasEstudios getEstudioPersona(@PathVariable int id){
        return iPersonaService.getEstudioPersona(id);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("api/persona/estudio/{id}")
    public void editarEstudioPersona(@PathVariable int id, @RequestBody ModelPerEst personasEstudios){
        iPersonaService.editarEstudioPersona(id, personasEstudios);
    }

    //<-------CONTROLLERS PERSONAS HABILIDADES ------->

    @GetMapping("api/personas/habilidades")
    public List<PersonasHabilidades> getPersonasHabilidades(){
        return iPersonaService.getPersonasHabilidades();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("api/persona/habilidad")
    public void agregarPersonaHabilidad(@RequestBody ModelPerHab perHab){
        iPersonaService.agregarPersonaHabilidad(perHab);
    }

    @GetMapping("api/persona/{id}/habilidades")
    public List<PersonasHabilidades> getPersonaHabilidades(@PathVariable Integer id){
        return iPersonaService.getPersonaHabilidades(id);
    }

    @GetMapping("api/persona/{id}/habilidades/lista")
    public List<Habilidades> getHabilidadesPersona(@PathVariable Integer id){
        return iPersonaService.getHabilidadesPersona(id);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("api/persona/habilidad/{id}")
    public void eliminarPersonaHabilidad(@PathVariable Integer id){
        iPersonaService.eliminarPersonaHabilidad(id);
    }

    //<-------CONTROLLERS PERSONAS PROYECTOS ------->

    @GetMapping("api/personas/proyectos")
    public List<PersonasProyectos> getPersonasProyectos(){
        return iPersonaService.getPersonasProyectos();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("api/persona/proyecto")
    public void agregarPersonaProyecto(@RequestBody ModelPerPro perPro){
        iPersonaService.agregarPersonaProyecto(perPro);
    }

    @GetMapping("api/persona/{id}/proyectos")
    public List<PersonasProyectos> getProyectosPersona(@PathVariable Integer id){
        return iPersonaService.getProyectosPersona(id);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("api/persona/proyecto/{id}")
    public void eliminarPersonaProyecto(@PathVariable Integer id){
        iPersonaService.eliminarPersonaProyecto(id);
    }

}

