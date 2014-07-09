package se.natusoft.tools.optionsmgr;

import org.junit.*;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests CommandLineOptionsManager functionality.
 */
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
