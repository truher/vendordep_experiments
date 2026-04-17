# vendordep_experiments
Monorepo for all the vendordep stuff

I'm working my way through the vendordep process, in stages.

## simple_vendor_local

Step 1: make a dependency that can be read by maven.

* make a very simple java class 
* package it as a `jar` using the vscode "make jar" button
* make a simple `pom` file
* copy `jar` and `pom` to the local gradle maven repo.

## simple_project_local

Step 2: make a very simple consumer of the code above.

* make a java test that uses the class above
* make a vendor json file
* specify `useLocal` in the build.gradle
* gradle picks up the maven dependency, and the test passes.

## simple_vendor_remote

Step 3: a dependency on the internet.

* same vendor code as step 1
* increment the `jar` and `pom` version number
* copy the files to a place that `github.io` will pick them up

## simple_project_remote

Step 4: use the remote dependency

* same test as step 2
* remove `useLocal`
* use the incremented version number
* add a maven url in the vendor json.
* gradle finds the new maven dependency, and the test passes.
