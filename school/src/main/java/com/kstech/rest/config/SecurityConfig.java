package com.kstech.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				// Spring Security should completely ignore URLs starting with /resources/
				.antMatchers("/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/public/**").permitAll().anyRequest().hasRole("USER").and()
				// Possibly more configuration ...
				.formLogin() // enable form based log in
				// set permitAll for all URLs associated with Form Login
				.permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				// enable in memory based authentication with a user named "user" and "admin"
				.inMemoryAuthentication().withUser("user").password(encoder().encode("userp")).roles("USER").and().withUser("admin")
				.password(encoder().encode("adminp")).roles("USER", "ADMIN");

	}

	@Bean
	public PasswordEncoder  encoder() {
	    return new BCryptPasswordEncoder();
	}
}