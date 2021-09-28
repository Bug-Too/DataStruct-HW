
public class BSTree2 extends BTreePrinter {
    Node root;

    // Implement this function using iterative method
    // Do not use recursion
    public Node find(int search_key) {
        Node current = root;
        while (current != null) {
            if(search_key == current.key) return current;

            if (search_key > current.key) {
                if (current.right != null) {
                    current = current.right;
                } else {
                    return null;
                }
            } else if (search_key < current.key) {
                if (current.left != null) {
                    current = current.left;
                }else{
                    return null;
                }
            }
            
        }
        return null;
    }

    // Implement this function using iterative method
    // Do not use recursion
    public Node findMin() {
        Node current = root;
        if(root == null) return null;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Implement this function using iterative method
    // Do not use recursion
    public Node findMax() {
        Node current = root;
        if(root == null) return null;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    // Implement this function using iterative method
    // Do not use recursion
    public void insert(int key) {
        Node current = root;
        if(root == null) root = new Node(key);

        while (current != null) {

            if (key > current.key) {
                if (current.right != null) {
                    current = current.right;
                } else {
                    break ;
                }
            } else{
                if (current.left != null) {
                    current = current.left;
                }else{
                    break ;
                }
            }
        }
        if(current == null) {current = new Node(key);}
        if(key < current.key){
            Node temp = new Node(key);
            current.left = temp;
            temp.parent = current;
        }else{
            Node temp = new Node(key);
            current.right = temp;
            temp.parent = current;
        }
    }





    // This function is complete, no need to edit
    public void printTree() {
        if (root == null) {
            System.out.println("Empty tree!!!");
        } else {
            super.printTree(root);
        }
    }
}