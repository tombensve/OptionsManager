This is build with maven and have dependencies to other maven artifacts that 
are available at bintray.com. Bintrays JCenter is a superset of maven central.
Therefore it can be used as a mirror of maven central which is needed to build
this.

Add relevant parts of the following to your ~/.m2/settings.xml file or copy it if you don't have a settings.xml:

    <?xml version="1.0" encoding="UTF-8" ?>
    <settings xsi:schemaLocation='http://maven.apache.org/SETTINGS/1.0.0
      http://maven.apache.org/xsd/settings-1.0.0.xsd'
        xmlns='http://maven.apache.org/SETTINGS/1.0.0'
          xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>
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
                        <url>http://jcenter.bintray.com</url>
                    </repository>

                </repositories>
                <pluginRepositories>

                    <pluginRepository>
                        <snapshots>
                            <enabled>false</enabled>
                        </snapshots>
                        <id>central</id>
                        <name>bintray-plugins</name>
                        <url>http://jcenter.bintray.com</url>
                    </pluginRepository>

                </pluginRepositories>
            </profile>
        </profiles>

        <activeProfiles>
            <activeProfile>bintray</activeProfile>
        </activeProfiles>
    </settings>

