package se.natusoft.tools.optionsmgr;

import org.junit.*;

import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Tests XMLElementOptionsManager functionality.
 */
public class XMLElementOptionsManagerTest {

    public XMLElementOptionsManagerTest() {
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
     * Test of loadOptions method, of class XMLElementOptionsManager.
     */
    @Test
    public void loadOptionsLessComplexOptionModel() throws Exception {

        InputStream xmlStream = getClass().getResourceAsStream("project.xml");
        
        XMLElementOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex.Project> xeom =
                new XMLElementOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex.Project>(se.natusoft.tools.optionsmgr.testmodels.complex.Project.class);

        se.natusoft.tools.optionsmgr.testmodels.complex.Project project = xeom.loadOptions(xmlStream);

        xeom.validateLoadedOptions("", "/");

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
     * Test of loadOptions method, of class XMLElementOptionsManager.
     */
    @Test
    public void loadOptionsMoreComplexOptionModel() throws Exception {

        InputStream xmlStream = getClass().getResourceAsStream("project2.xml");

        XMLElementOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex2.Project> xeom =
                new XMLElementOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex2.Project>(se.natusoft.tools.optionsmgr.testmodels.complex2.Project.class);

        se.natusoft.tools.optionsmgr.testmodels.complex2.Project project = xeom.loadOptions(xmlStream);

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
     * Test of loadOptions method, of class XMLElementOptionsManager.
     */
    @Test
    public void loadOptionsValidateRequiredValues() throws Exception {

        InputStream xmlStream = getClass().getResourceAsStream("projectFaulty.xml");

        XMLElementOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex.Project> xeom =
                new XMLElementOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex.Project>(se.natusoft.tools.optionsmgr.testmodels.complex.Project.class);

        se.natusoft.tools.optionsmgr.testmodels.complex.Project project = xeom.loadOptions(xmlStream);

        assertNotNull(project);
        try {
            xeom.validateLoadedOptions("", "/");
            fail("This test is supposed to fail since it is missing the required 'project/name'!");
        }
        catch (OptionsException oe) {
            // OK this is expected!
        }

    }

    /**
     * Test of loadOptions method, of class XMLElementOptionsManager.
     */
    @Test
    public void loadOptionsValidateModelPropertyValue() throws Exception {

        InputStream xmlStream = getClass().getResourceAsStream("projectInvalidLicType.xml");

        XMLElementOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex.Project> xeom =
                new XMLElementOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex.Project>(se.natusoft.tools.optionsmgr.testmodels.complex.Project.class);

        try {
            se.natusoft.tools.optionsmgr.testmodels.complex.Project project = xeom.loadOptions(xmlStream);
        }
        catch (OptionsException oi) {
            assertTrue(oi.getMessage(), oi.getMessage().startsWith("Invalid value (BSD) for 'project/thirdparty/license/licenseType'! Value must match \"[AGL][SPG][FLP]*\"!"));
        }

    }

    /**
     * Test of loadOptions method, of class XMLElementOptionsManager.
     */
    @Test
    public void loadOptionsLessComplexOptionModelWithCollection() throws Exception {

        InputStream xmlStream = getClass().getResourceAsStream("project.xml");

        XMLElementOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex3.Project> xeom =
                new XMLElementOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex3.Project>(se.natusoft.tools.optionsmgr.testmodels.complex3.Project.class);

        se.natusoft.tools.optionsmgr.testmodels.complex3.Project project = xeom.loadOptions(xmlStream);

        xeom.validateLoadedOptions("", "/");

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
     * Test of loadOptions method, of class XMLElementOptionsManager.
     */
    @Test
    public void loadOptionsLessComplexOptionModelWithCollectionUsingList() throws Exception {

        InputStream xmlStream = getClass().getResourceAsStream("projectUsingList.xml");

        XMLElementOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex3.Project> xeom =
                new XMLElementOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex3.Project>(se.natusoft.tools.optionsmgr.testmodels.complex3.Project.class);

        se.natusoft.tools.optionsmgr.testmodels.complex3.Project project = xeom.loadOptions(xmlStream);

        xeom.validateLoadedOptions("", "/");

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
     * Test of loadOptions method, of class XMLElementOptionsManager.
     */
    @Test
    public void loadOptionsLessComplexOptionModelWithCollectionUsingListLikeMaven() throws Exception {

        InputStream xmlStream = getClass().getResourceAsStream("projectUsingList2.xml");

        XMLElementOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex4.Project> xeom =
                new XMLElementOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex4.Project>(se.natusoft.tools.optionsmgr.testmodels.complex4.Project.class);

        se.natusoft.tools.optionsmgr.testmodels.complex4.Project project = xeom.loadOptions(xmlStream);

        xeom.validateLoadedOptions("", "/");

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
     * This test is a real code test taken straight from another tool since it provides a relative complex
     * structure to load with a collections of entries also having a collection. This case cauth some
     * previously uncauth catches that got fixed in version 1.0.1.
     */
    @Test
    public void loadOptionsMoreComplexWithCollectionsInCollections() throws Exception {

        InputStream xmlStream = getClass().getResourceAsStream("config.xml");

        XMLElementOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex5.Configuration> xeom =
                new XMLElementOptionsManager<se.natusoft.tools.optionsmgr.testmodels.complex5.Configuration>(se.natusoft.tools.optionsmgr.testmodels.complex5.Configuration.class);

        se.natusoft.tools.optionsmgr.testmodels.complex5.Configuration config = xeom.loadOptions(xmlStream);

        xeom.validateLoadedOptions("", "/");

//        System.out.println(project.toString());

        assertNotNull(config);

        // project
        assertNotNull(config.getProject());
        assertTrue(config.getProject().getName().equals("My Test Project"));
        assertTrue(config.getProject().getDescription().equals("This is a description of my test project."));
        assertTrue(config.getProject().getLicense().getType().equals("ASF"));
        assertTrue(config.getProject().getLicense().getVersion().equals("2.0"));
        assertTrue(config.getProject().getCopyrights().getCopyrights().get(0).getHolder().equals("Natusoft AB"));
        assertTrue(config.getProject().getCopyrights().getCopyrights().get(0).getYear().equals("2009"));
        assertTrue(config.getProject().getCopyrights().getCopyrights().get(1).getHolder().equals("Tommy Svensson"));
        assertTrue(config.getProject().getCopyrights().getCopyrights().get(1).getYear().equals("2008"));

        // thirdpartyLicenses
        assertNotNull(config.getThirdpartyLicenses());
        assertTrue(config.getThirdpartyLicenses().getLicenses().get(0).getType().equals("LGPL"));
        assertTrue(config.getThirdpartyLicenses().getLicenses().get(0).getVersion().equals("v3"));
        assertTrue(config.getThirdpartyLicenses().getLicenses().get(0).getProducts().get(0).equals("BeanShell-1.3.0"));
        assertTrue(config.getThirdpartyLicenses().getLicenses().get(0).getProducts().get(1).equals("Something-5.8"));
        assertTrue(config.getThirdpartyLicenses().getLicenses().get(1).getType().equals("ASF"));
        assertTrue(config.getThirdpartyLicenses().getLicenses().get(1).getVersion().equals("2.0"));
        assertTrue(config.getThirdpartyLicenses().getLicenses().get(1).getProducts().get(0).equals("Whatever-5.0"));

        // codeOptions
        assertNotNull(config.getCodeOptions());
        assertTrue(config.getCodeOptions().isVerbose() == true);
        assertTrue(config.getCodeOptions().getCodeLanguage().equals("by-extension"));
        assertTrue(config.getCodeOptions().isUpdateLicenseInfo() == false);
        assertTrue(config.getCodeOptions().isUpdateCopyright() == true);
        assertTrue(config.getCodeOptions().isUpdateProject() == false);
        assertTrue(config.getCodeOptions().isAddAuthorsBlock() == true);
        assertTrue(config.getCodeOptions().getSourceCodeDirs().get(0).equals("src/main/java/**/.*.java"));
        assertTrue(config.getCodeOptions().getSourceCodeDirs().get(1).equals("src/main/resources/**/.*.bsh"));
        assertTrue(config.getCodeOptions().getSourceCodeDirs().get(2).equals("src/main/resources/**/.*.properties"));

        // installOptions
        assertNotNull(config.getInstallOptions());
        assertTrue(config.getInstallOptions().isVerbose() == true);
        assertTrue(config.getInstallOptions().getLicenseDir().equals("${basedir}/license"));
        assertTrue(config.getInstallOptions().getThirdpartyLicenseDir().equals("${basedir}/license/thirdparty"));

        // userData
        assertNotNull(config.getUserData());
        assertTrue(config.getUserData().getProperty("maintainer").equals("Tommy Svensson tommy@natusoft.se"));
    }
}
