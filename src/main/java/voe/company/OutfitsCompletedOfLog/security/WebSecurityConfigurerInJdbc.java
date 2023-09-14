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

    @Bean
    public SecurityFilterChain filterChainJdbc(HttpSecurity http) throws Exception {
       http.csrf().disable()
               .authorizeRequests()
               .requestMatchers("/journal/get")
               .hasAuthority("ADMIN")
               .requestMatchers("/journal/homepage")
               .hasAuthority("USER")
               .and()
               .formLogin();
       return http.build();
    }
}
