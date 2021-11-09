package APITestCases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	// This class generate random data

	public static String getFirstName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("John" + generatedString);
	}

	public static String getLastName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Kenedy" + generatedString);
	}

	public static String getUserName() {
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return ("John" + generatedString);
	}

	public static String getPassword() {
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return ("John" + generatedString);
	}

	public static String getEmail() {
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return (generatedString + "gmail.com");
	}

	public static String empName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("John" + generatedString);
	}

	public static String empSal() {
		String generatedString = RandomStringUtils.randomNumeric(5);
		return (generatedString);
	}

	public static String empAge() {
		String generatedString = RandomStringUtils.randomNumeric(2);
		return (generatedString);
	}

	public static String getJob() {
		String generatedString = RandomStringUtils.randomNumeric(2);
		return ("Analist" + generatedString);
	}
	
	/**
	 * This function is used for get the string from txt format file
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static String generateStringFromResource(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}
}
