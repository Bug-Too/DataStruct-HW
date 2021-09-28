public class BSTree extends BTreePrinter{
    Node root;

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
        Node w = y.parent;
        Node x = y.left;
        Node z = x.right;
        singleRotateFromRight(x);
        singleRotateFromLeft(y);

    }

    public void doubleRotateFromRight(Node y) {
        // Do something
        Node w = y.parent;
        Node x = y.right;
        Node z = x.left;
        singleRotateFromLeft(x);
        singleRotateFromRight(y);
        
    }

    public Node find(int search_key) {
        // Pls copy the code from the previous homework
        return find(root, search_key); // Fix this
    }

    public static Node find(Node node, int search_key) {
        // Pls copy the code from the previous homework
        if(node.key == search_key) return node;
        if(node.left != null && search_key < node.key){
            return find(node.left, search_key);
        }else if(node.right != null && search_key > node.key){
            return find(node.right, search_key);
        }
        return null;
    }

    public static Node findMin(Node node) {
        // Pls copy the code from the previous homework
        if(node == null) return null;
        
        if(node.left != null){
            return findMin(node.left);
        }else{
            return node;
        }

    }

    public static Node findMax(Node node) {
        // Pls copy the code from the previous homework
        if(node == null) return null;
        
        if(node.right != null){
            return findMax(node.right);
        }else{
            return node;
        }
    }

    public void insert(int key) {
        // Pls copy the code from the previous homework
        if(root == null){
            root = new Node(key);
            return;
        }
        insert(root,key);

    }

    public static void insert(Node node, int key) {
        // Pls copy the code from the previous homework
        if(node == null){
            node = new Node(key);
        }else{
            Node closetLeaf = findClosestLeaf(node,key);
            if(key < closetLeaf.key){
                Node temp = new Node(key);
                closetLeaf.left = temp;
                temp.parent = closetLeaf;
            }else{
                Node temp = new Node(key);
                closetLeaf.right = temp;
                temp.parent = closetLeaf;

            }
        }
        
    }

    public Node findClosestLeaf(int search_key){
        return findClosestLeaf(root, search_key); // Call the recursive version
    }
    
    public static Node findClosestLeaf(Node node, int search_key){
        // this function should be recursive
        if(node.right == null && node.left == null){
            return node;
        }
        if(search_key < node.key){
            if(node.left == null){
                return node;
            }else{
                return findClosestLeaf(node.left, search_key);
            }
        }else{
            if(node.right == null){
                return node;
            }else{
                return findClosestLeaf(node.right, search_key);
            }
        }
        
    }

    public void delete(int key) {
        // There should be 6 cases here
        // Non-root nodes should be forwarded to the static function
        Node node = find(key);
        if(root == null){
            System.out.println("Empty tree");
        }else if(node == null){
            System.out.println("Key not found");
        }else if(node == root){
            if (root.left == null && root.right == null) {
                root = null;
            }else if(root.left != null && root.right == null){
                root = root.left;
                root.parent = null;
            }else if(root.right != null && root.left == null){
                root = root.right;
                root.parent = null;
            }else{
                Node n = findMin(root.right);
                root.key = n.key;
                delete(n);
            }
        }else{
            delete(node);
        }
        
    }

    // Use this function to delete non-root nodes
    public static void delete(Node node){
        // There should be 7 cases here
        if(node.left == null && node.right == null){
            if(node.key < node.parent.key){
                node.parent.left = null;
            }else{
                node.parent.right = null;
            }
        }else if(node.left != null && node.right == null){
            if(node.key < node.parent.key){
                node.parent.left = node.left;
                node.left.parent = node.parent;
            }else{
                node.parent.right = node.left;
                node.left.parent = node.parent;
            }
        }else if(node.right != null && node.left == null){
            if(node.key < node.parent.key){
                node.parent.left = node.right;
                node.right.parent = node.parent;
            }else{
                node.parent.right = node.right;
                node.right.parent = node.parent;
            }
        }
        else{
            Node n = findMin(node.right);
            node.key = n.key;
            delete(n);
        }
    }

    public static boolean isMergeable(Node r1, Node r2) {
        if(r1 == null || r2 == null) return true;
        return findMax(r1).key < findMin(r2).key;// Fix this
    }

    public static Node mergeWithRoot(Node r1, Node r2, Node t) {
        if (isMergeable(r1, r2)) {
            // Fix this
            t.left = r1;
            t.right = r2;
            if(r1 != null) r1.parent = t;
            if(r2 != null) r2.parent = t;
            return t;
        } else {
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
            return null;
        }
    }

    public void merge(BSTree tree2) {
        if (isMergeable(this.root, tree2.root)) {
            // Do something
            Node T = findMax(this.root);
            this.delete(T.key);
            this.root = mergeWithRoot(this.root, tree2.root , T);     
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