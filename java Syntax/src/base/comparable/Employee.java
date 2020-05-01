package base.comparable;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee implements Comparable<Employee> {
	
	private int id;
	private String name;
	private String department;
	private String position;
	private BigInteger sales;

	public Employee(int id, String name, String department, String position, BigInteger sales) {
		this.id = id;
		this.name = name;
		this.department = name;
		this.position = position;
		this.sales = sales;
	}
	@Override
	public int compareTo(Employee o) {
		return this.name.compareTo(o.name);
        //return this.id - o.id;
        //return this.department.compareTo(o.department);		
	}
	
	// compareTo() �� int Ÿ���� ��ȯ
	
	// �Ķ���ͷ� �� ����� �Ǵ� ��ü�� ������ ��
	
	// A.compareTo(B) �� ��, 
	// A<B �� ��� ���� ����,
	// A==B �� ���� 0 �� ����,
	// A>B �� �� ����� ����
	// ���Ŀ� �־ �տ� ���� ���� �� ������ �������� �ȴ�.
	// * �����ؾ��� ���� �ƹ� ����, �ƹ� ����� �������� �Ǵ°��� �ƴ϶�, ���������� -1, 0, 1 �� ����� ��
	@Override
	public String toString() {
		return String.format("id=%d, name=%s, department=%s, position=%s, sales=%d \n", this.getId(), this.getName(), this.getDepartment(), this.getPosition(), this.getSales());
	}	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public BigInteger getSales() {
		return sales;
	}
	public void setSales(BigInteger sales) {
		this.sales = sales;
	}
	

	public static void main(String[] args) {
		Employee employee1 = new Employee(1, "jdk", "�ַ�ǰ���1", "������", new BigInteger("2800"));
        Employee employee2 = new Employee(2, "jeong", "�ַ�ǰ���1", "���ӿ�����", new BigInteger("3200"));
        Employee employee3 = new Employee(3, "amateur", "�ַ�ǰ���2", "������", new BigInteger("2800"));
        Employee employee4 = new Employee(4, "pro", "�ַ�ǰ���2", "����������", new BigInteger("7000"));
        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        System.out.println(list);//���� �������
        Collections.sort(list);
        System.out.println("##########");
        System.out.println(list);//�̸� �������
        
        System.out.println("##########");
        
        // �͸��� Comparator�� ����
        Comparator<Employee> salesComparator = new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o2.getSales().intValue() - o1.getSales().intValue();
			}
        	
        };
        
        Collections.sort(list,salesComparator);
        System.out.println("#############sort###########");
        System.out.println(list); //Comparator sort
        
        
        // ���
        // Comparable�� �Ϲ����� ����
        // Comparator�� Ŀ���͸����� ���Ŀ� ���Ǿ�, �񱳰� �ƴ�
    }



}
