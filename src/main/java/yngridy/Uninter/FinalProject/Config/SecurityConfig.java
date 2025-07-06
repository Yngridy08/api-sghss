package yngridy.Uninter.FinalProject.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // desabilita CSRF e permite uso do H2 console
            .csrf(csrf -> csrf.disable())
            .headers(headers -> headers.frameOptions(frame -> frame.disable()))

            // configuração de autorização por rota
            .authorizeHttpRequests(auth -> auth
                // rotas públicas de autenticação
                .requestMatchers("/api/auth/**").permitAll()
                // liberando console H2
                .requestMatchers("/h2-console/**").permitAll()

                // endpoints de profissionais só para ADMIN
                .requestMatchers(HttpMethod.POST,   "/api/profissionais/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT,    "/api/profissionais/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/profissionais/**").hasAuthority("ADMIN")
                // se quiser liberar GET para todos, descomente a linha abaixo:
                // .requestMatchers(HttpMethod.GET, "/api/profissionais/**").permitAll()

                // qualquer outra rota exige autenticação
                .anyRequest().authenticated()
            )

            // deshabilita sessões (stateless JWT)
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            // configura o provedor de autenticação e o filtro JWT
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
