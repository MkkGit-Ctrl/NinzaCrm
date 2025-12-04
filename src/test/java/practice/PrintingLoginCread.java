package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PrintingLoginCread {
	
	@DataProvider
	public Object[][] facebookCred() {
		
		Object[][] objeArr = new Object[3][2];
		
		objeArr[0][0]= "Qspiders";
		objeArr[0][1]= "Q";
		objeArr[1][0]= "Jspiders";
		objeArr[1][1]= "J";
		objeArr[2][0]= "Pyspiders";
		objeArr[2][1]= "Py";
		
		
		return objeArr;
	}
	
	@Test(dataProvider = "facebookCred")
	public void Printing(String user, String pass) {
		
		System.out.println(user);
		System.out.println(pass);
		
		
	}

}
