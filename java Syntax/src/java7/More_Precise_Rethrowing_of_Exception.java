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
		
		//JDK7 ���� ���������� catch ���������� ������ ���� ������ ������ ���� �� �ִ�
		//JDK7������ catch �������� ������ ���ܸ� ������ ���� �� �ִ�
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
