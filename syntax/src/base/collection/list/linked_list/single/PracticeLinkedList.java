package base.collection.list.linked_list.single;

import java.util.Objects;

public class PracticeLinkedList<E> implements MyLinkedList {
    private Node<E> head;
    private Node<E> tail;

    private int size;

    private Node<E> search(int index) {
        Node node = null;
        for (int i = 0; i < index; i++) {
            node = head.next;
        }

        return node;
    }

    @Override
    public void addFirst(Object object) {
        Node<E> first = head;

        Node<E> new_node = new Node<>((E) object, first);

        size++;
        head = new_node;

        if (first == null) {
            tail = new_node;
        }
    }

    @Override
    public void addLast(Object object) {
        Node<E> last = tail;

        Node<E> new_node = new Node<>((E) object, null);

        size++;
        tail = new_node;

        if (last == null) {
            head = new_node;
        } else {
            last.next = new_node;
        }
    }

    @Override
    public void add(int index, Object value) {
        checkIndex(index);

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

        Node<E> new_node = new Node<>((E) value, next_node);

        prev_node.next = new_node;

        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean add(Object value) {
        addLast(value);
        return true;
    }

    @Override
    public boolean remove(Object value) {

        if (head == null) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> prev_node = null;
        Node<E> del_node = null;
        Node<E> next_node = null;

        Node<E> i = head;

        while (i != null) {
            if (Objects.equals(value, i.item)) {
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

        size--;
        del_node.unlink();

        prev_node.next = next_node;

        return true;
    }

    @Override
    public Object removeFirst() {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> del_node = head;

        E returnValue = del_node.item;
        Node<E> next_node = del_node.next;

        size--;

        head = next_node;
        del_node.unlink();

        if (head == null) {
            tail = null;
        }

        return returnValue;
    }

    @Override
    public Object removeLast() {
        return remove(size - 1);
    }

    @Override
    public Object remove(int index) {
        checkIndex(index);

        if (index == 0) {
            return removeFirst();
        }

        Node<E> prev_Node = search(index - 1);

        Node<E> del_node = prev_Node.next;

        E returnValue = (E) del_node.item;
        Node<E> next_node = del_node.next;

        size--;

        del_node.unlink();
        prev_Node.next = next_node;

        return returnValue;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return search(index).item;
    }

    @Override
    public void set(int index, Object value) {
        checkIndex(index);

        Node node = search(index);

        node.item = value;
    }

    static class Node<E> {
        private Node<E> next;
        private E item;

        public Node(E item, Node<E> next) {
            this.next = next;
            this.item = item;
        }

        public void unlink() {
            this.next = null;
            this.item = null;
        }
    }
}
