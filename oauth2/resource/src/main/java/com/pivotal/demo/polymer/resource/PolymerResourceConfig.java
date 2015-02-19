package com.pivotal.demo.polymer.resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class PolymerResourceConfig {
	@Bean
	public JwtTokenStore tokenStore() throws Exception {
		JwtAccessTokenConverter enhancer = new JwtAccessTokenConverter();
		enhancer.afterPropertiesSet();
		return new JwtTokenStore(enhancer);
	}

	//@EnableOAuth2Resource
	//@EnableResourceServer
    protected static class OAuth2Config extends ResourceServerConfigurerAdapter {

//	  @Autowired
//	  private AuthenticationManager authenticationManager;
//      
//      @Override
//      public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//    	  resources.authenticationManager(authenticationManager);
//      }
      
//      @Override
//      public void configure(HttpSecurity http) throws Exception {
//	      http.authorizeRequests()
//              .antMatchers("/env/", "/beans/").permitAll();
////              .and()
////              .authorizeRequests().anyRequest();
//      }
    }
}
