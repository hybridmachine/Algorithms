package searching.symboltables.rbBST;
public class RedBlack<Key extends Comparable<Key>, Value>
{    
    private static final boolean RED    = true;
    private static final boolean BLACK  = false;

    private Node root;

    private class Node
    {
        Key key;
        Value val;
        Node left, right;
        int n;
        boolean color;

        public Node(Key key, Value val, int n, boolean color)
        {
            this.key = key;
            this.val = val;
            this.n = n;
            this.color = color;
        }
    }

    private boolean isRed(Node h)
    {
        if (h == null) return false;
        return h.color == RED;
    }

    private Node rotateLeft(Node h)
    {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = 1 + size(h.left)
                + size(h.right);
        return x;
    }

    private Node rotateRight(Node h)
    {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = 1 + size(h.left)
                + size(h.right);
        return x;
    }

    public int size()
    {
        return size(root);
    }

    private int size(Node x)
    {
        if (x == null) return 0;
        return x.n;
    }

    public Value get(Key key)
    {
        return get(root, key);
    }

    private Value get(Node x, Key key)
    {
        // Return value associate with key in the subtree rooted at x;
        // return null if key not present in subtree rooted at x;
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if          (cmp < 0) return get(x.left, key);
        else if     (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    public void put(Key key, Value val)
    {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val)
    {
        // Change key's value to val if key in subtree rooted at x.
        // Otherwise, add new node to subtree associating key with val.

    if (x == null) return new Node(key, val,1, RED);
    int cmp = key.compareTo(x.key);

    if      (cmp < 0) x.left = put(x.left, key, val);
    else if (cmp > 0) x.right = put(x.right, key, val);
    else x.val = val;

    x.n = size(x.left) + size(x.right) + 1;
    return x;
    }
}

