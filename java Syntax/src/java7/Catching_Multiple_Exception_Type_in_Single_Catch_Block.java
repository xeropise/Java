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

        // 단일 catch 블록에서 여러개의 예외처리(Exception) 가능
    }

}
