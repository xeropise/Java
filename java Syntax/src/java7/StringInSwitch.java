package java7;

public class StringInSwitch {

	public static void main(String[] args) {
		
		StringInSwitch test = new StringInSwitch();
		test.withSwitching("sam");

	}
	
	public void withSwitching(String str) {
		
		switch(str) {
		case "bob":
			System.out.println("��");
			break;
		case "sam":
			System.out.println("��");
			break;
		case "carl":
			System.out.println("Į");
			break;
		}
	}

}
