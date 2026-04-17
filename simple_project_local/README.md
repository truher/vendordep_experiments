# simple_project_local

A simple **(Java-only)** consumer of simple_vendor,
that contains one interesting line:

```java
public class SimpleTest {
    @Test
    void test0() {
        System.out.println(VendorCode.A_CONSTANT);
    }
}
```

The vendor json file simply specifies the maven dependency
without a maven url, so the "normal" maven resolver looks
for it.

```json
{
    "fileName": "simple_vendor.json",
    "name": "Simple Vendor",
    "version": "0.0.1",
    "uuid": "41590dfc-9499-4bfe-bc26-72c46e48812f",
    "frcYear": "2026",
    "mavenUrls": [],
    "jsonUrl": "",
    "javaDependencies" : [
        {
            "groupId": "org.team100.simple_vendor",
            "artifactId": "simple_vendor",
            "version": "0.0.1"
        }
    ],
    "jniDependencies": [],
    "cppDependencies": []
}
```

I told gradle to look in the special maven repo, which is `/home/joel/wpilib/2026/maven/` on my machine:

```groovy
wpi.maven.useLocal = true
```

I've put the `simple_vendor` jar/pom files in that directory, using
the maven layout.

"Clean" the java project to get gradle to notice these changes.

Run `SimpleTest.test0()` to see it work.