# simple_cpp_local

An example of putting **native code** in the local maven repo.

This is C++ only, consisting of one C++ class:

```c++
namespace team100 {
class Hello {
   public:
    Hello();
    ~Hello() noexcept;
    int add(int a, int b);
};
}  // namespace team100
```

Since FFM can't use mangled names directly, there is a wrapper that exposes
C externs:

```c++
extern "C" {
team100::Hello* Hello() {
    return new team100::Hello();
}

int Hello_add(team100::Hello* obj, int a, int b) {
    return obj->add(a, b);
}

void Hello_delete(team100::Hello* obj) {
    delete obj;
}
}
```

The build uses the vscode "CMake:Build" task.

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

Then I copied the zip and pom to right place in the gradle maven tree:

```
$ tree org/team100/simple_cpp
org/team100/simple_cpp
└── simple_cpp
    └── 0.0.1
        ├── simple_cpp-0.0.1-linuxx86-64.zip
        └── simple_cpp-0.0.1.pom

```
