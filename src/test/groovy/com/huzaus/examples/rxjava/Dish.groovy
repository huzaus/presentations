package com.huzaus.examples.rxjava

class Dish {
    final byte[] oneKb = new byte[1024]
    int id

    Dish(int id) {
        this.id = id
        println "Created: Dish{$id}"
    }


    @Override
    String toString() {
         "Dish{$id}"
    }
}
