package EX2;

import java.util.ArrayList;

class SortedTableMap<K extends Comparable<K>, V> {

    class Entry {
        K key;
        V value;

        Entry(K k, V v) {
            key = k;
            value = v;
        }
    }

    private ArrayList<Entry> table = new ArrayList<>();

    private int findIndex(K key) {
        int low = 0, high = table.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = key.compareTo(table.get(mid).key);

            if (cmp == 0)
                return mid;
            else if (cmp < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public void put(K key, V value) {
        int j = findIndex(key);

        if (j < table.size() && table.get(j).key.equals(key)) {
            table.get(j).value = value;
        } else {
            table.add(j, new Entry(key, value));
        }
    }

    public V get(K key) {
        int j = findIndex(key);

        if (j < table.size() && table.get(j).key.equals(key))
            return table.get(j).value;

        return null;
    }

    // ✅ REQUIRED METHOD
    public boolean containKey(K key) {
        int j = findIndex(key);

        if (j < table.size() && table.get(j).key.equals(key))
            return true;

        return false;
    }
}
