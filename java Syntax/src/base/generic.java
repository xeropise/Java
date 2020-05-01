package base;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class generic {

	public static void main(String[] args) {

		//�� ���׸�
		Corn corn = new Corn();
		
		corn.set("��");						// String -> Object (�ڵ� Ÿ�� ��ȯ)
		
		String name = (String) corn.get();  // Object -> String (���� Ÿ�� ��ȯ)
		//String
		
		// ���׸�
		Corn2<String> corn2 = new Corn2();

		corn2.set("��");
		
		String name2 = corn2.get();
		
		/*------------------------------------------------------*/
		
		
		// ��Ƽ Ÿ�� �Ķ����
		// ���׸� Ÿ���� �� �� �̻��� ��Ƽ �Ķ���͸� �̿��� �� �ִ�, �� ��� �� Ÿ�� �Ķ���ʹ� �޸��� �����Ѵ�.
		
		Entry<String, String> ent = new Entry("�Ժ�", "�� �����ΰ�");
		
		
		/*------------------------------------------------------*/
		
		// ���׸� �޼ҵ�
		
		String[] name3 = {"��ö��", "�迵��", "�����", "�踻��" };
		String[] last = generic.genericMethod(name3); // �����Ϸ��� �̹� Ÿ�� ������ �˰� ����
		
		/*------------------------------------------------------*/
		// ���ϵ� ī�� ? , Ÿ�� �Ķ���Ͱ� �ǹ̰� ���� �� ���
		// ���� ������ 
		List<? super Integer> foo3 = new ArrayList<>();
		
		// ���� ������
		List<? extends Integer> foo4 = new ArrayList<>();
	}
	
	
	// ���׸� Ÿ��(class, interface)
	// Ÿ���� �Ķ���ͷ� ������ Ŭ������ �������̽�
	// Ŭ���� �Ǵ� �������̽� �̸� �ڿ� "<>" ��ȣ�� �ٰ�, ���̿� Ÿ�� �Ķ���Ͱ� ��ġ�Ѵ�.
	public class Person<T> {}
	
	public interface interfacePerson<T> {}
	
	
	
	//�� ���׸� Ÿ�� �̿� ��
	
	static public class Corn {
		private Object obj;
		
		public Object get() { return obj; }
		
		public void set(Object obj) { this.obj = obj; }
	}
	
	// ���׸� Ÿ�� �̿��
	
	static public class Corn2<T> {
		
		private T t;
		
		public T get() {return t; }
		
		public void set(T t) {this.t = t; }
		
	}
	
/*------------------------------------------------------*/
	
	// ��Ƽ Ÿ�� �Ķ���� (class<K,V,...>, interface<K,V,...>)
	// ���׸� Ÿ���� �� �� �̻��� ��Ƽ �Ķ���͸� �̿��� �� �ִ�. �� ��� �� Ÿ�� �Ķ���ʹ� �޸��� �����Ѵ�.
	
	static public class Entry<K, V> implements Map.Entry<K, V> {
		
		private K key;
		
		private V value;
		
		public Entry(K key, V Value) {
			this.key = key;
			this.value = value;
		}
		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public V setValue(V value) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
/*------------------------------------------------------*/
	
	// ���׸� �޼ҵ� (<T,R> R method(T t))
	
	// ���׸� �޼ҵ�� �Ű�Ÿ�԰� ����Ÿ������ Ÿ���Ķ���͸� ���� �޼ҵ带 ���Ѵ�.
	
	// ���׸� �޼ҵ带 �����ϴ� ����� ���� Ÿ�� �տ� "<>" ��ȣ�� �߰��ϰ�, Ÿ�� �Ķ���͸� ����� ����,
	
	// ���� Ÿ�԰� �Ű� Ÿ������ Ÿ�� �Ķ���͸� ����ϸ� �ȴ�.
	
	public static <T> T genericMethod(T name3) {
		
		return name3;
		
	}
	
/*------------------------------------------------------*/
	
	// ������ Ÿ�� �Ű����� (Bounded Type Parameter)
	// ���� ����
	

	
}
