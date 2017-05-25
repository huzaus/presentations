package com.huzaus.examples.rxjava

import rx.Observable
import rx.Scheduler
import rx.observers.TestSubscriber
import rx.schedulers.Schedulers
import rx.schedulers.TestScheduler
import spock.lang.Specification

import static java.util.concurrent.TimeUnit.SECONDS

class ExperimentSpec extends Specification {
    def "Sampling example"() {

        given: "Observable with names: "
        Observable names = Observable.just(
                'Zuzanna', 'Lena', 'Julia',
                'Maja',
                'Zofia',
                'Hanna', 'Amelia',
                'Aleksandra',
                'Alicja', 'Natalia')

        and: "Observable with absolute delays: "
        Observable delays = Observable.just(
                0.1, 0.5, 0.9,
                1.1,
                2.3,
                3.4, 3.5,
                4.6,
                5.4, 5.8)
                .map({ it * 1_000 as Long })

        and: "Observable that emits names with delay:"
        TestScheduler scheduler = Schedulers.test()
        Observable delayedNames =
                withAbsoluteDelays(names, delays, scheduler)


        expect:

        TestSubscriber subscriber = TestSubscriber.create()
        delayedNames
                .sample(1, SECONDS)
                .subscribe(subscriber)

        scheduler.advanceTimeTo(2L, SECONDS)
        subscriber.assertNotCompleted()
        subscriber.assertValueCount(1)
//        subscriber.assertValues("Julia")
//
    }


    static Observable withAbsoluteDelays(Observable observable, Observable delays, Scheduler scheduler) {
        observable
//                .concatWith(delayedCompletion())
                .zipWith(delays,
                { name, milliseconds ->
                    Observable
                            .just(name)
                            .delay(milliseconds as long, MILLISECONDS, scheduler)
                })
                .flatMap({ it })
    }

    static Observable delayedCompletion() {
        Observable.empty().delay(1L, SECONDS)
    }
}