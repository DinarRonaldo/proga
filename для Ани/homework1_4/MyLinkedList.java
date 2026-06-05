package proga.homework1_4;

public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        if (head == null) {
            head = new Node<>(item);
        } else {
            Node<T> node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<>(item);
        }
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (index == 0) {
            Node<T> newN = new Node<>(item);
            newN.next = head;
            head = newN;
        } else {
            Node<T> node = head;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            Node<T> newN = new Node<>(item);
            newN.next = node.next;
            node.next = newN;
        }
        size++;
    }

    @Override
    public T get(int index) {
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    @Override
    public T remove(int index) {
        Node<T> node = head;
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        Node<T> newN = node.next;
        T data = newN.data;
        node.next = newN.next;
        size--;
        return data;
    }

    @Override
    public boolean remove(T item) {
        if (head != null && head.data.equals(item)) {
            head = head.next;
            size--;
            return true;
        }
        Node<T> node = head;
        while (node.next != null) {
            if (node.next != null && node.next.data.equals(item)) {
                node.next = node.next.next;
                size--;
                return true;
            } else {
                node = node.next;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) { return true; }
        else { return false; }
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean contains(T item) {
        Node<T> node = head;
        while (node != null) {
            if (node.data.equals(item)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public int indexOf(T item) {
        Node<T> node = head;
        int index = 0;
        while (node != null) {
            if (node.data.equals(item)) {
                return index;
            }
            node = node.next;
            index += 1;
        }
        return -1;
    }
}
