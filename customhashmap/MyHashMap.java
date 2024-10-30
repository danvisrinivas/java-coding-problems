package customhashmap;

public class MyHashMap<K, V> {

    private int DEFAULT_BUCKET_COUNT = 10;

    private Entry<K, V>[] buckets;

    public MyHashMap() {
        buckets = new Entry[DEFAULT_BUCKET_COUNT];
    }

    public MyHashMap(int capacity) {
        buckets = new Entry[capacity];
    }

    public V get(K key) {
        throwIfKeyNull(key);
        Entry<K, V> entry = buckets[bucketIndexForKey(key)];
        while (entry != null && !key.equals(entry.getKey())) {
            entry = entry.getNext();
        }
        return entry != null ? entry.getValue() : null;
    }

    public void put(K key, V value) {
        throwIfKeyNull(key);

        Entry<K, V> entry = buckets[bucketIndexForKey(key)];
        System.out.println("Entry:" + entry);

        while (entry != null) {
            if (key.equals(entry.getKey())) {
                entry.setValue(value);
                return;
            } else if (entry.getNext() == null) {
                entry.setNext(new Entry<>(key, value));
                return;
            }
            entry = entry.getNext();
        }

        // If no entry was found, insert a new one
        buckets[bucketIndexForKey(key)] = new Entry<>(key, value);
    }

    public int bucketIndexForKey(K key) {
        return key.hashCode() % buckets.length;
    }

    private void throwIfKeyNull(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key may not be null");
        }
    }

    static class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }
}
