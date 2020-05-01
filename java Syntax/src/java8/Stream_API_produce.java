package java8;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Stream_API_produce {

	public static void main(String[] args) throws IOException {
		
		// 람다식을 활용할 수 있음
		
		// 스트림 사용 방법?
		
		// 1. 생성하기 : 스트림 인스턴스 생성
		// 2. 가공하기 : 필터링(filtering) 및 맵핑(mapping)등 원하는 결과를 만들어가는 중간 작업(intermediate operations)
		// 3. 결과 만들기: 최종적으로 결과를 만들어내는 작업(terminal operations)
		
		// 전체 -> 맵핑 -> 필터링 1 -> 필터링 2 -> 결과 만들기 -> 결과물
		
//================================================ 1. 생성하기 ===================================================================
		
		// 1) 배열 스트림
		String[] array = new String[] {"a","b","c"};
		
		Stream<String> stream = Arrays.stream(array);
		Stream<String> streamOfArrayPart = Arrays.stream(array, 1, 3); // 1~2 요소 [b,c]
		
		// 2) 컬렉션 스트림
		List<String>list = Arrays.asList("a","b","c");
		
		Stream<String> streamC = list.stream();
		Stream<String> parallelStream = list.parallelStream(); // 병렬 처리 스트림
		
		// 3) 다른 방법들
		// 3-1) Stream.of()    null도 이렇게 만들 수 있음
		Stream<String> stream1 = Stream.of(null);
		
		// 3-2) Stream.builder()
		// 스트림 빌더로 스트림에 직접 원하는 값을 넣을 수 있음, 마지막에 build메소드로 스트림 리턴
		Stream<String> builderStream = Stream.<String>builder()
											.add("홍").add("길").add("동")
											.build();
		
		// 3-3) Stream.generate()
		// generate 메소드를 이용하면, Supplier<T> 에 해당하는 람다로 값을 넣을 수 있다. 
		Stream<String> generateStream = Stream.generate(() -> "ABC"  );
		
		// 3-4) Stream.itereate()
		// generate와 유사한데, 인자가 없는 generate에 반해 인자가 2개임,  첫번째는 초기값, 두번째는 함수
		// 초기값을 함수에 대입하면 0,2,4,8... 무한한 스트림 생성, limit로 제한시킴
		Stream<Integer> iterateStream= Stream.iterate(0, n -> n + 2).limit(5);
		
		// 3-5) Stream.empty()
		Stream<String> emptyStream = Stream.empty();
		
		// 3-6) *** 기본 타입형 스트림 ***
		// 제네릭을 사용하면 리스트나 배열을 이용해서 기본타입 (int,long,double) 스트림을 생성할 수 있다.
		// 하지만 제네릭을 사용하지 않고, 직접적으로 해당 타입의 스트림을 다룰 수 있음.
		IntStream intStream = IntStream.range(1, 5);  // [ 1, 2, 3, 4]
		LongStream longStream = LongStream.range(1, 5); // [ 1, 2, 3, 4, 5 ]
		
		// 제네릭을 사용하지 않기 때문에 불필요한 오토박싱(auto-boxing)이 일어나지 않는다, 필요한 경우 boxed 메소드를 이용해서 박싱(boxing) 할 수 있다.
		Stream<Integer> boxedIntStream = IntStream.range(1, 5).boxed();
		
		// Random 클래스
		// Random 클래스는 난수를 가지고 세가지 타입의 스트림(intStream, LongStream, DoubleStream)을 만들어 낼 수 있다.
		DoubleStream doubleStream = new Random().doubles(3);
		
		// 3-7) *** 문자열 스트링 ***
		// String을 이용해서 스트림을 생성할 수도 있지만, 다음은 각 문자(char)를 IntStream으로 변환한 예제, char는 문자이지만 본질적으로 숫자이기 때문에 가능
		IntStream charStream = "Stream".chars(); // [83, 116, 114, 101, 97, 109]
		
		// 정규표현식으로 문자열을 자르고 각 요소 들로 스트림을 만든 예제
		Stream<String> stringStream = 
				  Pattern.compile(", ").splitAsStream("Eric, Elena, Java"); 
											// [Eric, Elena, Java]
		
		// 3-8) *** 파일 스트림 ***
		// 자바 NIO 의 Files 클래스의 lines 메소드는 해당 파일의 각 라인을 스트링 타입의 스트림으로 만들어줍니다.
		Stream<String> lineStream = 
				  Files.lines(Paths.get("file.txt"), 
				              Charset.forName("UTF-8"));
		
		// 3-9) *** 병렬 스트림 Parellel 스트림 ***
		// 병렬 스트림 생성
		//Stream<Product> parallelStream = productList.parallelStream();

		// 병렬 여부 확인
		//boolean isParallel = parallelStream.isParallel();
		
//		// 다음 코드는 각 작업을 쓰레드를 이용해 병렬로 처리함
//		boolean isMany = parallelStream
//				  .map(product -> product.getAmount() * 10)
//				  .anyMatch(amount -> amount > 200);
		
		// 배열을 이용해서 병렬 스트림 생성, 병렬 스트림이 무조건 좋은것이 아님에 주의
		// Arrays.stream(arr).parallel();
		
		// 컬렉션과 배열이 아닌 경우 다음과 같이 parallel 메소드를 이용해서 처리
		
		IntStream intParellelStream = IntStream.range(1, 150).parallel();
		boolean isParallel = intStream.isParallel();
		
		// 다시 시퀀셜 모드로 돌리려면 이렇게..
		intStream = intParellelStream.sequential();
		isParallel = intParellelStream.isParallel();
		
		
		// 3-10) Stream.concat
		// 두개의 스트림을 연결해서 하나의 스트림을 만들 수도 있다
		Stream<String> streamA = Stream.of("Java", "Scala", "Groovy");
		Stream<String> streamB = Stream.of("Python", "Go", "Swift");
		Stream<String> concat = Stream.concat(streamA, streamB);
		// [Java, Scala, Groovy, Python, Go, Swift]		
	}
	
	
	public Stream<String> streamOf(List<String> list){
		
		return list==null || list.isEmpty()
				? Stream.empty() : list.stream();
	}

}
