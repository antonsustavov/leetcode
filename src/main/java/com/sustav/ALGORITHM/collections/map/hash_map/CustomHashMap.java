package com.sustav.ALGORITHM.collections.map.hash_map;

public class CustomHashMap<K, V> {
  private static final int DEFAULT_INITIAL_CAPACITY = 16;
  private static final float DEFAULT_LOAD_FACTOR = 0.75f;
  private Entry<K, V>[] table = new Entry[DEFAULT_INITIAL_CAPACITY];

  private static class Entry<K, V> {
    private final K key;
    private V value;
    private Entry<K, V> next;

    public Entry(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  public void put(K key, V value) {
    if (key == null) {
      throw new RuntimeException("key is null");
    }

    int hash = key.hashCode();
    int index = hash % DEFAULT_INITIAL_CAPACITY;

    Entry<K, V> newEntry = new Entry<>(key, value);

    if (table[index] == null) {
      table[index] = newEntry;
    } else {
      Entry<K, V> current = table[index];
      while (current.next != null) {
        if (current.key.equals(key)) {
          current.value = value;
          return;
        }
        current = current.next;
      }

      current.next = newEntry;
    }
  }

  public V get(K key) {
    if (key == null) {
      throw new RuntimeException("key is null");
    }

    int hash = key.hashCode();
    int index = hash % DEFAULT_INITIAL_CAPACITY;

    Entry<K, V> current = table[index];

    while (current.next != null) {
      if (current.key.equals(key)) {
        return current.value;
      }
      current = current.next;
    }

    return null;
  }
}
