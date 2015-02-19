package com.pivotal.demo.polymer;

import java.security.Principal;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableResourceServer
public class PolymerAuthController {
	  @RequestMapping("/user")
	  public Principal user(Principal user) {
	    return user;
	  }
}
