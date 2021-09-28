package hw7classes;

import java.util.LinkedList;
import java.util.Queue;

public class SplayTree extends BTreePrinter {
    Node root;

    public SplayTree(Node root) {
        this.root = root;
        root.parent = null; // Clear parent of the root (Important for SplayTree)
    }

    // zig() function will move up the node x one level
    // Case 1: x == root
    // Case 2-3: x.parent == root (sig from left, zig from right)
    // Case 4-5: x.parent != root (sig from left, zig from right)
    public void zig(Node x) {
        Node y = x.parent;
        if (y == null){
            System.out.println("Cannot perform Zig operation on the root node");
        }
        else if (y == root){ // If the node is a child of the root
            if (x.key < y.key){// Zig from left
                Node t = x.right != null ? x.right : null;
                root = x;
                root.right = y;
                root.parent = null;
                y.parent = root;
                
                y.left = t;
                if (t != null) t.parent = y;
            }
            else {
                Node t = x.left != null ? x.left : null;
                root = x;
                root.left = y;
                root.parent = null;
                y.parent = root;
                
                y.right = t;
                if (t != null) t.parent = y;
            }
        }
        else if (y != root) {
            if (x.key < y.key) {
                Node w = y.parent != null ? y.parent : null;
                Node t = x.right != null ? x.right : null;
                
                if (w.key > x.key) {
                    w.left = x;
                    x.parent = w;
                }
                else {
                    w.right = x;
                    x.parent = w;
                }
                x.right = y;
                y.parent = x;
                y.left = t;
                if (t != null) t.parent = y;
                
            }
            else {
                Node w = y.parent != null ? y.parent : null;
                Node t = x.left != null ? x.left : null;
                
                if (w.key > x.key) {
                    w.left = x;
                    x.parent = w;
                }
                else {
                    w.right = x;
                    x.parent = w;
                }
                x.left = y;
                y.parent = x;
                y.right = t;
                if (t != null) t.parent = y;
            }
        }
    }

    // zigzig() function will move up node x two levels along the outer path
    // Pls call zig() to perform zigzig()
    public void zigzig(Node x) {
        // Do something
        zig(x.parent);
        zig(x);
    }

    // zigzag() function will move up node x two levels along the inner path
    // Pls call zig() to perform zigzag()
    public void zigzag(Node x) {
        // Do something
        zig(x);
        zig(x);
    }

    // This function will interatively splay (move up) node x all the way to the
    // root
    public void splay(Node x) {
        while (x != null && x != root) {
            Node y = x.parent;
            if (y == root) {
                zig(x);
                // Do something and break
                break;
            } else {
                Node w = y.parent;
                if (w.left != null && w.left.left == x || w.right != null && w.right.right == x) {
                    zigzig(x);
                } else if (w.left != null && w.left.right == x || w.right != null && w.right.left == x) {
                    zigzag(x);
                }
            }
        } // Complete the rest of the cases yourself
    }

    // Modify this function to have the splaying feature
    // This can be done by calling the splay() function
    public void insert(int key) {
        Node current = root;
        if (root == null)
            root = new Node(key);

        while (current != null) {

            if (key > current.key) {
                if (current.right != null) {
                    current = current.right;
                } else {
                    break;
                }
            } else {
                if (current.left != null) {
                    current = current.left;
                } else {
                    break;
                }
            }
        }
        if (current == null) {
            current = new Node(key);
        }
        Node temp = new Node(key);
        if (key < current.key) {
            
            current.left = temp;
            temp.parent = current;
            
        } else {
            
            current.right = temp;
            temp.parent = current;
            
        }
        splay(temp);
    }

    // Modify this function to have the splaying feature (if withSplay is true)
    // This can be done by calling the splay() function
    public Node find(int search_key , boolean withSplay) {
        Node current = root;
        while (current != null) {

            if (search_key == current.key) {
                if(withSplay) splay(current);
                return current;
            }

            if (search_key > current.key) {
                if (current.right != null) {
                    current = current.right;
                } else {
                    return null;
                }
            } else if (search_key < current.key) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    return null;
                }
            }

        }
        return null;
    }

    // This delete() is different than what you learned in BSTree and AVLTree before
    // Use the algorithm learned in the class to implement this function
    public void delete(int key) {
        splay(find(key, true)); 
        Node r1 = root.left; 
        root.left.parent = r1;
        Node r2 = root.right; 
        root.right.parent = r2; 
        SplayTree tree2 = new SplayTree(r2); 
        tree2.splay(tree2.findMin()); 
        tree2.root.left = r1; 
        this.root = tree2.root; 
    }

    // This function does not have the splaying feature
    public Node findMin() {
        // Pls copy code from the previous problem
        // Do not add the splaying feature in this function
        Node current = root;
        if(root == null) return null;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // This is another version of height() called iterative method to find BST
    // height
    // This function is complete, no need to edit
    @SuppressWarnings("unchecked")
    public int height() {
        if (root == null)
            return -1;
        Queue<Node> q = new LinkedList();
        q.add(root);
        int height = -1;
        while (true) {
            int nodeCount = q.size();
            if (nodeCount == 0)
                return height;
            height++;
            while (nodeCount > 0) {
                Node newnode = q.remove();
                if (newnode.left != null)
                    q.add(newnode.left);
                if (newnode.right != null)
                    q.add(newnode.right);
                nodeCount--;
            }
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

    public SplayTree() {
    } // Dummy Constructor, no need to edit

    // This is the editable testcase (test#4)
    // No need to edit
    public static void test4() {
        BSTree2 tree1 = new BSTree2();
        long start = System.currentTimeMillis();
        int N = 40000;
        for (int i = 0; i < N; i++)
            tree1.insert(i);
        System.out.println("Time for sequentially inserting " + N + " objects into BST = "
                + (System.currentTimeMillis() - start) + " msec");
        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++)
            tree1.find((int) (Math.random() * N));

        System.out.println("Time for finding " + N + " different objects in BST= "
                + (System.currentTimeMillis() - start) + " msec");
        SplayTree tree2 = new SplayTree();
        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++)
            tree2.insert(i);

        System.out.println("Time for sequentially inserting " + N + " objects into SplayTree = "
                + (System.currentTimeMillis() - start) + " msec");
        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++)
            tree2.find((int) (Math.random() * N), true);
        System.out.println("Time for finding " + N + " different objects in SplayTree = "
                + (System.currentTimeMillis() - start) + " msec");

        System.out.println("Which one is faster: BSTree or SplayTree?");
    }

}