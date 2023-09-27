package br.gama.jwtexample.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.gama.jwtexample.security.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {
    
    @Autowired
    private JwtAuthenticationFilter jwtFilter;
    // @Bean
    // InMemoryUserDetailsManager inMemoryUser() {
    //     UserDetails user = User.withDefaultPasswordEncoder()
    //                     .username("myuser")
    //                     .password("1234")
    //                     .roles("USER") // papel do usuário. Exemplos: USER, ADM, MANAGER ...
    //                     .build();
    //     UserDetails admin = User.withDefaultPasswordEncoder()
    //                     .username("admin")
    //                     .password("1234")
    //                     .roles("ADMIN") // papel do usuário. Exemplos: USER, ADM, MANAGER ...
    //                     .build();                        
    //     // System.out.println(user);
    //     // System.out.println(user.getPassword());
    //     return new InMemoryUserDetailsManager(user, admin);
    // }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/auth/**").permitAll() 
                .requestMatchers("/hello/free").permitAll()      // permite o acesso sem precisar de autenticação
                .requestMatchers("/hello/auth").authenticated()  // permite o acesso somente para usuário autenticados
                .requestMatchers("/hello/secret").hasAnyRole("ADMIN") // somente usuário autenticado com papel de ADMIN pode acessar
                .anyRequest()
                .authenticated() // qualquer outra requisição precisa estar autenticado
            ).addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    // () -> anotação de método anônimo, ou seja, estamos declarando um método sem nome
    // que será executado somente neste lugar
    // em Java isso é chamado de função lambda

    // Classe::método 
    // Classe.metodo()
}
