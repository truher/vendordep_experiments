# simple_project_remote

I started with two changes from the "local" version:

* remove `useLocal` from `build.gradle`.
* change the version number in `simple_vendor.json`

These two changes alone make the build fail, because gradle
can't find the simple_vendor dependency.

So make one more change:

* add a maven URL, for the `github.io` rendition of the `simple_vendor_remote` repository.