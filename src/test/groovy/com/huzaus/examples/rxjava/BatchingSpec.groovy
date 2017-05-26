package com.huzaus.examples.rxjava

import rx.Observable
import spock.lang.Specification

import static java.util.concurrent.TimeUnit.MILLISECONDS


class BatchingSpec extends Specification {

    long interval = 10L

    def "Time stamp buffer example"() {
        given: "Observable that emits timestamp every 10ms"
            long startTime = System.currentTimeMillis()
            Observable timestamp = Observable
                    .interval(interval, MILLISECONDS)
                    .timestamp()
                    .map({ timestamp -> "${timestamp.timestampMillis - startTime}ms: ${(timestamp.value)}" })
// rxjava2               .map({ timestamp -> "${timestamp.time() - startTime}ms: ${(timestamp.value() + 1)}" })

        expect: "Buffering 10 events"
            println 'Buffer:'
            timestamp
                    .buffer(10)
                    .take(5)
                    .toBlocking()
                    .subscribe({ println it })
//  rxjava2              .blockingSubscribe({ println it })
    }

    def "Time stamp window example"() {
        given: "Observable that emits timestamp every 10ms"
            long startTime = System.currentTimeMillis()
            Observable timestamp = Observable
                    .interval(interval, MILLISECONDS)
                    .timestamp()
                    .map({ timestamp -> "${timestamp.timestampMillis - startTime}ms: ${(timestamp.value)}" })
//  rxjava2               .map({ timestamp -> "${timestamp.time() - startTime}ms: ${(timestamp.value() + 1)}" })

        expect: "Windowing 10 events"
            println 'Window:'
            timestamp
                    .window(10)
                    .flatMap({ it })
                    .take(20)
                    .toBlocking()
                    .subscribe({ println it })
//  rxjava2               .blockingSubscribe({ println it })
    }
}