package base;

public class equals_method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 
	      String s1 = new String("HELLO"); 
	      String s2 = new String("HELLO"); 
	      String s3 = s1; // ���� ����� ����Ų��.
	      String s4 = new String("WORLD"); 
	      /* --print-- */
	      
	      // equals()
	      System.out.println(s1.equals(s2)); // true
	      System.out.println(s1.equals(s3)); // true
	      System.out.println(s3.equals(s4)); // false
	      // �� ��ü�� ���� ������ Ȯ���Ѵ�.
	      // ��, ���ڿ��� ������/ �Ͽ��� ������� ���Ѵ� 
	      // �⺻ ����(Primitive Types)�� ���ؼ��� ������ �� ����
	      // ���� ��(����)�̸� true, �ٸ� �����̸� false�� ���� 
	      
	      // == ������
	      System.out.println(s1==s2); //false
	      System.out.println(s1==s3); //true
	      System.out.println(s1==s4); //false
	      // �� ��ü�� ���� �޸� ������ ����Ű���� Ȯ���Ѵ�.
	      // ���� �ּҸ� return true, �ٸ� �ּҸ� return false
	      // ��� �⺻ ����(Primitive Types)�� ���� ������ �� �ִ�
	}

}
