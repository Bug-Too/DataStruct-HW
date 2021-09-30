package hwclass;

public class Queue {
    Node[] arr; // circular Queue
    int capacity;
    int front;
    int back;
    int size;
    
    public Queue(int cap){
        capacity = cap;
        arr = new Node[capacity];
        size = 0;
        front = 0;
        back = -1;
    }
    
    public void enqueue(Node node){
        if (!isFull()){
            // do something

            
            back = (back + 1)%capacity;
            arr[back] = node;
            size++;


        }else{
            System.out.println("Queue Overflow!!!");
        }
    }
    
    public Node dequeue(){
        
        if (!isEmpty()){
            // do something
            Node temp = arr[front];
            front = (front+ 1) % capacity;
            size--;
            return temp;

        }else{
            System.out.println("Queue Underflow!!!");
            return null; // fix this (out of place)
        }
        
    }
    
    public boolean isEmpty(){
        return size == 0; // fix this
    }
    
    public boolean isFull(){
        return size == capacity; // fix this (out of place)
    }
    
    public void printCircularIndices(){
        System.out.println("Front index = " + front + " Back index = " + (back + 1) % capacity);
    }
    
    public void printQueue(){
        if (!isEmpty()){
            System.out.print("[Front] ");
            // do something here
            for (int i = front; i != back ; i = (i + 1) % capacity) {
                System.out.print(arr[i].data + " ");
            }
            System.out.print(arr[back].data+ " ");
            System.out.println("[Back]");
        }else{
            System.out.println("Empty Queue!!!");
        }
    }
}
