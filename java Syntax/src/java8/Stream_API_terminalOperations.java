package java8;

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
		
		// ================================================ 3. ���� �۾� ===================================================================
		
		// Calculating
		// Stream API�� �پ��� ���� �۾��� �����Ѵ�, �ּ�, �ִ�, ��, ��� �� �⺻�� Ÿ������ ����� ���� �� �ִ�.
		
		long count = IntStream.of(1, 3, 5, 7, 9).count();
		long sum = LongStream.of(1, 3, 5, 7, 9).sum();
		
		// �� ��Ʈ���� ��� �ִ°��, count�� sum�� 0�� ���,
		//   ������ ���, �ּ�, �ִ��� ��쿡�� ǥ���� �� ���� ������ Optional�� �̿��� �����Ѵ�.
		
		OptionalInt min = IntStream.of(1, 3, 5, 7, 9).min();
		OptionalInt max = IntStream.of(1, 3, 5, 7, 9).max();
		
		// ��Ʈ������ �ٷ� ifPresent �޼ҵ带 �̿��ؼ� Optional ó���� �� �� �ִ�.
		DoubleStream.of(1.1, 2.2, 3.3, 4.4, 5.5)
			.average()
			.ifPresent(System.out::println);
		
		
		
		// Reduction
		// ��Ʈ�� reduce ��� �޼ҵ带 �̿��ؼ� ����� ������.
		// reduce�� 3���� �Ķ���͸� �޴´�
		// accumulator : �� ��Ҹ� ó���ϴ� ��� ����. �� ��Ұ� �� ������ �߰� ����� �����ϴ� ����.
		// identity : ����� ���� �ʱⰪ���� ��Ʈ���� �� ����� ������ ������ �� ���� ����.
		// combiner : ����(parallel) ��Ʈ������ ���� ����� ����� �ϳ��� ��ġ�� �����ϴ� ����.
		
		// ���ڰ� 1�� (BinaryOperator<T> accumulator))�� �ִ� ���
		
		OptionalInt reduced = IntStream.range(1, 4)
				.reduce((a,b) -> {	// [1, 2, 3]
					return Integer.sum(a, b);
				});
		
		// ���ڰ� 2�� (T identity, BinaryOperator<T> accumulator)
		
		int reducedTwoParams = 
				IntStream.range(1, 4) // [1, 2, 3]
					.reduce(10, Integer::sum); // method reference
				// 10�� �ʱⰪ, ��Ʈ�� �� ���� ���ؼ� ����� 16 ( 10 + 1+ 2+ 3)
		
		// ���ڰ� 3�� (U identity,BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner) )
		
		Integer reducedParallel = Arrays.asList(1, 2, 3)
				  .parallelStream()
				  .reduce(10,
				          Integer::sum,
				          (a, b) -> {
				            System.out.println("combiner was called");
				            return a + b;
				          });
		// 3��° ������ Combiner�� ���� ó�� �� ���� �ٸ� �����忡�� ������ ����� �������� ��ġ�� �ܰ�,
		// ���Ľ�Ʈ�������� �����Ѵ�.
		
		
		
		
		// Collecting
		// collect() �� �� �ٸ� ���� �۾�
		// Collector Ÿ���� ���ڸ� �޾Ƽ� ó��, ���� ����ϴ� �۾��� Collectors ��ü���� ����.
		List<Product> productList = 
				  Arrays.asList(new Product(23, "potatoes"),
				                new Product(14, "orange"),
				                new Product(13, "lemon"),
				                new Product(23, "bread"),
				                new Product(13, "sugar"));
		
		// Collectors.toList()
		// ��Ʈ������ �۾��� ����� ���� List�� ��ȯ
		// ���� ������ map���� �� ����� �̸��� ������ ��, Collectors.toList�� �̿��ؼ� List�� ����� �����´�.
		
		List<String> collectorCollection =
				productList.stream()
					.map(Product::getName)
					.collect(Collectors.toList());
			// [potatoes, oragne, lemon, bread, sugar]
		
		
		// Collectors.joining()
		// ��Ʈ������ �۾��� ����� �ϳ��� String���� �̾� ���� �� �ִ�.
		
		String listToString = 
				productList.stream()
					.map(Product::getName)
					.collect(Collectors.joining());
			// potatoesorangelemonbreadsugar
		
		// Collectors.joining()�� 3���� ���ڸ� ���� �� �ִ�
		// delimiter : �� ��� �߰��� �� ��Ҹ� ���н����ִ� ������
		// prefix : ��� �� �տ� �ٴ� ����
		//suffix : ��� �� �ڿ� �ٴ� ����
		
		listToString =
				productList.stream()
					.map(Product::getName)
					.collect(Collectors.joining(", ", "<", ">"));
		    // <potatoes, orange, lemon, bread, sugar>
		
		
		// Collectors.averageingInt()
		
		// ���� ��(Integer value)�� ���(arithmetic mean)�� ���ϴ�.
		
		Double averageAmount = 
				productList.stream()
					.collect(Collectors.averagingInt(Product::getQuantity));
				// 17.2
		
		
		// Collectors.summingInt()
		
		// ���ڰ��� ��(sum)�� ����.
		
		Integer summingAmount =
				productList.stream()
					.collect(Collectors.summingInt(Product::getQuantity));
				// 86
		
		// IntStream ���� �ٲ��ִ� mapToInt �޼ҵ带 ����ؼ� �� �� �����ϰ� ǥ�� ����
		
		summingAmount =
				productList.stream()
					.mapToInt(Product::getQuantity)
					.sum();
		
		
		
		// Collectors.summarizingInt()
		// �հ�� ��� ��� ���� �� �ִ� ���
		// summarizingInt
		
		IntSummaryStatistics statistics =
				productList.stream()
					.collect(Collectors.summarizingInt(Product::getQuantity));
					
		// IntSummaryStatistics {count=5, sum=86, min=13, average=17.200000, max=23}
		
		
		
		
		// Collectors.groupingBy()
		// Ư�� �������� ��ҵ��� �׷����� �� �ִ�.
		// ������ �������� �׷����غ��ڴ�, ���⼭ �޴� ���ڴ� �Լ��� �������̽� Function
		
		Map<Integer, List<Product>> collectorMapOfLists =
				productList.stream()
					.collect(Collectors.groupingBy(Product::getQuantity));
		
		// ���
		//		{23=[Product{amount=23, name='potatoes'}, 
		//		     Product{amount=23, name='bread'}], 
		//		 13=[Product{amount=13, name='lemon'}, 
		//		     Product{amount=13, name='sugar'}], 
		//		 14=[Product{amount=14, name='orange'}]}
		
		
		// Collectors.partitioningBy()
		
		Map<Boolean, List<Product>> mapPartitioned=
				productList.stream()
					.collect(Collectors.partitioningBy(el -> el.getQuantity() > 15));
		// ���
		//		{false=[Product{amount=14, name='orange'}, 
		//		        Product{amount=13, name='lemon'}, 
		//		        Product{amount=13, name='sugar'}], 
		//		 true=[Product{amount=23, name='potatoes'}, 
		//		       Product{amount=23, name='bread'}]}
		
		
		// Collectors.collectingAndThen()
		
		// Ư�� Ÿ������ ����� collect�� ���Ŀ� �߰� �۾��� �ʿ��� ��� ���
		// Collections.toSet �� �̿��ؼ� ����� Set���� collect �� ��, ���� �Ұ��� Set���� ��ȯ�ϴ� �۾�
		Set<Product> unmodifiableSet = 
				 productList.stream()
				  .collect(Collectors.collectingAndThen(Collectors.toSet(),
				                                        Collections::unmodifiableSet));
		
		// Collector.of()
		
		// �� �ܿ� �ʿ��� ������ ������, ���� collector�� ���� ���� �ִ�.
		
		Collector<Product, ?, LinkedList<Product>> toLinkedList =
				Collector.of(LinkedList::new,
							 LinkedList::add,
							 (first, second) -> {
								 first.addAll(second);
								 return first;
							 });
		// Collector�� �ϳ� ����
		// supplier �� LinkedList�� ������, accumulator���� list�� �߰��ϴ� add()
		// ��Ʈ���� �� ��ҿ� LinkedList�� ����� ��Ҹ� �߰��ϰ� �ȴ�.
		// ���������� combiner�� �̿��� ����� �����ϴµ�, ������ ����Ʈ���� �ϳ��� ����Ʈ�� ��ġ�� �ִ�.
		
		// �ٶ� ������ ���� collect() �� �츮�� ���� Ŀ���� �����͸� �Ѱ��� �� �ְ�, ����� ��� LinkedList�� ��ȯ
		
		LinkedList<Product> linkedListOfPersons =
				productList.stream()
					.collect(toLinkedList);
		
		
		
		// Matching
		// ��Ī�� ���ǽ� ���� Predicate�� �޾Ƽ� �ش� ������ �����ϴ� ��Ұ� �ִ���, üũ�� ����� ����
		// ������ ���� �� ���� �޼ҵ尡 �ִ�
		/*
		1. �ϳ��� ������ �����ϴ� ��Ұ� �ִ���(anyMatch)
		2. ��� ������ �����ϴ���(allMatch)
		3. ��� ������ �������� �ʴ���(noneMatch)
		*/
		
		List<String> names = Arrays.asList("Eric", "Elena", "Java");
		
		boolean anyMatch = names.stream()
				.anyMatch(name -> name.contains("a"));
		boolean allMatch = names.stream()
				.allMatch(name -> name.length() > 3);
		boolean noneMatch = names.stream()
				.noneMatch(name -> name.endsWith("s"));
		
		
		// Iterating
		
		// foreach �� ��Ҹ� ���鼭 ����Ǵ� ���� �۾�
		// �ռ� ���캻 peek ���� �߰� �۾��� ���� �۾��� ���̰� �ִ�.
		
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
