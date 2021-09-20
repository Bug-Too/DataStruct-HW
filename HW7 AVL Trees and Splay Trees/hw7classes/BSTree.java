package hw7classes;

public class BSTree extends BTreePrinter {
    Node root;
    public Node w;
    public Node x;

    public void singleRotateFromLeft(Node y) {
        // Do something
        if (y == null){
            return;
        }
            
        Node w = y.parent;
        Node x = y.left;

        if (w != null) {
            if (y.key < w.key) {
                if (x.right != null) {
                    x.right.parent = y;
                    x.parent = w;
                    y.parent = x;
                    w.left = x;
                    y.left = x.right;
                    x.right = y;
                } else {
                    x.parent = w;
                    y.parent = x;
                    x.right = y;
                    w.left = x;
                    y.left = null;
                }
            } else {
                if (x.right != null) {
                    x.right.parent = y;
                    x.parent = w;
                    y.parent = x;
                    w.right = x;
                    y.left = x.right;
                    x.right = y;
                } else {
                    x.parent = w;
                    y.parent = x;
                    x.right = y;
                    w.right = x;
                    y.left = null;
                }
            }

        } else {
            if (x.right != null) {
                x.right.parent = y;
                y.parent = x;
                x.parent = null;
                root = x;
                y.left = x.right;
                x.right = y;
            } else {
                y.parent = x;
                x.parent = null;
                x.right = y;
                root = x;
                y.left = null;
            }

        }
    }

    public void singleRotateFromRight(Node y) {
        // Do something
        if (y == null){
            return;
        }
        
    Node w = y.parent;
    Node x = y.right;

    if(w != null){
        if(y.key < w.key){
            if(x.left != null){
                x.left.parent = y;
                y.parent = x;
                x.parent = w;
                y.right = x.left;
                x.left = y;
                w.left = x;
            }else{
                y.parent = x;
                x.parent = w;
                x.left = y;
                w.left = x;
                y.right = null;
            }
        }else{
            if(x.left != null){
                x.left.parent = y;
                y.parent = x;
                x.parent = w;
                y.right = x.left;
                x.left = y;
                w.right = x;
            }else{
                y.parent = x;
                x.parent = w;
                x.left = y;
                w.right = x;
                y.right = null;
            }
        }
    }else{
        if(x.left != null){
            y.parent = x;
            x.left.parent = y;
            x.parent = null;
            root = x;
            y.right = x.left;
            x.left = y;
        }else{
            y.parent = x;
            x.parent = null;
            root = x;
            y.right = null;
            x.left = y;
        }
    }


    }

    public void doubleRotateFromLeft(Node y) {
        // Do something
    }

    public void doubleRotateFromRight(Node y) {
        // Do something
    }

    public Node find(int search_key) {
        // Pls copy the code from the previous homework
        return null; // Fix this
    }

    public static Node find(Node node, int search_key) {
        // Pls copy the code from the previous homework
        return null; // Fix this
    }

    public static Node findMin(Node node) {
        // Pls copy the code from the previous homework
        return null; // Fix this
    }

    public static Node findMax(Node node) {
        // Pls copy the code from the previous homework
        return null; // Fix this
    }

    public void insert(int key) {
        // Pls copy the code from the previous homework
    }

    public static void insert(Node node, int key) {
        // Pls copy the code from the previous homework
    }

    public void delete(int key) {
        // Pls copy the code from the previous homework
    }

    public static void delete(Node node) {
        // Pls copy the code from the previous homework
    }

    public static boolean isMergeable(Node r1, Node r2) {
        return false;// Fix this
    }

    public static Node mergeWithRoot(Node r1, Node r2, Node t) {
        if (isMergeable(r1, r2)) {
            // Fix this
            return null;
        } else {
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
            return null;
        }
    }

    public void merge(BSTree tree2) {
        if (isMergeable(this.root, tree2.root)) {
            // Do something
        } else {
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
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