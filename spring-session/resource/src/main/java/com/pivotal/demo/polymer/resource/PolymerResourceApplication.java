package com.pivotal.demo.polymer.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;

@SpringBootApplication
@EnableRedisHttpSession
public class PolymerResourceApplication extends WebSecurityConfigurerAdapter {

//    @Bean
//    HeaderHttpSessionStrategy sessionStrategy() {
//      return new HeaderHttpSessionStrategy();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.httpBasic().disable();
      http.authorizeRequests().anyRequest().authenticated();
    }

    public static void main(String[] args) {
        SpringApplication.run(PolymerResourceApplication.class, args);
    }
}

//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
//class CorsFilter implements Filter {
//
//	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {
//		HttpServletResponse response = (HttpServletResponse) res;
//		response.setHeader("Access-Control-Allow-Origin", "*");
//		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
//		response.setHeader("Access-Control-Max-Age", "3600");
//		response.setHeader("Access-Control-Allow-Headers", "x-auth-token");
//		HttpServletRequest request = (HttpServletRequest)req; 
//		if (!request.getMethod().equals("OPTIONS")) {
//			try {
//				chain.doFilter(req, res);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ServletException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} else {
//		}
//	}
//
//	public void init(FilterConfig filterConfig) {}
//
//	public void destroy() {}
//
//}
