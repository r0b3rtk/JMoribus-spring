package nl.r0b3rtk.jmoribus.spring.steps;

import nl.eernie.jmoribus.annotation.Given;
import nl.eernie.jmoribus.annotation.Then;
import nl.eernie.jmoribus.annotation.When;
import nl.r0b3rtk.jmoribus.spring.annotation.ContainingSteps;
import org.springframework.beans.factory.annotation.Autowired;

@ContainingSteps
public class SimpleSteps {

    @Autowired
    MonitorBean monitor;

    @Given("a")
    public void a()
    {
        monitor.setA(true);
    }

    @When("b")
    public void b()
    {
        monitor.setB(true);
    }

    @Then("c")
    public void c()
    {
        monitor.setC(true);
    }
}
