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
        hashMap.put("testKey", "testValue");
        assertThat(hashMap.get("testKey"), is(equalTo("testValue")));
    }
}
