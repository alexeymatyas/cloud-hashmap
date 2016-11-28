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

    public TrivialStringHashMap() {
        this.buckets = new ArrayList<>(DEFAULT_CAPACITY);
        for(int i = 0; i < DEFAULT_CAPACITY; i++) {
            this.buckets.add(null);
        }
    }

    public void put(String key, String value) {
        int hash = hash(key);
        int index = getIndex(hash);
        List<Entry> bucket = buckets.get(index);
        if(bucket == null) {
            List<Entry> newBucket = new LinkedList<>();
            newBucket.add(new Entry(key, value));
            buckets.set(index, newBucket);
        } else {
            if(bucket.get(0).getHash() == hash) {
                boolean isInBucket = false;
                for(Entry e: bucket) {
                    if(e.getKey().equals(key)) {
                        isInBucket = true;
                        e.setValue(value);
                        break;
                    }
                }
                if(!isInBucket) {
                    bucket.add(new Entry(key, value));
                }
            }
        }
    }

    public String get(String key) {
        String value = null;
        List<Entry> bucket = buckets.get(getIndex(hash(key)));

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

    static final int hash(Object key) {
        int h;
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        return key.hashCode();
    }

    private int getIndex(int hash) {
        return (DEFAULT_CAPACITY-1) & hash;
    }

    class Entry {
        private Integer hash;
        private String key;
        private String value;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
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
