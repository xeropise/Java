package base.collection_framework_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class List {

	public static void main(String[] args) {

		// 1. 요소의 저장 순서가 유지된다.
		// 2. 같은 요소의 중복 저장을 허용합니다.
		// 3. 둘다 Thread-safe 하지 않으므로, 필요하다면 Collections.synchronizedList 사용 고려
		// https://www.holaxprogramming.com/2014/02/12/java-list-interface/
/*
		// 1) ArrayList

		// ① 내부적으로 배열을 이용하여, 요소를 저장합니다.
		// ② 배열은 크기를 변경할 수 없는 인스턴스이므로, 크기를 늘리기 위해서는 새로운 배열을 생성하고 기존 요소들을 옮겨야하는 복잡한 과정을 거칩니다.
		// ③ 물론 이 과정은 자동으로 수행되지만, 요소의 추가 및 삭제 작업에 걸리는 시간이 매우 길어지는 단점을 가지게 됩니다.
		// 동기화가 제공되지 않음, 데이터의 검색에 유리하며 추가, 삭제에는 성능 고려
		ArrayList<Integer> arrList = new ArrayList<Integer>();

		arrList.add(40);
		arrList.add(30);
		arrList.add(20);
		arrList.add(10);

		// for 문과 get() 메소드를 이용한 요소의 출력
		for(int i=0; i<arrList.size(); i++) {
			System.out.println(arrList.get(i) + " ");
		}

		// remove() 메소드를 이용한 요소의 제거
		arrList.remove(1);

		// Enhanced for 문과 get() 메소드를 이용한 요소의 출력
		for (int e : arrList) {
		    System.out.print(e + " ");
		}

		System.out.println("");

		// Collections.sort() 메소드를 이용한 요소의 정렬
		Collections.sort(arrList);
		// iterator() 메소드와 get() 메소드를 이용한 요소의 출력
		Iterator<Integer> iter = arrList.iterator();
		while (iter.hasNext()) {
		    System.out.print(iter.next() + " ");
		}

		System.out.println("");
		// set() 메소드를 이용한 요소의 변경
		arrList.set(0, 20);
		System.out.println(arrList);
		// size() 메소드를 이용한 요소의 총 개수
		System.out.println("리스트의 크기 : " + arrList.size());

		*/
/*
		// 2) LinkedList

		// https://m.blog.naver.com/PostView.nhn?blogId=highkrs&logNo=220443469613&proxyReferer=https%3A%2F%2Fwww.google.com%2F

		// ① ArrayList 클래스가 배열을 이용하여, 요소를 저장함으로써 발생하는 단점을 극복하기 위해 고안되었습니다.
		// ArrayList에 비해 데이터의 추가, 삭제에 유리하며 데이터 검색 시에는 성능을 고려

		LinkedList<Integer> lnkList = new LinkedList();

		lnkList.add(1);
		lnkList.add(2);
		lnkList.add(3);
		lnkList.add(4);

		System.out.println(lnkList);

		System.out.println(lnkList.indexOf(1));

*/

/*
		// 3) Vector

		// legacy 클래스 : Collections 프레임워크가 포함되어 있지 않던, 초기 자바 버전에서 정의한 인터페이스
		// 현재는 재구성 및 설계되어서 현재의 Collections 프레임워크가 완벽하게 호환됩니다

		// ArrayList와 달리 Vector는 동기화를 지원, Thread-safe
		// 단 동기화되어 있지 않은 ArrayList보다는 성능 상 느림
		// 멀티스레드 환경이 아닌 경우, ArrayList를 사용하는 것이 바람직 하다

		Vector<Integer> vector = new Vector<>();

		vector.add(1);
		vector.add(2);
		vector.add(3);
		vector.add(4);

		System.out.println(vector.toString());
*/
		Collections.synchronizedList(new ArrayList());
		Collections.unmodifiableMap(new HashMap());
	}

}
