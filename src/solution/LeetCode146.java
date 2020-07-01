package solution;

import java.util.HashMap;
import java.util.Map;

public class LeetCode146 {
    // wo shi SB , xiele bantian haishi you bug
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(7, 28);
        lruCache.put(7, 1);
        lruCache.put(8, 15);
        lruCache.get(6);
        lruCache.put(10, 27);
        lruCache.put(8, 10);
        lruCache.get(8);
        lruCache.put(6, 29);
        lruCache.put(1, 9);
        lruCache.get(6);
        lruCache.put(10, 7);
        lruCache.get(1);
        lruCache.get(2);
        lruCache.get(13);
        lruCache.put(8, 30);
        lruCache.put(1, 5);
        lruCache.get(1);
        lruCache.put(13, 2);
        lruCache.get(12);

//        lruCache.put(2, 1);
//        lruCache.put(2, 2);
//        lruCache.get(2);
//        lruCache.put(1, 1);
//        lruCache.put(4, 1);
//        lruCache.get(2);
    }

    public static class LRUCache {
        Integer capacity;
        Integer currentLength;
        int[] lru;
        Map<Integer, Integer> map;


        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.currentLength = 0;
            this.lru = new int[capacity];
            this.map = new HashMap<>();
        }

        public int get(int key) {
            if (this.map.containsKey(key)) {
                updateLRU(key, false);
                return map.get(key);
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (!this.map.containsKey(key)) {
                if (this.map.keySet().size() == this.capacity) {
                    int removeKey = this.lru[this.capacity - 1];
                    this.map.remove(removeKey);
                }
                this.updateLRU(key, true);
            } else {
                this.updateLRU(key, false);
            }
            this.map.put(key, value);
        }

        private void updateLRU(int key, boolean newKey) {
            if (newKey) {
                if (currentLength == capacity) {
                    this.updateLRU(capacity - 1, 0);
                    this.lru[0] = key;
                } else {
//                    this.updateLRUDec();
                    this.lru[capacity - 1 - currentLength] = key;
                    currentLength++;
                }
            } else {
                int location = getLocation(key);
                this.updateLRU(location, capacity - currentLength);
                this.lru[capacity - currentLength] = key;
            }
        }

        private void updateLRUDec() {
            for (int i = capacity - currentLength; i < capacity; i++) {
                this.lru[i - 1] = this.lru[i];
            }
        }

        private void updateLRU(int start, int end) {
            for (int i = start; i > end; i--) {
                this.lru[i] = this.lru[i - 1];
            }
        }

        private int getLocation(int target) {
            int result = 0;
            while (this.lru[result] != target) {
                result++;
            }

            return result;
        }
    }
}
