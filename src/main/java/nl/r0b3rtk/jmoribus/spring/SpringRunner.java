package nl.r0b3rtk.jmoribus.spring;

import nl.eernie.jmoribus.JMoribus;
import nl.eernie.jmoribus.configuration.Configuration;
import nl.r0b3rtk.jmoribus.spring.annotation.ContainingSteps;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Map;

public class SpringRunner extends JMoribus {

    private ApplicationContext context = null;

    public SpringRunner(Configuration config, String applicationContextLocation)
    {
        super(config);
        context = new ClassPathXmlApplicationContext(applicationContextLocation);
        Map<String, Object> beansContainingSteps = context.getBeansWithAnnotation(ContainingSteps.class);
        config.addSteps(new ArrayList<Object>(beansContainingSteps.values()));
    }

    public ApplicationContext getSpringApplicationContext()
    {
        return context;
    }
}
