package com.joberty.backend.config;

import com.joberty.backend.security.RestAuthenticationEntryPoint;
import com.joberty.backend.security.TokenAuthenticationFilter;
import com.joberty.backend.service.UserDetailsService;
import com.joberty.backend.util.TokenUtils;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private final TokenUtils tokenUtils;
    private final UserDetailsService customUserDetailsService;
    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()

                .authorizeRequests().antMatchers("/auth/**").permitAll()
                .antMatchers(HttpMethod.POST, "/company-registration").permitAll()
                .antMatchers("/salary/**").permitAll()
                .antMatchers("/interview/**").permitAll()
                .antMatchers("/comment/**").permitAll()
                .antMatchers("/company/**").permitAll()
                .antMatchers("/position/**").permitAll()
                .anyRequest().authenticated().and()

                .cors().and()
                .addFilterBefore(new TokenAuthenticationFilter(tokenUtils, customUserDetailsService), BasicAuthenticationFilter.class);

        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.POST, "/auth/register");
        web.ignoring().antMatchers(HttpMethod.POST, "/auth/login");
        web.ignoring().antMatchers(HttpMethod.GET, "/", "/webjars/**", "/*.html", "favicon.ico", "/**/*.html",
                "/**/*.css", "/**/*.js");
    }
}
