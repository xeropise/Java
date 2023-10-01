package base.collection.list.stack;

public interface MyStack<T> {
    void push(T object);

    T peek();

    T pop();

    boolean isEmpty();
}
