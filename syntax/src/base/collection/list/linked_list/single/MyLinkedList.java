package base.collection.list.linked_list.single;

public interface MyLinkedList <E>{

    void addFirst(E object);

    void addLast(E object);

    void add(int index, E value);

    boolean add(E value);

    boolean remove(E value);

    E removeFirst();

    E removeLast();

    E remove(int index);

    E get(int index);

    void set(int index, E value);
}
