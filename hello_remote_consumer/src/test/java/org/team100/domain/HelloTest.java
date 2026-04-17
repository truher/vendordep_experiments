package org.team100.domain;

import org.junit.jupiter.api.Test;

public class HelloTest {
    @Test
    void test0() throws Throwable {
        System.out.println("start");
        Hello hello = new Hello();
        System.out.println("call a method");
        int result = hello.add(1, 2);
        System.out.printf("show the result: %d\n", result);
        System.out.println("make hello unreachable");
        hello = null;
        System.out.println("suggest garbage collecting");
        System.gc();
        System.out.println("wait for the cleaner thread");
        Thread.sleep(100);
        System.out.println("done");
    }
}
