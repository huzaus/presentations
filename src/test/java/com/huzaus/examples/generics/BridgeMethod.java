package com.huzaus.examples.generics;


import java.util.stream.Stream;

import org.junit.Test;

public class BridgeMethod {

    @Test
    public void methods() {
        Stream.of(Person.class.getDeclaredMethods())
              .forEach(System.out::println);
    }
}