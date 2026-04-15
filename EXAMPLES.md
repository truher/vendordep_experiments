# Examples

Here's what other people do.



## Examples from the [vendor json repo](https://github.com/wpilibsuite/vendor-json-repo)


**Advantagekit**:
does something similar to the wpi template,
but not the same, uses kotlin.
[example](https://github.com/Mechanical-Advantage/AdvantageKit/blob/main/akit/publish.gradle).  uses a [template json file](https://github.com/Mechanical-Advantage/AdvantageKit/blob/main/akit/AdvantageKit.json).
Is hosted from frcmaven.wpi.edu, publish uses username/password env vars.


**Choreo**:
hosted from [frcmaven](https://frcmaven.wpi.edu/artifactory/sleipnirgroup-mvn-release/). 
There seems to be a vendordep tree [here](https://github.com/SleipnirGroup/Choreo/tree/main/choreolib).
The json file seems to be served from the choreo doc tree,
which is "github pages" with a
[CNAME](https://github.com/SleipnirGroup/Choreo/blob/main/docs/CNAME).
For example, java artifacts are [here](https://frcmaven.wpi.edu/ui/native/sleipnirgroup-mvn-release/choreo/ChoreoLib-java/2026.0.3/) (javadoc, sources, jar, pom),
and cpp artifacts are [here](https://frcmaven.wpi.edu/ui/native/sleipnirgroup-mvn-release/choreo/ChoreoLib-cpp/2026.0.3/),
(headers, sources, architectures with shared, static, with and without debug).



**PathplannerLib**:
hosted out of [github pages](https://3015rangerrobotics.github.io/pathplannerlib/repo),
using a [dedicated repo](https://github.com/3015RangerRobotics/3015RangerRobotics.github.io)
the code itself seems to be [here](https://github.com/mjansen4857/pathplanner)
and it's built using the normal build.gradle and publish.gradle.
the json file master appears to be in that dedicated repo.


**Redux**:
uses a [json file](https://github.com/Redux-Robotics/canandrepo-public/blob/main/ReduxLib/ReduxLib_2026.json) that points at maven.reduxrobotics.com.  includes all three
pieces of the vendordep -- java, jni, and cpp.


**[Grapple](https://github.com/GrappleRobotics/libgrapplefrc)**
serves out of google storage somehow.
looks like the vendor template with some changes,
since they build the rust part there too.



**Photonvision**: have a [maven server](maven.photonvision.org).
The vendordep is [here](https://github.com/PhotonVision/photonvision/tree/main/photon-lib),
is seems different than the template.
munges the [json file](https://github.com/PhotonVision/photonvision/blob/main/photon-lib/src/generate/photonlib.json.in) to fix "photon_version" and "frc_year".
Builds the lib itself, not just the glue.




## Java-only examples

Interesting but not directly helpful.

**[DogLog](https://github.com/jonahsnider/doglog)**:
hosted out of jitpack.  [json file](https://doglog.dev/vendordep.json)
does not seem to use the vendordep build.
the json seems to just
specify a maven dependency in jitpack.
Uses Renovate, which seems to be
some sort of dependency finder/fixer thing.


**5516's [Maple-Sim](https://github.com/Shenzhen-Robotics-Alliance/maple-sim)**:
is Java-only, uses github pages.
The [json](https://shenzhen-robotics-alliance.github.io/maple-sim/vendordep/maple-sim.json) is static.
Appears to use the vendor-template,
with a slightly customized `publish.gradle` file. 
Artifacts are published into the same repo's "doc"
directory.
In the
[contribution guide](https://github.com/Shenzhen-Robotics-Alliance/maple-sim/blob/main/docs/CONTRIBUTION.md)
they suggest using the gradle task "publishing/publishToMavenLocal".
There are "templates" that use maplesim ([example](https://github.com/Shenzhen-Robotics-Alliance/AdvantageKit-TalonSwerveTemplate-MapleSim/tree/main)),
it uses the vendordep json file.


**YAGSL/YAMS**: has a [vendordep project](https://github.com/Yet-Another-Software-Suite/YAGSL/tree/main/vendordep).  uses a [json file](https://github.com/Yet-Another-Software-Suite/YAGSL/blob/main/vendordep/yagsl.json) that points at github pages.



## Other examples

Less helpful.

**[Andymark](https://github.com/AndyMarkProductSoftware/amlib-vendordep)**: there's a vendordep from Andymark, for CAN stuff.  [example](https://andymarkproductsoftware.github.io/amlib-vendordep/repo/2026/)  [example](https://github.com/AndyMarkProductSoftware/amlib-vendordep/tree/gh-pages/repo/2026/com/andymark/frc).  this appears to be only a published-artifact repo; the vendordep build
is somewhere else (private?)

**Phoenix**: CTRE keeps everything private, runs a maven server.

**Playing with fusion**: keeps everything private, runs a maven server.

**Revlib**: keeps everything private, runs a maven server.

**Studica**: private, runs maven.

**Thrifty**: seems like their own thing.

**URCL**: a mechanical advantage thing.

**[246](https://github.com/lobstahbots/nfclib)**: an unfinished example, using github packages, which seems to require some
sort of credentials. The author says they got it working from another
project but that seems not to have been checked in anywhere.
[thread](https://www.chiefdelphi.com/t/custom-library-in-java/503012)

**[177](https://github.com/BobcatRobotics/BobcatLib/tree/main)** a vendordep that, like maple, appears to use the github repo itself as the
maven repo, again using github.io.  It's a java-only vendordep.  It doesn't seem to be used by anyone, including
themselves.

**[4330](https://github.com/rambunction4330/librmb)**: Appears to use githubusercontent as
the maven repo.  The code here is c++, built by build.gradle.  The resulting
library seems never to have actually been used; maybe this is unfinished. Here's
the [CD post about it](https://www.chiefdelphi.com/t/vendordep-template/440357/6).

**Lumyn Labs**: publishes packages/json to a [dedicated repo](https://github.com/Lumyn-Labs/packages)
but none of the code appears to be public.

