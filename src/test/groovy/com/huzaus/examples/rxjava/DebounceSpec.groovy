package com.huzaus.examples.rxjava

import rx.Observable
import spock.lang.Specification

import static java.util.concurrent.TimeUnit.MILLISECONDS

class DebounceSpec extends Specification {

    long interval = 10L


    def "Simple denounce example"() {
        given: 'Observable that emits timestamp every 10ms'
            long startTime = System.currentTimeMillis()
            Observable timestamp = Observable
                    .interval(interval, MILLISECONDS)
                    .timestamp()
                    .map({ timestamp -> "${timestamp.timestampMillis - startTime}ms: ${(timestamp.value)}" })

        expect: 'Denounce events that appears too frequently'
            println 'Simple denounce example:'
            timestamp
                    .debounce(20L, MILLISECONDS)
                    .take(5)
                    .toBlocking()
                    .subscribe({ println it })
    }

    def "Denounce example"() {
        given: 'Observable that emits timestamp every 10ms'
            Observable debounce = Observable.unsafeCreate(
                    { subscriber ->
                        (1..100).forEach(
                                { id ->
                                    if (id % 10 == 0) {
                                        sleep(10 * interval)
                                    } else {
                                        sleep(interval)
                                    }
                                    subscriber.onNext(id)
                                }
                        )
                        subscriber.onCompleted()
                    })

        expect: 'Denounce events that appears too frequently'
            println 'Debounce example:'
            debounce
                    .debounce(20L, MILLISECONDS)
                    .take(5)
                    .toBlocking()
                    .subscribe({ println it })
    }
}