package base.polymorphism;

public abstract class MyAbstractClass {

    private int size = 0;
    public final int CODE_CLASS = 123;

    MyAbstractClass(int size) {
        this.size = size;
    }

    abstract void abstract_run();

    void not_abstract_run() {

    }
}
