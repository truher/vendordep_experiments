# cpp_local_consumer

Uses the local maven artifact made by simple_cpp_local.

It has "useLocal" in the gradle file.

```
wpi.maven.useLocal = true
```

It has a vendor json file that references the cpp library,
which has been installed in the local maven repo.

Something that wasn't obvious to me:
the "cpp" part of the json file is for cpp robot code.

I want the "jni" part, to include libs loadable by java robot code,
even though it's not jni per se.

## Upgrading gradle

In the vscode terminal window, type

./gradlew wrapper --gradle-version 9.4.1

Note that the gradle upgrade has to happen first: if you try to run it with the newer jdk it will fail.

Also note you're supposed to run this command twice: once to install the new version, and once
to update gradle-wrapper.jar.

## Upgrading the JDK

I moved the existing ~/wpilib/2026/jdk out of the way, and made a symlink to the v25 installed on my machine.

