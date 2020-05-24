package base;

public class call_by_value_and_call_by_reference {
    
	public static void main(String[] args) {
		
		// Call By Value�� '���� ���� ȣ��'
		// �޼ҵ�� ���ڰ��� �ѱ� �� �� ���� �����Ͽ� �ѱ�� ����
		// �� ������� �޼ҵ� ȣ���� �ϸ� �޼ҵ� �������� ����� ������ �۾��� �ϱ� ������
		// ������ ���� �����Ű�� �ʴ´�.
		
		// 1. ���� ���� �⺻���� ��� ���� ��
//		int num1= 10, num2 = 20;
//		
//		System.out.println("Before");
//		System.out.println("num1 = " + num1);
//		System.out.println("num2 = " + num2);
//		swap1(num1, num2);
//		System.out.println("After");
//		System.out.println("num1 = " + num1);
//		System.out.println("num2 = " + num2);
		
		// ��� : �ڹٴ� �⺻�� �����͸� ó���� �� Call By Value �������� ó���Ѵ�.
		
		// 2. ���� ������ ��ü�� ������� ��(wrapper Ŭ���� ���), ���� Call By reference �ϱ�?
		
//		Integer num1 = 10, num2 = 20;
//		// Integer num1 = new Integer(10), num2 = new Integer(20)
//		// �� ����
//		System.out.println("Before");
//		System.out.println("num1 = " + num1);
//		System.out.println("num2 = " + num2);
//		swap2(num1, num2);
//		System.out.println("After");
//		System.out.println("num1 = " + num1);
//		System.out.println("num2 = " + num2);
		
		// ��ü��  swap�� ���� �ٲپ����� call By reference��� �ٲ����ߴµ� �ٲ��� �ʾҴ�
		// ��� : ��ü ���� �޼ҵ�� ���� ���� �� ��, �� �������� Call By Value�� ���·� ���޵ȴ�.
		
		// 3. ���ڰ����� ���� �������� ���� ��� ������ ����
		
//		NumberClass num3 = new NumberClass(10);
//		NumberClass num4 = new NumberClass(20);
//		
//		System.out.println("Before");
//		System.out.println("num3 = " + num3.num);
//		System.out.println("num4 = " + num4.num);
//		swapFinal(num3,num4);
//		System.out.println("After");
//		System.out.println("num3 = " + num3.num);
//		System.out.println("num4 = " + num4.num);
		
		// ��ü�� �������� ���� �ٲ� ���� �ƴ϶�, ��ü�� �������� ���ؼ� 
		// �� ��ü�� ��������� �����Ͽ� �� ���� �ٲ���
		
		// �ڹٴ� ��ü�� �޼ҵ�� �ѱ� ��, ��ü�� �����ϴ�  ���������� ���� �ּҸ� �ѱ�� ���� �ƴ϶�, 
		// �� ���������� ����Ű�� �ִ� �� ������ ��ü�� ����Ű�� ������ ���ο� ���������� �����Ͽ�,
		// �װ��� ���Ͽ� ���� ��ü�� ����Ű���� �ϴ� ���
		
		// ���� ��� �ڹ��� �޼ҵ�� ���� ���� �ѱ�� ����� Call By Value�̴�
		
		// 4. String���� Swap ����
		
		String a = "10";
		String b = "20";
		System.out.println("Before");
		System.out.println("String a = " + a);
		System.out.println("String b = " + b);
		swapString(a,b);
		System.out.println("After");
		System.out.println("String a = " + a);
		System.out.println("String b = " + b);
	}
	
	// �ڸ� �ٲٱ� �޼ҵ�
	
	static void swap1(int num1, int num2) {
		int temp;
		
		temp = num2;
		num1 = temp;
		num2 = num1;
	}
	static void swap2(Integer num1, Integer num2) {
		Integer temp;	//�ӽ� ����
		
		// �ڸ� �ٲٱ�
		temp = num1;
		num1 = num2;
		num2 = temp;
	}
	
	// �ڸ� �ٲٱ� �޼ҵ�
	static void swapFinal(NumberClass one, NumberClass two) {
		
		int temp = one.num;
		
		one.setNum(two.num);
		
		two.setNum(temp);
	}
	
	static void swapString(String a, String b) {
		String temp; // �ӽ� ����
		
		// �ڸ� �ٲٱ�
		
		temp = a; 
		a = b;
		b= temp;
		
	}
	
	static class NumberClass {
		int num;
		
		public NumberClass(int num) {
			this.num = num;
		}
		
		public void setNum(int num) {
			this.num = num;
		}
	}

}
