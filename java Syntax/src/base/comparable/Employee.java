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
	
	// compareTo() 는 int 타입을 반환
	
	// 파라미터로 비교 대상이 되는 객체가 들어오게 됨
	
	// A.compareTo(B) 일 때, 
	// A<B 인 경우 음수 리턴,
	// A==B 일 때는 0 을 리턴,
	// A>B 일 때 양수를 리턴
	// 정렬에 있어서 앞에 오고 싶을 때 음수를 내보내면 된다.
	// * 주의해야할 점은 아무 음수, 아무 양수를 내보내면 되는것이 아니라, 마찬가지로 -1, 0, 1 만 사용할 것
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
		Employee employee1 = new Employee(1, "jdk", "솔루션개발1", "연구원", new BigInteger("2800"));
        Employee employee2 = new Employee(2, "jeong", "솔루션개발1", "선임연구원", new BigInteger("3200"));
        Employee employee3 = new Employee(3, "amateur", "솔루션개발2", "연구원", new BigInteger("2800"));
        Employee employee4 = new Employee(4, "pro", "솔루션개발2", "수석연구원", new BigInteger("7000"));
        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        System.out.println(list);//넣은 순서대로
        Collections.sort(list);
        System.out.println("##########");
        System.out.println(list);//이름 순서대로
        
        System.out.println("##########");
        
        // 익명의 Comparator를 만듦
        Comparator<Employee> salesComparator = new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o2.getSales().intValue() - o1.getSales().intValue();
			}
        	
        };
        
        Collections.sort(list,salesComparator);
        System.out.println("#############sort###########");
        System.out.println(list); //Comparator sort
        
        
        // 결론
        // Comparable은 일반적인 정렬
        // Comparator는 커스터마이즈 정렬에 사용되어, 비교가 아님
    }



}
