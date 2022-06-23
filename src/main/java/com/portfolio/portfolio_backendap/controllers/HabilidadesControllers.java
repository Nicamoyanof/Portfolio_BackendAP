package com.portfolio.portfolio_backendap.controllers;

import com.portfolio.portfolio_backendap.models.Habilidades;
import com.portfolio.portfolio_backendap.services.IHabilidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class HabilidadesControllers {

    @Autowired
    private IHabilidadesService iHabilidadesService;

    @GetMapping("api/habilidades")
    public List<Habilidades> getHabilidades(){
        return iHabilidadesService.getHabilidades();
    }

    @GetMapping("api/habilidad/{id}")
    public Habilidades getHabilidad(@PathVariable Integer id){
        return iHabilidadesService.getHabilidad(id);
    }

    @PostMapping("api/habilidad")
    public void agregarHabilidad(@RequestBody Habilidades habilidades){
        iHabilidadesService.agregarHabilidad(habilidades);
    }

    @DeleteMapping("api/habilidad/{id}")
    public void eliminarHabilidad(@PathVariable Integer id){
        iHabilidadesService.eliminarHabilidad(id);
    }

}
