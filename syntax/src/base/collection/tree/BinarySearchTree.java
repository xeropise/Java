package base.collection.tree;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T> {
    Node root = null;
    int size = 0;

    public BinarySearchTree() {}

    public <T extends Comparable> boolean insert(T value) {
        Node newNode = new Node(value);

        if (size == 0) {
            root = newNode;
        } else {
            Node current = root; // 포인터
            Node parent = null;

            while (true) {
                parent = current;

                if (current.value.compareTo(value) > 0) { // 전달된 값이 더 작다면
                    current = parent.left;
                    if (current == null) {
                        parent.left = newNode;
                        break;
                    }
                } else {                // 전달된 값이 더 크다면
                    current = parent.right;
                    if (current == null) {
                        parent.right = newNode;
                        break;
                    }
                }
            }

            newNode.parent = parent;
        }
        size++;

        return true;
    }

    public <T extends Comparable>  Node find(T value) {
        if (root == null) {
            return null;
        }

        Node current = root;

        while (!current.value.equals(value)) {
            if (current.value.compareTo(value) > 0) { // 현재 값이 전달된 값보다 더 크다면
                current = current.left;
            } else {
                current = current.right;
            }

            if (current == null) {
                throw new NullPointerException();
            }
        }

        return current;
    }

    public void inOrder() {
        if (root == null) {
            System.out.println("Tree is Empty");
            return;
        }
        inOrder(root);
    }

    // 중위 선회
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.value + ", ");
            inOrder(node.right);
        }
    }

    public void preOrder(){
        if(root == null){
            System.out.println("Tree is Empty");
            return;
        }
        preOrder(root);
    }

    // 선위 순회
    public void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.value + ", ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(){
        if(root == null){
            System.out.println("Tree is Empty");
            return;
        }
        postOrder(root);
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.value + ", ");
        }
    }

    public void levelOrder() {
        if (root == null) {
            System.out.println("Tree is Empty");
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.peek();
            System.out.println(", ");
            if (temp.left != null) {
                q.add(temp.left);
            }

            if (temp.right != null) {
                q.add(temp.right);
            }

            q.poll();
        }
    }

    public Node getMin(){
        if(root == null){
            throw new NullPointerException();
        }
        return getSubTreeMin(root);
    }

    public Node getSubTreeMin(Node start){
        if(start == null){
            throw new NullPointerException();
        }
        Node current = start;
        while(current.left != null){
            current = current.left;
        }
        return current;
    }

    public Node getMax(){
        if(root == null){
            throw new NullPointerException();
        }
        return getSubTreeMax(root);
    }

    public Node getSubTreeMax(Node start){
        if(start == null){
            throw new NullPointerException();
        }
        Node current = start;
        while(current.right != null){
            current = current.right;
        }
        return current;
    }

    public <T extends Comparable> Node remove(T value) {
        Node target = find(value);
        Node parent = target.parent;

        // 부모 노드와 현재 target 노드의 관계 알아내기
        boolean isLeft = target.equals(root) ? false : target.equals(parent.left) ? true : false;

        Node replacement;

        // 자식 노드가 없는 경우
        if(target.left == null && target.right == null){
            target = null;

            // 왼쪽 자식 노드만 있는 경우
        } else if(target.right == null){
            replacement = target.left;
            if(target.equals(root)){  // root를 삭제한다면 root 정보를 바꿔준다.
                root = replacement;
            } else if(isLeft){
                parent.left = replacement; // parent와의 관계를 통해 연결해준다.
            } else {
                parent.right = replacement;
            }
            replacement.parent = parent;  // 대체된 노드의 parent도 변경한다.

            // 우측 자식 노드만 있는 경우
        } else if(target.left == null){
            replacement = target.right;
            if(target.equals(root)){  // root를 삭제한다면 root 정보를 바꿔준다.
                root = replacement;
            } else if(isLeft){
                parent.left = replacement; // parent와의 관계를 통해 연결해준다.
            } else {
                parent.right = replacement;
            }
            replacement.parent = parent;  // 대체된 노드의 parent도 변경한다.

            // 양 쪽 자식 노드가 모두 있는 경우
        } else {
            // 이번 코드 예시에선 좌측 서브 트리의 가장 큰 노드로 대체해보자.
            Node leftSubTreeRoot = target.left;
            Node rightSubTreeRoot = target.right;

            replacement = getSubTreeMax(leftSubTreeRoot);
            replacement.parent.right = null;  // 대체 노드로 사용했으니 해당 자리는 null로 변경

            // 대체된 후 모든 관계를 바꿔주어야 함.
            if(target.equals(root)){
                root = replacement;
            } else if(isLeft){
                parent.left = replacement;
            } else {
                parent.right = replacement;
            }
            replacement.left = leftSubTreeRoot;
            replacement.right = rightSubTreeRoot;
            replacement.parent = parent;
        }
        return target;
    }


    private static class Node<T extends Comparable> implements Comparable<Node> {
        T value;
        Node left;
        Node right;

        Node parent;

        Node(T value) {
            this.value =  value;
        }

        @Override
        public int compareTo(@NotNull Node o) {
            return this.value.compareTo(o);
        }
    }
}
