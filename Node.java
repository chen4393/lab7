/**
 * Created by chen4393 on 3/7/17.
 */
import java.util.Random;

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

    public static <T> Node<T> reverse(Node<T> list) {
        /*
        Node prev = null;
        Node current = list;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        list = prev;
        return list;
        */
        Node node = null;
        Node oldNode = null;
        while (list != null) {
            node = new Node(list.getData());
            node.setNext(oldNode);
            oldNode = node;
            list = list.getNext();
        }
        return node;
    }

    public static <T> Node<T> shuffle(Node<T> list) {
        Node<T> copyList = copy(list);
        copyList = shuffleInPlace(copyList);
        return copyList;
    }

    public static <T> Node<T> copy(Node<T> list) {
        Node<T> head = new Node(-1);
        while (list != null) {
            add(head, (T)list.getData());
            list = list.getNext();
        }
        return head.getNext();
    }

    public static <T> Node<T> shuffleInPlace(Node<T> list) {
        int n = 0;  // size
        Node<T> trailer = list;
        while (trailer != null) {
            n++;
            trailer = trailer.getNext();
        }
        Random random = new Random();
        //random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(list, i, change);
            System.out.println("swap " + i + " and " + change);
        }
        return list;
    }

    public static <T> void swap(Node<T> list, int i, int change) {
        Object helper = getFromIndex(list, i);
        setFromIndex(list, i, getFromIndex(list, change));
        setFromIndex(list, change, helper);
    }

    public static <T> Object getFromIndex(Node<T> list, int i) {
        while (i > 0) {
            list = list.getNext();
            i--;
        }
        return list.getData();
    }

    public static <T> void setFromIndex(Node<T> list, int i, Object obj) {
        while (i > 0) {
            list = list.getNext();
            i--;
        }
        list.setData((T)obj);
    }
}