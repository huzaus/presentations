package com.huzaus.examples.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import org.junit.Test;

import static java.util.Collections.singletonList;

public class UsageExample {

    @Test
    public void collectionsExample() {
        List<Person> persons = singletonList(new Person());
//        public static <Number> T max(Collection<? extends Number> coll,
// Comparator<Number super T> comp) {
        //public static <T extends Comparable<? super T>> T max(Collection<? extends T> coll)
        Person max = Collections.max(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return 0;
            }
        });
        System.out.println(max);
    }

    @Test
    public void arrayOfLists() {
//        List<String>[] lists1 = new ArrayList<String>[5];
//        List<?>[] lists2 = new ArrayList<?>[5];
        arrayOfLists(new ArrayList<>());
    }





















    public static void arrayOfLists(List<String>... array) {
        Object[] objects = array;
        objects[1] = "";
//        Arrays.stream(array).forEach(System.out::println);
    }
}
