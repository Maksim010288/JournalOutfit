package voe.company.OutfitsCompletedOfLog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import voe.company.OutfitsCompletedOfLog.entity.UsersEntity;
import voe.company.OutfitsCompletedOfLog.service.UserDetService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurerInJdbc{

    @Autowired
    private UserDetService userDetService;

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());

        return provider;
    }

    public String provider() {
        UsersEntity users = userDetService.getUsers();
       return users.getEmail();
    }

    @Bean
    public SecurityFilterChain filterChainJdbc(HttpSecurity http) throws Exception {
       http.csrf().disable()
               .authorizeRequests()
               .requestMatchers("/person/add")
               .hasAnyAuthority("ADMIN", "DIRECTOR")
               .requestMatchers("/journal/get")
               .hasAnyAuthority("ADMIN", "DIRECTOR")
               .requestMatchers("/journal/deleteId")
               .hasAnyAuthority("ADMIN", "DIRECTOR")
               .requestMatchers("/journal/deleteAll")
               .hasAnyAuthority("ADMIN", "DIRECTOR")
               .requestMatchers("/journal/edit")
               .hasAnyAuthority("ADMIN", "DIRECTOR")
               .requestMatchers("/")
               .hasAnyAuthority("ADMIN","USER", "DIRECTOR")
               .requestMatchers("/journal/homepage")
               .hasAnyAuthority("ADMIN","USER", "DIRECTOR")
               .requestMatchers("/journal/get/by")
               .hasAnyAuthority("ADMIN", "USER", "DIRECTOR")
               .and()
               .formLogin();
       return http.build();
    }
}
