package base.polymorphism;

public class Main {
    public static void main(String[] args) {

        int code = MyChildImplClass.CODE_INTERFACE;
        int cod2 = MyInterface.CODE_INTERFACE;

        // 추상 클래스는 생성자 구현이 되나 직접 생성은 불가능
        // MyAbstractClass abstractClass = new MyAbstractClass();
        MyAbstractClass abstractClass = new MyChildClass();

        MyInterface myInterface = new MyChildImplClass();


        System.out.println(abstractClass instanceof MyAbstractClass);
        System.out.println(myInterface instanceof MyInterface);

    }
}
