package com.huzaus.examples.rxjava

import rx.Observable
import rx.Subscriber
import rx.schedulers.Schedulers
import spock.lang.Specification


class BackpressureSpec extends Specification {

    def "Custom slow consumer unsafe example"() {
        expect:
            Observable.unsafeCreate(
                    { subscriber ->
                        (1..100).forEach(
                                { id -> subscriber.onNext(new Dish(id)) }
                        )
                        subscriber.onCompleted()
                    })
                    .subscribe(
                    { dish ->
                        println "Washing: ${dish}"
                        sleep(50L)
                    })

            sleep(10_000L)
    }






    def "Slow consumer with build-in backpressure example"() {
        expect:
            Observable
                    .range(1, 100)
                    .map({ new Dish(it) })
                    .observeOn(Schedulers.io())
                    .subscribe(
                    {
                        println "Washing: ${it}"
                        sleep(50L)
                    })
            sleep(10_000L)
    }







    def "Slow consumer with build-in backpressure with custom feedback example"() {
        expect:
            Observable
                    .range(1, 100)
                    .map({ new Dish(it) })
                    .observeOn(Schedulers.io())
                    .subscribe(new CustomSubscriber())

            sleep(10_000L)
    }

    static class CustomSubscriber extends Subscriber {

        @Override
        void onStart() {
            request(10L)
        }

        @Override
        void onCompleted()            {
            println 'done'
        }

        @Override
        void onError(Throwable e) {
            e.printStackTrace()
        }

        @Override
        void onNext(def item) {
            request(10L)
            println item
        }
    }

}