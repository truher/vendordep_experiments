# vendordep_experiments
Monorepo for all the vendordep stuff

I'm working my way through the vendordep process, in stages.

## simple_vendor

Very simple java class, packaged as a jar in the
local maven repository.

## simple_project

Vendor json defines the maven dependency, gradle looks
in the local repo, java test exercises the vendor code.

