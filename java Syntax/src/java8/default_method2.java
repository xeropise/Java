package java8;
import java8.default_method.Calculator;

//Calculator인터페이스를 구현한 MyCalculator클래스
    public class default_method2 implements Calculator {

        @Override
        public int plus(int i, int j) {
            return i + j;
        }

        @Override
        public int multiple(int i, int j) {
            return i * j;
        }
    

        public static void main(String[] args){
            Calculator cal = new default_method2();
            int value = cal.exec(5, 10);
            System.out.println(value);

            int value2 = Calculator.exec2(5, 10);  //static메소드 호출 
            System.out.println(value2);
        }
        
        //인터페이스가 변경이 되면, 인터페이스를 구현하는 모든 클래스들이 해당 메소드를 구현해야 하는 문제가 있다. 
        //이런 문제를 해결하기 위하여 인터페이스에 메소드를 구현해 놓을 수 있도록 하였다.
    }