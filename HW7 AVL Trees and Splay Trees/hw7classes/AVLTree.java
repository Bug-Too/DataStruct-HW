package hw7classes;

public class AVLTree extends BTreePrinter {
    Node root;

    public void singleRotateFromLeft(Node y) {
        // Do something
        if (y == null) {
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
        if (y == null) {
            return;
        }

        Node w = y.parent;
        Node x = y.right;

        if (w != null) {
            if (y.key < w.key) {
                if (x.left != null) {
                    x.left.parent = y;
                    y.parent = x;
                    x.parent = w;
                    y.right = x.left;
                    x.left = y;
                    w.left = x;
                } else {
                    y.parent = x;
                    x.parent = w;
                    x.left = y;
                    w.left = x;
                    y.right = null;
                }
            } else {
                if (x.left != null) {
                    x.left.parent = y;
                    y.parent = x;
                    x.parent = w;
                    y.right = x.left;
                    x.left = y;
                    w.right = x;
                } else {
                    y.parent = x;
                    x.parent = w;
                    x.left = y;
                    w.right = x;
                    y.right = null;
                }
            }
        } else {
            if (x.left != null) {
                y.parent = x;
                x.left.parent = y;
                x.parent = null;
                root = x;
                y.right = x.left;
                x.left = y;
            } else {
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

    public static void rebalance(AVLTree tree, Node node) {
        int balanceFactor = Math.abs(height(node.left) - height(node.right)); // Calculate balanceFactor
        if (balanceFactor > 1) { // Use balanceFactor to check if unbalanced?
            if (height(node.left) > height(node.right)) { // Use balanceFactor to check if left heavy?
                if (height(node.left.left) > height(node.left.right)) { // Use the grandchild to check if Outer or
                                                                        // Inner?
                    tree.singleRotateFromLeft(node);
                    System.out.println("Perform SingleRotationFromLeft(Node " + node.key + ")"); // Fix ??? and call a
                                                                                                 // function

                } else {
                    tree.doubleRotateFromLeft(node);
                    System.out.println("Perform DoubleRotationFromLeft(Node " + node.key + ")"); // Fix ??? and call a
                                                                                                 // function

                }
            } else {
                if (height(node.right.left) > height(node.right.right)) { // Use the grandchild to check if Outer or
                                                                          // Inner?
                    tree.doubleRotateFromRight(node);
                    System.out.println("Perform DoubleRotationFromRight(Node " + node.key + ")"); // Fix this and call a
                                                                                                  // function

                } else {
                    tree.singleRotateFromRight(node);
                    System.out.println("Perform SingleRotationFromRight(Node " + node.key + ")"); // Fix this and call a
                                                                                                  // function

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
        } else if (key < node.key) {// Go left
            if (node.left == null) {
                node.left = new Node(key);
                node.left.parent = node;
            } else {
                insert(tree, node.left, key);
            }
        } else { // Go right
            if (node.right == null) {
                node.right = new Node(key);
                node.right.parent = node;
            } else {
                insert(tree, node.right, key);
            }
        }
        rebalance(tree, node);
    }

    // This function is for deleting the root node
    // If the node is not the root, please call the recursive version
    public void delete(int key) {
        // There should be 6 cases here
        // Non-root nodes should be forwarded to the static function
        Node node = find(key);
        if (root == null) {
            System.out.println("Empty tree");
        } else if (node == null) {
            System.out.println("Key not found");
        } else if (node == root) {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left != null && root.right == null) {
                root = root.left;
                root.parent = null;
            } else if (root.right != null && root.left == null) {
                root = root.right;
                root.parent = null;
            } else {
                Node n = findMin(root.right);
                root.key = n.key;
                delete(this, n);
            }
        } else {
            delete(this, node);
        }
    }

    // Use this function to delete non-root nodes
    // Also, fix the code to have the rebalancing feature
    public static void delete(AVLTree tree, Node node) {
        // Pls copy the code from the previous homework
        // Add code segments to enable the rebalancing feature
        Node curr = node.parent;
        if (node.left == null && node.right == null) {
            if (node.key < node.parent.key) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }
        } else if (node.left != null && node.right == null) {
            if (node.key < node.parent.key) {
                node.parent.left = node.left;
                node.left.parent = node.parent;
            } else {
                node.parent.right = node.left;
                node.left.parent = node.parent;
            }
        } else if (node.right != null && node.left == null) {
            if (node.key < node.parent.key) {
                node.parent.left = node.right;
                node.right.parent = node.parent;
            } else {
                node.parent.right = node.right;
                node.right.parent = node.parent;
            }
        } else {
            Node n = findMin(node.right);
            node.key = n.key;
            delete(tree, n);
        }
        while (curr != null) {
            rebalance(tree, curr);
            curr = curr.parent;
        }
    }

    public Node find(int search_key) {
        return find(root, search_key); // Call the recursive version
    }

    public static Node find(Node node, int search_key) {
        // this function should be recursive
        // You should check null in this function
        if (node.key == search_key)
            return node;
        if (node.left != null && search_key < node.key) {
            return find(node.left, search_key);
        } else if (node.right != null && search_key > node.key) {
            return find(node.right, search_key);
        }
        return null;
    }

    public Node findMin() {
        return findMin(root); // Call the recursive version
    }

    public static Node findMin(Node node) {
        // this function should be recursive
        if (node == null)
            return null;

        if (node.left != null) {
            return findMin(node.left);
        } else {
            return node;
        }

    }

    public Node findMax() {
        return findMax(root); // Call the recursive version
    }

    public static Node findMax(Node node) {
        // this function should be recursive
        if (node == null)
            return null;

        if (node.right != null) {
            return findMax(node.right);
        } else {
            return node;
        }

    }

    public static boolean isMergeable(Node r1, Node r2) {
        if (r1 != null && r2 == null || r1 == null && r2 != null)
            return true;
        return findMax(r1).key < findMin(r2).key;// Fix this
    }

    public Node mergeWithRoot(Node r1, Node r2, Node t) {
        if (r1 == null && r2 == null) {
            return t;
        }

        if (isMergeable(r1, r2)) {
            // Fix this
            int diff = height(r1) - height(r2);
            if (Math.abs(diff) <= 1) {
                t.left = r1;
                t.right = r2;
                if (r1 != null)
                    r1.parent = t;
                if (r2 != null)
                    r2.parent = t;
                return t;
            } else if (diff > 1) {
                Node newRoot = mergeWithRoot(r1.right, r2, t);
                r1.right = newRoot;
                newRoot.parent = r1;
                rebalance(this, r1);
                return r1;
            } else if (diff < -1) {
                Node newRoot = mergeWithRoot(r1, r2.left, t);
                r2.left = newRoot;
                newRoot.parent = r2;
                rebalance(this, r2);
                return r2;
            }
            return t;
        } else {
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
            return null;
        }
    }

    public void merge(AVLTree tree2) {
        if (isMergeable(this.root, tree2.root)) {
            // Do something
            Node T = findMax(this.root);
            delete(T.key);
            root = mergeWithRoot(this.root, tree2.root, T);
        } else {
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
        }
    }

    // Fix this function
    public Node[] split(int key) {
        return split(root, key); // This is incorrect, fix this by calling the static split
    }

    // Fix this function
    public Node[] split(Node r, int key) {
        Node[] arr = new Node[2];
        if (r == null) {
            arr[0] = null;
            arr[1] = null;
            return arr;
        } else if (key < r.key) {
            arr = split(r.left, key);
            Node temp = null;
            if (r.parent != null) {
                if (r.parent.key > r.key) {
                    r.parent.left = null;
                    r.parent = null;
                } else {
                    r.parent.right = null;
                    r.parent = null;
                }
            }
            if(r.right != null) {
                temp = r.right;
                r.right.parent = null;
                r.right = null;
            }
            if(arr[1] != null) {
                arr[1].parent = null;
            }

            r.parent = null;
            Node newRoot = mergeWithRoot(arr[1],temp,r);
            while(newRoot.parent != null) {
                newRoot = newRoot.parent;
            }
            arr[1] = newRoot;
            return arr;
        }else if(key >= r.key){
            arr = split(r.right, key);
            Node temp = null;
            if (r.parent != null) {
                if (r.parent.key > r.key) {
                    r.parent.left = null;
                    r.parent = null;
                } else {
                    r.parent.right = null;
                    r.parent = null;
                }
            }////
            if(r.left != null) {
                temp = r.left;
                r.left.parent = null;
                r.left = null;
            }
            if(arr[0] != null) {
                arr[0].parent = null;
            }

            r.parent = null;
            Node newRoot = mergeWithRoot(temp,arr[0],r);
            while(newRoot.parent != null) {
                newRoot = newRoot.parent;
            }
            arr[0] = newRoot;
            return arr;
        }

        return arr;
    }

    // Use this function to check the node height
    // This function is complete, no need to edit
    public static int height(Node node) {
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

    public AVLTree() {
    } // Dummy Constructor, no need to edit
}