package java8.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Stream_API_terminalOperations {

	public static void main(String[] args) {

		// ================================================ 3. 최종 작업 ===================================================================

		// Calculating
		// Stream API는 다양한 종료 작업을 제공한다, 최소, 최대, 합, 평균 등 기본형 타입으로 결과를 만들어낼 수 있다.

		long count = IntStream.of(1, 3, 5, 7, 9).count();
		long sum = LongStream.of(1, 3, 5, 7, 9).sum();

		// ※ 스트림이 비어 있는경우, count와 sum은 0을 출력,
		//   하지만 평균, 최소, 최대의 경우에는 표현할 수 없기 때문에 Optional을 이용해 리턴한다.

		OptionalInt min = IntStream.of(1, 3, 5, 7, 9).min();
		OptionalInt max = IntStream.of(1, 3, 5, 7, 9).max();

		// 스트림에서 바로 ifPresent 메소드를 이용해서 Optional 처리할 수 도 있다.
		DoubleStream.of(1.1, 2.2, 3.3, 4.4, 5.5)
				.average()
				.ifPresent(System.out::println);



		// Reduction
		// 스트림 reduce 라는 메소드를 이용해서 결과를 만들어낸다.
		// reduce는 3개의 파라미터를 받는다
		// accumulator : 각 요소를 처리하는 계산 로직. 각 요소가 올 때마다 중간 결과를 생성하는 로직.
		// identity : 계산을 위한 초기값으로 스트림이 비어서 계산할 내용이 없더라도 이 값은 리턴.
		// combiner : 병렬(parallel) 스트림에서 나눠 계산한 결과를 하나로 합치는 동작하는 로직.

		// 인자가 1개 (BinaryOperator<T> accumulator))만 있는 경우

		OptionalInt reduced = IntStream.range(1, 4)
				.reduce((a,b) -> {	// [1, 2, 3]
					return Integer.sum(a, b);
				});

		// 인자가 2개 (T identity, BinaryOperator<T> accumulator)

		int reducedTwoParams =
				IntStream.range(1, 4) // [1, 2, 3]
						.reduce(10, Integer::sum); // method reference
		// 10이 초기값, 스트림 내 값을 더해서 결과는 16 ( 10 + 1+ 2+ 3)

		// 인자가 3개 (U identity,BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner) )

		Integer reducedParallel = Arrays.asList(1, 2, 3)
				.parallelStream()
				.reduce(10,
						Integer::sum,
						(a, b) -> {
							System.out.println("combiner was called");
							return a + b;
						});
		// 3번째 인자인 Combiner는 병렬 처리 시 각자 다른 쓰레드에서 실행한 결과를 마지막에 합치는 단계,
		// 병렬스트림에서만 동작한다.




		// Collecting
		// collect() 는 또 다른 종료 작업
		// Collector 타입의 인자를 받아서 처리, 자주 사용하는 작업은 Collectors 객체에서 제공.
		List<Product> productList =
				Arrays.asList(new Product(23, "potatoes"),
						new Product(14, "orange"),
						new Product(13, "lemon"),
						new Product(23, "bread"),
						new Product(13, "sugar"));

		// Collectors.toList()
		// 스트림에서 작업한 결과를 담은 List를 반환
		// 다음 예제는 map으로 각 요소의 이름을 가져온 후, Collectors.toList를 이용해서 List로 결과를 가져온다.

		List<String> collectorCollection =
				productList.stream()
						.map(Product::getName)
						.collect(Collectors.toList());
		// [potatoes, oragne, lemon, bread, sugar]


		// Collectors.joining()
		// 스트림에서 작업한 결과를 하나의 String으로 이어 붙일 수 있다.

		String listToString =
				productList.stream()
						.map(Product::getName)
						.collect(Collectors.joining());
		// potatoesorangelemonbreadsugar

		// Collectors.joining()은 3개의 인자를 받을 수 있다
		// delimiter : 각 요소 중간에 들어가 요소를 구분시켜주는 구분자
		// prefix : 결과 맨 앞에 붙는 문자
		//suffix : 결과 맨 뒤에 붙는 문자

		listToString =
				productList.stream()
						.map(Product::getName)
						.collect(Collectors.joining(", ", "<", ">"));
		// <potatoes, orange, lemon, bread, sugar>


		// Collectors.averageingInt()

		// 숫자 값(Integer value)의 평균(arithmetic mean)을 냅니다.

		Double averageAmount =
				productList.stream()
						.collect(Collectors.averagingInt(Product::getQuantity));
		// 17.2


		// Collectors.summingInt()

		// 숫자값의 합(sum)을 낸다.

		Integer summingAmount =
				productList.stream()
						.collect(Collectors.summingInt(Product::getQuantity));
		// 86

		// IntStream 으로 바꿔주는 mapToInt 메소드를 사용해서 좀 더 간단하게 표현 가능

		summingAmount =
				productList.stream()
						.mapToInt(Product::getQuantity)
						.sum();



		// Collectors.summarizingInt()
		// 합계와 평균 모두 얻을 수 있는 방법
		// summarizingInt

		IntSummaryStatistics statistics =
				productList.stream()
						.collect(Collectors.summarizingInt(Product::getQuantity));

		// IntSummaryStatistics {count=5, sum=86, min=13, average=17.200000, max=23}




		// Collectors.groupingBy()
		// 특정 조건으로 요소들을 그룹지을 수 있다.
		// 수량을 기준으로 그룹핑해보겠다, 여기서 받는 인자는 함수형 인터페이스 Function

		Map<Integer, List<Product>> collectorMapOfLists =
				productList.stream()
						.collect(Collectors.groupingBy(Product::getQuantity));

		// 결과
		//		{23=[Product{amount=23, name='potatoes'},
		//		     Product{amount=23, name='bread'}],
		//		 13=[Product{amount=13, name='lemon'},
		//		     Product{amount=13, name='sugar'}],
		//		 14=[Product{amount=14, name='orange'}]}


		// Collectors.partitioningBy()

		Map<Boolean, List<Product>> mapPartitioned=
				productList.stream()
						.collect(Collectors.partitioningBy(el -> el.getQuantity() > 15));
		// 결과
		//		{false=[Product{amount=14, name='orange'},
		//		        Product{amount=13, name='lemon'},
		//		        Product{amount=13, name='sugar'}],
		//		 true=[Product{amount=23, name='potatoes'},
		//		       Product{amount=23, name='bread'}]}


		// Collectors.collectingAndThen()

		// 특정 타입으로 결과를 collect한 이후에 추가 작업이 필요한 경우 사용
		// Collections.toSet 을 이용해서 결과를 Set으로 collect 한 후, 수정 불가한 Set으로 변환하는 작업
		Set<Product> unmodifiableSet =
				productList.stream()
						.collect(Collectors.collectingAndThen(Collectors.toSet(),
								Collections::unmodifiableSet));

		// Collector.of()

		// 이 외에 필요한 로직이 있으면, 직접 collector를 만들 수도 있다.

		Collector<Product, ?, LinkedList<Product>> toLinkedList =
				Collector.of(LinkedList::new,
						LinkedList::add,
						(first, second) -> {
							first.addAll(second);
							return first;
						});
		// Collector를 하나 생성
		// supplier 는 LinkedList의 생성자, accumulator에는 list에 추가하는 add()
		// 스트림의 각 요소에 LinkedList를 만들고 요소를 추가하게 된다.
		// 마지막으로 combiner를 이용해 결과를 조합하는데, 생성된 리스트들을 하나의 리스트로 합치고 있다.

		// 다라서 다음과 같이 collect() 에 우리가 만든 커스텀 셀렉터를 넘겨줄 수 있고, 결과가 담긴 LinkedList가 반환

		LinkedList<Product> linkedListOfPersons =
				productList.stream()
						.collect(toLinkedList);



		// Matching
		// 매칭은 조건식 람다 Predicate를 받아서 해당 조건을 만족하는 요소가 있는지, 체크한 결과를 리턴
		// 다음과 같은 세 가지 메소드가 있다
		/*
		1. 하나라도 조건을 만족하는 요소가 있는지(anyMatch)
		2. 모두 조건을 만족하는지(allMatch)
		3. 모두 조건을 만족하지 않는지(noneMatch)
		*/

		List<String> names = Arrays.asList("Eric", "Elena", "Java");

		boolean anyMatch = names.stream()
				.anyMatch(name -> name.contains("a"));
		boolean allMatch = names.stream()
				.allMatch(name -> name.length() > 3);
		boolean noneMatch = names.stream()
				.noneMatch(name -> name.endsWith("s"));


		// Iterating

		// foreach 는 요소를 돌면서 실행되는 최종 작업
		// 앞서 살펴본 peek 과는 중간 작업과 최종 작업의 차이가 있다.

		names.stream().forEach(System.out::println);


	}

	static class Product {

		int quantity =0;
		String name = null;

		public Product(int quantity, String name) {
			this.quantity = quantity;
			this.name = name;
		}

		public String getName() {

			return this.name;
		}

		public int getQuantity() {

			return this.quantity;
		}
	}

}
