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

	@EnableAuthorizationServer
    protected static class OAuth2Config extends AuthorizationServerConfigurerAdapter {

      @Autowired
      private AuthenticationManager authenticationManager;

      //Inject the Boot configured AuthenticationManager into the OAuth endpoints
      @Override
      public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
      }

      @Override
      public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
               .withClient("polymer-ui-server")
               .secret("polymer-ui-secret")
               .authorizedGrantTypes("authorization_code", "refresh_token", "password")
               .scopes("openid");
      }
    }
}
