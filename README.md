# vendordep_experiments
Monorepo for all the vendordep stuff

I'm working my way through the vendordep process, in stages.

## simple_vendor_local

Very simple java class, packaged as a jar in the
local maven repository.

## simple_project_local

Vendor json defines the maven dependency, gradle looks
in the local repo, java test exercises the vendor code.

## simple_vendor_remote

Same jar, published using "Github Pages" as a maven repo.

## simple_project_remote

Same project, with vendor json that points at the maven repo.