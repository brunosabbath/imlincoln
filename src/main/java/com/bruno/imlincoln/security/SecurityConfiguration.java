package com.bruno.imlincoln.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests()
				.antMatchers("/**","auth/").permitAll().anyRequest()
				.authenticated().and()
				.logout().logoutSuccessUrl("/").and() 
				.csrf()
				.csrfTokenRepository(csrfTokenRepository()).and()
				.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
		/*http
	      .httpBasic().and()
	      .authorizeRequests()
	        .antMatchers("/*").permitAll().anyRequest()
	        .authenticated().and()
	      .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);*/
				
	}

	private CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName("X-XSRF-TOKEN");
		return repository;
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		  auth.inMemoryAuthentication().withUser("bruno").password("bruno").roles("ADMIN");
		  auth.inMemoryAuthentication().withUser("bvrsilva1@gmail.com").password("bruno").roles("ADMIN");
		  auth.inMemoryAuthentication().withUser("ravan").password("ravan").roles("USER");
		  auth.inMemoryAuthentication().withUser("kans").password("kans").roles("USER");
	}

}