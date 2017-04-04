package com.huzaus.examples.generics;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class BoxTest {

    @Test
    public void nonGenericExample() {
        Box rawBox = new Box();
        rawBox.put("Hello");

        assertThat(rawBox.get())
//            .hasSize(5)
            .isEqualTo("Hello");
    }

    @Test
    public void genericExample() {
        Box<String> rawBox = new Box<>();
        rawBox.put("Hello");

        assertThat(rawBox.get())
            .hasSize(5)
            .isEqualTo("Hello");
    }

    @Test
    public void explicitTypeArgument() {
        assertThat(Box.<String>boxed(null).get())
            .hasSize(5)
            .isNull();
    }

}