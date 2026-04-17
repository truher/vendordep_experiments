# Hello Vendordep

A copy of WPILib vendor-template with a few changes:

* deleted the VendorJNI etc
* added the "Hello" java proxy code and FFM utils to the "java" directory
* added the "Hello" c++ code and "extern" wrapper to the "driver" directory
* upgraded gradle to 9.4.1 ("./gradlew wrapper --gradle-version 9.4.1" twice)
* added a line to symbols.txt, so that the wrapper function symbols will be visible
* removed all the "native" code: it's for C++ robot code.
* removed the "Vendor" block from build.gradle components and exportConfigs
* removed all the test code and everything about native testing in build.gradle.
* changed the library names in build.gradle, see below
* change publish.gradle
  * changed templateVendorFile name
  * changed the group and artifact id
  * removed the "native" parts, keeping java and driver parts.
  * removed the "vendordep" publication
* modified the vendordep json file to
  * remove cpp dependencies
  * add a guid
  * remove the maven url
  * remove the json url
  * change the frcYear to 2026, to match the consumer.
  * removed all the validPlatforms except linuxx86-64, to match the consumer.

I ran
```
./gradlew build
./gradlew publish
```

this produced output in build/repos/releases, which I copied
to the local gradle maven repo at ~/wpilib/2026/maven.

```
cp -r hello-vendordep/build/repos/releases/org/team100/hello-vendordep/hello-vendordep-* ~/wpilib/2026/maven/org/team100/hello-vendordep/
```

This makes `hello_consumer` work, since it has useLocal.




## where's the library name?

The vendor-template tells you what to do

* The java library name should be "hello-vendordep" ?  Maybe this means the name of the jar.
* There is no "native" code so i can ignore it?
* The "driver" library name, call it "hellowrapper" (no hyphen allowed)
  * build.gradle privateExportsConfigs
  * build.gradle components
  * publish.gradle model.publishing.driverTaskList
  * this also needs to appear in the FFM loader as "libhellowrapper.so", in `Lib.java`.


## what is "symbols.txt" for?

the "symbols.txt" file becomes "exportsFile" in "VendorDriver" in "privateExportsConfigs" which is an instance of "JniNativeLibrarySpec"

The gradle config "nativeUtils" references the
[NativeUtils](https://github.com/wpilibsuite/native-utils/blob/main/src/main/java/edu/wpi/first/nativeutils/NativeUtils.java)
[`Plugin`](https://docs.gradle.org/current/userguide/part2_add_extension.html)
which uses [NativeUtilsExtension](https://github.com/wpilibsuite/native-utils/blob/main/src/main/java/edu/wpi/first/nativeutils/NativeUtilsExtension.java)
... apparently in gradle, the word "extension" means "config holder".

So the extension has properties like `exportsConfigs` and `privateExportsConfigs`

I would like to avoid restating all the exports in symbols.txt.  How can
I do that?  What *is* symbols.txt?  It's used to populate the ld
["version script"](https://man7.org/conf/lca2006/shared_libraries/slide18c.html),
which specifies which symbols to export.
([more](https://sourceware.org/binutils/docs/ld/VERSION.html))

In [PrivateExportsGenerationTask](https://github.com/wpilibsuite/native-utils/blob/main/src/main/java/edu/wpi/first/nativeutils/exports/PrivateExportsGenerationTask.java),
the exports file is parsed, and then added to a tmp version-script file.

* The library name is used as the "VERSION".
* The listed exports are put in the "global" section
* There's nothing in the "local" section

The tmp export file name is used in the "--version-script=" argument to gcc.

The version-script symbol matching is *inclusive*, so you can't include
everything except for C++ ("_Z*") symbols.

Since all my wrapper function names start with the class name, I can
use the class name with a wildcard.