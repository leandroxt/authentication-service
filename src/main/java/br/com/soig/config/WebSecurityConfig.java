package br.com.soig.config;

import br.com.soig.service.AuthenticationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String URI_LOGIN = "/authentication";
    private static final String URI_LOGOUT = "/logout";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers(URI_LOGIN)
                        .permitAll()
                    .anyRequest()
                        .authenticated()
                    .and()
                        .logout()
                        .logoutSuccessUrl(URI_LOGOUT)
                        .invalidateHttpSession(true)
                            .permitAll()
                    .and()
                        .csrf()
                        .disable();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new AuthenticationService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }
}
