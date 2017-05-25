package com.huzaus.examples.rxjava

import rx.Observable
import rx.schedulers.Schedulers
import spock.lang.Specification

import static rx.Observable.unsafeCreate


class BackpressureSpec extends Specification {

    def "Slow consumer basic example"() {
        expect:
        Observable
                .range(1, 100)
                .map({ new Dish(it) })
                .subscribe(
                {
                    println "Washing: ${it}"
                    sleep(50)
                })
    }

    def "Slow consumer async example"() {
        expect:
        Observable
                .range(1, 100_000_000)
                .map({ new Dish(it) })
                .observeOn(Schedulers.io())
                .subscribe(
                {
                    println "Washing: ${it}"
                    sleep(50)
                })
        sleep(10_000)
    }

    def "Slow consumer unsafe example"() {
        expect:
        unsafeCreate(
                { subscriber ->
                    (1..100_000_000).forEach(
                            { id -> subscriber.onNext(new Dish(id)) }
                    )
                    subscriber.onCompleted()
                })
//                .range(1, 100_000_000)
                .observeOn(Schedulers.io())
                .subscribe(
                { dish ->
                    println "Washing: ${dish}"
                    sleep(50)
                })
        sleep(10_000)
    }


    static Observable<Dish> dishes() {
        Observable
                .range(1, 1_000_000_000)
                .map({ new Dish(it) })
    }

}