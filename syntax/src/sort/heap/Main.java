package sort.heap;

public class Main {
    static int[] data = {0, 32, 53, 61, 1, 2, 100, 42, 58, 98, 72};
    static int n = 10;
    static int[] heap = new int[11];
    static int size = 0;

    public static void main(String[] args) {
        for (int i = 1; i <= n; i++) {
            addNode(data[i], i);
        }

        System.out.print("push: ");
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }

        System.out.println("\npop: ");
        while (size > 0) {
            System.out.print(pop() + " ");
        }
    }

    static void swap(int[] data, int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    static void upHeapify(int index) {
        int parent = index / 2;
        while (parent >= 1) {
            if (heap[parent] > heap[index]) return;
            swap(heap, parent, index);
            index = parent;
            parent = index / 2;
        }
    }

    static void downHeapify(int index) {
        int left = index * 2;
        while (left <= size) {
            int right = left + 1;
            if (right <= size) {
                if (heap[left] < heap[right]) left = right;
            }
            if (heap[left] < heap[index]) return;
            swap(heap, index, left);
            index = left;
            left = index * 2;
        }
    }

    static void addNode(int data, int index) {
        heap[index] = data;
        upHeapify(index);
        size++;
    }

    static int pop() {
        int root = heap[1];
        heap[1] = heap[size];
        size--;
        downHeapify(1);
        return root;
    }
}
