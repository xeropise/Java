package java.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

public class serial_ization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		// ����ȭ ����
		/*
		Member member = new Member("����", "deliverkim@baemin.com", 25);
		byte[] serializedMember;
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
				oos.writeObject(member);
				// serializedMember - > ����ȭ�� member ��ü
				serializedMember = baos.toByteArray();
			}
		}
		
		// ����Ʈ �迭�� ������ ����ȭ �����͸� base64�� ��ȯ
		System.out.println(Base64.getEncoder().encodeToString(serializedMember));
		
		// ��ü�� ����ȭ�Ͽ�, ����Ʈ �迭(byte []) ���·� ��ȯ
		 * 
		 */
		
		// ����ȭ �������� ������ base64 ������
		String base64Member = "...����";
		byte[] serializedMember = Base64.getDecoder().decode(base64Member);
		try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember)) {
			try (ObjectInputStream ois = new ObjectInputStream(bais)) {
				// ������ȭ�� Member ��ü�� �о�´�.
				Object objectMember = ois.readObject();
				Member member = (Member) objectMember;
				System.out.println(member);;
			}
		}
		
		// �ڹ��� ����ȭ �� ����ұ�?
		
		//CSV
		// �����͸� ǥ���ϴ� ���� ���� ���Ǵ� ��� �� �ϳ��� �޸�(,)�� �������� ������ ����
		Member member = new Member("����", "deliverykim@baemin.com", 25 );
		// member ��ü�� csv�� ��ȯ
		String csv = String.format("%s,%s,%d",member.getName(), member.getEmail(), member.getAge()); 
		System.out.println(csv);
		
		//JSON
		// �ֱٿ� ���� ���� ����ϴ� ����, �ڹٽ�ũ��Ʈ(ECMAScript)���� ���� ��밡��, �ٸ� ������ ���� ��Ŀ� ���� ������尡 ���� �αⰡ ����.
		  // member��ü�� json���� ��ȯ 
		  String json = String.format(
		          "{\"name\":\"%s\",\"email\":\"%s\",\"age\":%d}",
		          member.getName(), member.getEmail(), member.getAge());
		  System.out.println(json);    
		  
		// Protocol Buffer, Apache Avro ���� �ִ�.
		  
		// " �ڹ� ����ȭ ������ ������ ��ȯ�� �ڹ� �ý��� ���� ������ ��ȯ�� ���ؼ� ���� "
		  
		// " �ڹٿ����� CSV,JSON�� ����ϸ�Ǵµ� �ڹ� ����ȭ�� �ֽ�ߵǳ���? "
		  
		// => ������ ���� ������ ����� ��
		  
		/*
		 * - �ڹ� ����ȭ�� ����
		 *  1) �ڹ� �ý��� ���߿� ����ȭ �Ǿ� �ִ�.
		 *  2) ������ �����ͱ����� Ŭ������ ��ü�� ����ȭ �⺻ ���Ǹ� ��Ű�� ū �۾� ���� �ٷ� ����ȭ �����ϴ�, ������ȭ�� ��������
		 *  3) ������ Ÿ���� �ڵ����� �������� ������, ���� �κ��� ū �Ű��� ���� �ʾƵ� �ȴ�.
		 * 
		 * - �ڹ� ����ȭ�� ���� ��� ���ǳ���?
		 *  1) JVM �޸𸮿����� ���ֵǾ� �ִ� ��ü �����͸� �״�� ����ȭ(Persistence)�� �ʿ��� �� ���
		 *  2) �ý����� ����Ǵ��� �������� �ʴ� ����, ����ȭ�� �������̱� ������ ��Ʈ��ũ�ε� ���� ����
		 *  3) �ʿ��� �� ����ȭ�� ��ü �����͸� �����ͼ�, ������ȭ�Ͽ� ��ü�� �ٷ� ����� �� �ְ� �ȴ�.
		 *  
		 *  *����ϴ� ��
		 *  - ���� ���� ( Servlet Session )
		 *  - ĳ�� ( Cache )
		 *  - �ڹ� RMI( Remote Method Invocation )
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
