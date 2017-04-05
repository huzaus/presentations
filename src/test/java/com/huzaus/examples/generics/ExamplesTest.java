package com.huzaus.examples.generics;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ExamplesTest {

    @Test
    public void questionOne() {
        List<? extends Number> list = new ArrayList<>();

        //list.add()
    }

    @Test
    public void questionTwo() {
        List<? super Number> list = new ArrayList<>();

        //list.add();
    }

    @Test
    public void questionThree() {
        List<?> list = new ArrayList<>();

//        list.add();
    }

    @Test
    public void questionFour() {
//      PECS
//      Collections.max();
    }
}
