import com.typesafe.sbt.GitPlugin.autoImport.git
import de.heikoseeberger.sbtheader.HeaderPlugin.autoImport.{HeaderLicense, headerLicense}
import sbt.Keys._
import sbt._

object CommonSettingsPlugin extends CommonSettingsPluginTpl {

  // the rationale for placing settings defs here is that they should (or can) not be updated automatically using the scala-base-sync script
  // in the following, organizationName and startYear would also be required by sbt-header to generate ready-made license headers
  override lazy val projectSettings: Seq[Def.Setting[_]] = {
    tplProjectSettingsPlus(
      developers := List(Developer("$developer_id$", "$developer_name$", "$developer_email$", url("$developer_url$"))),
      git.baseVersion := "0.0.0",
      // basically only needed for sbt-ghpages
      git.remoteRepo := "git@github.com:$developer_id$/$name$.git",
      // TODO: see https://github.com/sbt/sbt-header#configuration for setting up a license header
      headerLicense := Some(
        HeaderLicense.Custom(
          s"""TODO: define a license header
             |""".stripMargin
        )),
      homepage := Some(url("https://github.com/$developer_id$/$name$")),
      // TODO: (e.g.: "MIT" -> "https://opensource.org/licenses/MIT")
      licenses += "TODO: license type" -> url(
        "https://TODO/uri/of/project/license"
      ),
      organization := "$organization$",
      organizationName := "$organization_name$",
      resolvers ++= Dependencies.resolvers,
      scmInfo := Some(ScmInfo(homepage.value.get, git.remoteRepo.value)),
      startYear := Some($start_year$)
    )
  }
}
