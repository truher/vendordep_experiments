# hello_local_consumer

Uses the vendordep made in hello-vendordep.

I kept `useLocal` in `build.gradle`, and copied the library jar/zip files from

```
hello-vendordep/build/repos/releases/org/team100/hello-vendordep/hello-vendordep-driver
hello-vendordep/build/repos/releases/org/team100/hello-vendordep/hello-vendordep-java
```

To the maven repo

```
~/wpilib/2026/maven
```

I copied the vendordep file:

```
hello-vendordep/build/repos/releases/hello-vendordep.json
```

to this project's `vendordeps` directory.

