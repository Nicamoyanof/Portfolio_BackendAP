package com.portfolio.portfolio_backendap.services;

import com.portfolio.portfolio_backendap.models.Usuarios;
import com.portfolio.portfolio_backendap.utils.Roles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private IUsuarioService iUsuarioService;

    private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios usuario = iUsuarioService.getUsuartioByUsername(username);
        String rolUsuarios = usuario.getRoles();
        if (usuario == null) {
            logger.error("Error en el Login: no existe el usuario '" + username + "' en el sistema!");
            throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
        }
        List<GrantedAuthority> authorities = new
                ArrayList<GrantedAuthority>(); //forma primitiva de auutorizaciones
        //buscamos el rol del usuario y si tiene rol se lo agregamos a  authorities

        List<Roles> roles = new ArrayList<Roles>();
        roles.add(new Roles("ROLE_ADMIN"));

        for (Roles rol : roles) {
            if (rol.getRol().equals(rolUsuarios)) {
                logger.info("Role: ".concat(rol.getRol()));
                authorities.add(new SimpleGrantedAuthority(rol.getRol()));
            }
        }
        //ahora verificamos que no tenga rol
        if (authorities.isEmpty()) {
            logger.error("Error en el Login: Usuario '" + username + "' no tiene roles asignados !");
            throw new UsernameNotFoundException("Error en el Login:  usuario '" + username + "' no tiene roles asignados !");
        }
        //si existe el usuario y tiene rol retornamos un user de la clase security
        return new User(usuario.getEmail(), usuario.getPass(),true, true, true, true,
                authorities);
    }

}
