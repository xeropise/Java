package base.comparable;

public class Explanation {

	public static void main(String[] args) {

		// 1) Comparable
		// 객체 간의 일반적인 정렬이 필요할 때, Comparable 인터페이스를 확장해서
		// 정렬의 기준을 정의하는 compareTo() 를 구현 한다.

		// 2) Comparator
		// 객체 간의 특정한 정렬이 필요할 때, Comparator 인터페이스를 확장해서 특정 기준을 정의하는 compare() 메서드를 구현한다.


		// ** 공통점 **
		// 정렬의 기준을 정의

		// ** 차이점 **
		// 1. 정렬 기준이 일반적이냐 일반적이지 않냐
		// 2. compareTo(Object o) 메서드를 구현하느냐 아니면 compare(Object o1, Objecto2) 메서드를 구현하느냐가 전부
	}

}
