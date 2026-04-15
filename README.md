# vendordep_experiments
Monorepo for all the vendordep stuff

I'm working my way through the vendordep process, in stages:

## The simplest thing

* a tiny bit of "vendor" Java code
* a jar containing it
* stick it in my local gradle maven directory
* tell gradle to look there ("uselocal")
* the simplest possible vendordep json
* a project that uses the vendordep
* a tiny project java test that exercises the vendor code.
