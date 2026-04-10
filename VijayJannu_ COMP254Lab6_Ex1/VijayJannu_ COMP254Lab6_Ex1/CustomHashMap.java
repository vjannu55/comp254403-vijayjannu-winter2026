package EX1;

import java.util.LinkedList;

class CustomHashMap<K, V> {

    class Entry {
        K key;
        V value;

        Entry(K k, V v) {
            key = k;
            value = v;
        }
    }

    private LinkedList<Entry>[] table;
    private int capacity;
    private int size;
    private double loadFactor;

    public CustomHashMap(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        table = new LinkedList[capacity];
        size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);

        if (table[index] == null)
            table[index] = new LinkedList<>();

        for (Entry e : table[index]) {
            if (e.key.equals(key)) {
                e.value = value;
                return;
            }
        }

        table[index].add(new Entry(key, value));
        size++;

        if ((double) size / capacity > loadFactor) {
            resize();
        }
    }

    public V get(K key) {
        int index = hash(key);

        if (table[index] != null) {
            for (Entry e : table[index]) {
                if (e.key.equals(key)) {
                    return e.value;
                }
            }
        }
        return null;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        LinkedList<Entry>[] oldTable = table;

        table = new LinkedList[newCapacity];
        capacity = newCapacity;
        size = 0;

        for (LinkedList<Entry> bucket : oldTable) {
            if (bucket != null) {
                for (Entry e : bucket) {
                    put(e.key, e.value);
                }
            }
        }
    }

    public int size() {
        return size;
    }
}