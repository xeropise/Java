package base.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

public class serial_ization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		// 직렬화 예졔
		/*
		Member member = new Member("김배민", "deliverkim@baemin.com", 25);
		byte[] serializedMember;
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
				oos.writeObject(member);
				// serializedMember - > 직렬화된 member 객체
				serializedMember = baos.toByteArray();
			}
		}

		// 바이트 배열로 생성된 직렬화 데이터를 base64로 변환
		System.out.println(Base64.getEncoder().encodeToString(serializedMember));

		// 객체를 직렬화하여, 바이트 배열(byte []) 형태로 변환
		 *
		 */

		// 직렬화 예제에서 생성된 base64 데이터
		String base64Member = "...생략";
		byte[] serializedMember = Base64.getDecoder().decode(base64Member);
		try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember)) {
			try (ObjectInputStream ois = new ObjectInputStream(bais)) {
				// 역직렬화된 Member 객체를 읽어온다.
				Object objectMember = ois.readObject();
				Member member = (Member) objectMember;
				System.out.println(member);;
			}
		}

		// 자바의 직렬화 왜 사용할까?

		//CSV
		// 데이터를 표현하는 가장 많이 사용되는 방법 중 하나로 콤마(,)를 기준으로 데이터 구분
		Member member = new Member("김배민", "deliverykim@baemin.com", 25 );
		// member 객체를 csv로 변환
		String csv = String.format("%s,%s,%d",member.getName(), member.getEmail(), member.getAge());
		System.out.println(csv);

		//JSON
		// 최근에 가장 많이 사용하는 포맷, 자바스크립트(ECMAScript)에서 쉽게 사용가능, 다른 데이터 포맷 방식에 비해 오버헤드가 적어 인기가 많다.
		// member객체를 json으로 변환
		String json = String.format(
				"{\"name\":\"%s\",\"email\":\"%s\",\"age\":%d}",
				member.getName(), member.getEmail(), member.getAge());
		System.out.println(json);

		// Protocol Buffer, Apache Avro 등이 있다.

		// " 자바 직렬화 형태의 데이터 교환은 자바 시스템 간의 데이터 교환을 위해서 존재 "

		// " 자바에서도 CSV,JSON을 사용하면되는데 자바 직렬화를 왜써야되나요? "

		// => 목적에 따라 적절히 사용할 것

		/*
		 * - 자바 직렬화의 장점
		 *  1) 자바 시스템 개발에 최적화 되어 있다.
		 *  2) 복잡한 데이터구조의 클래스의 객체라도 직렬화 기본 조건만 지키면 큰 작업 없이 바로 직렬화 가능하다, 역직렬화도 마찬가지
		 *  3) 데이터 타입이 자동으로 맞춰지기 때문에, 관련 부분을 큰 신경을 쓰지 않아도 된다.
		 *
		 * - 자바 직렬화는 언제 어디서 사용되나요?
		 *  1) JVM 메모리에서만 상주되어 있는 객체 데이터를 그대로 영속화(Persistence)가 필요할 때 사용
		 *  2) 시스템이 종료되더라도 없어지지 않는 장점, 영속화된 데이터이기 때문에 네트워크로도 전송 가능
		 *  3) 필요할 때 직렬화된 객체 데이터를 가져와서, 역직렬화하여 객체를 바로 사용할 수 있게 된다.
		 *
		 *  *사용하는 곳
		 *  - 서블릿 세션 ( Servlet Session )
		 *  - 캐시 ( Cache )
		 *  - 자바 RMI( Remote Method Invocation )
		 */
	}


	public static class Member implements Serializable {

		private String name;
		private String email;
		private int age;

		public Member(String name, String email, int age) {
			this.name = name;
			this.email = email;
			this.age = age;

		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return String.format("Member{name='%s', email='%s', age='%s'}", name, email, age);
		}


	}
}
