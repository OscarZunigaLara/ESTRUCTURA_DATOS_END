package HASHING;

import java.util.NoSuchElementException;

/**
 *
 * @author Julio Arriaga
 */
public class OAMap<K, V> implements Map<K, V> {

    private Entry<K, V>[] map;
    private double numElements;

    public OAMap(int size) {
        map = new Entry[size];
        numElements = 0;
    }

    @Override
    public void add(K key, V value) {
        int hash = hash(key);
        int position = hash;
        Entry<K, V> e = new Entry(key, value);
        int i = 0;
        try {
            get(key);
        } catch (NoSuchElementException ex) {
            do {
                if (map[position] == null || map[position].deleted) {
                    map[position] = e;
                    numElements++;
                    break;
                } else {
                    i++;
                    position = getNext(hash, i);
                }
            } while (hash != position && i < map.length);
            if (loadFactor() > 0.5) {
                resize();
            }
        }
    }

    private void resize() {
        Entry<K, V>[] oldMap = map; // guardamos una referencia al viejo arreglo
        map = new Entry[PrimeGenerator.getNextPrime(oldMap.length*2)]; // creamos un nuevo arreglo mas grande y lo asignamos al atributo map
        for (Entry<K, V> e : oldMap) { // por cada Entry en el viejo arreglo
            if (e != null && !e.deleted) { // si el Entry no es null ni borrado (es decir es una entrada existente)
                add(e.key, e.value); // agregamos la llave y valor al mapa (podriamos implementar un metodo reAdd que fuera mas eficiente como en CHashMap)
            }
        }
    }

    private double loadFactor() {
        return numElements / map.length;
    }

    private int getNext(int h, int i) {
        int step = 1;
        return (int)(h + Math.pow(i, 2)) % map.length;
    }

    private int hash(K key) {
        return key.hashCode() % map.length;
    }

    @Override
    public V get(K key) {
        int hash = hash(key);
        int position = hash;
        int i = 0;
        while (map[position] != null) {
            if (!map[position].deleted && map[position].equals(new Entry(key, null))) {
                return map[position].value;
            }
            i++;
            position = getNext(hash, i);
            if (position == hash || i > map.length) {
                break;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public V delete(K key) {
        int hash = hash(key);
        int position = hash;
        int i = 0;
        while (map[position] != null) {
            if (map[position].equals(new Entry(key, null))) {
                map[position].delete();
                numElements--;
                return map[position].value;
            }
            i++;
            position = getNext(hash, i);
            if (position == hash || i > map.length) {
                break;
            }
        }
        throw new NoSuchElementException();

    }

    @Override
    public String toString() {
        String mapS = "OAMap{";
        for (Entry<K, V> e : map) {
            if (e != null && !e.deleted) {
                mapS += e.toString() + " ";
            }
        }
        return mapS + '}';
    }

}
