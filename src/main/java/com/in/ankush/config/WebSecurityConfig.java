package com.in.ankush.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.in.ankush.security.CustomUserDetailsService;

import static org.springframework.security.config.Customizer.withDefaults;
import com.in.ankush.security.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;


@Configuration
public class WebSecurityConfig {
	
	@Autowired 
	CustomUserDetailsService customUserDetailsService;
	

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * http .csrf(csrf -> csrf.disable()) .authorizeRequests(requests -> requests
	 * .antMatchers("/login", "/register").permitAll() .anyRequest()
	 * .authenticated()) .sessionManagement(management ->
	 * management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	 * http.addFilterBefore(authenticationJwtTokenFilter(),
	 * UsernamePasswordAuthenticationFilter.class); http.httpBasic();}
	 */    
	
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.inMemoryAuthentication()
	 * .withUser("ankush").password("12345").authorities("admin") .and()
	 * .withUser("akshay").password("12345").authorities("user") .and()
	 * .passwordEncoder(NoOpPasswordEncoder.getInstance());
	 * 
	 * }
	 */
	
	@Bean
	 SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		 http
	        .csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(requests -> requests
    		.requestMatchers("/login", "/register").permitAll()
           .anyRequest()
           .authenticated())
           .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		   http.addFilterBefore(authenticationJwtTokenFilter(),UsernamePasswordAuthenticationFilter.class);
		   http.httpBasic(withDefaults());
       return http.build();
		
	}
	
	@Bean
	 JwtRequestFilter authenticationJwtTokenFilter() {
		return new JwtRequestFilter();
	}
	
	@Bean
	 PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	 DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(customUserDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}


    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
	
	
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(customUserDetailsService);
//	}
	
	/*
	 * @Bean public PasswordEncoder passwordEncoder() { return
	 * NoOpPasswordEncoder.getInstance(); }
	 */

	
//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
}
