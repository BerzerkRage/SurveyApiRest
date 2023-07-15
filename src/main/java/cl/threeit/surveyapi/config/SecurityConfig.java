package cl.threeit.surveyapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SecurityFilterChain h2ConsoleSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().requestMatchers(
            new AntPathRequestMatcher("/h2-console/**")).permitAll();
        http.authorizeHttpRequests(withDefaults());
        http.csrf((csrf) -> csrf.disable());
        http.headers((headers) -> headers.frameOptions().sameOrigin());
        return http.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests
                .antMatchers("/api/**")
                .permitAll())
            .authorizeHttpRequests(requests -> requests
                .anyRequest()
                .permitAll())
                // .authenticated())
            .httpBasic(withDefaults());
        return http.build();
    }


}
