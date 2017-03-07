/**
 * Created by chen4393 on 3/7/17.
 */
/*
public class Pair {
    private Object left;
    private Object right;
    public Pair(Object a, Object b) {
        left = a;
        right = b;
    }
    public void setLeft(Object left) {this.left = left;}
    public void setRight(Object right) {this.right = right;}
    public Object getLeft() {return left;}
    public Object getRight() {return right;}
}
*/
public class Pair<T> {
    private T left;
    private T right;
    public Pair(T a, T b) {
        left = a;
        right = b;
    }
    public void setLeft(T left) {this.left = left;}
    public void setRight(T right) {this.right = right;}
    public T getLeft() {return left;}
    public T getRight() {return right;}
}
