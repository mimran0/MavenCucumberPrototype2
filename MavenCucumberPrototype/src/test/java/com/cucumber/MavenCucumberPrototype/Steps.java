package com.cucumber.MavenCucumberPrototype;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	@Given("^this is my first dummy given step$")
	public void this_is_my_first_dummy_given_step() throws Throwable {
       System.out.println("First Step");
	}

	@When("^this is my first dummy when step$")
	public void this_is_my_first_dummy_when_step() throws Throwable {
		System.out.println("Second Step");
	}

	@Then("^this is first dummy then step$")
	public void this_is_first_dummy_then_step() throws Throwable {
		System.out.println("Last step");

	}

}
