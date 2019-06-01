package HASHING;

/**
 *
 * @author Julio Arriaga
 */
public class Entry<K, V> {

    K key;
    V value;
    boolean deleted;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        deleted = false;
    }

    public void delete() {
        deleted = true;
    }

    @Override
    public String toString() {
        return "(" + key + ": " + value + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Entry) {
            Entry e = (Entry) o;
            return this.key.equals(e.key);
        }
        return false;
    }

}