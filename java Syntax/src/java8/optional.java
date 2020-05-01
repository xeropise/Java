package java8;

import java.util.Optional;
import java.util.function.Consumer;

public class optional {

    public static void main(String[] args){
    	
    	
    	// 1. Optional ����
    	
    	Optional<String> opName = Optional.empty();
    	Optional<String> opName2 = Optional.of("xeropise");
    	Optional<String> opName3 = Optional.ofNullable("xeropise"); // null �� �־ ����
    	
    	// 2. Optional get
    	// �� ��������
    	// get()�� �̿��ؼ� ���׸��� ǥ��� �ڷ����� ���� ������ �� �ִ�.
    	//opName.get(); // java.util.NoSuchElementException�� ����.
    	//opName2.get();  
    	//opName3.get(); // ���� �� ���, java.util.NoSuchElementException�� ����.
    	
    	
    	// 3. Optional isPresent
    	// isPresent()�� �̿��Ͽ� ���� ������� �� �� �ֽ��ϴ�.
    	System.out.println( opName.isPresent() );
    	System.out.println( opName2.isPresent() );
    	System.out.println( opName3.isPresent() );
    	
    	
    	// 4. Optional ifPresent
    	//ifPresent()�� �̿��Ͽ� ���� ���� ���, ���ϴ� ó���� �� �� �ֵ��� �����ݴϴ�.
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
