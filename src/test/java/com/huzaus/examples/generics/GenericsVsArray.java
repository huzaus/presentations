package com.huzaus.examples.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class GenericsVsArray {

    @Test
    public void numbersArray() {
        Number[] numbers = new Double[5];
//            new Integer[10];
        numbers[0] = 2.1D;
        System.out.println(Arrays.toString(numbers));
    }

    @Test
    public void numbersList() {
        List<Number> numbers = new ArrayList<Number>();
        numbers.add(2.1D);
        System.out.println(numbers);
    }

}
