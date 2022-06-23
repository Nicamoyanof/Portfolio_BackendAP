package com.portfolio.portfolio_backendap.controllers;

import com.portfolio.portfolio_backendap.models.Usuarios;
import com.portfolio.portfolio_backendap.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private IUsuarioService iUsuarioService;


    @GetMapping("api/usuarios")
    public List<Usuarios> getUsuarios() {
        return iUsuarioService.getUsuarios();
    }

    @GetMapping("api/usuario/{id}")
    public Usuarios getUsuario(@PathVariable Integer id) {
        return iUsuarioService.getUsuario(id);
    }

    @PostMapping("api/usuario")
    public void agregarUsuario(@RequestBody Usuarios usuarios) {
        iUsuarioService.agregarUsuario(usuarios);
    }

}
