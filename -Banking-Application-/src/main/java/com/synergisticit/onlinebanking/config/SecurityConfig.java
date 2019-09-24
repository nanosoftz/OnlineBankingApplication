package com.synergisticit.onlinebanking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true,prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	

	@Autowired 
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity httpSecurity)throws Exception
	{
		httpSecurity.authorizeRequests().antMatchers("/register").permitAll().anyRequest().authenticated().and()
		.formLogin().loginPage("/login").permitAll()
		.and().logout().logoutSuccessUrl("/login").permitAll().
		and().exceptionHandling().accessDeniedPage("/accessDenied")
		.accessDeniedHandler(accessDeniedHandler());
		
		httpSecurity.httpBasic();
	}
	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		//userdetail service is used for authentication and authorization purpose
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Bean
	public AccessDeniedHandler accessDeniedHandler(){
		
		return new AccessDeniedHandlerImpl();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		return super.authenticationManager();
		
	}
}
