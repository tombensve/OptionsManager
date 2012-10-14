package se.natusoft.tools.optionsmgr;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se.natusoft.tools.codelicmgr.annotations.*;
import se.natusoft.tools.codelicmgr.enums.Source;

/**
 * Tests CommandLineOptionsManager functionality.
 */
@Project(
    name="OptionsManager",
    codeVersion="1.0",
    description="Manages options. Options are mapped to Java Bean setters using annotations." +
                "Help texts can be specified for options also using annotations and a complete" +
                "help text can be generated by the options manager. Options can be loaded" +
                "from command line arg String[] array, an XML file, and a java properties file."
)
@Copyright(year="2009", holder="Natusoft AB")
@License(
    type="Apache",
    version="2.0",
    description="Apache License",
    source=Source.OPEN,
    text={
        "Licensed under the Apache License, Version 2.0 (the 'License');",
        "you may not use this file except in compliance with the License.",
        "You may obtain a copy of the License at",
        "",
        "  http://www.apache.org/licenses/LICENSE-2.0",
        "",
        "Unless required by applicable law or agreed to in writing, software",
        "distributed under the License is distributed on an 'AS IS' BASIS,",
        "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.",
        "See the License for the specific language governing permissions and",
        "limitations under the License."
    }
)
@Authors({
    @Author(
        name="Tommy Svensson",
        email="tommy@natusoft.se",
        changes={
            @Change(when="2009-12-17", description="Created")
        }
    )
})
public class CommandLineOptionsManagerTest {

    public CommandLineOptionsManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of loadOptions method, of class CommandLineOptionsManager.
     */
    @Test
    public void loadOptionsNamedTopLevelOptionsModel() throws Exception {
        String[] args = new String[] {
            "--project-name", "testproj",
            "--project-description", "Some description.",
            "--project-projectLicense-licenseType", "ASF",
            "--project-projectLicense-licenseVersion", "2",
            "--project-thirdparty-license-licenseType", "GPL",
            "--project-thirdparty-license-licenseVersion", "3"
        };

        CommandLineOptionsManager<se.natusoft.tools.optionsmgr.testmodels.simple.Project> clom =
                new CommandLineOptionsManager<se.natusoft.tools.optionsmgr.testmodels.simple.Project>(se.natusoft.tools.optionsmgr.testmodels.simple.Project.class);

        se.natusoft.tools.optionsmgr.testmodels.simple.Project project = clom.loadOptions("--", "-", args);

        clom.validateLoadedOptions("--", "-");

//        System.out.println(project.toString());
        
        assertTrue(project.getName().equals("testproj"));
        assertTrue(project.getDescription().equals("Some description."));
        assertTrue(project.getProjectLicense().getLicenseType().equals("ASF"));
        assertTrue(project.getProjectLicense().getLicenseVersion() == 2);
        assertTrue(project.getThirdpartyLicense().getLicense().getLicenseType().equals("GPL"));
        assertTrue(project.getThirdpartyLicense().getLicense().getLicenseVersion() == 3);
    }

    /**
     * Test of loadOptions method, of class CommandLineOptionsManager.
     */
    @Test
    public void loadOptionsUnnamedTopLevelOptionsModel() throws Exception {
        String[] args = new String[] {
            "--name", "testproj",
            "--description", "Some description.",
            "--projectLicense-licenseType", "ASF",
            "--projectLicense-licenseVersion", "2",
            "--thirdparty-license-licenseType", "GPL",
            "--thirdparty-license-licenseVersion", "3"
        };

        CommandLineOptionsManager<se.natusoft.tools.optionsmgr.testmodels.simple2.Project> clom =
                new CommandLineOptionsManager<se.natusoft.tools.optionsmgr.testmodels.simple2.Project>(se.natusoft.tools.optionsmgr.testmodels.simple2.Project.class);

        se.natusoft.tools.optionsmgr.testmodels.simple2.Project project = clom.loadOptions("--", "-", args);

//        System.out.println(project.toString());

        assertTrue(project.getName().equals("testproj"));
        assertTrue(project.getDescription().equals("Some description."));
        assertTrue(project.getProjectLicense().getLicenseType().equals("ASF"));
        assertTrue(project.getProjectLicense().getLicenseVersion() == 2);
        assertTrue(project.getThirdpartyLicense().getLicense().getLicenseType().equals("GPL"));
        assertTrue(project.getThirdpartyLicense().getLicense().getLicenseVersion() == 3);
    }

    /**
     * Test of loadOptions method, of class CommandLineOptionsManager.
     */
    @Test()
    public void loadOptionsValidateRequiredInput() throws Exception {
        String[] args = new String[] {
            "--project-description", "Some description.",
            "--project-projectLicense-licenseType", "ASF",
            "--project-projectLicense-licenseVersion", "2",
            "--project-thirdparty-license-licenseType", "GPL",
            "--project-thirdparty-license-licenseVersion", "3"
        };

        CommandLineOptionsManager<se.natusoft.tools.optionsmgr.testmodels.simple.Project> clom =
                new CommandLineOptionsManager<se.natusoft.tools.optionsmgr.testmodels.simple.Project>(se.natusoft.tools.optionsmgr.testmodels.simple.Project.class);

        se.natusoft.tools.optionsmgr.testmodels.simple.Project project = clom.loadOptions("--", "-", args);

        try {
            clom.validateLoadedOptions("--", "-");
            fail("clom.validateLoadedOptions should have failed since required --name is missing!");
        }
        catch (OptionsException oe) {
            // OK, this is expected.
        }

//        System.out.println(project.toString());

    }

}
