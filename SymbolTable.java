public class SymbolTable <Key extends Comparable<Key>, Value> {
    Node root;//first node, first thing in the tree
    private class Node {
        Key k;
        Value v;
        Node left;
        Node right;

        public Node(Key k, Value v) {
            this.k = k;
            this.v = v;
			this.left = null;
			this.right = null;
        }
		
		private Node put(Node x, Key k, Value v) {
			if (x == null) {
				return new Node(k, v);
			}
			
			int cmp = k.compareTo(x.k);
			if (cmp > 0) {
				x.right = put(x.right, k, v);
			}
			if (cmp < 0) {
				x.left = put(x.left, k, v);
			}
			return x;
		}

        private Node select(Node x, int k) {
            if (x == null)
				return null;
        }
    }
	
	public Key select(int k) {
			return select(root, k);
		}

    public void put(Key k, Value v) {
		root = put(root, k, v);
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