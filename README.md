# Scala Base
A [Giter8 (g8)](https://github.com/foundweekends/giter8) template for new Scala projects.  
Also serves as a source for syncing the project directory (and other shared files) of existing Scala projects.



## Usage
* Create a project using this template:
```
g8 https://github.com/cerst/scala-base.g8
```
* Set-up license information (see TODOs) in
  * _project/CommonSettingsPlugin.scala_
  * _LICENSE.md_
* Feel free to exclude (by commenting with '#') the following files if your project does not produce a runnable package
  (don't forget to remove them in _/scripts/_scala-base_sync/included\_files_ as well)
  * _project/sbt-build-info-tpl.sbt_
  * _project/sbt-native-packager-tpl.sbt_
  * _project/BuildInfoSettingsPluginTpl.scala_
  * _project/SbtNativePackagerSettingsPluginTpl.scala_



## Configured Plugins

### [Sbt Api Mappings](https://github.com/ThoughtWorksInc/sbt-api-mappings)

Motivation
* Fixes Scaladoc not being able to create even basic link to stock Scala or Java classes

### [Sbt Buildinfp](https://github.com/sbt/sbt-buildinfo)

Motivation
* > sbt-buildinfo generates Scala source from your build definitions.

### [Sbt Coursier](http://get-coursier.io/)

Motivation
* Fast(er) dependency resolution and fetching.  

Relevant Commands:
* _coursierDependencyTree_
  * Render a dependency tree including eviction information (printed yellow)
  * Slightly better visualization compared to [sbt-dependency-graph](https://github.com/jrudolph/sbt-dependency-graph) (IMHO)
  
### [Sbt ghpages](https://github.com/sbt/sbt-ghpages)

Motivation
* publish documentation via Github pages

Relevant Commands
* _ghpagesPushSite_
  * Copies and pushes documentation into the Github pages branch  
  
### [Sbt Git](https://github.com/sbt/sbt-git)

Motivation
* Deduce project version based on git information (tag, commit-id, etc)
* Show Git branch in Sbt terminal

### [Sbt Header](https://github.com/sbt/sbt-header)

Motivation
* Generate **and update** source code license headers

Relevant Commands
* _headerCreate_

### [Sbt License Report](https://github.com/sbt/sbt-license-report)

Motivation
* Check that no problematic licenses are used

Relevant Commands
* dumpLicenseReport (integrated into documentation by this project)

### [Sbt Paradox](https://github.com/lightbend/paradox)

Motivation
* Build website documentation based on markdown
* Variable and snippet inclusion

Relevant Commands (normally, use the _sbt-site_ ones is enough)
* _paradox_
  * generate documentation site into _target/paradox/site/main_
* _paradoxBrowse_
  * generate documentation and open browser (seems to start a Java process as a child of the Sbt session)

   
### [Sbt Scalafmt](https://scalameta.org/scalafmt/)

Motivation
* thorough code formatting (recommendation: use Intellij plugin configured as format-on-save)

### [Sbt Site](https://www.scala-sbt.org/sbt-site/index.html)

Motivation
* Integration requirement for _sbt-ghpages_
* Allows for keeping only the latest documentation in the main branch while not deleting old documentation

Relevant Commands
* _makeSite_
  * generate documentation site into _target/site_
* _previewSite_
  * generate documentation and make it available at _localhost:4000_
  

### [Sbt Updates](https://scalameta.org/scalafmt/)

Motivation
* Check for new releases of dependencies

Relevant Commands:
* _dependencyUpdates_ 



## Development
Test your changes using:
```
sbt g8Test
```