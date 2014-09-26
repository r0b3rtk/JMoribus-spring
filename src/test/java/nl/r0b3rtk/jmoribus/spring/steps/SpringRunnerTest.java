package nl.r0b3rtk.jmoribus.spring.steps;

import nl.eernie.jmoribus.configuration.Configuration;
import nl.eernie.jmoribus.configuration.DefaultConfiguration;
import nl.eernie.jmoribus.model.Story;
import nl.eernie.jmoribus.parser.ParseableStory;
import nl.eernie.jmoribus.parser.StoryParser;
import nl.eernie.jmoribus.reporter.DefaultReporter;
import nl.r0b3rtk.jmoribus.spring.SpringRunner;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import java.io.InputStream;
import java.util.Arrays;

public class SpringRunnerTest {

    @Test
    public void testSpringRunner()
    {
        Configuration config = new DefaultConfiguration();
        config.addReporter(new DefaultReporter());

        String springConfigFile = "simple-spring-config.xml";
        SpringRunner runner = new SpringRunner(config, springConfigFile);

        InputStream fileInputStream = getClass().getResourceAsStream("/simple.story");
        ParseableStory parseableStory = new ParseableStory(fileInputStream,  "simple.story");

        Story story = StoryParser.parseStory(parseableStory);

        runner.runStories(Arrays.asList(story));

        ApplicationContext context = runner.getSpringApplicationContext();
        MonitorBean monitor = context.getBean(MonitorBean.class);

        Assert.assertTrue(monitor.isA());
        Assert.assertTrue(monitor.isB());
        Assert.assertTrue(monitor.isC());
    }
}
