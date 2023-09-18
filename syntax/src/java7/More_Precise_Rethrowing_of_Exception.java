package java7;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class More_Precise_Rethrowing_of_Exception {

	public static void main(String[] args) throws ParseException, IOException {
		// TODO Auto-generated method stub
		More_Precise_Rethrowing_of_Exception test = new More_Precise_Rethrowing_of_Exception();

		test.precise();

		//JDK7 이전 버젼에서는 catch 구문내에서 선언한 예외 유형만 밖으로 던질 수 있다
		//JDK7에서는 catch 구문에서 선언한 예외를 밖으로 던질 수 있다
	}


	//before jdk7
	public void obscure() throws Exception {
		try {
			new FileInputStream("abc.txt").read();
			new SimpleDateFormat("ddMMyyyy").parse("12-03-2014");
		} catch (Exception ex) {
			System.out.println("Caught exception: " + ex.getMessage());
			throw ex;
		}
	}

	//jdk7
	public void precise() throws ParseException, IOException {
		try {
			new FileInputStream("abc.txt").read();
			new SimpleDateFormat("ddMMyyyy").parse("12-03-2014");
		} catch (Exception ex) {
			System.out.println("Caught exception: " + ex.getMessage());
			throw ex;
		}
	}
}
