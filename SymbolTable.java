public class SymbolTable <Key extends Comparable<Key>, Value> {
    Node root;//first node, first thing in the tree
    private class Node {
        Key k;
        Value v;
        Node left;
        Node right;
		int size;

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
		
		private int size(Node x) {
			//give size of tree x
		}
		
		private Node deleteMin(Node x) {
			if (x == null)
				return null;
			if (x.left == null)//x is minimum
				return x.right;
			x.left = deleteMin(x.left);
			x.size = size(x.left) + size(x.right) + 1;
			return x;
		}
		
		private Node delete(Node x, Key k) {
			if (x == null)
				return null;
			int cmp = k.compareTo(x.key);
			if (cmp < 0) 
				x.left = delete(x.left, k);
			else if (cmp > 0)
				x.right = delete(x.right, k);
			else {
				if (x.left == null)
					return x.right;
				if (x.right == null)
					return x.left;
				Node t = x;
				x = min(t.right);
				x.right = deleteMin(t.right);
				x.left = t.left;
			}
			x.size = size(x.left) + size(x.right) + 1;
			return x;
			}
		}
		
		private void keys(Node x, Queue<Key> q, Key lo, Key hi) {//change to arraylist
			if (x == null)
				return;
			int cmplo = lo.compareTo(x.key);
			int cmphi = hi.compareTo(x.key);
			if (cmplo < 0) 
				keys(x.left, q, lo, hi);
			if (cmplo <= 0 && cmphi >= 0)
				q.enqueue(x.key);
			if (comphi > 0)
				keys(x.right, q, lo, hi);
		}
    }
	
	public Iterable<Key> keys(Key min, Key max) {//range search
		Queue<Key> q = new Queue<Key>();
		keys(root, q, min, max);
		return q;
	}
	
	public Iterable<Key> keys() {//range search
		return keys(min(), max());
	}
	
	public void delete(Key k) {
		root = delete(root, k);
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
	
	public void deleteMin() {
		root = delMin(root);
	}
}