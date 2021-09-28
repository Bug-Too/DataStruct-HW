package classes;

public class SinglyLinkedList {
    Node head;
    String listName;

    public SinglyLinkedList(String name) {
        this.listName = name;
    }

    public void popBack() {
        if (isEmpty()) {
            System.out.println("ERROR");
        } else {
            Node current = head;
            if (current.next == null) {
                current = null;
            } else {
                while (current.next != null) {
                    current = current.next;
                }
                current.next = null;
            }
        }
    }

    public void popFront() {
        if (isEmpty()) {
            System.out.println("ERROR");
        } else {
            head = head.next;
        }
    }

    public Node topFront() {
        if (isEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node temp = head;
            head = head.next;
            return temp;
        }
    }

    public Node topBack() {
        if (isEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node current = head;
            Node temp = new Node();
            if (current.next == null) {
                temp = current;
                current = null;
                return temp;
            } else {
                while (current.next != null) {
                    current = current.next;
                }
                temp = current.next;
                current.next = null;
                return temp;
            }
        }
    }

    public void pushFront(Node node) {
        if (isEmpty()) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void pushBack(Node node) {
        if (isEmpty()) {
            head = node;
        } else {
            Node current = head;
            if (current.next == null) {
                current = node;
            } else {
                while (current.next != null) {
                    current = current.next;
                }
                current.next = node;
            }
        }
    }

    public Node findNode(int id) {

        if (isEmpty()) {
            System.out.println("Student Not Found!");
            return new Node();
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

    public Node eraseNode(int id) {
        if (isEmpty()) {
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

    public void addNodeAfter(Node node1, Node node2) {
        node2.next = node1.next;
        node1.next = node2;
    }

    public void addNodeBefore(Node node1, Node node2) {
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

    public boolean isEmpty() {
        return head == null;
    }

    public void merge(SinglyLinkedList list) {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = list.head;
    }

    public void printStructure() {
        Node curr;
        System.out.print(listName + ": head -> ");
        if (!isEmpty()) {
            for (curr = head; curr.next != null; curr = curr.next) {
                System.out.print("{" + curr.student_id + "} -> ");
            }
            System.out.print("{" + curr.student_id + "} -> ");
        }

        System.out.print("null\n");
    }

    public Node whoGotHighestGPA() {
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
