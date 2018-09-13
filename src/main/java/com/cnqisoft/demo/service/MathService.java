package com.cnqisoft.demo.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class MathService {

    @Cacheable("math")
    public int computeSomething(int i) {
        System.out.println("invoked");
        return 564 * 427 * i;
    }
}
