# OptionsManager

Copyright © 2012 Natusoft AB

__Version:__ 2.0

__Author:__ Tommy Svensson (tommy@natusoft.se)

----

_A Java tool for handling options in different formats._

[User Guide](https://github.com/tombensve/OptionsManager/blob/master/docs/UserGuide.md)

[Licenses](https://github.com/tombensve/OptionsManager/blob/master/docs/licenses.md)

----

[PDF version of User Guide](https://github.com/tombensve/OptionsManager/blob/master/docs/OptionsManager-User-Guide.pdf)

----

__Maven Repository__

This tool is available for download by maven (and other tools using maven repositories) by
adding the following repository in your settings.xml:

    <profiles>
        <profile>
            <id>bintray</id>
            <repositories>
                <repository>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                    <id>central</id>
                    <name>bintray</name>
                    <url>http://dl.bintray.com/tommy/maven</url>
                </repository>
            </repositories>
            <pluginRepositories>
                <pluginRepository>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                    <id>central</id>
                    <name>bintray-plugins</name>
                    <url>http://dl.bintray.com/tommy/maven</url>
                </pluginRepository>
            </pluginRepositories>
        </profile>
    </profiles>
    <activeProfiles>
       <activeProfile>bintray</activeProfile>
    </activeProfiles>
