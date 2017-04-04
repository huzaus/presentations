package com.huzaus.examples.generics;

public class Box<T> {

    private T t;

    public void put(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public <S> S cast(T t) {
        return (S) t;
    }

    public static <T> Box<T> boxed(T t) {
        Box<T> box = new Box<>();
        box.put(t);
        return box;
    }
}
