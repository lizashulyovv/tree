import java.util.*;

public class Tree1 implements Collection<Integer> {

    static class Node {
        int value;
        Node left, right;
        Node(int value) { this.value = value; }
    }

    private Node root;
    private int size = 0;


    public boolean add(Integer value) {
        if (root == null) root = new Node(value);
        else addNode(root, value);
        size++;
        return true;
    }

    private void addNode(Node current, int value) {
        if (value < current.value) {
            if (current.left == null) current.left = new Node(value);
            else addNode(current.left, value);
        } else {
            if (current.right == null) current.right = new Node(value);
            else addNode(current.right, value);
        }
    }


    public boolean remove(Object o) {
        int before = size;
        root = removeNode(root, (Integer)o);
        return size < before;
    }

    private Node removeNode(Node current, int value) {
        if (current == null) return null;

        if (value < current.value) current.left = removeNode(current.left, value);
        else if (value > current.value) current.right = removeNode(current.right, value);
        else {
            size--;

            if (current.left == null) return current.right;
            if (current.right == null) return current.left;

            Node min = current.right;
            while (min.left != null) min = min.left;
            current.value = min.value;
            current.right = removeNode(current.right, min.value);
        }
        return current;
    }

    public Iterator<Integer> iterator() {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list.iterator();
    }

    private void traverse(Node node, List<Integer> list) {
        if (node == null) return;
        traverse(node.left, list);
        list.add(node.value);
        traverse(node.right, list);
    }


    @Override public int size() { return size; }
    @Override public boolean isEmpty() { return size == 0; }
    @Override public void clear() { root = null; size = 0; }


    @Override public boolean contains(Object o) { return false; }
    @Override public Object[] toArray() { return new Object[0]; }
    @Override public <T> T[] toArray(T[] a) { return null; }
    @Override public boolean containsAll(Collection<?> c) { return false; }
    @Override public boolean addAll(Collection<? extends Integer> c) { return false; }
    @Override public boolean removeAll(Collection<?> c) { return false; }
    @Override public boolean retainAll(Collection<?> c) { return false; }
    
}