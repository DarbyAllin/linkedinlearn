package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day1 {

	@Parameters({"URL"})
	@Test
	public void WebLogInPersonalLoan(String url) {
		System.out.println("web login for personal loan");
		System.out.println(url);
	}
	
	@Test
    public void MobileLogInPersonalLoan() {
		System.out.println("mobile login for persoanl loan");
	}
	
	@Test
	public void APILogInPersonalLoan() {
		System.out.println("API login for personal loan");
	}

}
