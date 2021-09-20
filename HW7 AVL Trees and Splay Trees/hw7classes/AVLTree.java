package hw7classes;
public class AVLTree extends BTreePrinter{
    Node root;

    public void singleRotateFromLeft(Node y) {
        // Pls copy the code from the previous problem
    }

    public void singleRotateFromRight(Node y) {
        // Pls copy the code from the previous problem
    }

    public void doubleRotateFromLeft(Node y) {
        // Pls copy the code from the previous problem
    }

    public void doubleRotateFromRight(Node y) {
        // Pls copy the code from the previous problem
    }

    public static void rebalance(AVLTree tree, Node node){
        int balanceFactor = 0;              // Calculate balanceFactor
        if (true){                          // Use balanceFactor to check if unbalanced?
            if (true){                      // Use balanceFactor to check if left heavy?
                if (true){                  // Use the grandchild to check if Outer or Inner?
                    System.out.println("Perform ??? (Node " + node.key +")");   // Fix ??? and call a function
                    
                }else{
                    System.out.println("Perform ??? (Node " + node.key +")");   // Fix ??? and call a function

                }
            }else{
                if (true){                  // Use the grandchild to check if Outer or Inner?
                    System.out.println("Perform ??? (Node " + node.key +")");   // Fix this and call a function

                }else{
                    System.out.println("Perform ??? (Node " + node.key +")");   // Fix this and call a function
                    
                }
            }
        }
    }
    
    // This function is complete, no need to edit
    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            insert(this, root, key);
        }
    }
    
    // Fix this function to have the rebalancing feature
    // There should be rebalance() function calling somewhere in the code
    public static void insert(AVLTree tree, Node node, int key) {
        if (key == node.key) {
            System.out.println("Duplicated key:" + key);
        }else if (key < node.key) {//Go left
            if (node.left == null) {
                node.left = new Node(key);
                node.left.parent = node;
            }else {
                insert(tree, node.left, key);
            }
        }else{  // Go right
            if (node.right == null) {
                node.right = new Node(key);
                node.right.parent = node;
            }else {
                insert(tree, node.right, key);
            }
        }
    }
    

    // This function is for deleting the root node
    // If the node is not the root, please call the recursive version
    public void delete(int key) {
        // Pls copy the code from the previous homework
    }
    
    // Use this function to delete non-root nodes
    // Also, fix the code to have the rebalancing feature
    public static void delete(AVLTree tree, Node node){
        // Pls copy the code from the previous homework
        // Add code segments to enable the rebalancing feature
    }
    
    public Node find(int search_key) {
        // Pls copy the code from the previous problem
        return null; // Fix this
    }

    public static Node find(Node node, int search_key) {
        // Pls copy the code from the previous problem
        return null; // Fix this
    }
    
    // This function is complete, no need to edit
    public static Node findMin(Node node){
        // Pls copy the code from the previous problem
        return null; // Fix this
    }
    
    public static Node findMax(Node node){
        // Pls copy the code from the previous problem
        return null; // Fix this
    }
    
    public static boolean isMergeable(Node r1, Node r2){
        return false;// Fix this
    }

    public static Node mergeWithRoot(Node r1, Node r2, Node t){
        if (isMergeable(r1, r2)) {
            // Fix this
            return null;
        } else {
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
            return null;
        }
    }
    
    public void merge(AVLTree tree2){
        if (isMergeable(this.root, tree2.root)){
            // Do something
        }else{
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
        }
    }
    
    // Fix this function
    public Node[] split(int key){
        return new Node[2]; // This is incorrect, fix this by calling the static split
    }
    
    // Fix this function
    public static Node[] split(Node r, int key){ 
        Node[] arr = new Node[2];
        // Do something
        return arr;
    }
    
    // Use this function to check the node height
    // This function is complete, no need to edit
    public static int height(Node node){
        if (node == null)
            return -1;
        else
            return 1 + Math.max(height(node.left), height(node.right));
    }
    
    // This function is complete, no need to edit
    public void printTree() {
        if (root == null) {
            System.out.println("Empty tree!!!");
        } else {
            super.printTree(root);
        }
    }
    
    public AVLTree() {} // Dummy Constructor, no need to edit
}