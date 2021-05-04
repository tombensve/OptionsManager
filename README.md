# OptionsManager

Copyright © 2012 Natusoft AB

__Version:__ 2.0.2

__Note:__ This version is identical to version 2.0.1 with the exception of dependency versions. The new dependency versions are all available for download on Bintrays JCenter.

__Author:__ Tommy Svensson (tommy@natusoft.se)

----

_A Java tool for handling options in different formats._

USer Guide: [Markdown](https://github.com/tombensve/OptionsManager/blob/master/docs/UserGuide.md) / [PDF](https://github.com/tombensve/OptionsManager/blob/master/docs/OptionsManager-User-Guide.pdf)

[Licenses](https://github.com/tombensve/OptionsManager/blob/master/docs/licenses.md)

----

# Binaries

Since bintray has shut down binaries are now available at https://download.natusoft.se/maven.

You need to add the following to your pom:
```xml
    <repositories>
        <repository>
            <id>ns-repo</id>
            <name>ns-artifact-repository</name>
            <url>https://download.natusoft.se/maven</url>
        </repository>
    </repositories>

    <pluginRepositories>
        <pluginRepository>
            <id>ns-plugin-repo</id>
            <name>ns-plugin-repository</name>
            <url>https://download.natusoft.se/maven</url>
            <releases>
                <enabled>true</enabled>
            </releases>
        </pluginRepository>
    </pluginRepositories>
```

I'm choosing this solution for now since getting things into maven central is still painful even tough it has gotten a little bit better than before. 
The stuff at my GitHub account are things I work on in my spare time. I don't want that time wasted by an overly complicated way of sharing binaries. Bintray really made everyhing as simple as it should be and I mourn its passing! 
