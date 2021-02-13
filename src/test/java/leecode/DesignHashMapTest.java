package leecode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DesignHashMapTest {
  class MyHashMap {

    class Bucket {
      private List<Map.Entry<Integer, Integer>> bucket;

      public Bucket() {
        this.bucket = new LinkedList<>();
      }

      public Integer get(Integer key) {
        for (Map.Entry<Integer, Integer> entry : this.bucket) {
          if (entry.getKey().equals(key))
            return entry.getValue();
        }
        return -1;
      }

      public void update(Integer key, Integer value) {
        boolean found = false;
        for (Map.Entry<Integer, Integer> entry : this.bucket) {
          if (entry.getKey().equals(key)) {
            entry.setValue(value);
            found = true;
          }
        }
        if (!found)
          this.bucket.add(new AbstractMap.SimpleEntry<>(key, value));
      }

      public void remove(Integer key) {
        for (Map.Entry<Integer, Integer> entry : this.bucket) {
          if (entry.getKey().equals(key)) {
            this.bucket.remove(entry);
            break;
          }
        }
      }
    }


    private int capacity;
    private Bucket[] buckets;

    /** Initialize your data structure here. */
    public MyHashMap() {
      this.capacity = 2069;
      this.buckets = new Bucket[this.capacity];
      for (int i = 0; i < this.capacity; ++i) {
        this.buckets[i] = new Bucket();
      }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
      int index = key % this.capacity;
      this.buckets[index].update(key, value);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
     * for the key
     */
    public int get(int key) {
      int index = key % this.capacity;
      return this.buckets[index].get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
      int index = key % this.capacity;
      this.buckets[index].remove(key);
    }
  }

  @Test
  void myHashMapTest(){
    MyHashMap hashMap = new MyHashMap();
    hashMap.put(1, 1);
    hashMap.put(2, 2);
    assertEquals(1, hashMap.get(1));
    assertEquals(-1, hashMap.get(3));
    hashMap.put(2, 1);
    assertEquals(1, hashMap.get(2));
    hashMap.remove(2);
    assertEquals(-1, hashMap.get(2));
  }
}
