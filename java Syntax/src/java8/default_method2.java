package java8;
import java8.default_method.Calculator;

//Calculator�������̽��� ������ MyCalculatorŬ����
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

            int value2 = Calculator.exec2(5, 10);  //static�޼ҵ� ȣ�� 
            System.out.println(value2);
        }
        
        //�������̽��� ������ �Ǹ�, �������̽��� �����ϴ� ��� Ŭ�������� �ش� �޼ҵ带 �����ؾ� �ϴ� ������ �ִ�. 
        //�̷� ������ �ذ��ϱ� ���Ͽ� �������̽��� �޼ҵ带 ������ ���� �� �ֵ��� �Ͽ���.
    }