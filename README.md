# vendordep_experiments
Monorepo for all the vendordep stuff

I'm working my way through the vendordep process, in stages.

## simple_vendor_local

Step 1: make a java dependency that can be read by maven.

* make a very simple java class 
* package it as a `jar` using the vscode "make jar" button
* make a simple `pom` file
* copy `jar` and `pom` to the local gradle maven repo.

## simple_project_local

Step 2: make a very simple consumer of the java code above.

* make a java test that uses the class above
* make a vendor json file with a `javaDependency`
* specify `useLocal` in the build.gradle
* gradle picks up the maven dependency, and the test passes.

## simple_vendor_remote

Step 3: a java dependency on the internet.

* same vendor code as step 1
* increment the `jar` and `pom` version number
* copy the files to a place that `github.io` will pick them up

## simple_project_remote

Step 4: use the remote java dependency

* same test as step 2
* remove `useLocal`
* use the incremented version number
* add a maven url in the vendor json.
* gradle finds the new maven dependency, and the test passes

## simple_cpp_local

Step 5: a C++ dependency

* make a C++ class
* make an `extern` wrapper
* build a shared library
* put it in a zip file with the correct directories
* write a `pom` file
* put the files in the correct place in the gradle maven repo

## cpp_local_consumer

Step 6: use the C++ dependency

* upgrade gradle and the jdk to support FFM
* make some FFM utility classes for loading the library
* make a Java test that exercises the C++ code above
* make a vendor json file with a `jniDependency`
* specify `useLocal` in the build.gradle
* gradle picks up the native dependency, and the test passes

## simple_cpp_remote

Step 7: same C++ dependency, served remotely

* changed the version number, redid the zip file
* put the files in the repository directory

## cpp_remote_consumer

Step 8: same C++ test, using remote dependency

* remove 'useLocal'
* change the version number
* add a mavenUrl

## simple_proxy_local

Step 9: proxy classes in a local dependency

* copy the FFM utility classes
* jar and pom in local maven

## dual_local_consumer

Step 10: both dependencies

* add a javaDependency to the c++ vendordep above
* test passes.