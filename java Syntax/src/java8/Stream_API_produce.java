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
		
		// ���ٽ��� Ȱ���� �� ����
		
		// ��Ʈ�� ��� ���?
		
		// 1. �����ϱ� : ��Ʈ�� �ν��Ͻ� ����
		// 2. �����ϱ� : ���͸�(filtering) �� ����(mapping)�� ���ϴ� ����� ������ �߰� �۾�(intermediate operations)
		// 3. ��� �����: ���������� ����� ������ �۾�(terminal operations)
		
		// ��ü -> ���� -> ���͸� 1 -> ���͸� 2 -> ��� ����� -> �����
		
//================================================ 1. �����ϱ� ===================================================================
		
		// 1) �迭 ��Ʈ��
		String[] array = new String[] {"a","b","c"};
		
		Stream<String> stream = Arrays.stream(array);
		Stream<String> streamOfArrayPart = Arrays.stream(array, 1, 3); // 1~2 ��� [b,c]
		
		// 2) �÷��� ��Ʈ��
		List<String>list = Arrays.asList("a","b","c");
		
		Stream<String> streamC = list.stream();
		Stream<String> parallelStream = list.parallelStream(); // ���� ó�� ��Ʈ��
		
		// 3) �ٸ� �����
		// 3-1) Stream.of()    null�� �̷��� ���� �� ����
		Stream<String> stream1 = Stream.of(null);
		
		// 3-2) Stream.builder()
		// ��Ʈ�� ������ ��Ʈ���� ���� ���ϴ� ���� ���� �� ����, �������� build�޼ҵ�� ��Ʈ�� ����
		Stream<String> builderStream = Stream.<String>builder()
											.add("ȫ").add("��").add("��")
											.build();
		
		// 3-3) Stream.generate()
		// generate �޼ҵ带 �̿��ϸ�, Supplier<T> �� �ش��ϴ� ���ٷ� ���� ���� �� �ִ�. 
		Stream<String> generateStream = Stream.generate(() -> "ABC"  );
		
		// 3-4) Stream.itereate()
		// generate�� �����ѵ�, ���ڰ� ���� generate�� ���� ���ڰ� 2����,  ù��°�� �ʱⰪ, �ι�°�� �Լ�
		// �ʱⰪ�� �Լ��� �����ϸ� 0,2,4,8... ������ ��Ʈ�� ����, limit�� ���ѽ�Ŵ
		Stream<Integer> iterateStream= Stream.iterate(0, n -> n + 2).limit(5);
		
		// 3-5) Stream.empty()
		Stream<String> emptyStream = Stream.empty();
		
		// 3-6) *** �⺻ Ÿ���� ��Ʈ�� ***
		// ���׸��� ����ϸ� ����Ʈ�� �迭�� �̿��ؼ� �⺻Ÿ�� (int,long,double) ��Ʈ���� ������ �� �ִ�.
		// ������ ���׸��� ������� �ʰ�, ���������� �ش� Ÿ���� ��Ʈ���� �ٷ� �� ����.
		IntStream intStream = IntStream.range(1, 5);  // [ 1, 2, 3, 4]
		LongStream longStream = LongStream.range(1, 5); // [ 1, 2, 3, 4, 5 ]
		
		// ���׸��� ������� �ʱ� ������ ���ʿ��� ����ڽ�(auto-boxing)�� �Ͼ�� �ʴ´�, �ʿ��� ��� boxed �޼ҵ带 �̿��ؼ� �ڽ�(boxing) �� �� �ִ�.
		Stream<Integer> boxedIntStream = IntStream.range(1, 5).boxed();
		
		// Random Ŭ����
		// Random Ŭ������ ������ ������ ������ Ÿ���� ��Ʈ��(intStream, LongStream, DoubleStream)�� ����� �� �� �ִ�.
		DoubleStream doubleStream = new Random().doubles(3);
		
		// 3-7) *** ���ڿ� ��Ʈ�� ***
		// String�� �̿��ؼ� ��Ʈ���� ������ ���� ������, ������ �� ����(char)�� IntStream���� ��ȯ�� ����, char�� ���������� ���������� �����̱� ������ ����
		IntStream charStream = "Stream".chars(); // [83, 116, 114, 101, 97, 109]
		
		// ����ǥ�������� ���ڿ��� �ڸ��� �� ��� ��� ��Ʈ���� ���� ����
		Stream<String> stringStream = 
				  Pattern.compile(", ").splitAsStream("Eric, Elena, Java"); 
											// [Eric, Elena, Java]
		
		// 3-8) *** ���� ��Ʈ�� ***
		// �ڹ� NIO �� Files Ŭ������ lines �޼ҵ�� �ش� ������ �� ������ ��Ʈ�� Ÿ���� ��Ʈ������ ������ݴϴ�.
		Stream<String> lineStream = 
				  Files.lines(Paths.get("file.txt"), 
				              Charset.forName("UTF-8"));
		
		// 3-9) *** ���� ��Ʈ�� Parellel ��Ʈ�� ***
		// ���� ��Ʈ�� ����
		//Stream<Product> parallelStream = productList.parallelStream();

		// ���� ���� Ȯ��
		//boolean isParallel = parallelStream.isParallel();
		
//		// ���� �ڵ�� �� �۾��� �����带 �̿��� ���ķ� ó����
//		boolean isMany = parallelStream
//				  .map(product -> product.getAmount() * 10)
//				  .anyMatch(amount -> amount > 200);
		
		// �迭�� �̿��ؼ� ���� ��Ʈ�� ����, ���� ��Ʈ���� ������ �������� �ƴԿ� ����
		// Arrays.stream(arr).parallel();
		
		// �÷��ǰ� �迭�� �ƴ� ��� ������ ���� parallel �޼ҵ带 �̿��ؼ� ó��
		
		IntStream intParellelStream = IntStream.range(1, 150).parallel();
		boolean isParallel = intStream.isParallel();
		
		// �ٽ� ������ ���� �������� �̷���..
		intStream = intParellelStream.sequential();
		isParallel = intParellelStream.isParallel();
		
		
		// 3-10) Stream.concat
		// �ΰ��� ��Ʈ���� �����ؼ� �ϳ��� ��Ʈ���� ���� ���� �ִ�
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
