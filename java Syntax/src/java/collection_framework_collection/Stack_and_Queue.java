package java.collection_framework_collection;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Stack_and_Queue {

	public static void main(String[] args) {
		
		// 1. Stack
		// �ڹٿ����� Vector�� Ȯ���� Ŭ����, List�� ���� Ŭ������
		// LIFO ( Last In First Out )
		Stack<Integer> stack = new Stack<>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		//System.out.println(stack);
		System.out.println("=== Stack ===");
		while(!stack.isEmpty()) {
			System.out.println( stack.pop() );
		}
		//System.out.println(stack);
		
		

		// 2. Queue
		// �ڹٿ����� �������̽�
		// FIFO ( First In First Out )
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		
		//System.out.println(queue);
		System.out.println("=== Queue ===");
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
			
		}
		
		
	}

}
