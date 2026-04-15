# Notes

How the vendordeps work:

* The java dependencies are hosted as a maven artifact.
* The cpp dependencies are hosted in a separate maven artifact.
* The vendordep json points at these dependencies.
* The gradle build reads the json and uses the dependencies

The most popular maven host seems to be "github pages."

For development, the local gradle maven repo works.

The vendordep file is a serialization of [JsonDependency](https://github.com/wpilibsuite/native-utils/blob/main/src/main/java/edu/wpi/first/nativeutils/vendordeps/WPIVendorDepsExtension.java#L346).

There's also a vscode thing that can download the vendordep
json, but I'm going to ignore that.

The vendor-template includes a gradle build that makes three parts (C, JNI, Java), using lots of architectures.

## doc

Somebody wrote [a doc](https://github.com/ApolloFops/VendorTools/blob/main/docs/docs/vendordep-json-format.md) about the vendor json format.

## random notes

The WPI gradle plugin uses the `WPIVendorDepsExtension`

There's stuff in [native-utils](https://github.com/wpilibsuite/native-utils)
that seems to include stuff for gradle, e.g. the
[WPIVendorDepsPlugin](https://github.com/wpilibsuite/native-utils/blob/main/src/main/java/edu/wpi/first/nativeutils/vendordeps/WPIVendorDepsPlugin.java).





## Thirdparty

There's a "thirdparty" build that makes zip files
that are published to the
[frc maven](https://frcmaven.wpi.edu/ui/native/release/)
as described
[here](https://github.com/wpilibsuite/allwpilib/blob/main/MavenArtifacts.md).

So, for example,

https://github.com/wpilibsuite/thirdparty-gtsam

eventually finds its way to

https://frcmaven.wpi.edu/ui/native/release/edu/wpi/first/thirdparty/frc2025/gtsam/gtsam-cpp/4.3-3/

which contains zip files.

The build itself seems to publish to user.home.
Maybe finished thirdparty libs are uploaded manually?

