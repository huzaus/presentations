package com.huzaus.examples.rxjava

import rx.Observable
import rx.observers.TestSubscriber
import rx.schedulers.Schedulers
import rx.schedulers.TestScheduler
import spock.lang.Specification

import static java.util.concurrent.TimeUnit.MILLISECONDS
import static java.util.concurrent.TimeUnit.SECONDS

class SamplingSpec extends Specification {

    long interval = 10L

    def "Time stamp sampling example"() {
        given:
        long startTime = System.currentTimeMillis()
        Observable timestamp = Observable
                .interval(interval, MILLISECONDS)
                .timestamp()
//                .map({ timestamp -> "${timestamp.time() - startTime}ms: ${(timestamp.value() + 1)}" })
                .map({ timestamp -> "${timestamp.timestampMillis - startTime}ms: ${(timestamp.value)}" })

        expect:
        println 'Sample:'
        timestamp
                .sample(1L, SECONDS)
                .take(5)
                .toBlocking()
                .subscribe({ println it })
//                .blockingSubscribe({ println it })
    }

    def "Time stamp sampling example with test scheduler and test subscriber"() {
        given:
        TestScheduler scheduler = Schedulers.test()
        TestSubscriber subscriber = TestSubscriber.create()
        Observable timestamp = Observable
                .interval(interval, MILLISECONDS, scheduler)
                .timestamp()
//                .map({ timestamp -> "${timestamp.time() - startTime}ms: ${(timestamp.value() + 1)}" })
                .map({ timestamp -> timestamp.value })

        expect:
        println 'Sample:'
        timestamp
                .sample(1L, SECONDS, scheduler)
                .take(5)
//                .toBlocking()
                .subscribe(subscriber)

        scheduler.advanceTimeBy(1L, SECONDS)
        subscriber.assertNotCompleted()
        subscriber.assertValue(98L)

        scheduler.advanceTimeTo(5L, SECONDS)
        subscriber.assertCompleted()
        subscriber.assertValues(98L, 198L, 298L, 398L, 498L)
    }

    def "Time stamp throttle first example"() {
        given:
        long startTime = System.currentTimeMillis()
        Observable timestamp = Observable
                .interval(interval, MILLISECONDS)
                .timestamp()
                .map({ timestamp -> "${timestamp.timestampMillis - startTime}ms: ${(timestamp.value)}" })
//                .map({ timestamp -> "${timestamp.time() - startTime}ms: ${(timestamp.value() + 1)}" })

        expect:
        println 'Throttle First:'
        timestamp
                .throttleFirst(1L, SECONDS)
                .take(5)
                .toBlocking()
                .subscribe({ println it })
//                .blockingSubscribe({ println it })
    }

    def "Time stamp window example"() {
        given:
        long startTime = System.currentTimeMillis()
        Observable timestamp = Observable
                .interval(interval, MILLISECONDS)
                .timestamp()
                .map({ timestamp -> "${timestamp.timestampMillis - startTime}ms: ${(timestamp.value)}" })
//                .map({ timestamp -> "${timestamp.time() - startTime}ms: ${(timestamp.value() + 1)}" })

        expect:
        println 'Window:'
        timestamp
                .window(1)
                .flatMap({ it })
                .take(5)
                .toBlocking()
                .subscribe({ println it })
//                .blockingSubscribe({ println it })
    }

}