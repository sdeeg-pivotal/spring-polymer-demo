package com.pivotal.demo.polymer;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class PolymerAuthApplication extends WebMvcConfigurerAdapter implements CommandLineRunner {
    private static final Logger log = Logger.getLogger(PolymerAuthApplication.class);

    @Value("${bean.dump:false}")
    private boolean beanDump;
    
    @Autowired
    ApplicationContext ctx;
    
    @Override
    public void run(String... arg0) throws Exception
    {
        if(beanDump)
        {
            StringBuffer sb = new StringBuffer();
            sb.append("\n=========================================================\n\n");
            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames)
            {
                sb.append(beanName+"\n");
            }
            sb.append("\n=========================================================\n");
            if (log.isInfoEnabled())
            {
                log.info(sb.toString());
            }
            else
            {
                System.out.println(sb.toString());
            }
        }
    }
    public static void main(String[] args) {
        SpringApplication.run(PolymerAuthApplication.class, args);
    }
}
