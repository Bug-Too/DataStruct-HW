public class Heap {

    int capacity;
    Node[] arr;
    int size;

    boolean isMinHeap; // true if minHeap, false if maxHeap

    int timer; // For each push, the timer will increase by 1

    public Heap(boolean isMinHeap, int cap) {
        // Initialize the heap here
        // Don't forget that we will build the binary heap using...
        // ... the concept of "Complete binary tree based on the array implementation"
        // ... The 0 index will not be used, The index starts from 1 (remember?)
        arr = new Node[cap];
        capacity = cap;
        size = 0;
        this.isMinHeap = isMinHeap;
    }

    public Node top() {
        return arr[1]; // FIX THIS
    }

    public void push(Node node) {
        // Increase timer each time you push something into the Queue
        timer++;
        node.timestamp = timer; // Stamp the time number to the node

        // To do:
        // 1. Push the new node at the end of the array (via back pointer)
        // 2. Sift (percolate) it up the heap
        // * Check priority of the current node with its parent
        // * Swap the current node if the priority is higher than the parent
        // * Repeat the process until reaching the root or there is no swap (Pls use
        // while loop)
        // 3. Increase the heap size
        if (size + 1 == capacity) {
            return;
        }
        arr[size + 1] = node;
        size++;

        if (isMinHeap) {
            // minheap
            int current = size;
            while (current > 1) {
                if (arr[current].price < arr[current / 2].price) {
                    swap(current, current / 2);
                    current = current / 2;
                } else {
                    break;
                }

            }
        } else {
            // maxheap
            int current = size;
            while (current > 1) {
                if (arr[current].price > arr[current / 2].price) {
                    swap(current, current / 2);
                    current = current / 2;
                } else {
                    break;
                }

            }
        }

    }

    public Node pop() {

        // To do:
        // 1. Mark the root for return (Don't forget to return this node)
        // 2. Move the last node to the root (change pointer, set null)
        // 3. Decrease the heap size
        // 4. Sift (percolate) it down the heap
        // * Check priority of the current node with both children
        // * Swap the current node with the lower priority child
        // * Repeat the process until the node has no child or there is no swap (Pls use
        // while loop)

        Node temp = null; // กำหนดให้ select เท่ากับ null
        if (size == 0) {
            return temp;
        }

        temp = arr[1];
        if (size != 1)
            arr[1] = arr[size--];
        else
            arr[size--] = null;
        int current = 1;

        if (isMinHeap) {// check minheap or maxheap
            // minheap
            // ค่าน้อยขึ้นบน
            int min;

            while (current < size) {
                if (current * 2 == size) { // 1 child case
                    if (arr[current].price >= arr[current * 2].price)
                        swap(current, current * 2);
                    break;
                } else if (2 * current + 1 <= size) {// 2 children cases
                    min = findmin(current * 2, current * 2 + 1);
                    if (arr[current].price >= arr[min].price) {
                        swap(current, min);
                        current = min;
                    } else {
                        break;
                    }
                } else {// 0 child
                    break;
                }
            }

        } else {
            // maxheap
            // ค่ามากๆขึ้นบน
            int max;
            while (current < size) {
                if (current * 2 == size) { // 1 child case
                    if (arr[current].price <= arr[current * 2].price)
                        swap(current, current * 2);
                    break;
                } else if (2 * current + 1 <= size) {// 2 children cases
                    max = findmax(current * 2, current * 2 + 1);
                    if (arr[current].price <= arr[max].price) {
                        swap(current, max);
                        current = max;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }

        }

        // maxheap

        return temp; // FIX THIS

    }

    public int findmin(int n1, int n2) {
        Node N1 = arr[n1];
        Node N2 = arr[n2];

        if (N1.price == N2.price) {
            if (N1.timestamp < N2.timestamp)
                return n1;
            else
                return n2;
        } else {
            if (N1.price < N2.price) {
                return n1;
            } else {
                return n2;
            }
        }
    }

    public int findmax(int n1, int n2) {
        Node N1 = arr[n1];
        Node N2 = arr[n2];

        if (N1.price == N2.price) {
            if (N1.timestamp < N2.timestamp)
                return n1;
            else
                return n2;
        } else {
            if (N1.price > N2.price) {
                return n1;
            } else {
                return n2;
            }
        }
    }

    // This is an optional function, you may use it if you know what it is
    // This function is complete, no need to edit
    public void swap(int index1, int index2) {
        Node temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
