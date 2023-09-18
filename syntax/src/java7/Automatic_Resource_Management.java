package java7;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Automatic_Resource_Management {
	public static void main(String[] args) {
		try (
				FileInputStream is = new FileInputStream("C:\\file.txt");
				BufferedInputStream bis = new BufferedInputStream(is)
		) {
			int data = -1;
			while ((data = bis.read()) != -1) {
				System.out.print((char) data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		/* https://codechacha.com/ko/java-try-with-resources/
		 *
		 */
	}

}
