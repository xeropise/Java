package base.polymorphism;

public class MyChildClass extends MyAbstractClass {

    private int num = 30;
    MyChildClass() {
        super(30);
    }

    @Override
    void abstract_run() {
        System.out.println("MyChildClass test");
    }
}
