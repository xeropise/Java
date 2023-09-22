package base.collection.list.linked_list.single;

import java.util.Objects;

class PracticeLinkedList <E> {
    private Node<E> head;
    private Node<E> tail;


    private int size;

    private Node<E> search(int index) {
        Node<E> node = head;

        for (int i = 0; i < index; i++) {
            node = head.next;
        }

        return node;
    }

    public void addFirst(E value) {
        Node<E> oldHead = head;

        Node<E> new_Node = new Node(value, oldHead);

        size++;

        head = new_Node;

        // 최초
        if (oldHead == null) {
            tail = new_Node;
        }
    }

    public void addLast(E value) {
        Node<E> oldTail = tail;

        Node<E> new_Node = new Node<>(value, null);

        size++;

        tail = new_Node;

        // 최초 인 경우
        if (oldTail == null) {
            head = new_Node;

        // 기존 oldTail과 새 노드를 이어 준다.
        } else {
            oldTail.next = new_Node;
        }
    }

    public boolean add(E value) {
        addLast(value);
        return false;
    }

    public void add(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(value);
            return;
        }

        if (index == size - 1) {
            addLast(value);
            return;
        }

        Node<E> prev_node = search(index - 1);
        Node<E> next_node = prev_node.next;

        Node<E> new_Node = new Node<>(value, next_node);

        size++;

        prev_node.next = new_Node;


    }

    public E removeFirst() {

        if (head == null) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> oldHead = head;

        E returnedValue = oldHead.item;

        Node<E> nextNode = oldHead.next;

        head.next = null;
        head.item = null;

        head = nextNode;

        size--;

        if (head == null) {
            tail = null;
        }

        return returnedValue;
    }

    public E remove() {

        return removeFirst();
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return removeFirst();
        }

        Node<E> prev_node = search(index - 1);

        Node<E> del_node = prev_node.next;

        Node<E> next_node = del_node.next;

        E returnValue = del_node.item;;

        del_node.next = null;
        del_node.item = null;

        size--;

        prev_node.next = next_node;

        return returnValue;
    }

    public boolean remove(Object value) {
        if (head == null) {
            throw new RuntimeException();
        }

        Node<E> prev_node = null;
        Node<E> del_node = null;
        Node<E> next_node = null;

        Node<E> i = head;

        while (i != null) {
            if (Objects.equals(i.item, value)) {
                del_node = i;
                break;
            }

            prev_node = i;

            i = i.next;
        }

        if (del_node == null) {
            return false;
        }

        if (del_node == head) {
            removeFirst();
            return true;
        }


        next_node = del_node.next;


        del_node.next = null;
        del_node.item = null;

        size--;

        prev_node.next = next_node;

        return true;
    }

    public E removeLast() {

        return remove(size - 1);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return search(index).item;
    }

    public void set(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        // 1. search 메소드를 이용해 교체할 노드를 얻는다.
        Node<E> replace_node = search(index);

        // 2. 교체할 노드의 요소를 변경한다.
        replace_node.item = value;
    }




    private static class Node<E> {
        private E item;
        private Node<E> next;

        Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
