package task123456;

public class HashTable<K, V> {
    private SingleLinkedList<K, V>[] baskets;
    private int basketsCount;
    private long countData;

    public HashTable() {
        this(100);
    }

    public HashTable(int basketsCount) {
        basketsCount = Math.max(basketsCount, 10);
        this.basketsCount = basketsCount;
        init();
    }

    private void init() {
        baskets = new SingleLinkedList[basketsCount];
        for (int i = 0; i < basketsCount; i++)
            baskets[i] = new SingleLinkedList<>();
        countData = 0;
    }

    private int getIndex(K key) {
        return key.hashCode() % basketsCount;
    }

    public boolean add(K key, V value) {
        if (countData >= (long) (0.75*basketsCount)) refactoring();
        if (baskets[getIndex(key)].push(key, value)) {
            countData++;
            return true;
        }
        return false;
    }

    private void refactoring() {
        SingleLinkedList<K, V>[] basketsOld = baskets;

        basketsCount *= 2;
        init();
        for (SingleLinkedList<K, V> basket : basketsOld) {
            Node<K, V> node;
            while ((node = basket.pop()) != null) add(node.key, node.value);
        }
    }

    public boolean deleteByKey(K key) {
        if (baskets[getIndex(key)].deleteByKey(key)) {
            countData--;
            return true;
        }
        return false;
    }

    public boolean deleteByValue(V value) {
        long countD = 0;
        for (SingleLinkedList<K, V> basket : baskets) countD += basket.deleteByValue(value);
        countData -= countD;
        return countD > 0;
    }

    public V getValue(K key) {
        return baskets[getIndex(key)].getValue(key);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("HashTable (count:" + countData +", width = " + basketsCount +"):\n");
        for (SingleLinkedList<K, V> basket : baskets)  if (!basket.isEmpty()) stringBuilder.append(basket);
        return stringBuilder.toString();
    }
}
