package classes;

public class DoublyLinkedList {
    Node head;
    Node tail;
    String listName;
    
    public DoublyLinkedList(String name){
        this.listName = name;
        head.next = tail;
        tail.previous = head;
    }
    
    public void popBack() {
      if (isEmpty()){
        System.out.println("ERROR");
        }else{
            tail.previous.previous.next = tail;
            tail.previous = tail.previous.previous;
        }
    }
    
    public void popFront(){
        if (isEmpty()){
            System.out.println("ERROR");
        }else{
            head.next.next.previous = head;
            head.next = head.next.next;
        }
    }
    
    public Node topFront(){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node temp = head;
            head = head.next;
            return temp;
        }
    }
    
    public Node topBack(){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node temp = tail;
            popBack();
            return temp;
        }
    }
    
    public void pushFront(Node node){
        if (isEmpty()){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head = node;
            
        }
    }
    
    public void pushBack(Node node) {
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
        }
    }

    public Node findNode(int id){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node current = head;
            while (current.next != null) {
                if (current.student_id == id) {
                    return current;
                }
                current = current.next;
            }
            if (current.student_id == id) {
                return current;
            }
            return new Node("Student Not Found!");
        }
    }
    
    public Node eraseNode(int id){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node current = head;
            Node temp = new Node();
            while (current.next != null) {
                if (current.student_id == id) {
                    temp = current;
                    current = null;
                    return temp;
                }
                current = current.next;
            }
            if (current.student_id == id) {
                temp = current;
                current = null;
                return temp;
            }
            return new Node("Student Not Found!");
        }
    }
    
    public void addNodeAfter(Node node1, Node node2){
        node2.next = node1.next;
        node1.next = node2;
    }
    
    public void addNodeBefore(Node node1, Node node2){
        Node curr;

        if (node1 == head) {
            node2.next = node1;
            head = node2;
            return;
        }

        for (curr = head; curr.next.next != null; curr = curr.next) {
            if (curr.next == node1) {
                node2.next = node1;
                curr.next = node2;
            } 
        }
        
        if (curr.next == node1) {
            node2.next = node1;
            curr.next = node2;
        } 
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    public void merge(DoublyLinkedList list){
        tail.next = list.head;
        tail = list.tail;
    }
    
    public void printStructure(){
        Node curr = head.next;
        System.out.print(listName + ": head <-> ");
        
        while(curr != tail){
            System.out.print("{" + curr.student_id + "} <-> ");
            curr = curr.next;
        }

        System.out.println("tail");
    }
    
    // This may be useful for you for implementing printStructure()
    public void printStructureBackward(){ 
        Node current = tail.previous;
        System.out.print(listName + ": tail <-> ");

        while(current != head){
            System.out.print("{" + current.student_id + "} <-> ");
            current = current.previous;
        }
        System.out.println("head");
    }
    
    public Node whoGotHighestGPA(){
        if (isEmpty()) {
            return new Node("Empty List!");
        } else {
            Double gpa_max = head.gpa;
            Node temp = null;

            for (Node curr = head; curr != null; curr = curr.next) {
                if (curr.gpa >= gpa_max) {
                    gpa_max = curr.gpa;
                    temp = curr;
                }
            }

            return temp;
        }
    }
}
