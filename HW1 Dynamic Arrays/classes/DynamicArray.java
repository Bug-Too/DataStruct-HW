package classes;

public class DynamicArray {
    private int[] arr;
    private int capacity;
    private int size; // Last element can be indexed at size-1
    
    public DynamicArray(int cap){ // Class Constructor
        arr = new int[cap];
        capacity = cap;
    }
    
    public void pushBack(int data){
        if (size == capacity) {
            this.capacity = capacity * 2;
            int[] temp = new int[capacity];
            for (int i = 0; i < size; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
        arr[size] = data;
        size++;
    }
    public int popBack(){
        size--;
        return arr[size];
    }

    public int get(int i){
        if (i>size||i<0) {
            System.out.print("Error");
        }
        return arr[i];
    }
    public void set(int i, int value){
        if (i>size||i<0) {
            System.out.print("Error");
        }else{
            arr[i] = value;
        }

    }
    
    public void remove(int i){
        if (i>=size||i<0) {
            System.out.print("Error");
        }
        if(i==size-1){
            size--;
        }else{
            for(int j = i;j<size-1;j++){
                arr[j] = arr[j+1];
            }
        }
    }
    
    public boolean isEmpty(){

        return size == 0;
    }
    
    public int getSize(){
        // FIXED THIS
        return size;
    }
    
    public void printStructure(){
        // FIXED THIS
        System.out.print("Size = " + size + ", Cap = " + capacity + ", arr = [");
        for (int i = 0; i < size; i++) {
            if (i != size - 1) System.out.print(arr[i] + ", ");
            else System.out.print(arr[i]);
        }
        System.out.print("]");
    }
}
