package java8;

import java.util.Objects;
import java.util.Random;
import java.util.function.Function;

public class Lambda_expressions2 {
	
	// java.util.function.Function �������̽��� apply �޼ҵ尡 �ϳ��� �Ķ���͸� ���� �� �ֱ� ������ ������ Ŭ����
	public class TwoNumbers {
	    private int first;
	    private int second;
	    public TwoNumbers(int first, int second) {
	        this.first = first;
	        this.second = second;
	    }
	    public int getFirst() {
	        return first;
	    }
	    public void setFirst(int first) {
	        this.first = first;
	    }
	    public int getSecond() {
	        return second;
	    }
	    public void setSecond(int second) {
	        this.second = second;
	    }
	}
	  
	// ������ �������̽��� �޼ҵ� ���� java.util.function.Function �������̽��� �������

	private void testFunction() {
	    Function<TwoNumbers, Integer> plusOperator = n -> n.getFirst() + n.getSecond();
	    Function<TwoNumbers, Integer> minusOperator = n -> n.getFirst() - n.getSecond();
	    Function<TwoNumbers, Integer> multiplyOperator = n -> n.getFirst() * n.getSecond();
	    Function<TwoNumbers, Integer> divideOperator = n -> {
	        if (n.getSecond() == 0) {
	            return 0;
	        }
	        return n.getFirst() / n.getSecond();
	    };
	    Function<TwoNumbers, Integer> spareOperator = n -> {
	        if (n.getSecond() == 0) {
	            return 0;
	        }
	        return n.getFirst() % n.getSecond();
	    };
	    TwoNumbers numbers = new TwoNumbers(new Random().nextInt(10000), new Random().nextInt(10000));
	    int plus = plusOperator.apply(numbers);
	    int minus = minusOperator.apply(numbers);
	    int multiply = multiplyOperator.apply(numbers);
	    int divide = divideOperator.apply(numbers);
	    int spare = spareOperator.apply(numbers);
	}
	
	
/*
 * 	funcction Package�� ��ǥ���� Interface
 * 
 * 	Consumer<T> 
 * 		- void accept(T) �޼��尡 ����Ǿ� �ִ� �������̽�
 * 		- �Էµ� T type �����Ϳ� ���� � �۾��� �����ϰ��� �� �� ���
 * 		- ����Ÿ���� void�̹Ƿ�, ó�� ����� �����ؾ� �ϴ� ��쿡�� Function �������̽��� ����ؾ� �Ѵ�.
 * 		- Ȥ�� call by reference�� �̿��Ͽ�, �Էµ� �������� ���� Property�� ������ ���� �ִ�
 * 		
 * 	Function<T,R>
 * 		- R apply(T) �޼��尡 ����Ǿ� �ִ� �������̽�
 * 		- �Էµ� T type �����Ϳ� ���� �Ϸ��� �۾��� �����ϰ�, R type �����͸� ������ �� ���
 * 		- �Էµ� �����͸� ��ȯ�� �� ����� �� �ִ�.
 * 
 * 	Predicate<T>
 * 		- bollean test(T) �޼��尡 ����Ǿ� �ִ� �������̽�
 * 		- �Էµ� T type �����Ͱ� Ư�� ���ǿ� ���յǴ��� Ȯ���Ͽ� boolean ����� ����
 * 	
 * 	Supplier<T>
 * 		- T get() �޼��尡 ����Ǿ� �ִ� �������̽�
 * 		- �Ű������� ���� �ʰ�, Ư�� Ÿ���� ����� ���� �Ѵ�.
 * 	
 *  
 *  
 *  �̿ܿ��� ���� �Լ��� �������̽��� �ִµ� 
 *  �ʿ��� ������ ã�ƺ���.. ��ǥ���ΰ� ��������	
 */


}
