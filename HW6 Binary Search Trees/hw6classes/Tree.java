package hw6classes;
// This Tree needs to inherit BTreePrinter
public class Tree extends BTreePrinter{ // Fix this
    public Node root;
      
    public Tree(Node root){
        this.root = root;
    }
    
    public Tree(){} // Dummy constructor (No need to edit)
    
    public void printTree(){
        if(root != null){
            super.printTree(root);
        }else{
            System.out.println("Empty tree!!!");
        }
        
        
    }

    public static void printNode(Node node){
        if(node != null){
            System.out.println(node.key);
        }else{
            System.out.println("Node not found!!!");
        }
    }
        
    public Node find(int search_key){
        return find(root, search_key); // Call the recursive version
    }
    
    public static Node find(Node node, int search_key){
        // this function should be recursive
        // You should check null in this function
        if(node.key == search_key) return node;
        if(node.left != null && search_key < node.key){
            return find(node.left, search_key);
        }else if(node.right != null && search_key > node.key){
            return find(node.right, search_key);
        }
        return null;
    }
    
    
    public Node findMin(){
        return findMin(root); // Call the recursive version
    }
    
    public static Node findMin(Node node){
        // this function should be recursive
        if(node == null) return null;
        
        if(node.left != null){
            return findMin(node.left);
        }else{
            return node;
        }

    }
    
    public Node findMax(){
        return findMax(root); // Call the recursive version
    }
    
    public static Node findMax(Node node){
        // this function should be recursive
        if(node == null) return null;
        
        if(node.right != null){
            return findMax(node.right);
        }else{
            return node;
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
    
    public Node findClosest(int search_key){
        // Please use while loop to implement this function
        // Try not to use recursion
        
        Node current, closest;
        closest = current = root;
        int min_diff = Integer.MAX_VALUE;
        
        // Use while loop to traverse from root to the closest leaf
        while(current != null){
            if(current.key == search_key) return current;
            if(Math.abs(search_key - current.key) < min_diff){
                min_diff = Math.abs(search_key - current.key);
                closest = current;
            }
            if (search_key < current.key) {
                current = current.left;
            }else{
                current = current.right;
            }
        }
        
        return closest;
    }
    
    // Implement this function using the findClosestLeaf technique
    // Do not implement the recursive function
    public void insert(int key) {
        // Implement insert() using the non-recursive version
        // This function should call findClosestLeaf()
        if(root == null){
            root = new Node(key);
        }else{
            Node closetLeaf = findClosestLeaf(root,key);
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
    
    public void printPreOrderDFT(){
        System.out.print("PreOrder DFT node sequence [ ");
        // Call the recursive version
        printPreOrderDFT(root);
        System.out.println("]");
    }
    
    public static void printPreOrderDFT(Node node){
        // this function should be recursive   
        if (node == null) return;
        System.out.println(node.key + " ");
        printPreOrderDFT(node.left);
        printPreOrderDFT(node.right);
        
    }
    
    public void printInOrderDFT(){
        System.out.print("InOrder DFT node sequence [ ");
        // Call the recursive version
        printInOrderDFT(root);
        System.out.println("]");
    }
    
    public static void printInOrderDFT(Node node){
        // this function should be recursive  
        if (node == null) return;
        
        printInOrderDFT(node.left);
        System.out.println(node.key + " ");
        printInOrderDFT(node.right);
    }
    
    public void printPostOrderDFT(){
        System.out.print("PostOrder DFT node sequence [ ");
        // Call the recursive version
        printPostOrderDFT(root);
        System.out.println("]");
    }
    
    public static void printPostOrderDFT(Node node){
        // this function should be recursive 
        if (node == null) return;
        
        printPostOrderDFT(node.left);
        printPostOrderDFT(node.right);
        System.out.println(node.key + " ");
    }
    
    public static int height(Node node){
        // Use recursion to implement this function
        // height = length(path{node->deepest child})
        if(node == null){
            return -1;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }
    
    public static int size(Node node){
        // Use recursion to implement this function
        // size = #children + 1(itself)
        if(node == null){
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }
    
    public static int depth(Node root, Node node){
        // Use recursion to implement this function
        // Similar to height() but start from node, go up to root
        // depth = length(path{node->root})

        if(node == root){
            return 0;
        }else{
            return 1 + depth(root, node.parent);
        }
    }
    
    public int height(){ // Tree height
        // Hint: call the static function

        return height(root);
    }
    
    public int size(){ // Tree size
        // Hint: call the static function
        return size(root);
    }
    
    public int depth(){ // Tree depth
        // Hint: call the static function
        return height(root);
    }
    
    public Node findKthSmallest(int k){
        return findKthSmallest(root, k); // Call the recursive version
    }
    
    public static Node findKthSmallest(Node node, int k){
        // this function should be recursive
        /*  1. Find the size of the left subtree.
            2. If k is less than the size of the left subtree, then the kth smallest element lies in the left subtree.
            3. If k is greater than the size of the left subtree, then the kth smallest element lies in the right subtree.
            4. If k is equal to the size of the left subtree, then the kth smallest element is the root.*/

            int x = size(node.left);
            if(k == x+1){
                return node;
            }
            if(k < x+1){
                return findKthSmallest(node.left, k);
            }else{
                return findKthSmallest(node.right, k - x -1);
            }
                

    }
    
    public static Node findNext(Node node){
        //this function should call other functions
        /* if node has right sub-tree the minimum object in that sub-tree is the next-largest object 
        If there is no right sub-tree, the next largest object (if any) 
        should be somewhere in the path from the node to the root */

        return null;
    }
    
    public static Node leftDescendant(Node node){// Case 1 (findMin)
        // this function should be recursive
        if(node.left == null){
            return node;
        }else{
            return leftDescendant(node.left);
        }
    }
    
    public static Node rightAncestor(Node node) {// Case 1 (first right parent)
        // this function should be recursive
        if(node.parent == null) return null;
        
        if(node.key < node.parent.key){
            return node.parent;
        }else{
            rightAncestor(node.parent);
        }

        return null;
    }
    
    public List rangeSearch(int x, int y){
        // This function utilizes findCloest() and findNext()
        // Use List list append(node) to add node to the list
        // List is the static Array
        List l = new List(100);
        Node n = findClosest(x);

        while(n != null && n.key <= y){
            if(n.key >= x){
                l.append(n);
            }
            n = findNext(n);
        }

        return l;
    }
    
         
    // This function is for deleting the root node
    // If the node is not the root, please call the recursive version
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
}
