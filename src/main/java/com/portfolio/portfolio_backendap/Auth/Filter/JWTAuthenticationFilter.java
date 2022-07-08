package com.portfolio.portfolio_backendap.Auth.Filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.portfolio_backendap.models.Usuarios;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;



    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/login", "POST"));



    }


    //este metodo se encarga de realizar la autenticacion
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException
    {
        String username = obtainUsername(request);
        String password = obtainPassword(request);
        if(username!=null && password!=null){
            logger.info("username : " + username);
            logger.info("password : " + password);
        }else{
            Usuarios user = null;
            try {
                //convertimos el json que enviamos por post en un objeto y  lo guardamos como usuario
                user = new ObjectMapper().readValue(request.getInputStream(), Usuarios.class);
                //asignamos el objeto username y password y le asignamos la del user
                username=user.getEmail();
                password=user.getPass();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        username = username.trim();//Método que elimina los caracteres  blancos iniciales y finales de la cadena, devolviendo una copia de la misma.
                //creamos el token
                UsernamePasswordAuthenticationToken authToken = new
                UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(authToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String username = ((User)
                authResult.getPrincipal()).getUsername();
        //llamamos a todos los roles existentes
        Collection<? extends GrantedAuthority> roles = authResult.getAuthorities();
        //almacenamos los roles para luego ser validados
        Claims claims = Jwts.claims();
        //los roles serian de tipo objeto por eso hay que convertilo a  string
        claims.put("authorities", new ObjectMapper().writeValueAsString(roles));
        //aca acreamos el token jwt
        String token = Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS512,
                        "AmLc0wi4y^wCZ+p5Q+Re~".getBytes())
                .setIssuedAt(new Date())
                //3600000 serian 1 hora
                .setExpiration(new Date(System.currentTimeMillis() +
                        (3600000L*4L) ))
                .compact();
        //enviamos el token al header del navegador
        response.addHeader("Authorization", "Bearer " + token);
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("token", token);
        body.put("user", ((User) authResult.getPrincipal()));
        body.put("mensaje", "Se inicio sesion correctramente");
        //ahora convertimos el body en json para porder escribirlo en la respúesta
        response.getWriter().write( new
                ObjectMapper().writeValueAsString(body) );
        response.setStatus(200);
        response.setContentType("application/json");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response, AuthenticationException failed) throws
            IOException, ServletException {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("mensaje", "Error de autenticacion: usuario o contraseña incorrecta!");
        body.put("error", failed.getMessage());
        response.getWriter().write( new
                ObjectMapper().writeValueAsString(body) );
        response.setStatus(401);
        response.setContentType("application/json");
    }

}
