package base.collection_framework_map;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class Map {

	public static void main(String[] args) {
		
		
		// 키(Key)와 값(Value)로 구성된 Entry 객체를 저장하는 구조
		
		// 키는 중복될 수 없지만, 값은 중복 저장될 수 있음
		// 기존에 저장된 키와 동일한 키로 값을 저장하면, 기존 저장 값은 없어지고, 새로운 값으로 대체
		
		
		// 1. HashMap
		
		// 대표적인 Map Collection
		// HashMap의 키로 사용할 객체는 hashCode()와 equals()를 재정의해서, 동등 객체가 될 조건을 정해야 함
		
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        map.put("Jack", 30);
        map.put("Andy", 40);
        map.put("John", 22);
        map.put("Jolie", 10);
        map.put("Exo", 50);
        map.put("Tiger", 91);
        
        System.out.println("총 Entry 수: " + map.size());
        
        System.out.println("\tJolie" + map.get("Jolie"));
        System.out.println();
        
        // 객체를 하나씩 처리
        Set<String> keySet = map.keySet();
        Iterator<String> it = keySet.iterator();
        
        while (it.hasNext()) {
            String key = it.next();
            Integer value = map.get(key);
            System.out.println("\t" + key + " : " + value);
        }
        
        System.out.println();
        
        // 객체 삭제
        map.remove("Exo");
        System.out.println("총 Entry 수: " + map.size());
        
        map.clear();
        System.out.println("총 Entry 수: " + map.size());
        
        
        // 2. HashTable
        
        // HashTable도 키로 사용할 객체는 hashCode()와 equals()를 재정의해서, 동등 객체가 될 조건을 정해야 함
        
        // HashMap과의 차이점은, HashTable은 동기화(Synchronized)가 되어 있다. 멀티 스레드 환경에 적합
        
        
        // 3. Properties
        
        // HashTable의 하위 클래스, HashTable의 모든 특징을 그대로 가지고 있음
        
        // 차이점은 HashTable은 키와 값은 다양한 타입으로 지정 가능한데 비해, Properties는 키와 값을 String으로 제한
        
        // 프로퍼티(*.properties) 파일을 읽을 때 주로 사용
        // 프로퍼티 파일은 키와 값이 = 기호로 연결외어 있는 텍스트 파일로 ISO 8859-1 문자셋으로 저장된다
        
        Properties properties = new Properties();
        
        try {
			properties.load(new FileReader("C:/~/database.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
        
	}

}
