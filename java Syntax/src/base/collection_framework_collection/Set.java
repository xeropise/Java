package base.collection_framework_collection;

import java.util.HashSet;
import java.util.TreeSet;

public class Set {
	
	public static void main(String args[]) {
/*
 * 		 1. HashSet
 * 		
		//������ ���� ���� �ʴ� �������� ����, ������ �����Ϸ��� LinkedHashSet
		//�������� �ߺ��� ������� �ʴ´�
		//���������� �ؽ��� �̿��ؼ� ������ �÷���
		
		Set<Integer> set = new HashSet<>();
		Set<String> set2 = new HashSet<>();
		int[] valArr = {99,120,12, 1, 2, 2, 10, 3, 3, 5, 6, 10};
		
		for(int i=0; i< valArr.length; i++) {
			set.add(valArr[i]);
		}
		
		System.out.println(set);
		System.out.println();
		
		String[] valArr2 = {"��", "��", "��", "��", "��", "��", "��", "��", "��", "��"};
		
		for (int i=0; i<valArr2.length; i++) {
			set2.add(valArr2[i]);
		}
		
		System.out.println(set2);
		
*/
		//2. TreeSet
		
		TreeSet<Integer> set2 = new TreeSet<>();
		
		set2.add(1);
		set2.add(2);
		set2.add(3);
		set2.add(4);
		
		System.out.println( set2.first() );
		
		System.out.println( set2.subSet(1, 3));
		
/*	
		1. ���� ���

		 - HashSet�� �ؽ��� �̿��Ͽ� ����
		 - TreeSet�� ����Ž��Ʈ���� �̿��Ͽ� ����

		2. �ӵ� ��
		 - HashSet > TreeSet
		 - �ؽ��� ����Ž��Ʈ������ ������

		3. ���� ���
		 - HashSet < TreeSet
		 - ����Ž��Ʈ���� �̿��߱� ������ ������ ������ ���� (Comparator �̿�)

*/
	}
}
