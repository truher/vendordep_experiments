# simple_cpp_local

An example of putting native code in the local maven repo.

Use the vscode "CMake:Build" task.

This builds into ./bin, so I made a zip file and moved it manually.

It needs

* group id: org.team100.simple_cpp
* artifact id: simple_cpp
* version: 0.0.1

So I made a directory tree, put the library in it,
and zipped it.

```
zip -r simple_cpp-0.0.1-linuxx86-64.zip simple_cpp-0.0.1-linuxx86-64
```
Then I made a home in the local maven repo

Then I copied the zip and pom to right place.

```
$ tree org/team100/simple_cpp
org/team100/simple_cpp
└── simple_cpp
    └── 0.0.1
        ├── simple_cpp-0.0.1-linuxx86-64.zip
        └── simple_cpp-0.0.1.pom

```
