package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day3 {
    @Parameters({"URL"})    
	@Test
	public void WebLogInCarLoan(String url) {
		System.out.println("web login for car loan");
		System.out.println(url);
	}
	
	@Test
    public void MobileLogInCarLoan() {
		System.out.println("mobile login for car loan");
	}
	
	@Test
	public void APILogInCarLoan() {
		System.out.println("API login for car loan");
	}

}
