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
		
		// 1. ����� ���� ������ �����ȴ�.
		// 2. ���� ����� �ߺ� ������ ����մϴ�.
		// 3. �Ѵ� Thread-safe ���� �����Ƿ�, �ʿ��ϴٸ� Collections.synchronizedList ��� ���
		// https://www.holaxprogramming.com/2014/02/12/java-list-interface/
/*
		// 1) ArrayList
		
		// �� ���������� �迭�� �̿��Ͽ�, ��Ҹ� �����մϴ�.
		// �� �迭�� ũ�⸦ ������ �� ���� �ν��Ͻ��̹Ƿ�, ũ�⸦ �ø��� ���ؼ��� ���ο� �迭�� �����ϰ� ���� ��ҵ��� �Űܾ��ϴ� ������ ������ ��Ĩ�ϴ�.
		// �� ���� �� ������ �ڵ����� ���������, ����� �߰� �� ���� �۾��� �ɸ��� �ð��� �ſ� ������� ������ ������ �˴ϴ�.
		// ����ȭ�� �������� ����, �������� �˻��� �����ϸ� �߰�, �������� ���� ���
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		
		arrList.add(40);
		arrList.add(30);
		arrList.add(20);
		arrList.add(10);
		
		// for ���� get() �޼ҵ带 �̿��� ����� ���
		for(int i=0; i<arrList.size(); i++) {
			System.out.println(arrList.get(i) + " ");
		}
		
		// remove() �޼ҵ带 �̿��� ����� ����
		arrList.remove(1);
		
		// Enhanced for ���� get() �޼ҵ带 �̿��� ����� ���

		for (int e : arrList) {

		    System.out.print(e + " ");

		}
		
		System.out.println("");
		
		// Collections.sort() �޼ҵ带 �̿��� ����� ����

		Collections.sort(arrList);

		// iterator() �޼ҵ�� get() �޼ҵ带 �̿��� ����� ���

		Iterator<Integer> iter = arrList.iterator();

		while (iter.hasNext()) {

		    System.out.print(iter.next() + " ");

		}
		
		System.out.println("");
		// set() �޼ҵ带 �̿��� ����� ����

		arrList.set(0, 20);

		System.out.println(arrList);

		// size() �޼ҵ带 �̿��� ����� �� ����

		System.out.println("����Ʈ�� ũ�� : " + arrList.size());
		
		*/
/*		
		// 2) LinkedList
		
		// https://m.blog.naver.com/PostView.nhn?blogId=highkrs&logNo=220443469613&proxyReferer=https%3A%2F%2Fwww.google.com%2F
		
		// �� ArrayList Ŭ������ �迭�� �̿��Ͽ�, ��Ҹ� ���������ν� �߻��ϴ� ������ �غ��ϱ� ���� ��ȵǾ����ϴ�.
		// ArrayList�� ���� �������� �߰�, ������ �����ϸ� ������ �˻� �ÿ��� ������ ���
		
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
		
		// legacy Ŭ���� : Collections �����ӿ�ũ�� ���ԵǾ� ���� �ʴ�, �ʱ� �ڹ� �������� ������ �������̽�
		// ����� �籸�� �� ����Ǿ ������ Collections �����ӿ�ũ�� �Ϻ��ϰ� ȣȯ�˴ϴ�
		
		// ArrayList�� �޸� Vector�� ����ȭ�� ����, Thread-safe
		// �� ����ȭ�Ǿ� ���� ���� ArrayList���ٴ� ���� �� ����
		// ��Ƽ������ ȯ���� �ƴ� ���, ArrayList�� ����ϴ� ���� �ٶ��� �ϴ�
		
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
