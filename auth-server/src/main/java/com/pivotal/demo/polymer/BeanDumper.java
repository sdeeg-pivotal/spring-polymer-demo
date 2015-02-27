package com.pivotal.demo.polymer;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("bean-dump")
@Component
public class BeanDumper  implements CommandLineRunner {
    private static final Logger log = Logger.getLogger(BeanDumper.class);

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
}
