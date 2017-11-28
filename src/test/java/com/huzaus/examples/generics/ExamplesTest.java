package com.huzaus.examples.generics;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.classfile.InnerClass;
import groovy.lang.IntRange;
import org.junit.Test;

public class ExamplesTest {


    @Test
    public void questionZero() {
        List<Number> list = new ArrayList<>();
        List<Object>l;
        list.add(new Double(5));
        list.add(new Long(5));
        Number number = list.get(3);
//        list.add(?);
    }











    @Test
    public void questionOne() {
        List<? extends Number> list = new ArrayList<>();
        List<Number> k;
        Number m  =list.get(1);
//        list.add(new Integer(5));
//        list.add(10L);
//        list.add(?);
    }









    @Test
    public void questionTwo() {
        List<? super Number> list = new ArrayList<>();
        list = new ArrayList<Number>();
        list = new ArrayList<Object>();
        list.add(10L);
        list.add(10.0D);
        Object object = list.get(2);
//        list.add(new Object());
//        list.add(?);
    }







    @Test
    public void questionThree() {
        List<?> list = new ArrayList<>();
        list = new ArrayList<InnerClass>();
        list = new ArrayList<IntRange>();
        Object object = list.get(3);
        list.add(null);
    }
















    @Test
    public void questionFour() {
//      PECS
    }
}
