package hwclass;

public class Node extends BTreePrinter {

    public Node left;
    public Node right;
    public int data;

    public Node(int data) {
        this.data = data;
    }

    public void printTree() {
        // uncomment the following line and fix the errors
        super.printTree(this);
    }

    public void printBFT() {
        Queue q = new Queue(50);
        System.out.print("BFT node sequence [ ");

        q.enqueue(this);

        while (q.size != 0 ){
            Node temp = q.dequeue();
            System.out.print(temp.data + " ");

            if (temp.left != null) {
                q.enqueue(temp.left);
            }
            if (temp.right != null) {
                q.enqueue(temp.right);
            }
        }

        System.out.println("]");
    }

    public void printDFT() { // PreOrder
        Stack s = new Stack(50);
        System.out.print("DFT node sequence [ ");
        s.push(this);
        while (s.size != 0){
            Node temp = s.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null) {
                s.push(temp.right);
            }
            if (temp.left != null) {
                s.push(temp.left);
            }

        }
        System.out.println("]");
        
    }
}
