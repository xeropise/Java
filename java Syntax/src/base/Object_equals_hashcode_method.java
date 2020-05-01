package base;

public class Object_equals_hashcode_method {

	public static void main(String[] args) {
		
		// 1. Object�� ��
//		Object object1 = new Object();
//		Object object2 = new Object();
//		Object object3 = new Object();
//		Object object4 = new Object();
//		
//		System.out.println(object1.equals(object2));
//		System.out.println(object2.equals(object3));
//		System.out.println(object3.equals(object4));
//		System.out.println(object4.equals(object1));
//		
//		System.out.println("\n");
//		
//		System.out.println(object1.hashCode());
//		System.out.println(object2.hashCode());
//		System.out.println(object3.hashCode());
//		System.out.println(object4.hashCode());
		
		// 2. ��ü�� �� 
		Member member = new Member("���Ժ�",31);
		Member member2 = new Member("���Ժ�",31);
		
		System.out.println(member.equals(member2)); // false, ������ �� ��� true ����
		
		System.out.println("member 1�� "+member.hashCode());
		System.out.println("member 2�� "+member2.hashCode());
		
		//���� false ������ Member Ŭ���� Ư�� �� �ΰ��� ���ƾ� �Ѵ�
		// �� ���Ӱ� ������ Ŭ���������� �� ��ü�� ���� ��ü���� �ǹ��ϴ� equals �޼ҵ带 ������ �ؾ��� �ʿ伺
		
		// ������ �������Ͽ� equal true�� �������� hashCode�� �ٸ��ٴ� ���� �ٸ� ��ü��� ��Ⱑ �ȴ�.
		
		// hashcode() �������ϸ� true�� �Ѵ�
		
		// ���� ��� : equals()�� ���� true�� ������ �� ��ü�� hashCode�� ���ƾ� �Ѵ�.
	}
	
	
	
	
	public static class Member {
		
		private String name;
		private int age;
		
		
		public Member(String name, int age) {
			this.name = name;
			this.age = age;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public int getAge() {
			return age;
		}


		public void setAge(int age) {
			this.age = age;
		}


		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Member) {
				Member member = (Member) obj;
				return (age==member.age) && (name.equals(member.name));
			}else {
				return false;
			}
		}


		@Override
		public int hashCode() {
			return age + name.hashCode();
		}
		
		
	}
}

