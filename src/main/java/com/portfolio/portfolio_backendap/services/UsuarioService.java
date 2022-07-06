package com.portfolio.portfolio_backendap.services;

import com.portfolio.portfolio_backendap.models.Personas;
import com.portfolio.portfolio_backendap.models.Usuarios;
import com.portfolio.portfolio_backendap.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements  IUsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PersonaService personaService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;



    @Override
    public List<Usuarios> getUsuarios() {

        return usuarioRepository.findAll();

    }

    @Override
    public Usuarios getUsuario(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuarios getUsuartioByUsername(String username) {
       List<Usuarios> usuarios = getUsuarios();

       for (Integer i=0;i<usuarios.size();i++){
           if(usuarios.get(i).getEmail().equals(username)) {
               return usuarios.get(i);
           }
       }
       return null;

    }

    @Override
    public void agregarUsuario(Usuarios usuarios) {

        String passEncripted = passwordEncoder.encode(usuarios.getPass());

        usuarios.setPass(passEncripted);

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

    @Override
    public Integer personaLogeada(String username) {

        Usuarios usuario = getUsuartioByUsername(username);
        List<Personas> listaPersonas = personaService.getPersonas();
        for(int i = 0; i < listaPersonas.size(); i++){
            if (listaPersonas.get(i).getUsuariosByIdUsuario().getIdUsuario() == (usuario.getIdUsuario())){

                return listaPersonas.get(i).getIdPersona();

            }
        }

        return null;
    }

}
