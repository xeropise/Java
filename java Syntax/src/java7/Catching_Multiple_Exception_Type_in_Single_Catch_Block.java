package java7;

public class Catching_Multiple_Exception_Type_in_Single_Catch_Block {

	public static void main(String[] args) {
        try{    
            int array[] = new int[10];    
            array[10] = 30/0;    
        }    
        catch(ArithmeticException | ArrayIndexOutOfBoundsException e){  
            System.out.println(e.getMessage());  
        }   
        
        // ���� catch ��Ͽ��� �������� ����ó��(Exception) ����
	}

}
