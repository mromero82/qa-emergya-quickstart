# QA Emergya Quickstart Project
The aim of this project is to provide a maven archetype for selenium projets using the _qa-selenium-handler_ available in https://github.com/Emergya/qa-selenium-handler

## Prerequisites
1. [Maven 3 configuration](/documentation/prerequisites/maven3Installation.md)
2. [Oracle Java 8 installation](/documentation/prerequisites/java8Installation.md)

##Adding dependencies
--
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
