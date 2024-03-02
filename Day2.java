package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day2 {
    @Parameters({"URL"})
	@Test
	public void WebLogInHomeLoan(String url) {
		System.out.println("web login for home loan");
		System.out.println(url);
	}
	
	@Test
    public void MobileLogInHomeLoan() {
		System.out.println("mobile login for home loan");
	}
	
	@Test
	public void APILogInHomeLoan() {
		System.out.println("API login for home loan");
	}

}
