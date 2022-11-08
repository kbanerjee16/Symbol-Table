public class SymbolTable <Key extends Comparable<Key>, Value> {
    Node root;
    class Node {
        Key k;
        Value v;
        Node left;
        Node right;

        public Node(Key k, Value v, Node left, Node right) {
            this.k = k;
            this.v = v;
            this.left = left;
            this.right = right;
        }

        public Key getKey() {
            return this.k;
        }
    }
    public SymbolTable() {
        
    }

    public void put(Key k, Value v) {
        if (k < root.k) {
            Node temp = root;
            root = Node(k, v, temp, null);
        }
        //put it in the right place
    }

    public Value get(Key k) {
        //return the node with the key of k
    }

    public void delete(Key k) {

    }

    public Key floor(Key k) {
        Node x = floor(root, k);
        if (x == null) {
            return null;
        }
        return x.k;
    }

    private Node floor(Node x, Key k) {
        if (x == null) {
            return null;
        }

        int cmp = k.compareTo(x.k);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            return floor(x.left, k);
        }
        Node t = floor(x.right, k);
        if (t != null) {
            return t;
        }
        return x;
    }

    public Key ceiling(Key k) {

    }
}