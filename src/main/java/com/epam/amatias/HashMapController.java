package com.epam.amatias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Alexey on 26.11.2016.
 */
@RestController
public class HashMapController {
    @Autowired
    Map<String, String> map;

    @PostMapping("/put/{key}")
    public void put(@RequestBody String value, @PathVariable String key) {
        map.put(key, value);
    }

    @GetMapping("/get/{key}")
    public String get(@PathVariable String key) {
        return map.get(key);
    }
}
