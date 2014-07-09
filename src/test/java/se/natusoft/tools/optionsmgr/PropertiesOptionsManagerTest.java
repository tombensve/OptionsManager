package se.natusoft.tools.optionsmgr;

import org.junit.*;

import java.util.Properties;

import static org.junit.Assert.assertTrue;

/**
 * Tests PropertiessOptionsManager functionality.
 */
public class PropertiesOptionsManagerTest {

    public PropertiesOptionsManagerTest() {
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
     * Test of loadOptions method, of class PropertiesOptionsManager.
     */
    @Test
    public void loadOptions() throws Exception {
        Properties props = new Properties();
        props.setProperty("project.name", "testproj");
        props.setProperty("project.description", "Some description.");
        props.setProperty("project.projectLicense.licenseType", "ASF");
        props.setProperty("project.projectLicense.licenseVersion", "2");
        props.setProperty("project.thirdparty.license.licenseType", "GPL");
        props.setProperty("project.thirdparty.license.licenseVersion", "3");
        
        PropertiesOptionsManager<se.natusoft.tools.optionsmgr.testmodels.simple.Project> pom =
                new PropertiesOptionsManager<se.natusoft.tools.optionsmgr.testmodels.simple.Project>(se.natusoft.tools.optionsmgr.testmodels.simple.Project.class);

        se.natusoft.tools.optionsmgr.testmodels.simple.Project project = pom.loadOptions(props);

//        System.out.println(project.toString());
        
        assertTrue(project.getName().equals("testproj"));
        assertTrue(project.getDescription().equals("Some description."));
        assertTrue(project.getProjectLicense().getLicenseType().equals("ASF"));
        assertTrue(project.getProjectLicense().getLicenseVersion() == 2);
        assertTrue(project.getThirdpartyLicense().getLicense().getLicenseType().equals("GPL"));
        assertTrue(project.getThirdpartyLicense().getLicense().getLicenseVersion() == 3);
    }

}
