package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Test1Glue {
    Test1 test1= new Test1();

    @Given("^User launches this URL$")
    public void launch(){
        test1.launch();
}

@When("^User enters value and clicks button$")
    public void test(){
        test1.test();
}

@Then("^User verifies the result$")
    public void verify() {
    test1.verify();
}

}
