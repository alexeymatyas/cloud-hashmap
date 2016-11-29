package com.epam.amatias;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Alexey on 28.11.2016.
 */
public class TrivialStringHashMapTest {
    TrivialStringHashMap hashMap;

    @Before
    public void before() {
        hashMap = new TrivialStringHashMap();
    }

    @Test
    public void shouldReturnPreviouslyPutString() {
        String key = "key";
        String value = "value";

        hashMap.put(key, value);
        assertThat(hashMap.get(key), is(equalTo(value)));

        hashMap.put(value, key);
        assertThat(hashMap.get(value), is(equalTo(key)));
    }

    @Test
    public void shouldWorkForManyItems() {
        for(Integer i = 0; i < 100; i++) {
            String key = i.toString();
            String value = key + "value";
            hashMap.put(key, value);
            assertThat(hashMap.get(key), is(equalTo(value)));
        }
    }
}
