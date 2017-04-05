package com.huzaus.examples.generics;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ExamplesTest {

    @Test
    public void questionOne() {
        List<? extends Number> list = new ArrayList<>();
        list = new ArrayList<Number>();
        list = new ArrayList<Long>();
        list = new ArrayList<Integer>();
        list = new ArrayList<Byte>();

        //list.add()
    }

    @Test
    public void questionTwo() {
        List<? super Number> list = new ArrayList<>();
        list = new ArrayList<Number>();
        list = new ArrayList<Object>();

        //list.add();
    }

    @Test
    public void questionThree() {
        List<?> list = new ArrayList<>();
        list = new ArrayList<Number>();
        list = new ArrayList<Object>();
        list = new ArrayList<String>();

//        list.add();
    }
}
