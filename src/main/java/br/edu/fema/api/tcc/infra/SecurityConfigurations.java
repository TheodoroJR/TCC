package br.edu.fema.api.tcc.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Autowired
    private SecurityFilter securityFilter;


//  @Bean //(METODO ORIGINAL !!!!!!!!!!! )))
//  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//      return http.csrf(csrf -> csrf.disable())
//              .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//              .authorizeHttpRequests(req -> {
//                  req.requestMatchers("/login").permitAll();
//                  req.anyRequest().authenticated();
//              })
//              .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class).build();
//  }


    @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                    // Permitir acesso ao endpoint de login
                    .requestMatchers("/login").permitAll()
                    // Permitir acesso às rotas do Swagger
                    .requestMatchers(
                            "/swagger-ui/**",
                            "/v3/api-docs/**",
                            "/swagger-resources/**",
                            "/webjars/**",
                            "/swagger-ui.html"
                    ).permitAll()
                    // Qualquer outra requisição precisa estar autenticada
                    .anyRequest().authenticated()
            )
            // Adicionar o filtro JWT antes do filtro de autenticação de usuário/senha
            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();}


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
