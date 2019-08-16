import java.util.Arrays;

public class ArrayDeque<Type> {
    private Type[] a;
    private int size;

    public ArrayDeque() {
        a = null;
        size = 0;
    }

    public ArrayDeque(ArrayDeque other) {
        System.arraycopy(other, 0, a, 0, other.size);
    }


    public void addFirst(Type item) {
        Type[] b = (Type[]) new Object[size + 1];
        b[0] = item;
        if (size > 0) {
            System.arraycopy(a, 0, b, 1, size);
        }
        a = b;
        size++;
    }

    public void addLast(Type item) {
        Type[] b = (Type[]) new Object[size + 1];
        b[size] = item;
        if (size > 0) {
            System.arraycopy(a, 0, b, 0, size);
        }
        a = b;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
        System.out.println("\n");
    }

    public Type removeFirst() {
        if (size > 0) {
            size--;
            Type p = a[0];
            Type[] b = (Type[]) new Object[size];
            System.arraycopy(a, 1, b, 0, size);
            a = b;
            return p;
        } else return null;
    }

    public Type removeLast() {
        if (size > 0) {
            size--;
            Type p = a[size];
            Type[] b = (Type[]) new Object[size];
            System.arraycopy(a, 0, b, 0, size);
            a = b;
            return p;
        } else return null;
    }

    public Type get(int index) {
        return a[index];
    }


    public static void main(String[] args) {
        ArrayDeque a = new ArrayDeque();
        a.addLast(10);
        a.addFirst(12);
        a.addFirst(122);
        a.printDeque();
        System.out.println(a.removeLast());
        a.printDeque();
    }
}
