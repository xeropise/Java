package base;

public class equals_method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		String s1 = new String("HELLO");
		String s2 = new String("HELLO");
		String s3 = s1; // 같은 대상을 가리킨다.
		String s4 = new String("WORLD");
		/* --print-- */

		// equals()
		System.out.println(s1.equals(s2)); // true
		System.out.println(s1.equals(s3)); // true
		System.out.println(s3.equals(s4)); // false
		// 두 객체의 값이 같은지 확인한다.
		// 즉, 문자열의 데이터/ 니용을 기반으로 비교한다
		// 기본 유형(Primitive Types)에 대해서는 적용할 수 없다
		// 같은 값(내용)이면 true, 다른 내용이면 false를 리턴

		// == 연산자
		System.out.println(s1==s2); //false
		System.out.println(s1==s3); //true
		System.out.println(s1==s4); //false
		// 두 객체가 같은 메모리 공간을 가리키는지 확인한다.
		// 같은 주소면 return true, 다른 주소면 return false
		// 모든 기본 유형(Primitive Types)에 대해 적용할 수 있다
	}

}
