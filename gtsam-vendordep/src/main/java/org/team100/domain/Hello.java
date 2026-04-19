package org.team100.domain;

import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_INT;

import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;

import org.team100.foreign.ForeignObject;
import org.team100.foreign.Lib;

/** Test proxy object */
public class Hello extends ForeignObject {
    private static final MethodHandle Hello = Lib.down(
            "Hello", ADDRESS);
    private static final MethodHandle Hello_delete = Lib.downVoid(
            "Hello_delete", ADDRESS);
    private static final MethodHandle Hello_add = Lib.down(
            "Hello_add", JAVA_INT, ADDRESS, JAVA_INT, JAVA_INT);

    public Hello() throws Throwable {
        super((MemorySegment) Hello.invokeExact(), Hello_delete);
    }

    public int add(int a, int b) throws Throwable {
        return (int) Hello_add.invokeExact(ptr, a, b);
    }
}
