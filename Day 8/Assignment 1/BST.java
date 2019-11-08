import java.util.*;

import javafx.scene.Node;
public class BST<Key extends Comparable<Key>, Value> {
    Node root;
    public class Node {
        Key key;
        Value val;
        Node left;
        Node right;
        int count;
   }
   public Node(Key key, Value val) {
       this.key = key;
       this.val = val;
       count = 0;
       left = null;
       right = null;
   }
   public int size(Node x) {
       if (x == null) {
           return 0;
       } else {
           return x.count;
       }
   }
   public void put(Key key, Value val) {
       root = put(x, key, val);
   }
   private Node put(Node x, Key key, Value val) {
       if (x == null) {
           return new Node(key, val);
       }
       int cmp = key.compareTo(x.key);
       if (cmp < 0) {
           x.left = put(x.left, key, val);
       } else if(cmp > 0) {
           x.right = put(x.right, key, val);
       } else {
           x.val = val;
       }
       x.count = 1 + size(x.left) + size(x.right);
       return x;
   }
   public Value get(Key key) {
       Node x = root;
       while (x != null) {
           int cmp = key.compareTo(x.key);
           if (cmp < 0) {
               x = x.left;
           } else if(cmp > 0) {
               x = x.right;
           } else {
               return x.val;
           }
       }
       return null;
   }
   public key min() {
       return min(x.left).key;
   }
   public Node min(Node x) {
       if (x.left == null) {
           return x;
       } else {
           return min(x.left);
       }
   }
   public key max() {
        return max(x.right).key;
   }
   public Node max(Node x) {
       if (x.right == null) {
           return x;
       } else {
           return max(x.right);
       }
   }
   public Key floor(Key key) {
       Node x = floor(root, key);
       if(x == null) {
            return null;
       }
       return x.key;
   }
   private Node floor(Node x, Key key) {
       if (x == null) {
           return null;
       }
       int cmp = key.compareTo(x.key);
        if (cmp < 0) {
           return floor(x.left, key);
       } else if(cmp > 0) {
           Node t = floor(x.right, key);
           if(t != null) {
               return t;
           } else {
               return x;
           }
       } else {
           return x;
       }
   }
   public key ceiling(Key key) {
       Node x = ceiling(root, key);
       if(x == null) {
           return null;
       }
       return x.key;
   }
   private Node ceiling(Node x, Key key) {
       if (x == null) {
           return null;
       }
       int cmp = key.compareTo(x.key);
       if (cmp < 0) {
           Node t = ceiling(x.left, key);
           if(t != null) {
               return t;
           } else {
               return x;
           }
       } else if(cmp > 0) {
           return ceiling(x.right, key);
       } else {
           return x;
       }
   }
   public int rank(Key key) {
       Node x = rank(key, root);
       if(x == null) {
           return 0;
       }
       return rank(key, root);
   }
   private int rank(Key key, Node x) {
       if(x == null) {
           return 0;
       }
       int cmp = key.compareTo(x.key);
       if(cmp < 0) {
           return rank(key, x.left);
       } else if(cmp > 0) {
           return 1 + size(x.left) + rank(key, x.right);
       } else {
           return size(x.left);
       }
   }
   public key select(int k) {
       Node x = select(root, k);
       return x.key;
   }
   private Node select(Node x, int k) {
       if(x == null) {
           return null;
       }
       int t = size(x.left);
       if(t > k) {
           return select(x.left, k);
       } else if(t < k) {
           return select(x.right, k);
       } else {
           return x;
       }
   }
   public void delete(Key key) {
    root = delete(root, key);
   }
   private Node delete(Node x, Key key) {
       if (x == null) {
           return null;
       }
       int cmp = key.compareTo(x.key);
       if(cmp < 0) {
           x.left = delete(x.left, key);
       } else if(cmp > 0) {
           x.right = delete(x.right, key);
       } else {
           if(x.left == null) {
               return x.left;
           }
           if(x.right == null) {
               return x.right;
           }
           Node t = x;
           x = min(t.right);
           x.right = deleteMin(t.right);
           x.left = t.left;
       }
       x.size = size(x.left) + size(x.right) + 1;
       return x;
   }
   public void deleteMin() {
    root = deleteMin(root);
   }
   private Node deleteMin(Node x) {
        if(x.left == null) {
            return x.right;
       }
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
   }
   public void deleteMax() {
       root = deleteMin(root);
   }
   private Node deleteMax(Node x) {
       if(x.right == null) {
           return x.left;
       }
       x.right = deleteMax(x.right);
       x.size = size(x.left) + size(x.right) + 1;
       return x;
   }
}