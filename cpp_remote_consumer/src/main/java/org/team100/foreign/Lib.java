package org.team100.foreign;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;

/**
 * Requires the correct java version,
 * so I set it to 25 in build.gradle.
 */
public class Lib {
    public static final Arena arena = Arena.ofAuto();
    // The vendordep library is unpacked somewhere the loader can find it.
    public static final SymbolLookup lib2 = SymbolLookup.libraryLookup("libsimple_cpp.so", arena);
    public static final Linker linker = Linker.nativeLinker();

    public static MethodHandle down2(
            String name, ValueLayout returnType, ValueLayout... parameterTypes) {
        return linker.downcallHandle(
                lib2.findOrThrow(name),
                FunctionDescriptor.of(returnType, parameterTypes));
    }

    public static MethodHandle downVoid2(
            String name, ValueLayout... parameterTypes) {
        return linker.downcallHandle(
                lib2.findOrThrow(name),
                FunctionDescriptor.ofVoid(parameterTypes));
    }
}
