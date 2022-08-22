/*
Clase de Segurity
 */
package com.proyectoWeb;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}123")
                .roles("ADMIN", "CLIENTE")
                .and()
                .withUser("cliente")
                .password("{noop}123")
                .roles("CLIENTE");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/administrador/vehiculos", "/administrador/modificarVehiculo",
                        "/administrador/comentarios", "/"
                )
                    .hasRole("ADMIN")
                .antMatchers("/cliente/acercaDe", "/cliente/contacto", "/cliente/galeria","/cliente/login",
                        "/cliente/register", "/cliente/terminosCondiciones", "/carros/audi", "/carros/bmw",
                        "/carros/honda", "/carros/mitsubishi", "/carros/toyota", "/carros/volvo",
                        "/comprar/compra", "/cliente/MetodoPago", "/nuevoComentario", "/index", "/index(lang=es)",
                        "/index(lang=en)"
                )
                    .hasAnyRole("ADMIN","CLIENTE")
                .antMatchers("/")
                    .hasAnyRole("ADMIN", "CLIENTE")
                .and()
                    .formLogin().loginPage("/cliente/login").permitAll().defaultSuccessUrl("/index", true)
                .and()
                    .exceptionHandling().accessDeniedPage("/errores/403");
    }   
}

//.loginPage("/login").permitAll().defaultSuccessUrl("/index", true)
///login?logout