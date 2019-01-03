/**
 *
 * @author gurpreet.s
 */

package com.javainuse.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class EmployeeSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
/*		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/welcome").hasAnyRole("USER", "ADMIN")
				.antMatchers("/getEmployees").hasAnyRole("USER", "ADMIN").antMatchers("/addNewEmployee")
				.hasAnyRole("ADMIN").anyRequest().authenticated()
				.and().formLogin().loginPage("/login").permitAll()
				.and().logout().permitAll();*///.and().addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);;
		   RequestMatcher csrfRequestMatcher = new RequestMatcher() {

			      private RegexRequestMatcher requestMatcher =
			          new RegexRequestMatcher("/addNewEmployee", null);

			      @Override
			      public boolean matches(HttpServletRequest request) {

			          // Enable the CSRF
			          if(requestMatcher.matches(request))
			              return true;
			              
			          // You can add here any other rule on the request object, returning 
			          // true if the CSRF must be enabled, false otherwise
			          // ....

			          // No CSRF for other requests
			          return false;
			      }

			    }; 
		http
	      // Enable csrf only on some request matches
	      .csrf()
	        .requireCsrfProtectionMatcher(csrfRequestMatcher).and().authorizeRequests().antMatchers("/").permitAll().antMatchers("/welcome").hasAnyRole("USER", "ADMIN")
		.antMatchers("/getEmployees").hasAnyRole("USER", "ADMIN").antMatchers("/addNewEmployee")
		.hasAnyRole("ADMIN").anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll()
		.and().logout().permitAll().and().addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
		http.csrf().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.inMemoryAuthentication().withUser("employee").password("{noop}employee")
        .authorities("ROLE_USER").and().withUser("javainuse").password("{noop}javainuse")
        .authorities("ROLE_USER", "ROLE_ADMIN");
	}
}
