/**
 * Created by chen4393 on 3/7/17.
 */
public class Node<T> {
    // instance variables
    private T data;
    private Node next;

    // constructors
    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(T data) {
        this(data, null);
    }

    public Node() {
        this(null, null);
    }

    // getters and setters
    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static <T> void add(Node<T> list, T element) {
        Node newNode = new Node(element);
        while (list.getNext() != null) {
            list = list.next;
        }
        list.setNext(newNode);
    }

    public static <T> String toString(Node<T> list) {
        String s = "[";
        while (list.getNext() != null) {
            s += list.getData() + ", ";
            list = list.getNext();
        }
        s += list.getData() + "]";
        return s;
    }

    public static Node<Integer> xify(int[] x) {
        Node<Integer> header = new Node<Integer>(-1);
        for (int i = 0; i < x.length; i++) {
            int times = x[i];
            while (times-- > 0) {
                add(header, x[i]);
            }
        }
        return header;
    }

    public static int[] xify(Node<Integer> x) {
        int num = 0;
        Node<Integer> trailer = x;
        while (trailer != null) {
            num += (Integer)trailer.getData();
            trailer = trailer.getNext();
        }
        trailer = x;

        int[] ans = new int[num];
        int i = 0;
        while (trailer != null) {
            int times = (Integer)trailer.getData();
            while (times-- > 0) {
                ans[i++] = (Integer)trailer.getData();
            }
            trailer = trailer.getNext();
        }
        return ans;
    }
}
