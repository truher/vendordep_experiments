# GTSAM Vendordep

A wrapper for GTSAM, which is included from WPILib third_party,
which lives here:

```
https://frcmaven.wpi.edu/ui/native/release/edu/wpi/first/thirdparty/frc2025/gtsam/gtsam-cpp/
```

Reading the [maven metadata file](https://frcmaven.wpi.edu/artifactory/release/edu/wpi/first/thirdparty/frc2025/gtsam/gtsam-cpp/maven-metadata.xml),
we find:

* group id: edu.wpi.first.thirdparty.frc2025.gtsam
* artifact id: gtsam-cpp
* version: 4.3-3

So I added a section to config.gradle.

Note: you have to list all the targetPlatforms, or when the resolver tries to match one of the ones I don't actually need
(perhaps athena?) it barfs.

I copied the Point2 wrapper from cpp_test to
src/main/driver/cpp.

I added "Point2*" to symbols.txt.

It failed to compile, because the GTSAM thirdparty build uses TBB.

So install TBB:

```
sudo apt update
sudo apt install libtbb-dev
```

Then, warnings killed the build, so I silenced them in config.gradle.

Then, gcc complained about some of the internals of GTSAM, which make assignments with Eigen types without
reimplementing all the constructors.  This issue is described
[here](https://github.com/borglab/gtsam/issues/2279), and it's caused
by using Eigen 5.

The Eigen we're linking with comes from wpimath-2026.2.2, which uses Eigen 5.

Maybe I can make it work by setting wpilibVersion to 2025.3.2, which exists in maven.

Hm, that causes other gradle errors.  maybe rebuild the gtsam thirdparty?

Ah, I can make one of the errors go away with

```
./gradlew --stop
```

which does something to remove version clash or caching or whatever magic.

## custom gtsam

OK i built a gtsam from 4.3a1+ and it references eigen5.0.0 which
should be fine with wpimath.

and i put it in the gradle maven repo.

```
~/wpilib/2026/maven/edu/wpi/first/thirdparty/frc2025$ cp -r ~/releases/maven/release/edu/wpi/first/thirdparty/frc2025/gtsam .
```

so

```
./gradlew build
```

aaaand it seems like it worked. (!)

```
./gradlew publish
```

seems to have worked also, depositing output in build/repos

So copy the contents to the same local repo

```
~/wpilib/2026/maven/org/team100$ cp -r ~/FRC/TRUHER/vendordep_experiments/gtsam-vendordep/build/repos/releases/org/team100/hello-vendordep .
```

Ooops, forgot to include Point2.java, so do it over.





------------------------------------------------
------------------------------------------------
------------------------------------------------
------------------------------------------------
------------------------------------------------
------------------------------------------------



See **hello-vendordep** for notes.

See **cpp_test** for the origin of the wrapper.

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

This makes `hello_local_consumer` work, since it has useLocal.

I also added a mavenUrl, and put copies of the repos/releases output in "repository"
so that the `hello_remote_consumer` works too.

Check what's visible in the library:

```
$ nm -g libhellowrapper.so | grep ' T '
00000000000011b9 T Hello
0000000000001219 T Hello_add
0000000000001245 T Hello_delete
```




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