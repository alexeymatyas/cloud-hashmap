package com.epam.amatias.controller;

import com.epam.amatias.TrivialStringHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Alexey on 26.11.2016.
 */
@RestController
public class HashMapController {
    @Autowired
    TrivialStringHashMap map;

    @PostMapping("/put/{key}")
    public void put(@RequestBody String value, @PathVariable String key) {
        map.put(key, value);
    }

    @GetMapping("/get/{key}")
    public String get(@PathVariable String key) {
        return map.get(key);
    }
}
