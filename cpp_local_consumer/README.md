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

