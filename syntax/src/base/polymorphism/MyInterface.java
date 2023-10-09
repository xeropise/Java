package base.polymorphism;

public interface MyInterface {

    default String default_test() {
        return "test";
    }

    public static final int CODE_INTERFACE = 123;
    void run();


}
