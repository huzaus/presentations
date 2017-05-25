package com.huzaus.examples.generics;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class StringBoxTest {

    @Test
    public void stringBoxExample() {
        StringBox stringBox = new StringBox();
        stringBox.put("hello");
        assertThat(stringBox.get())
            .hasSize(5);
    }

}