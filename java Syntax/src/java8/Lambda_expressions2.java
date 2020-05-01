package java8;

import java.util.Objects;
import java.util.Random;
import java.util.function.Function;

public class Lambda_expressions2 {
	
	// java.util.function.Function 인터페이스의 apply 메소드가 하나의 파라미터만 받을 수 있기 때문에 정의한 클래스
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
	  
	// 별도의 인터페이스나 메소드 없이 java.util.function.Function 인터페이스를 직접사용

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
 * 	funcction Package의 대표적인 Interface
 * 
 * 	Consumer<T> 
 * 		- void accept(T) 메서드가 선언되어 있는 인터페이스
 * 		- 입력된 T type 데이터에 대해 어떤 작업을 수행하고자 할 때 사용
 * 		- 리턴타입이 void이므로, 처리 결과를 리턴해야 하는 경우에는 Function 인터페이스를 사용해야 한다.
 * 		- 혹은 call by reference를 이용하여, 입력된 데이터의 내부 Property를 변경할 수도 있다
 * 		
 * 	Function<T,R>
 * 		- R apply(T) 메서드가 선언되어 있는 인터페이스
 * 		- 입력된 T type 데이터에 대해 일련의 작업을 수행하고, R type 데이터를 리턴할 때 사용
 * 		- 입력된 데이터를 변환할 때 사용할 수 있다.
 * 
 * 	Predicate<T>
 * 		- bollean test(T) 메서드가 선언되어 있는 인터페이스
 * 		- 입력된 T type 데이터가 특정 조건에 부합되는지 확인하여 boolean 결과를 리턴
 * 	
 * 	Supplier<T>
 * 		- T get() 메서드가 선언되어 있는 인터페이스
 * 		- 매개변수를 받지 않고, 특정 타입의 결과를 리턴 한다.
 * 	
 *  
 *  
 *  이외에도 많은 함수형 인터페이스가 있는데 
 *  필요할 때마다 찾아보자.. 대표적인건 위에꺼야	
 */


}
