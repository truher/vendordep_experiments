# simple_vendor

The simplest vendor code I could think of, one class with one static member.

```java
public class VendorCode {
    public static final String A_CONSTANT = "A value";
}
```

I'm using the vscode "java project" buttons, e.g. to make a jar file:

```
simple_vendor.jar
```

contains

```
META-INF/MANIFEST.MF
org/
org/team100/
org/team100/simple_vendor/
org/team100/simple_vendor/VendorCode.class
```

and the manifest is essentially empty:

```
Manifest-Version: 1.0
```

WPI Gradle looks in a special place, e.g. on my machine it is:

```
/home/joel/wpilib/2026/maven/
```

So, using the 
[repository layout](https://maven.apache.org/repositories/layout.html)

inside `/home/joel/wpilib/2026/maven/` there would be:

```
org/team100/simple_vendor/simple_vendor/0.0.1/simple_vendor-0.0.1.jar
```

I also need a [minimal POM file](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html#Minimal_POM)

```
org/team100/simple_vendor/simple_vendor/0.0.1/simple_vendor.pom
```

TODO: use hyphen instead of underscore.

