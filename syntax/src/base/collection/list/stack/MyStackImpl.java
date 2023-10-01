package base.collection.list.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStackImpl<T> implements MyStack<T> {

    private int DEFAULT_CAPACITY = 5;
    private Object[] EMPTY_ELEMENT = {};

    private int size;

    private Object[] element_data;

    public MyStackImpl() {
        this.size = 0;
        this.element_data = new Object[DEFAULT_CAPACITY];
    }

    private void resize() {
        int capacity = element_data.length;

        if (capacity == size) {
            int increasedCapacity = capacity * 2;

            element_data = Arrays.copyOf(element_data, increasedCapacity);
            return ;
        }

        int half_capacity = capacity / 2;

        if (half_capacity > size) {
            element_data = Arrays.copyOf(element_data, Math.max(half_capacity, DEFAULT_CAPACITY));
            return;
        }

        if (Arrays.equals(element_data, EMPTY_ELEMENT)) {
            element_data = new Object[DEFAULT_CAPACITY];
            return;
        }
    }

    @Override
    public void push(T object) {
        resize();

        element_data[size] = object;
        size++;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) element_data[size - 1];
    }

    @Override
    public T pop() {
        T returnValue = this.peek();

        element_data[size - 1] = null;

        size--;
        resize();

        return returnValue;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }
}
