package base.collection.list.linked_list.double2;

import java.util.NoSuchElementException;
import java.util.Objects;

public class MyDoublyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;

    private int size;

    public MyDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node<E> search(int index) {
        Node<E> n; //반환할 노드

        // 인덱스가 앞쪽에 가까우면 순차 탐색
        if ((size / 2) > index) {
            n = head;

            for (int i = 0; i < index; i++) {
                n = n.next;
            }
        // 인덱스가 끝에 가까우면 역순 탐색
        } else {
            n = tail;

            for (int i = size - 1; i > index; i--) {
                n = n.prev;
            }
        }

        return n;
    }

    public void addFirst(E value) {
        Node<E> first = head;

        // 새 노드를 추가 (이때 첫번째 노드니까 prev는 null이 되고 next는 head가 가리키는 노드가 되게 된다)
        Node<E> new_Node = new Node<>(null, value, first);

        size++;

        head = new_Node;

        if (first == null) {
            // 만일 빈 리스트에서 최초의 요소 추가였을 경우, tail도 첫째 노드를 바라보도록 업데이트
            tail = new_Node;
        } else {
            // 만일 빈 리스트가 아닐경우, 추가되기 이전 첫번째이었던 노드에서 prev를 새 노드로 참조하도록 업데이트
            first.prev = new_Node;
        }
    }

    public void addLast(E value) {

        Node<E> last = tail;

        Node<E> new_node = new Node<>(last, value, null);

        size++;

        tail = new_node;

        // 만일 빈 리스트에서 최초의 요소 추가였을 경우, head도 첫째 노드를 바라보도록 업데이트
        if (last == null) {
            head = new_node;
        // 만일 빈 리스트가 아닐경우, 추가되기 이전 마지막이었던 노드에서 next를 새 노드로 참조하도록 업데이트
        } else {
            last.next = new_node;
        }
    }

    public boolean add(E value) {
        addLast(value);
        return true;
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

        Node<E> next_node = search(index);

        Node<E> prev_node = next_node.prev;


        Node<E> new_node = new Node<>(prev_node, value, next_node);

        size++;

        prev_node.next = new_node;
        next_node.prev = new_node;
    }

    public E removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        E value = head.item;

        Node<E> first = head.next;

        head.next = null;
        head.item = null;

        size--;

        head = first;

        // 만일 리스트의 유일한 값을 삭제해서 빈 리스트가 될 경우, tail도 null 처리
        if (first == null) {
            tail = null;

        // 만일 빈 리스트가 아닐경우, 삭제되기 이전 두번째 이었던 first가 첫번째 노드가 되니 prev를 null 처리
        } else {
            first.prev = null;
        }

        return value;
    }

    public E remove() {
        return removeFirst();
    }

    public E removeLast() {

        if (tail == null) {
            throw new NoSuchElementException();
        }

        E value = tail.item;

        Node<E> last = tail.prev;

        tail.item = null;
        tail.prev = null;

        size--;

        tail = last;

        // 만일 리스트의 유일한 값을 삭제해서 빈 리스트가 될 경우, head도 null 처리
        if (last == null) {
            head = null;
        } else {
        // 만일 빈 리스트가 아닐경우, 삭제되기 이전 마지막의 이전 노드 이었던 last가 마지막 노드가 되니 next를 null 처리
            last.next = null;
        }

        return value;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == size - 1) {
            return removeLast();
        }

        Node<E> del_node = search(index);

        Node<E> prev_node = del_node.prev;

        Node<E> next_node = del_node.next;

        E value = del_node.item;

        del_node.prev = null;
        del_node.item = null;
        del_node.next = null;

        size--;

        prev_node.next = next_node;
        next_node.prev = prev_node;

        return value;
    }

    public boolean remove(Object value) {

        Node<E> del_node = null;

        Node<E> i = head;

        while (i != null) {
            if (Objects.equals(i.item, value)) {
                del_node = i;
                break;
            }

            i = i.next;
        }

        // 못찾았음
        if (del_node == null) {
            return false;
        }

        if (del_node == head) {
            removeFirst();
            return true;
        }

        if (del_node == tail) {
            removeLast();
            return true;
        }

        Node<E> prev_node = del_node.prev;
        Node<E> next_node = del_node.next;

        del_node.item = null;
        del_node.prev = null;
        del_node.next = null;

        size--;

        prev_node.next = next_node;
        next_node.prev = prev_node;

        return true;
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

        Node<E> replace_node = search(index);

        replace_node.item = value;
    }

    public int indexOf(Object value) {
        Node<E> n = head;
        int i = 0;
        while (n != null) {
            if (Objects.equals(value, n.item)) {
                return i;
            }

            i++;
            n = n.next;
        }

        return -1;
    }

    public int lastIndexOf(Object value) {
        Node<E> n = tail;
        int i = size - 1;
        while (n != null) {
            if (Objects.equals(value, n.item)) {
                return i;
            }

            i--;
            n = n.prev;
        }

        return -1;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        // i.next가 null이 면 마지막을 의미하는거니, null 이 아닐때 까지 순회
        for (Node<E> i = head; i.next != null; ) {
            Node<E> next_node = i.next; // i에 관한 모든 값을 지울 것이기 때문에 미리 백업한다.

            i.item = null;
            i.prev = null;
            i.next = null;

            i = next_node;
        }

        head = null;
        tail = null;

        size = 0; // 모든 요소를 지웠으니 size도 초기화
    }

    public boolean contains(Object value) {
        return indexOf(value) != -1; // -1 이 아니라는 말은 요소가 리스트에 존재한다는 것이다.
    }


    private static class Node<E> {
        private Node<E> prev;
        private E item;
        private Node<E> next;

        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
