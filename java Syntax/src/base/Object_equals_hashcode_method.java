package base;

public class Object_equals_hashcode_method {

	public static void main(String[] args) {
		
		// 1. Object로 비교
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
		
		// 2. 객체로 비교 
		Member member = new Member("조규비",31);
		Member member2 = new Member("조규비",31);
		
		System.out.println(member.equals(member2)); // false, 재정의 할 경우 true 리턴
		
		System.out.println("member 1의 "+member.hashCode());
		System.out.println("member 2의 "+member2.hashCode());
		
		//답은 false 이지만 Member 클래스 특성 상 두개는 같아야 한다
		// 즉 새롭게 정의한 클래스에서는 두 객체가 같은 객체임을 의미하는 equals 메소드를 재정의 해야할 필요성
		
		// 하지만 재정의하여 equal true를 얻어냈으나 hashCode가 다르다는 것은 다른 객체라는 얘기가 된다.
		
		// hashcode() 재정의하면 true로 한다
		
		// 최종 결론 : equals()에 의해 true가 나오는 두 객체의 hashCode는 같아야 한다.
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

