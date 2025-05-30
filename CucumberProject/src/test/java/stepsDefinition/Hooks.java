package stepsDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	@Before
	public void BeforeHooks() {
		System.out.println("Before hooks");
	}

	@After
	public void AfterHooks() {
		System.out.println("After hooks");
	}
}
