package base;

public class printf {

	public static void main(String[] args) {
		
		//boolean ��� ������

		boolean isTrue = true;

		System.out.printf("isTrue[%b]%n",isTrue);

		

		//10���� ��� ������

		int number = 10;

		System.out.printf("isTrue[%d]%n",number);

		

		//���� ��� ������

		char c = 'A';

		System.out.printf("c[%c]%n",c);

		

		//8���� ��� ������

		int oNum = 010;

		System.out.printf("oNum[%o],[%d]%n",oNum, oNum);

		

		//16���� ��� ������

		int hNum = 0x10;

		System.out.printf("hNum[%x],[%d]%n",hNum, hNum);

		

		//���ڿ� ��� ������

	    String msg = "hello world";

		System.out.printf("msg[%s]%n",msg);



//��ó: https://jink1982.tistory.com/183 [�Ź���]
	}

}
