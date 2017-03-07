/**
 * Created by chen4393 on 3/7/17.
 */
public class test {
    public static <T> void printArray(T[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        /*
        Pair p1 = new Pair(1, 2);
        Pair p2 = new Pair(new Dog("Alice"), new Dog("Bob"));
        Pair p3 = new Pair(3.14, 2.718);

        //Dog alice1 = p2.getLeft(); // won’t compile since getLeft() returns an Object
        Dog alice2 = (Dog) p2.getLeft(); // OK, this works, but it’s annoying
        //System.out.println(alice2.name);
        //p2.setLeft(new Cat("Charlie")); // wait what
        Dog bob = (Dog) p2.getLeft(); // this compiles, but at runtime I get an exception??!?!one?eleven!?
        //System.out.println(bob.name);
        */

        /*
        Pair<Integer> p1 = new Pair<Integer>(1, 2);
        Pair<Dog> p2 = new Pair<Dog>(new Dog("Alice"), new Dog("Bob"));
        Pair<Double> p3 = new Pair<Double>(3.14, 2.718);
        Dog alice = p2.getLeft(); // works just fine, as we’d expect. Hooray!
        //p2.setLeft(new Cat("Charlie")); // this doesn’t compile, just like we expect it too. Yippie!
        Dog bob = (Dog) p2.getLeft(); // this doesn’t compile either. Woo!
        System.out.println(bob.name);

        Integer[] a = {1, 2, 3, 4, 5};
        printArray(a);
        */
/*
        Node<String> header = new Node<String>("head");
        //Node<String> n1 = new Node<String>("abc");
        //Node<String> n2 = new Node<String>("xyz");
        //Node<String> n3 = new Node<String>("lmnop");
        //header.setNext(n1);
        //n1.setNext(n2);
        //n2.setNext(n3);
        Node.add(header, "abc");
        Node.add(header, "xyz");
        Node.add(header, "lmnop");

        System.out.println(Node.toString(header.getNext()));
*/
        int[] x = {4, 2, 3};
        Node<Integer> header = Node.xify(x);
        System.out.println(Node.toString(header.getNext()));

        Node<Integer> header2 = new Node<Integer>(-1);
        Node.add(header2, 4);
        Node.add(header2, 2);
        Node.add(header2, 3);
        // header2 --> 4 --> 2 --> 3 --> null
        int[] a = Node.xify(header2.getNext());
        for (int i : a)
            System.out.print(i + "\t");
        System.out.println();
    }
}
