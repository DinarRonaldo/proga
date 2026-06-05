package proga.homework1_5;

public class MyHashSetImpl<T> implements MyHashSet<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private MyArrayList<T>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashSetImpl() {
        buckets = new MyArrayList[DEFAULT_CAPACITY];
        size = 0;
    }

    private int getBucketIndex(T item) {
        return Math.abs(item.hashCode() % buckets.length);
    }

    @Override
    public boolean add(T item) {
        if (contains(item)) return false;

        int index = getBucketIndex(item);
        if (buckets[index] == null) {
            buckets[index] = new MyArrayList<>();
        }
        buckets[index].add(item);
        size++;

        if (size > buckets.length * LOAD_FACTOR) {
            resize();
        }
        return true;
    }

    @Override
    public boolean contains(T item) {
        int index = getBucketIndex(item);
        if (buckets[index] == null) return false;
        for (int i = 0; i < buckets[index].size(); i++) {
            if (buckets[index].get(i).equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(T item) {
        int index = getBucketIndex(item);
        if (buckets[index] == null) return false;
        for (int i = 0; i < buckets[index].size(); i++) {
            if (buckets[index].get(i).equals(item)) {
                buckets[index].remove(i);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        MyArrayList<T>[] oldBuckets = buckets;
        buckets = new MyArrayList[oldBuckets.length * 2];
        size = 0;

        for (MyArrayList<T> bucket : oldBuckets) {
            if (bucket != null) {
                for (int i = 0; i < bucket.size(); i++) {
                    add(bucket.get(i));
                }
            }
        }
    }
}