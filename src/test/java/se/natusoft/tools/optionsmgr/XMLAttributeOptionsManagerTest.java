package se.natusoft.tools.optionsmgr;

import org.junit.*;

import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Tests XMLAttributeOptionsManager functionality.
 */
public class XMLAttributeOptionsManagerTest {

    public XMLAttributeOptionsManagerTest() {
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
     * Test of loadOptions method, of class XMLAttributeOptionsManager.
     */
    @Test
    public void loadOptionsLessComplexOptionModel() throws Exception {

        InputStream xmlStream = getClass().getResourceAsStream("projectAttr.xml");
        
        XMLAttributeOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex.Project> xaom =
                new XMLAttributeOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex.Project>(se.natusoft.tools.optionsmgr.testmodels.complex.Project.class);

        se.natusoft.tools.optionsmgr.testmodels.complex.Project project = xaom.loadOptions(xmlStream);

        xaom.validateLoadedOptions("", "/");

//        System.out.println(project.toString());
        
        assertNotNull(project);
        assertTrue(project.getName().equals("testproj"));
        assertTrue(project.getDescription().equals("Some Description."));
        assertTrue(project.getProjectLicense().getLicenseType().equals("ASF"));
        assertTrue(project.getProjectLicense().getLicenseVersion() == 2);
        assertTrue(project.getThirdpartyLicenses().getLicenses().get(0).getLicenseType().equals("GPL"));
        assertTrue(project.getThirdpartyLicenses().getLicenses().get(0).getLicenseVersion() == 3);
        assertTrue(project.getThirdpartyLicenses().getLicenses().get(1).getLicenseType().equals("LGPL"));
        assertTrue(project.getThirdpartyLicenses().getLicenses().get(1).getLicenseVersion() == 2);
    }

    /**
     * Test of loadOptions method, of class XMLAttributeOptionsManager.
     */
    @Test
    public void loadOptionsMoreComplexOptionModel() throws Exception {

        InputStream xmlStream = getClass().getResourceAsStream("projectAttr2.xml");

        XMLAttributeOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex2.Project> xaom =
                new XMLAttributeOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex2.Project>(se.natusoft.tools.optionsmgr.testmodels.complex2.Project.class);

        se.natusoft.tools.optionsmgr.testmodels.complex2.Project project = xaom.loadOptions(xmlStream);

//        System.out.println(project.toString());

        assertNotNull(project);
        assertTrue(project.getName().equals("testproj"));
        assertTrue(project.getDescription().equals("Some Description."));
        assertTrue(project.getProjectLicense().getLicenseType().getValue().equals("ASF"));
        assertTrue(project.getProjectLicense().getLicenseVersion().getValue() == 2.0);
        assertTrue(project.getThirdpartyLicenses().getLicenses().get(0).getLicenseType().getValue().equals("GPL"));
        assertTrue(project.getThirdpartyLicenses().getLicenses().get(0).getLicenseVersion().getValue() == 3.0);
        assertTrue(project.getThirdpartyLicenses().getLicenses().get(1).getLicenseType().getValue().equals("LGPL"));
        assertTrue(project.getThirdpartyLicenses().getLicenses().get(1).getLicenseVersion().getValue() == 2.0);
    }

    /**
     * Test of loadOptions method, of class XMLAttributeOptionsManager.
     */
    @Test
    public void loadOptionsValidateRequredValues() throws Exception {

        InputStream xmlStream = getClass().getResourceAsStream("projectAttrFaulty.xml");

        XMLAttributeOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex.Project> xaom =
                new XMLAttributeOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex.Project>(se.natusoft.tools.optionsmgr.testmodels.complex.Project.class);

        se.natusoft.tools.optionsmgr.testmodels.complex.Project project = xaom.loadOptions(xmlStream);

        assertNotNull(project);
        try {
            xaom.validateLoadedOptions("", "/");
            fail("This test is supposed to fail since it is missing the required 'project/name'!");
        }
        catch (OptionsException oe) {
            // OK this is expected!
        }

    }

    /**
     * Test of loadOptions method, of class XMLAttributeOptionsManager.
     */
    @Test
    public void loadOptionsHelpText() throws Exception {

        InputStream xmlStream = getClass().getResourceAsStream("projectAttr.xml");

        XMLAttributeOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex.Project> xaom =
                new XMLAttributeOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex.Project>(se.natusoft.tools.optionsmgr.testmodels.complex.Project.class);

        se.natusoft.tools.optionsmgr.testmodels.complex.Project project = xaom.loadOptions(xmlStream);

        assertNotNull(project);

        String helpText = xaom.getHelpTextAsString("", "/");

        assertTrue(helpText.indexOf("Test of top level model general description.") >= 0);
        assertTrue(helpText.indexOf("project/name") > 0);
        assertTrue(helpText.indexOf("The project name.") > 0);
        assertTrue(helpText.indexOf("project/description") > 0);
        assertTrue(helpText.indexOf("A description of the project") > 0);
        assertTrue(helpText.indexOf("project/projectLicense/licenseType") > 0);
        assertTrue(helpText.indexOf("Specifies the license type.") > 0);
        assertTrue(helpText.indexOf("project/projectLicense/licenseVersion") > 0);
        assertTrue(helpText.indexOf("Specifies the license version.") > 0);
        assertTrue(helpText.indexOf("project/thirdparty/license/licenseType") > 0);
        assertTrue(helpText.indexOf("project/thirdparty/license/licenseVersion") > 0);

    }

}
