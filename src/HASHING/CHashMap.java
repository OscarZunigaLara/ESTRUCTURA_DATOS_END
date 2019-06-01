package HASHING;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 *
 * @author Julio Arriaga
 * @param <K> The type of key
 * @param <V> The type of value
 */
public class CHashMap<K, V> implements Map<K, V> {

    private LinkedList<Entry<K, V>>[] buckets; // arreglo de cubetas, cada cubeta es una lista ligada de Entry
    private int numBuckets; // el numero de cubetas
    private double numElements; // el numero de elementos actuales en el mapa

    public CHashMap(int numBuckets) {
        buckets = new LinkedList[numBuckets];
        this.numBuckets = numBuckets;
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new LinkedList<>(); // inicializa cada cubeta como una lista vacia
        }
        numElements = 0;
    }

    private double loadFactor() {
        return numElements / numBuckets;
    }

    @Override
    public void add(K key, V value) {
        int h = hash(key);
        Entry<K, V> newE = new Entry<>(key, value);
        if (!contains(newE, h)) { // solo agregamos el nuevo elemento si no existe uno con la misma llava en el mapa
            buckets[h].add(newE);
            numElements++;
        }
        if (loadFactor() > 1) {
            resize();
        }
    }

    private void resize() {
        numBuckets = PrimeGenerator.getNextPrime(numBuckets*2); // calcula nuevo tamano
        LinkedList<Entry<K, V>>[] newBuckets = new LinkedList[numBuckets]; // crea un nuevo arreglo de cubetas
        for (int i = 0; i < newBuckets.length; i++) {
            newBuckets[i] = new LinkedList<>(); // inicializa cada cubeta
        }
        for (LinkedList<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> e : bucket) {
                reAdd(newBuckets, e.key, e.value); // pasa cada elemento del mapa chico al mapa mas grande
            }
        }
        buckets = newBuckets; // actualiza la referencia del atributo buckets al mapa mas grande
    }

    // Metodo especial para reagregar elementos al mapa agrandado
    // Similar al add tradicional, pero no revisa si ya existe la llave ni
    // calcula factor de carga para ser mas eficiente
    
    private void reAdd(LinkedList<Entry<K, V>>[] newBuckets, K key, V value) {
        int h = hash(key);
        newBuckets[h].add(new Entry(key, value));
    }

    private boolean contains(Entry<K, V> e, int h) {
        for (int i = 0; i < buckets[h].size(); i++) {
            if (e.equals(buckets[h].get(i))) {
                return true;
            }
        }
        return false;
    }

    private int hash(K key) {
        return key.hashCode() % numBuckets;
    }

    @Override
    public V get(K key) {
        int h = hash(key);
        for (int i = 0; i < buckets[h].size(); i++) {
            if (key.equals(buckets[h].get(i).key)) {
                return buckets[h].get(i).value;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public V delete(K key) {
        int h = hash(key);
        for (int i = 0; i < buckets[h].size(); i++) {
            if (key.equals(buckets[h].get(i).key)) {
                numElements--;
                return buckets[h].remove(i).value;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public String toString() {
        return "CHashMap{" + "buckets=" + Arrays.toString(buckets) + '}';
    }

}
