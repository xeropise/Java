package java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_API_intermediateOperation {

	public static void main(String[] args) {

		// ================================================ 2. 중간 작업 ===================================================================

		List<String> names = Arrays.asList("a","b","c");


		// 1) filter
		// Filtering
		// 스트림 내 요소들을 하나씩 평가해서 걸러내는 작업, 인자로 받는 Predicate는 boolean을 리턴하는 함수형 인터페이스로 평가식이 들어가게 된다.

		Stream<String> filterStream = names.stream().filter(name -> name.contains("a")); // [Elena, Java]
		// "a"가 들어간 스트림만 리턴

		// 2) map
		// Mapping : 스트림에 들어가 있는 값이 input이 되어서 특정 로직을 거진 후, output이 리턴되는 새로운 스트림에 담기게되는데, 이러한 작업을 말함
		// 스트림 내 요소들을 하나씩 특정 값으로 변환해준다, 이 때 값을 변환하기 위한 람다를 인자로 받는다.
		Stream<String> mappingStream = names.stream().map(String::toUpperCase);  //[ERIC, ELENAM, JAVA]

		// 다음처럼 요소 내 들어있는 Product 개체의 수량을 꺼내올 수도 있음

//		Stream<Integer> stream =
//							productList.stream()
//								.map(Product::getAmount);

		// 3) flatMap
		// 인자로 mapper를 받고 있는데, 리턴 타입이 Stream, 즉 새로운 스트림을 생성해서 리턴하는 람다를 넘겨야 한다.
		// flatMap은 중첩 구조를 한 단계 제거하고, 단일 컬렉션으로 만들어주는 역할을 한다.
		// 이러한 작업을 flattening(플래트닝)이라고 한다.

		List<List<String>> list = Arrays.asList(Arrays.asList("a"),Arrays.asList("b"));

		// flatMap을 사용해서 중첩 구조를 제거한 후 작업할 수 있음
		// 솔직히 많이 어렵다...
		List<String> flatList = list.stream().flatMap(Collection::stream)
				.collect(Collectors.toList());

		// 객체에 적용한 예
		// 학생 객체를 가진 스트림에서 학생의 국여수 점수를 뽑아 새로운 스트림을 만들어 평균을 구하는 코드
		// 이는 map 메소드 자체만으로는 한번에 할 수 없는 기능이다.
//		students.stream()
//		  .flatMapToInt(student ->
//		                IntStream.of(student.getKor(),
//		                             student.getEng(),
//		                             student.getMath()))
//		  .average().ifPresent(avg ->
//		                       System.out.println(Math.round(avg * 10)/10.0));


		// 4) Sorting
		// 인자 없이 그냥 호출할 경우 오름차순으로 정렬
		List<Integer> intList =IntStream.of(14, 11, 20, 39, 23)
				.sorted()
				.boxed()
				.collect(Collectors.toList());
		// [11, 14, 20, 23, 39]

		// 인자를 넘기는 경우,
		// 다음은 String List에서 알파벳 순으로 정렬한 코드와 Comparator를 넘겨서 역순으로 정렬한 것
		List<String> lang =
				Arrays.asList("Java","Scala","Groovy", "Python", "Go", "Swift");

		lang.stream()
				.sorted()
				.collect(Collectors.toList());
		// [Go, Groovy, Java, Python, Scala, Swift]

		lang.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		// [Swift, Scala, Python, Java, Groovy, Go]

		// Comparator의 compare 메소드는 두 인자를 비교해서 값을 리턴함
		// 기본적으로 Comparator 사용법과 동일, 이를 이용해 문자열 길이를 기준으로 정렬
		lang.stream()
				.sorted(Comparator.comparingInt(String::length))
				.collect(Collectors.toList());
		// [Go, Java, Scala, Swift, Groovy, Python ]

		lang.stream()
				.sorted( (s1,s2) -> s2.length() - s1.length())
				.collect(Collectors.toList());
		// [Groovy, Python, Scala, Swift, java, Go]


		// 5) Iterating
		// 스트림 내 요소들 각각을 대상으로 특정 연산을 수행하는 메소드로는 peek이 있다.
		// 그냥 확인해본다는 단어 뜻처럼 특정 결과를 반환하지 않는 함수형 인터페이스 Consumer를 인자로 받음
		// 따라서 스트림 내 요소들 각각에 특정 작업을 수행할 뿐 결과에 영향을 미치지 않음
		// 다음처럼 작업을 처리하는 중간에 결과를 확인해볼 때, 사용할 수 있다.

		int sum = IntStream.of(1, 3, 5, 7, 9)
				.peek(System.out::println)
				.sum();
	}

}
