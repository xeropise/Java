package java8;

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

		// ================================================ 2. �߰� �۾� ===================================================================
		
		List<String> names = Arrays.asList("a","b","c");
		
		
		// 1) filter
		// Filtering
		// ��Ʈ�� �� ��ҵ��� �ϳ��� ���ؼ� �ɷ����� �۾�, ���ڷ� �޴� Predicate�� boolean�� �����ϴ� �Լ��� �������̽��� �򰡽��� ���� �ȴ�.
		
		Stream<String> filterStream = names.stream().filter(name -> name.contains("a")); // [Elena, Java]
		// "a"�� �� ��Ʈ���� ����
		
		// 2) map
		// Mapping : ��Ʈ���� �� �ִ� ���� input�� �Ǿ Ư�� ������ ���� ��, output�� ���ϵǴ� ���ο� ��Ʈ���� ���ԵǴµ�, �̷��� �۾��� ����
		// ��Ʈ�� �� ��ҵ��� �ϳ��� Ư�� ������ ��ȯ���ش�, �� �� ���� ��ȯ�ϱ� ���� ���ٸ� ���ڷ� �޴´�.
		Stream<String> mappingStream = names.stream().map(String::toUpperCase);  //[ERIC, ELENAM, JAVA]
		
		// ����ó�� ��� �� ����ִ� Product ��ü�� ������ ������ ���� ����
		
//		Stream<Integer> stream = 
//							productList.stream()
//								.map(Product::getAmount);
		
		// 3) flatMap
		// ���ڷ� mapper�� �ް� �ִµ�, ���� Ÿ���� Stream, �� ���ο� ��Ʈ���� �����ؼ� �����ϴ� ���ٸ� �Ѱܾ� �Ѵ�.
		// flatMap�� ��ø ������ �� �ܰ� �����ϰ�, ���� �÷������� ������ִ� ������ �Ѵ�. 
		// �̷��� �۾��� flattening(�÷�Ʈ��)�̶�� �Ѵ�.
		
		List<List<String>> list = Arrays.asList(Arrays.asList("a"),Arrays.asList("b"));
		
		// flatMap�� ����ؼ� ��ø ������ ������ �� �۾��� �� ����
		// ������ ���� ��ƴ�...
		List<String> flatList = list.stream().flatMap(Collection::stream)
											 .collect(Collectors.toList());
		
		// ��ü�� ������ ��
		// �л� ��ü�� ���� ��Ʈ������ �л��� ������ ������ �̾� ���ο� ��Ʈ���� ����� ����� ���ϴ� �ڵ�
		// �̴� map �޼ҵ� ��ü�����δ� �ѹ��� �� �� ���� ����̴�.
//		students.stream()
//		  .flatMapToInt(student -> 
//		                IntStream.of(student.getKor(), 
//		                             student.getEng(), 
//		                             student.getMath()))
//		  .average().ifPresent(avg -> 
//		                       System.out.println(Math.round(avg * 10)/10.0));

		
		// 4) Sorting
		// ���� ���� �׳� ȣ���� ��� ������������ ����
		List<Integer> intList =IntStream.of(14, 11, 20, 39, 23)
			.sorted()
			.boxed()
			.collect(Collectors.toList());
			// [11, 14, 20, 23, 39]
		
		// ���ڸ� �ѱ�� ���, 
		// ������ String List���� ���ĺ� ������ ������ �ڵ�� Comparator�� �Ѱܼ� �������� ������ ��
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
		
		// Comparator�� compare �޼ҵ�� �� ���ڸ� ���ؼ� ���� ������ 
		// �⺻������ Comparator ������ ����, �̸� �̿��� ���ڿ� ���̸� �������� ����
		lang.stream()
			.sorted(Comparator.comparingInt(String::length))
			.collect(Collectors.toList());
		// [Go, Java, Scala, Swift, Groovy, Python ]
		
		lang.stream()
			.sorted( (s1,s2) -> s2.length() - s1.length())
			.collect(Collectors.toList());
		// [Groovy, Python, Scala, Swift, java, Go]
		
		
		// 5) Iterating
		// ��Ʈ�� �� ��ҵ� ������ ������� Ư�� ������ �����ϴ� �޼ҵ�δ� peek�� �ִ�.
		// �׳� Ȯ���غ��ٴ� �ܾ� ��ó�� Ư�� ����� ��ȯ���� �ʴ� �Լ��� �������̽� Consumer�� ���ڷ� ����
		// ���� ��Ʈ�� �� ��ҵ� ������ Ư�� �۾��� ������ �� ����� ������ ��ġ�� ����
		// ����ó�� �۾��� ó���ϴ� �߰��� ����� Ȯ���غ� ��, ����� �� �ִ�.
		
		int sum = IntStream.of(1, 3, 5, 7, 9)
				.peek(System.out::println)
				.sum();
	}
	
}
