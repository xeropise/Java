package base.collection.array_list;

import javax.swing.text.Element;
import java.util.Arrays;

public class MyPracticeArrayList<E> implements MyList<E> {

    private static final int DEFAULT_CAPACITY = 5;
    private static Object[] EMPTY_ELEMENTDATA = {};

    private int size;
    Object[] elementData;

    public MyPracticeArrayList() {
        this.size = 0;
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyPracticeArrayList(int capacity) {
        if (capacity > 0) {
            elementData = new Object[capacity];
        }

        else if (capacity == 0) {
            elementData = new Object[DEFAULT_CAPACITY];
        }

        else if (capacity < 0) {
            throw new RuntimeException(new IllegalAccessException("wrong capacity"));
        }

        this.size = 0;
    }

    private void resize() {
        int capacity = elementData.length;

        if (capacity == size) {
            elementData = Arrays.copyOf(elementData, capacity * 2);
            return;
        }

        if ((capacity / 2) > size) {
            int half_capacity = capacity / 2;
            elementData = Arrays.copyOf(elementData, Math.max(half_capacity , DEFAULT_CAPACITY));
            return;
        }

        if (Arrays.equals(elementData, EMPTY_ELEMENTDATA)) {
            elementData = new Object[DEFAULT_CAPACITY];
            return;
        }
    }

    @Override
    public boolean add(E value) {
        resize();

        elementData[size] = value;
        size++;
        return true;
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index <= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == size) {
            add(value);
        }

        else {
            resize();

            for (int i = size; i > index; i--) {
                elementData[i] = elementData[i-1];
            }

            elementData[index] = value;
            size++;
        }
    }

    @Override
    public boolean remove(Object value) {
        int index = indexOf(value);

        if (index == -1) return false;

        remove(index);

        return true;
    }

    @Override
    public E remove(int index) {
        // 인덱스가 음수이거나, size 보다 크거나 같을 경우 빈 공간
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        E element = (E)elementData[index];
        elementData[index] = null;

        for (int i = index; i < (size - 1); i++) {
            elementData[i] = elementData[i + 1];
            elementData[i + 1] = null;
        }

        size--;

        resize();

        return null;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return (E) elementData[index];
    }

    @Override
    public void set(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        elementData[index] = value;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) >= 0 ? true : false;
    }

    @Override
    public int indexOf(Object value) {
        if (value == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elementData[i].equals(value)) {
                    return i;
                }
            }
        }
        return -1 ;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = (size-1); i >= 0; i--) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = (size-1); i >= 0; i--) {
                if (elementData[i].equals(o)) {
                    return i;
                }
            }
        }

        return -1 ;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        elementData = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}
