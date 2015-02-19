package com.pivotal.demo.polymer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.security.oauth2.sso.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableOAuth2Sso
public class PolymerDemoApplication {
	  
	  @Configuration
	  @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	  protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	      http
	        .formLogin().and()
	        .logout().and()
	        .authorizeRequests()
	          .antMatchers("/index.html", "/home.html", "/login.html", "/", "/bower_components/**", "/elements/*").permitAll().anyRequest()
	          .authenticated().and()
	        .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
	    }
	  }

	  public static void main(String[] args) {
        SpringApplication.run(PolymerDemoApplication.class, args);
    }
}
