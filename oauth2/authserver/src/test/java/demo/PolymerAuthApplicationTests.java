package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pivotal.demo.polymer.PolymerAuthApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PolymerAuthApplication.class)
@WebAppConfiguration
public class PolymerAuthApplicationTests {

	@Test
	public void contextLoads() {
	}

}
