# QA Emergya Quickstart Project
The aim of this project is to provide a maven archetype for selenium projets using the _qa-selenium-handler_ available in https://github.com/Emergya/qa-selenium-handler

## Prerequisites
1. [Maven 3 configuration](/documentation/prerequisites/maven3Installation.md)
2. [Oracle Java 8 installation](/documentation/prerequisites/java8Installation.md)

##Adding dependencies
 1. Add the repository:

   ```xml
        <!-- GtHub Selenium WebDriver Handler Repository -->
        <repository>
                <id>selenium-handler</id>
                <name>Selenium WebDriver Handler</name>
                <url>https://raw.github.com/Emergya/qa-selenium-handler/mvn-repo</url>
        </repository>
    ```
 2. Adding the following maven dependency in your ```pom.xml``` file:


    ```xml
        <dependency>
                <groupId>com.emergya</groupId>
                <artifactId>selenium-handler</artifactId>
                <version>0.0.4</version>
        </dependency>
    ```

## How to use the archetype
Firstly, you have to clone the repository to get the project structure.

Secondly, change in the _pom.xml_ the project groupId, artifactId, name and version for the values you need.

Finally, enjoy coding!

_Do not remove the default developers who made this project real._

## Configuring pom.xml parameters
_pom.xml_ is located in the root path of the project. We have defined repositories for SeleniumHandler, versions of plugins and technologies, parameters for test executions, dependencies, profiles, and all the config for the Build phase. 

###Parameters for test executions
Important parameters to execute tests:

1._browser_: Browser used to launch tests. Allowed values: _Firefox_, _Chrome_ or _IE_.
2._local.OS_: Local OS used. Allowed values: _Windows_ (only with Chrome or IE) or empty.
3._ide.Enabled_:
4._video.Recording.Path_:
5._activate.Video.Recording_:
6._save.Video.For.Passed_:
7._webdriver.chrome.driver_:
8._webdriver.ie.driver_:
