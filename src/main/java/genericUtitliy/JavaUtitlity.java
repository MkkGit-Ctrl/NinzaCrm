package genericUtitliy;

import java.util.Date;
import java.util.Random;

public class JavaUtitlity {

	public String getRandomString() {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder(3);
		Random random = new Random();

		for (int i = 0; i < 3; i++) {
			int index = random.nextInt(chars.length());
			sb.append(chars.charAt(index));
		}

		String randomString = sb.toString();
		System.out.println("Random 3-char string: " + randomString);
		return randomString;
	}

	public String getCurrentDate() {

		Date date = new Date();
		String datenewString = date.toString().replace(" ", "_").replace(":", "_");

		return datenewString;

	}
}
