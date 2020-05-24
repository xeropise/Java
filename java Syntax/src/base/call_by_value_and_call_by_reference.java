package base;

public class call_by_value_and_call_by_reference {
    
	public static void main(String[] args) {
		
		// Call By Value는 '값에 의한 호출'
		// 메소드로 인자값을 넘길 때 그 값을 복사하여 넘기는 형태
		// 이 방식으로 메소드 호출을 하면 메소드 내에서는 복사된 값으로 작업을 하기 때문에
		// 원래의 값을 변경시키지 않는다.
		
		// 1. 인자 값을 기본형을 사용 했을 때
//		int num1= 10, num2 = 20;
//		
//		System.out.println("Before");
//		System.out.println("num1 = " + num1);
//		System.out.println("num2 = " + num2);
//		swap1(num1, num2);
//		System.out.println("After");
//		System.out.println("num1 = " + num1);
//		System.out.println("num2 = " + num2);
		
		// 결론 : 자바는 기본형 데이터를 처리할 때 Call By Value 형식으로 처리한다.
		
		// 2. 인자 값으로 객체를 사용했을 때(wrapper 클래스 사용), 과연 Call By reference 일까?
		
//		Integer num1 = 10, num2 = 20;
//		// Integer num1 = new Integer(10), num2 = new Integer(20)
//		// 과 같음
//		System.out.println("Before");
//		System.out.println("num1 = " + num1);
//		System.out.println("num2 = " + num2);
//		swap2(num1, num2);
//		System.out.println("After");
//		System.out.println("num1 = " + num1);
//		System.out.println("num2 = " + num2);
		
		// 객체를  swap을 통해 바꾸었지만 call By reference라면 바뀌어야했는데 바뀌지 않았다
		// 결론 : 객체 또한 메소드로 값이 전달 될 때, 그 참조값이 Call By Value의 형태로 전달된다.
		
		// 3. 인자값으로 받은 참조값을 통해 멤버 변수로 접근
		
//		NumberClass num3 = new NumberClass(10);
//		NumberClass num4 = new NumberClass(20);
//		
//		System.out.println("Before");
//		System.out.println("num3 = " + num3.num);
//		System.out.println("num4 = " + num4.num);
//		swapFinal(num3,num4);
//		System.out.println("After");
//		System.out.println("num3 = " + num3.num);
//		System.out.println("num4 = " + num4.num);
		
		// 객체의 참조값을 직접 바꾼 것이 아니라, 객체의 참조값을 통해서 
		// 그 객체의 멤버변수에 접근하여 그 값을 바꿨음
		
		// 자바는 객체를 메소드로 넘길 때, 객체를 참조하는  지역변수의 실제 주소를 넘기는 것이 아니라, 
		// 그 지역변수가 가리키고 있는 힙 영역의 객체를 가리키는 행위의 새로운 지역변수를 생성하여,
		// 그것을 통하여 같은 객체를 가리키도록 하는 방식
		
		// 최종 결론 자바의 메소드로 인자 값을 넘기는 방법은 Call By Value이다
		
		// 4. String으로 Swap 예제
		
		String a = "10";
		String b = "20";
		System.out.println("Before");
		System.out.println("String a = " + a);
		System.out.println("String b = " + b);
		swapString(a,b);
		System.out.println("After");
		System.out.println("String a = " + a);
		System.out.println("String b = " + b);
	}
	
	// 자리 바꾸기 메소드
	
	static void swap1(int num1, int num2) {
		int temp;
		
		temp = num2;
		num1 = temp;
		num2 = num1;
	}
	static void swap2(Integer num1, Integer num2) {
		Integer temp;	//임시 변수
		
		// 자리 바꾸기
		temp = num1;
		num1 = num2;
		num2 = temp;
	}
	
	// 자리 바꾸기 메소드
	static void swapFinal(NumberClass one, NumberClass two) {
		
		int temp = one.num;
		
		one.setNum(two.num);
		
		two.setNum(temp);
	}
	
	static void swapString(String a, String b) {
		String temp; // 임시 변수
		
		// 자리 바꾸기
		
		temp = a; 
		a = b;
		b= temp;
		
	}
	
	static class NumberClass {
		int num;
		
		public NumberClass(int num) {
			this.num = num;
		}
		
		public void setNum(int num) {
			this.num = num;
		}
	}

}
