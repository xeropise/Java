package base;

public class printf {

	public static void main(String[] args) {
		
		//boolean 출력 지시자

		boolean isTrue = true;

		System.out.printf("isTrue[%b]%n",isTrue);

		

		//10진수 출력 지시자

		int number = 10;

		System.out.printf("isTrue[%d]%n",number);

		

		//문자 출력 지시자

		char c = 'A';

		System.out.printf("c[%c]%n",c);

		

		//8진수 출력 지시자

		int oNum = 010;

		System.out.printf("oNum[%o],[%d]%n",oNum, oNum);

		

		//16진수 출력 지시자

		int hNum = 0x10;

		System.out.printf("hNum[%x],[%d]%n",hNum, hNum);

		

		//문자열 출력 지시자

	    String msg = "hello world";

		System.out.printf("msg[%s]%n",msg);



//출처: https://jink1982.tistory.com/183 [돼민이]
	}

}
