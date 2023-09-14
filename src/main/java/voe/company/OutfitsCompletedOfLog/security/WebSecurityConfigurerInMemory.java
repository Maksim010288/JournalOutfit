package voe.company.OutfitsCompletedOfLog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import voe.company.OutfitsCompletedOfLog.repository.UserRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserRepository userRepository;

    @Bean
    public UserDetailsService usersDB() {
        return new JdbcUserDetailsManager(dataSource);
    }


    @Bean
    public UserDetailsService usersMemory() {
        UserDetails admin = User.builder()
                .username("Maks")
                .password(passwordEncoder().encode("maks"))
                .roles("ADMIN").build();
        UserDetails user = User.builder()
                .username("Anton")
                .password(passwordEncoder().encode("anton"))
                .roles("USER").build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/journal/get").hasRole("ADMIN")
                        .requestMatchers("/journal/deleteAll").hasRole("ADMIN")
                        .requestMatchers("/journal/deleteId").hasRole("ADMIN")
                        .requestMatchers("/person/add").hasRole("ADMIN")
                        .requestMatchers("/journal/get/by").hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
