package base.collection_framework_collection;

import java.util.HashSet;
import java.util.TreeSet;

public class Set {
	
	public static void main(String args[]) {
/*
 * 		 1. HashSet
 * 		
		//순서를 유지 하지 않는 데이터의 집합, 순서를 유지하려면 LinkedHashSet
		//데이터의 중복을 허용하지 않는다
		//내부적으로 해싱을 이용해서 구현한 컬렉션
		
		Set<Integer> set = new HashSet<>();
		Set<String> set2 = new HashSet<>();
		int[] valArr = {99,120,12, 1, 2, 2, 10, 3, 3, 5, 6, 10};
		
		for(int i=0; i< valArr.length; i++) {
			set.add(valArr[i]);
		}
		
		System.out.println(set);
		System.out.println();
		
		String[] valArr2 = {"나", "다", "라", "마", "가", "차", "가", "하", "파", "파"};
		
		for (int i=0; i<valArr2.length; i++) {
			set2.add(valArr2[i]);
		}
		
		System.out.println(set2);
		
*/
		//2. TreeSet
		
		TreeSet<Integer> set2 = new TreeSet<>();
		
		set2.add(1);
		set2.add(2);
		set2.add(3);
		set2.add(4);
		
		System.out.println( set2.first() );
		
		System.out.println( set2.subSet(1, 3));
		
/*	
		1. 구현 방식

		 - HashSet은 해싱을 이용하여 구현
		 - TreeSet은 이진탐색트리를 이용하여 구현

		2. 속도 비교
		 - HashSet > TreeSet
		 - 해싱이 이진탐색트리보다 빠르다

		3. 정렬 기능
		 - HashSet < TreeSet
		 - 이진탐색트리를 이용했기 때문에 데이터 정렬이 가능 (Comparator 이용)

*/
	}
}
