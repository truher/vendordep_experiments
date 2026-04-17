# simple_vendor_remote

Serves the `simple_vendor` **(Java-only)** code from `github.io`.

I copied the jar/pom files to the `repository` directory here.

I changed the version number to force the maven resolver to
fail on the local repository: changed the pom, renamed the files.


```xml
<project xmlns="http://maven.apache.org/POM/4.0.0">
  <modelVersion>4.0.0</modelVersion>
  <groupId>org.team100.simple_vendor</groupId>
  <artifactId>simple_vendor</artifactId>
  <version>0.0.2</version>
</project>
```


```
org/team100/simple_vendor/simple_vendor/0.0.2/simple_vendor-0.0.2.jar
org/team100/simple_vendor/simple_vendor/0.0.2/simple_vendor.pom
```

