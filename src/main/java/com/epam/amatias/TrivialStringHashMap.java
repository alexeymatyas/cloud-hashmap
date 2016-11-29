package com.epam.amatias;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alexey on 28.11.2016.
 */
public class TrivialStringHashMap {
    private static final int DEFAULT_CAPACITY = 8;

    List<List<Entry>> buckets;
    List<Entry> entries;

    public TrivialStringHashMap() {
        create(DEFAULT_CAPACITY);
    }

    public void put(String key, String value) {
        int hash = getHash(key);
        int index = getIndex(hash);
        List<Entry> bucket = buckets.get(index);

        if(bucket == null) {
            // Nothing at position
            List<Entry> newBucket = new LinkedList<>();
            Entry newEntry = new Entry(key, value);
            newBucket.add(newEntry);
            buckets.set(index, newBucket);
            entries.add(newEntry);
        } else {
            if(bucket.get(0).getHash() == hash) {
                // Something with same hash at position...
                boolean isInBucket = false;
                for(Entry e: bucket) {
                    if(e.getKey().equals(key)) {
                        // ... and same key -> updating existing entry
                        isInBucket = true;
                        e.setValue(value);
                        break;
                    }
                }
                if(!isInBucket) {
                    //... with key not present in bucket -> hash collision -> tailing new entry
                    Entry newEntry = new Entry(key, value);
                    bucket.add(newEntry);
                    entries.add(newEntry);
                }
            } else {
                // Something with different hash at position -> current capacity is not enough
                resize();
                put(key, value);
            }
        }
    }

    public String get(String key) {
        List<Entry> bucket = buckets.get(getIndex(getHash(key)));

        if(bucket != null) {
            if(bucket.size() == 1) {
                return bucket.get(0).getValue();
            } else {
                for(Entry e: bucket) {
                    if(e.getKey().equals(key)) {
                        return e.getValue();
                    }
                }
            }
        }

        return null;
    }

    static final int getHash(Object key) {
        return key.hashCode();
    }

    private int getIndex(int hash) {
        return (buckets.size()-1) & hash;
    }

    void resize() {
        List<Entry> oldEntries = new ArrayList<>(entries);
        create(buckets.size() << 1);

        for(Entry e: oldEntries) {
            put(e.getKey(), e.getValue());
        }
    }

    void create(int size) {
        buckets = new ArrayList<>(size);
        for(int i = 0; i < size; i++) {
            this.buckets.add(null);
        }

        entries = new ArrayList<>(size);
    }

    class Entry {
        private Integer hash;
        private String key;
        private String value;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
            this.hash = TrivialStringHashMap.getHash(key);
        }

        public Integer getHash() {
            return hash;
        }

        public void setHash(Integer hash) {
            this.hash = hash;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
