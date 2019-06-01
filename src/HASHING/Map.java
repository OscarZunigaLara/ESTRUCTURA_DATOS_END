package HASHING;
/**
 *
 * @author Julio Arriaga
 */
public interface Map<K, V> {

    /**
     * Agrega el valor dado asociado a la llave
     *
     * @param key la llave
     * @param value el valor
     */
    void add(K key, V value);

    /**
     * Regresa el valor asociado a la llave
     *
     * @param key la llave del valor buscado
     * @return el valor asociado a la llave
     *
     * Arroja un NoSuchElementException en caso de que no exista la llave
     */
    V get(K key);

    /**
     * Elimina el valor asociado a la llave
     *
     * @param key la llave del valor buscado
     * @return el valor asociado a la llave
     *
     * Arroja un NoSuchElementException en caso de que no exista la llave
     */
    V delete(K key);

}