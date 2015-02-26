package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pivotal.demo.polymer.resource.PolymerResourceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PolymerResourceApplication.class)
@WebAppConfiguration
public class PolymerResourceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
