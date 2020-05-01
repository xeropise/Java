package java8;

import java.util.Random;
import java.util.concurrent.locks.Condition;

public class Lambda_expressions {
	
	/*
	 java.util.function 패키지에는 수많은 Functional Interface 들이 등록되어 있음
	  이 패키지에 등록되어 있는 모든 인터페이스들은 @Functionalinterface로 지정되어 있음
	  
	 (Object 클래스의 메서드를 제외하고) 단 하나의 추상 메서드만을 가진 인터페이스를 의미하며,
	 그런 이유로 단 하나의 기능적 계약을 표상하게 됨.
  
	*/
	
	// 예시 1
	
	//Functional Interface인 경우 : 메소드가 하나만 있음
	public interface Functional {
		public boolean test(Condition condition);
	}
	
	//java.lang.Runnable도 결과적으로 Functional Interface
	public interface Runnable {
		public void run();
	}
	
	//구현해야 할 메소드가 하나 이상 있는 경우는 Functional Interface(x)
	public interface NonFunctional {
		public void actionA();
		public void actionB();
	}
	
	// 예시 2
	
	//Object 객체의 메소드만 인터페이스에 선언되어 있는 경우는 Functional Interface가 아님
	public interface NotFunctional {
		public boolean equals(Object obj);
	}
	
	//Object 객체의 메소드를 제외하고 하나의 추상 메소드만 선언되어 있는 경우는 Functional Interface임
	public interface Functional2 {
		public boolean equals(Object obj);
		public void execute();
		
	}
	
	//Object 객체의 clone 메소드는 public 메소드가 아니기 때문에, Functional Interface의 대상이 됨ㅇ
	public interface Functional3 {
		public Object clone();
	}
	public interface NotFunctional3 {
		public Object clone();
		public void execute();
	}
	
	// 어노테이션 타입 @FunctionalInterface는 어떤 인터페이스가 Functional Interface라는 것을
	// 나타내기 위해 사용된다, 이것을 이용하면 부적절한 메서드 선언이 포함되어 있거나, 함수형이어야 하는 인터페이스가
	// 다른 인터페이스를 상속한 경우 미리 확인할 수 있다.
	
	// @FunctionalInterface로 지정되어 있으면서 실제로는 Functional Interface가 아닌 
	// 인터페이스를 선언한 경우, 컴파일 타임 에러가 발생한다.
	
	// 어떤 인터페이스들은 우연히 함수형으로 정의될 수도 있기 때문에, Functional Interface들이 모두
	// @FunctionalInterface 어노테이션으로 선언될 필요도 없고, 그렇게 하는 것이 바람직 하지도 않다.
	
	// @FunctionalInterface Annotation
	// 즉 인터페이스가 Functional Interface인지 아닌지 확실히 하기를 원할 때 사용
// ============================================================================ //
	
/*	
	() -> {}                // No parameters; result is void
	() -> 42                // No parameters, expression body
	() -> null              // No parameters, expression body
	() -> { return 42; }    // No parameters, block body with return
	() -> { System.gc(); }  // No parameters, void block body
	 
	() -> {                 // Complex block body with returns
	  if (true) return 12;
	  else {
	    int result = 15;
	    for (int i = 1; i < 10; i++)
	      result *= i;
	    return result;
	  }
	}                         
	 
	(int x) -> x+1              // Single declared-type parameter
	(int x) -> { return x+1; }  // Single declared-type parameter
	(x) -> x+1                  // Single inferred-type parameter
	x -> x+1                    // Parentheses optional for single inferred-type parameter
	 
	(String s) -> s.length()      // Single declared-type parameter
	(Thread t) -> { t.start(); }  // Single declared-type parameter
	s -> s.length()               // Single inferred-type parameter
	t -> { t.start(); }           // Single inferred-type parameter
	 
	(int x, int y) -> x+y  // Multiple declared-type parameters
	(x, y) -> x+y          // Multiple inferred-type parameters
	(x, int y) -> x+y    // Illegal: can't mix inferred and declared types
	(x, final y) -> x+y  // Illegal: no modifiers with inferred types 
*/
	
	// 자체 생성한 인터페이스 
	@FunctionalInterface
	public interface ArithmeticOperator {
		public int operate(int a, int b);
	}
	
	// 자체 생성한 ArithmeticOperator 인터페이스를 사용하는 경우
	public void testArithmeticOperator() {
		ArithmeticOperator plusOperator = (a, b) -> a+b;
		ArithmeticOperator minusOperator =(a, b) -> a-b;
		ArithmeticOperator multiplyOperator= (a, b) -> a*b;
		ArithmeticOperator divideOperator = (a, b) -> {
			if (b == 0) {
				b = 1;
			}
			return a / b;
		};
		ArithmeticOperator spareOperator = (a, b) -> {
			if (b == 0) {
				b = 1;
			}
			return a % b;
		};
		
	    int a = new Random().nextInt(10000);
	    int b = new Random().nextInt(10000);
	    int plus = plusOperator.operate(a, b);
	    int minus = minusOperator.operate(a, b);
	    int multiply = multiplyOperator.operate(a, b);
	    int divide = divideOperator.operate(a, b);
	    int spare = spareOperator.operate(a, b);
	 
	}
	
}
