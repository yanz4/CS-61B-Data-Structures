public class LinkedListDeque<Type> {
    class Node {
        private Type item;
        Node next;
        Node previous;

        public Node(Type x) {
            item = x;
        }

    }


    private int size;
    private Node sentinel;


    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null);
        sentinel.next = sentinel;
        sentinel.previous = sentinel;
    }

    public LinkedListDeque(LinkedListDeque other) {
        size = 0;
        sentinel = new Node(null);
        sentinel.next = sentinel;
        sentinel.previous = sentinel;
        for (int i = 0; i < other.size(); i++) {
            this.addLast((Type) other.get(i));
        }

    }

    public void addFirst(Type x) {
        size++;
        Node a = new Node(x);
        a.next = sentinel.next;
        sentinel.next.previous = a;
        sentinel.next = a;
        a.previous = sentinel;
        if (sentinel.previous == sentinel) sentinel.previous = a;

    }

    public void addLast(Type x) {
        size++;
        Node a = new Node(x);
        a.previous = sentinel.previous;
        sentinel.previous.next = a;
        a.next = sentinel;
        sentinel.previous = a;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel;
        while (p.next != sentinel) {
            System.out.print(p.next.item);
            System.out.print(" ");
            p = p.next;
        }
        System.out.println("\n");
    }

    public Type removeFirst() {
        Type p = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.previous = sentinel;
        if(size>0) size--;
        return p;
    }

    public Type removeLast() {
        Type p = sentinel.previous.item;
        sentinel.previous = sentinel.previous.previous;
        sentinel.previous.next = sentinel;
        if(size>0) size--;
        return p;
    }

    public Type get(int index) {
        Node p = sentinel;
        for (int i = 0; i <= index; i++) {
            p = p.next;
            if (p == sentinel) return null;

        }
        return p.item;
    }

    public Type getRecursive(int index) {
        if (index >= this.size()) {
            return null;
        } else {
            if (index == 0) {
                return (Type) this.sentinel.next.item;
            } else {
                LinkedListDeque p = new LinkedListDeque(this);
                p.removeFirst();
                return (Type) p.getRecursive(index - 1);
            }
        }

    }

    public static void main(String[] args) {
        LinkedListDeque a = new LinkedListDeque();
        a.addFirst(3.64);
        a.addLast("a");
        a.addFirst("adfadsfa");
        a.addFirst(1);
        a.printDeque();

        System.out.println(a.getRecursive(12));


    }


}
