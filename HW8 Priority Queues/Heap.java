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
        return null; // FIX THIS
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
        arr[size + 1] = node;
        size++;

        if (isMinHeap) {
            // minheap
            int current = size + 1;
            while (size != 1) {
                if (arr[current].price < arr[current / 2].price) {
                    swap(current, current / 2);
                } else {
                    break;
                }
                current = current / 2;
            }
        } else {
            // maxheap
            int current = size + 1;
            while (size != 1) {
                if (arr[current].price > arr[current / 2].price) {
                    swap(current, current / 2);
                } else {
                    break;
                }
                current = current / 2;
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
        Node temp = arr[1];
        arr[1] = arr[size];
        size--;

        if (isMinHeap) {
            // minheap
            int current = 1;
            while (arr[current * 2] != null || arr[current * 2 + 1] != null) {
                if (arr[current * 2] != null && arr[current * 2 + 1] != null) { // not null both
                    // child less than current ? swap : break
                    if (arr[current].price >= arr[current * 2].price
                            || arr[current].price >= arr[current * 2 + 1].price) {
                        // check min price of cureent child and swap min child with current
                        if (arr[current * 2].price < arr[current * 2 + 1].price) {
                            swap(current, current * 2);
                            current = current * 2;
                        } else if (arr[current * 2].price > arr[current * 2 + 1].price) {
                            swap(current, current * 2 + 1);
                            current = current * 2 + 1;
                        } else {
                            if (arr[current * 2].timestamp < arr[current * 2 + 1].timestamp) {
                                swap(current, current * 2);
                                current = current * 2;
                            } else {
                                swap(current, current * 2 + 1);
                                current = current * 2 + 1;
                            }
                        }
                    } else {
                        break;
                    }
                } else if (arr[current * 2 + 1] == null) { // left node != null
                    if (arr[current].price > arr[current * 2].price) {
                        // child less than current ? swap : break
                        swap(current, current * 2);
                        current = current * 2;
                    } else {
                        if (arr[current].price == arr[current * 2].price)
                            swap(current, current * 2);
                        break;
                    }
                } else if (arr[current * 2] == null) { // right node != null
                    if (arr[current].price > arr[current * 2 + 1].price) {
                        // child less than current ? swap : break
                        swap(current, current * 2 + 1);
                        current = current * 2 + 1;
                    } else {
                        if (arr[current].price == arr[current * 2 + 1].price)
                            swap(current, current * 2 + 1);
                        break;
                    }
                }
            }
        } else {
            int current = 1;
            while (arr[current * 2] != null || arr[current * 2 + 1] != null) {
                if (arr[current * 2] != null && arr[current * 2 + 1] != null) { // not null both
                    // child more than current ? swap : break
                    if (arr[current].price <= arr[current * 2].price
                            || arr[current].price <= arr[current * 2 + 1].price) {
                        // check min price of cureent child and swap min child with current
                        if (arr[current * 2].price > arr[current * 2 + 1].price) {
                            swap(current, current * 2);
                            current = current * 2;
                        } else if (arr[current * 2].price < arr[current * 2 + 1].price) {
                            swap(current, current * 2 + 1);
                            current = current * 2 + 1;
                        } else {
                            if (arr[current * 2].timestamp < arr[current * 2 + 1].timestamp) {
                                swap(current, current * 2);
                                current = current * 2;
                            } else {
                                swap(current, current * 2 + 1);
                                current = current * 2 + 1;
                            }
                        }
                    } else {

                        break;
                    }
                } else if (arr[current * 2 + 1] == null) { // left node != null
                    if (arr[current].price < arr[current * 2].price) {
                        // child less than current ? swap : break
                        swap(current, current * 2);
                        current = current * 2;
                    } else {
                        if (arr[current].price == arr[current * 2].price)
                            swap(current, current * 2);
                        break;
                    }
                } else if (arr[current * 2] == null) { // right node != null
                    if (arr[current].price < arr[current * 2 + 1].price) {
                        // child less than current ? swap : break
                        swap(current, current * 2 + 1);
                        current = current * 2 + 1;
                    } else {
                        if (arr[current].price == arr[current * 2 + 1].price)
                            swap(current, current * 2 + 1);
                        break;
                    }
                }
            }
        }

        // maxheap

        return temp; // FIX THIS

    }

    // This is an optional function, you may use it if you know what it is
    // This function is complete, no need to edit
    public void swap(int index1, int index2) {
        Node temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
