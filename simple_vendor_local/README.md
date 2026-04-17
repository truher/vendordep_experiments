# simple_vendor_local

Very simple **(Java-only)** vendor code served locally.

The Java code has one Java class with one static member.

```java
public class VendorCode {
    public static final String A_CONSTANT = "A value";
}
```

I'm using the vscode java project "export jar" button (the little arrow),
to make a jar file, `simple_vendor.jar`, which contains:

```
META-INF/MANIFEST.MF
org/
org/team100/
org/team100/simple_vendor/
org/team100/simple_vendor/VendorCode.class
```
The manifest is essentially empty:

```
Manifest-Version: 1.0
```

I also made a [minimal POM file](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html#Minimal_POM),
which defines the group id, artifact id, and version.

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0">
  <modelVersion>4.0.0</modelVersion>
  <groupId>org.team100.simple_vendor</groupId>
  <artifactId>simple_vendor</artifactId>
  <version>0.0.1</version>
</project>
```

Maven defines a
[repository layout](https://maven.apache.org/repositories/layout.html)
that involves the group id, artifact id, and version, so
the repository would contain:


```
org/team100/simple_vendor/simple_vendor/0.0.1/simple_vendor-0.0.1.jar
org/team100/simple_vendor/simple_vendor/0.0.1/simple_vendor.pom
```

WPI Gradle looks for local dependencies
in a special place (not `.m2`).  On my machine it is:

```
/home/joel/wpilib/2026/maven/
```

So I copied the jar and pom files there.