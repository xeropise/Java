package java8;

import java.util.Optional;
import java.util.function.Consumer;

public class optional {

    public static void main(String[] args){
    	
    	
    	// 1. Optional 생성
    	
    	Optional<String> opName = Optional.empty();
    	Optional<String> opName2 = Optional.of("xeropise");
    	Optional<String> opName3 = Optional.ofNullable("xeropise"); // null 을 넣어도 가능
    	
    	// 2. Optional get
    	// 값 가져오기
    	// get()을 이용해서 제네릭에 표기된 자료형의 값을 가져올 수 있다.
    	//opName.get(); // java.util.NoSuchElementException이 난다.
    	//opName2.get();  
    	//opName3.get(); // 값이 빈 경우, java.util.NoSuchElementException이 난다.
    	
    	
    	// 3. Optional isPresent
    	// isPresent()를 이용하여 값이 비었는지 알 수 있습니다.
    	System.out.println( opName.isPresent() );
    	System.out.println( opName2.isPresent() );
    	System.out.println( opName3.isPresent() );
    	
    	
    	// 4. Optional ifPresent
    	//ifPresent()를 이용하여 값이 있을 경우, 원하는 처리를 할 수 있도록 도와줍니다.
    	opName.ifPresent(System.out::println);
    	
    	
    	// 5. Optional isElse, isElseGet, isElseThrow
    	opName2.orElse(defaultValue());
    	opName2.orElseGet(() -> defaultValue());
    	
    	opName3.orElse(defaultValue());
    	opName3.orElseGet(() -> defaultValue());
    	
    	opName3.orElseThrow(NullPointerException::new);
	}
    
    private static String defaultValue() {
        System.out.println("call defaultValue()");
        return "default name : wonchul";
    }


    
}
