package bdd;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;

public class StepDef {
	HomePage h1 = new HomePage();

	@Given("^User is on Google Home Page$")
	public void openGoogle() {
		h1.openGoogle();
	}

	@When("^User search for New James Bond Movies$")
	public void search() {
		h1.searchText();
	}

	@Then("^James Bond movie results should display successfully$")
	public void verify() {
		h1.assertText();
		h1.closeApp();
	}
}
