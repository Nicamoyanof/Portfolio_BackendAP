package com.portfolio.portfolio_backendap.services;

import com.portfolio.portfolio_backendap.models.Personas;
import com.portfolio.portfolio_backendap.models.Usuarios;
import com.portfolio.portfolio_backendap.repository.UsuarioRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements  IUsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PersonaService personaService;

    @Override
    public List<Usuarios> getUsuarios() {

        return usuarioRepository.findAll();

    }

    @Override
    public Usuarios getUsuario(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void agregarUsuario(Usuarios usuarios) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1, usuarios.getPass());
        usuarios.setPass(hash);
        boolean validator=false;
        for (Usuarios uValidator : getUsuarios()){
            if(uValidator.getEmail().equals(usuarios.getEmail())){
                validator = false;
                break;
            }else{
                validator=true;
            }
        }
        if(validator){
            usuarioRepository.save(usuarios);
            Usuarios usuario;

            for (Usuarios usu : getUsuarios()){
                if(usu==usuarios){
                    usuario=usuarios;
                    Personas personas = new Personas();
                    personas.setUsuariosByIdUsuario(usuario);
                    personaService.agregarPersona(personas);
                    break;
                }
            }
        }


    }

}
