package base.reflection;

import java.lang.reflect.Method;

public class reflect {

	public static void main(String[] args) throws ClassNotFoundException {
		/*
		// 리플렉션(Reflection) 사용을 위한 Set up
		
		// ** 자바 기본형에 대한 클래스 정보를 얻는 방법 **
			// 다양한 방법으로 클래스 정보를 얻는다
		// 1)
		//	Class c = Class.forName("java.lang.String");
		
		// 2) 
		// 	Class c = int.class;
		
		// 3) 기본형의 경우 Wrapper에 기정의 된 Type을 사용 한다.
		//	Class c = Integer.TYPE; 	

		// 후 getDeclaredMethods와 같은 메소드를 호출 해서, 클래스에 정의된 모든 메소드의 리스트를 읽는다.
		
			Class c = Class.forName("java.lang.String");
			Method m[] = c.getDeclaredMethods();
			
			for(Method a : m) {
				System.out.println(a);
			}
		// 마지막으로 정보 수정을 위해 Reflection API를 이용한다.
		 * 
		 * 
		 */


	}

}
