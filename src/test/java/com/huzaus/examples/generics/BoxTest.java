package com.huzaus.examples.generics;


import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;

public class BoxTest {

    public void nonGenericExample() {
        Box rawBox = new Box();
        rawBox.put("Hello");

        assertThat(rawBox.get())
//            .hasSize(5)
            .isEqualTo("Hello");
    }

    public void genericExample() {
        Box<String> rawBox = new Box<>();
        rawBox.put("Hello");

        assertThat(rawBox.get())
            .hasSize(5)
            .isEqualTo("Hello");
    }

}