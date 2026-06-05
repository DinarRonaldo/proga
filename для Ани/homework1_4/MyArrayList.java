package proga.homework1_4;

public class MyArrayList<T> implements MyList<T> {
    private Object[] data;
    private int count;

    public MyArrayList() {
        this.data = new Object[10];
        this.count = 0;
    }

    @Override
    public void add(T item) {
        if (count == data.length) {
            int newCap = (int) (data.length * 1.5);
            Object[] newData = new Object[newCap];
            for(int i = 0; i < count; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        data[count] = item;
        count += 1;
    }

    public void add(int index, T item) {
        if (count == data.length) {
            int newCap = (int) (data.length * 1.5);
            Object[] newData = new Object[newCap];
            for(int i = 0; i < count; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = item;
        count += 1;
    }

    public T get(int index) {
        return (T) data[index];
    }

    public T remove(int index) {
        T temp = (T) data[index];
        for (int i = index; i < count - 1; i++) {
            data[i] = data[i + 1];
        }
        data[count - 1] = null; // дипсик сказал тут ошибка из за дублирования
        count -= 1;
        return temp;
    }

    public boolean remove(T item) {
        for (int i = 0; i < count; i++) {
            if (item.equals(data[i])) {
                remove(i);
                return true;
            } else {
                if (item == null) {
                    if (data[i] == null) {
                        remove(i);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        if (count == 0) { return true; }
        else { return false; }
    }

    public boolean contains(T item) {
        for (int i = 0; i < count; i++) {
            if (item.equals(data[i])) {
                return true;
            }
            }
        return false;
    }

    public void clear() {
        for(int i = 0; i < count; i++) {
            data[i] = null;
        }
        count = 0;
    }

    public int indexOf(T item) {
        for(int i = 0; i < count; i++) {
            if (item.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }
}
