package com.pivotal.demo.polymer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
public class PolymerAuthConfig {

	//access rules are not being obeyed
//	  @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//	  protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//	    @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	      http.authorizeRequests()
//	          .antMatchers("/env/", "/beans/").permitAll()
//	          .and()
//	          .authorizeRequests().anyRequest();
//	    }
//	  }

	  //TODO: why does this work on the inner class and not the outer class?
	  @EnableAuthorizationServer
    protected static class OAuth2Config extends AuthorizationServerConfigurerAdapter {

      @Autowired
      private AuthenticationManager authenticationManager;

      //TODO: Why are we doing this?
      @Override
      public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
      }
      
//      @Override
//      public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//      }

      @Override
      public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
            .withClient("acme")
            .secret("acmesecret")
            .authorizedGrantTypes("authorization_code", "refresh_token", "password").scopes("openid");
      }
    }
}
