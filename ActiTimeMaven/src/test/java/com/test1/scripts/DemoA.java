package com.test1.scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoA {
	
	@Test
	public void test_a() {
		Reporter.log("created by test1 engineer" ,true);
	}

}
