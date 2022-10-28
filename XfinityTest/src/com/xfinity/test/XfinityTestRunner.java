package com.xfinity.test;

public class XfinityTestRunner {
	public static void main(String args[]) throws Exception {
		StepDefinition test = new StepDefinition();
		String username = args[0];
		String password = args[1];
		test.driverInitiation();
		test.loginAuthentication(username, password);
		test.validateAuthentication();
		test.testXfinity();

	}

}
