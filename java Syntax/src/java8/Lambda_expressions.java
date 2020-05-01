package java8;

import java.util.Random;
import java.util.concurrent.locks.Condition;

public class Lambda_expressions {
	
	/*
	 java.util.function ��Ű������ ������ Functional Interface ���� ��ϵǾ� ����
	  �� ��Ű���� ��ϵǾ� �ִ� ��� �������̽����� @Functionalinterface�� �����Ǿ� ����
	  
	 (Object Ŭ������ �޼��带 �����ϰ�) �� �ϳ��� �߻� �޼��常�� ���� �������̽��� �ǹ��ϸ�,
	 �׷� ������ �� �ϳ��� ����� ����� ǥ���ϰ� ��.
  
	*/
	
	// ���� 1
	
	//Functional Interface�� ��� : �޼ҵ尡 �ϳ��� ����
	public interface Functional {
		public boolean test(Condition condition);
	}
	
	//java.lang.Runnable�� ��������� Functional Interface
	public interface Runnable {
		public void run();
	}
	
	//�����ؾ� �� �޼ҵ尡 �ϳ� �̻� �ִ� ���� Functional Interface(x)
	public interface NonFunctional {
		public void actionA();
		public void actionB();
	}
	
	// ���� 2
	
	//Object ��ü�� �޼ҵ常 �������̽��� ����Ǿ� �ִ� ���� Functional Interface�� �ƴ�
	public interface NotFunctional {
		public boolean equals(Object obj);
	}
	
	//Object ��ü�� �޼ҵ带 �����ϰ� �ϳ��� �߻� �޼ҵ常 ����Ǿ� �ִ� ���� Functional Interface��
	public interface Functional2 {
		public boolean equals(Object obj);
		public void execute();
		
	}
	
	//Object ��ü�� clone �޼ҵ�� public �޼ҵ尡 �ƴϱ� ������, Functional Interface�� ����� �ʤ�
	public interface Functional3 {
		public Object clone();
	}
	public interface NotFunctional3 {
		public Object clone();
		public void execute();
	}
	
	// ������̼� Ÿ�� @FunctionalInterface�� � �������̽��� Functional Interface��� ����
	// ��Ÿ���� ���� ���ȴ�, �̰��� �̿��ϸ� �������� �޼��� ������ ���ԵǾ� �ְų�, �Լ����̾�� �ϴ� �������̽���
	// �ٸ� �������̽��� ����� ��� �̸� Ȯ���� �� �ִ�.
	
	// @FunctionalInterface�� �����Ǿ� �����鼭 �����δ� Functional Interface�� �ƴ� 
	// �������̽��� ������ ���, ������ Ÿ�� ������ �߻��Ѵ�.
	
	// � �������̽����� �쿬�� �Լ������� ���ǵ� ���� �ֱ� ������, Functional Interface���� ���
	// @FunctionalInterface ������̼����� ����� �ʿ䵵 ����, �׷��� �ϴ� ���� �ٶ��� ������ �ʴ�.
	
	// @FunctionalInterface Annotation
	// �� �������̽��� Functional Interface���� �ƴ��� Ȯ���� �ϱ⸦ ���� �� ���
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
	
	// ��ü ������ �������̽� 
	@FunctionalInterface
	public interface ArithmeticOperator {
		public int operate(int a, int b);
	}
	
	// ��ü ������ ArithmeticOperator �������̽��� ����ϴ� ���
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
