package com.pivotal.demo.polymer.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/*
 * OAuth support is currently not fully baked.  It has worked at points, but I believe
 * is currently broken.
 * 
 * TODO:  Fix OAuth
 */
@Profile("oauth")
// @EnableOAuth2Resource
public class PolymerResourceOAuthConfig {
	@Bean
	public JwtTokenStore tokenStore() throws Exception {
		JwtAccessTokenConverter enhancer = new JwtAccessTokenConverter();
		enhancer.afterPropertiesSet();
		return new JwtTokenStore(enhancer);
	}

	protected static class OAuth2Config extends ResourceServerConfigurerAdapter {

		@Autowired
		private AuthenticationManager authenticationManager;

		@Override
		public void configure(ResourceServerSecurityConfigurer resources)
				throws Exception {
			resources.authenticationManager(authenticationManager);
		}

		@Override
		public void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/env/", "/beans/")
					.permitAll();
			// .and()
			// .authorizeRequests().anyRequest();
		}
	}

}
