package com.pivotal.demo.polymer;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Profile("session")
@Configuration
@EnableRedisHttpSession
public class PolymerDemoSpringSessionConfig {
	@Configuration
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.formLogin()
					.and()
					.logout()
					.and()
					.authorizeRequests()
					.antMatchers("/index.html", "/home.html", "/login.html", "/", "/bower_components/**", "/elements/*")
					.permitAll().anyRequest().authenticated().and()
					.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
		}
	}
}
