package base.collection.array_list;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {

    private static final int DEFAULT_CAPACITY = 5; // 생성자로 배열이 생성될 때 기본 용량
    private static final Object[] EMPTY_ELEMENTDATA = {}; // 빈 배열

    private int size; // elementData 배열의 총 개수를 나타내는 변수
    Object[] elementData; // 자료를 담을 배열

    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public MyArrayList(int capacity) {

        if (capacity > 0) {
            this.elementData = new Object[capacity];
        }

        else if (capacity == 0) {
            this.elementData = new Object[DEFAULT_CAPACITY];
        }

        else if (capacity < 0) {
            throw new RuntimeException(new IllegalAccessException("wrong list capacity"));
        }

        this.size = 0;
    }

    // 내부 배열의 크기를 동적으로 조절하는 메소드
    private void resize() {
        int element_capacity = elementData.length;

        // 용량이 꽉찬 경우
        if (element_capacity == size) {
            int new_capacity = element_capacity * 2;

            elementData = Arrays.copyOf(elementData, new_capacity);
            return;
        }

        // 용량에 비해 데이터의 양이 적은 경우
        if ((element_capacity / 2) > size) {
            int half_capacity = element_capacity / 2;

            elementData = Arrays.copyOf(elementData, Math.max(half_capacity, DEFAULT_CAPACITY));
            return;
        }

        // 들어있는 데이터가 하나도 없을 경우 (빈 배열)
        if (Arrays.equals(elementData, EMPTY_ELEMENTDATA)) {
            elementData = new Object[DEFAULT_CAPACITY];
            return;
        }
    }


    @Override
    public boolean add(E value) {
        resize(); // 현재 배열이 꽉 차있는 상태이면 리사이징

        elementData[size] = value; // size가 원소의 갯수이고, 배열의 인덱스는 0부터 시작하니 결국 추가할 수 있는 마지막 위치를 가리키게 된다.
        size++; // 원소가 추가되었으니, 배열 크기를 나타내는 size도 올린다.

        return true;
    }

    @Override
    public void add(int index, E value) {
        // 인덱스가 음수이거나, 배열 크기를 벗어난 경우 예외 발생 (리스트는 데이터가 연속되어야 한다.)
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        // 인덱스가 마지막 위치일 경우,
        if (index == size) {
            add(value);
        }

        // 인덱스가 중간 위치를 가리킬 경우
        else {
            resize(); // 현재 배열이 꽉 차있는 상태이면 리사이징

            // 루프변수에 배열 크기를 넣고, index 위치 까지 순회해서 요소들 한 칸 씩 뒤로 밀어 빈 공간 만들기
            for (int i = size; i > index; i--) {
                elementData[i] = elementData[i - 1];
            }

            elementData[index] = value;
            size++;
        }
    }

    @Override
    public boolean remove(Object value) {
        // 해당 요소가 몇번쨰 위치에 존재 하는지 인덱스를 가져온다.
        int index = indexOf(value);

        // 없으면 종료
        if (index == -1) return false;

        // 인덱스가 있으면 remove로 넘겨 삭제한다.
        remove(index);

        return true;
    }

    @Override
    public E remove(int index) {
        // 인덱스가 음수이거나, size 보다 크거나 같을 경우 빈 공간
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        // 반환한 값 백업
        E element = (E) elementData[index];

        // 요소 제거 (명시적으로 요소를 null 로 처리해주어야 GC가 수거해감)
        elementData[index] = null;

        // 배열 요소 이동
        for (int i = index; i < (size -1); i++) {
            elementData[i] = elementData[i+1];
            elementData[i + 1] = null;
        }

        // 요소를 제거했으니 size 감소
        size--;

        // 리사이징
        resize();

        // 백업한 요소 반환
        return element;
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
        // 매개변수가 null 일경우 (null 비교는 동등연산자로 행하기 때문에 비교 로직을 분리)
        if (value == null) {
            for (int i = 0; i< size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        }

        // 매개변수가 실질적인 값인 경우
        else {
            for (int i = 0; i < size; i++) {
                if (elementData[i].equals(value)) {
                    return i;
                }
            }
        }

        return -1; // 값이 없을 경우
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = (size - 1); i >= 0; i--) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        }

        else {
            for (int i = (size - 1); i >= 0; i--) {
                if (elementData[i].equals(o)) {
                    return i;
                }
            }
        }

        return -1;
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
