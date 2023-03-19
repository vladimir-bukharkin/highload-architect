package com.otus.hw.authorization.config;

import com.otus.hw.authorization.dto.AnonimusUD;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain( HttpSecurity http ) throws Exception {
        http
                .csrf().disable()
                .httpBasic(withDefaults())
                .authorizeHttpRequests( ( authorize ) -> authorize
                        .antMatchers("/user/register").permitAll()
                        .antMatchers("/v3/api-docs/**").permitAll()
                        .antMatchers("/swagger-ui/**").permitAll()
                        .anyRequest().authenticated()
                )
                .anonymous().principal( new AnonimusUD() )
                .and()
                .rememberMe().key("AnySecret").tokenValiditySeconds(60 * 30)
                .and()
                .formLogin()
                .usernameParameter("id");
        return http.build();
    }

    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
