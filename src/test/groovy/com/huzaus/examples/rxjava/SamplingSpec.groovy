package com.huzaus.examples.rxjava

import io.reactivex.Observable
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
                    .map({ timestamp -> "${timestamp.time() - startTime}ms: ${(timestamp.value() + 1)}" })

        expect:
            println 'Sample:'
            timestamp
                    .sample(1L, SECONDS)
                    .take(5L)
                    .blockingSubscribe({ println it })
    }

    def "Time stamp throttle first example"() {
        given:
            long startTime = System.currentTimeMillis()
            Observable timestamp = Observable
                    .interval(interval, MILLISECONDS)
                    .timestamp()
                    .map({ timestamp -> "${timestamp.time() - startTime}ms: ${(timestamp.value() + 1)}" })

        expect:
            println 'Throttle First:'
            timestamp
                    .throttleFirst(1L, SECONDS)
                    .take(5L)
                    .blockingSubscribe({ println it })
    }

    def "Time stamp window example"() {
        given:
            long startTime = System.currentTimeMillis()
            Observable timestamp = Observable
                    .interval(interval, MILLISECONDS)
                    .timestamp()
                    .map({ timestamp -> "${timestamp.time() - startTime}ms: ${(timestamp.value() + 1)}" })

        expect:
            println 'Sample:'
            timestamp
                    .window(1L)
                    .take(5L)
                    .blockingSubscribe({ println it })
    }
//    def "Sampling example"() {
//
//        given: "Observable with names: "
//            Observable names = Observable.just(
//                    'Zuzanna', 'Lena', 'Julia',
//                    'Maja',
//                    'Zofia',
//                    'Hanna', 'Amelia',
//                    'Aleksandra',
//                    'Alicja', 'Natalia')
//
//        and: "Observable with absolute delays: "
//            Observable delays = Observable.just(
//                    0.1, 0.5, 0.9,
//                    1.1,
//                    2.3,
//                    3.4, 3.5,
//                    4.6,
//                    5.4, 5.8)
//                    .map({ it * 1_000 as Long })
//
//        and: "Observable that emits names with delay:"
//            Observable delayedNames =
//                    withAbsoluteDelays(names, delays)
//
//
//        expect:
//            TestScheduler scheduler = new TestScheduler()
//            TestSubscriber subscriber = TestSubscriber.create()
//            delayedNames
//                    .sample(1L, SECONDS)
//                    .subscribeOn(scheduler)
//                    .test()
////                    .blockingSubscribe()
//                    .subscribe({ println it })
//
//            scheduler.advanceTimeTo(10L, SECONDS)
////            scheduler.advanceTimeTo(2L, SECONDS)
////            subscriber.assertValue("Julia")
////
//    }
//
//
//    static Observable withAbsoluteDelays(Observable observable, Observable delays) {
//        observable
//                .concatWith(delayedCompletion())
//                .zipWith(delays,
//                { name, milliseconds ->
//                    Observable
//                            .just(name)
//                            .delay(milliseconds as long, MILLISECONDS)
//                })
//                .flatMap({ it })
//    }
//
//    static Observable delayedCompletion() {
//        Observable.empty().delay(2L, SECONDS)
//    }
}