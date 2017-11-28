package com.huzaus.examples.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;


public class AdvancedExample {



    @Test
    public void recursiveGeneric() {
        Stream.of(1, 2, 3, 4, 5)
              .parallel() // BaseStream
              .map(i -> i * i)
              .forEach(System.out::println);
    }

    @Test
    public void genericClass() {
        Class<Integer> c = Integer.class;
        Integer i = new Integer(5);
        c = i.getClass(); // why it doesn't work
    }

    @Test
    public void wtf() {
        String string = AdvancedExample.newList();
        System.out.println("WTF?" + string);
    }
    private static <T extends List> T newList() {
        return null;
    }
}
