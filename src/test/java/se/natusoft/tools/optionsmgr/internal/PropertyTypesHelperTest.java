package se.natusoft.tools.optionsmgr.internal;

import org.junit.*;
import se.natusoft.tools.optionsmgr.OptionsException;

import java.io.File;
import java.net.URL;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Tests PropertyTypesHelper functionality.
 */
public class PropertyTypesHelperTest {

    private OMOptions omOptions;

    public PropertyTypesHelperTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        this.omOptions = new OMOptions();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testString() throws Exception {
        assertTrue(PropertyTypesHelper.getInstance().isValidPropertyType(String.class));
        assertNotNull(PropertyTypesHelper.getInstance().convertStringToTypeInstance(String.class, "qwerty", this.omOptions));
    }

    @Test
    public void testInteger() throws Exception {
        assertTrue(PropertyTypesHelper.getInstance().isValidPropertyType(int.class));
        assertTrue(PropertyTypesHelper.getInstance().isValidPropertyType(Integer.class));
        assertNotNull(PropertyTypesHelper.getInstance().convertStringToTypeInstance(Integer.class, "5", this.omOptions));
    }


    @Test
    public void testBoolean() throws Exception {
        assertTrue(PropertyTypesHelper.getInstance().isValidPropertyType(boolean.class));
        assertTrue(PropertyTypesHelper.getInstance().isValidPropertyType(Boolean.class));
        assertNotNull(PropertyTypesHelper.getInstance().convertStringToTypeInstance(Boolean.class, "true", this.omOptions));
    }

    @Test
    public void testLong() throws Exception {
        assertTrue(PropertyTypesHelper.getInstance().isValidPropertyType(long.class));
        assertTrue(PropertyTypesHelper.getInstance().isValidPropertyType(Long.class));
        assertNotNull(PropertyTypesHelper.getInstance().convertStringToTypeInstance(Long.class, "767827", this.omOptions));
    }

    @Test
    public void testFloat() throws Exception {
        assertTrue(PropertyTypesHelper.getInstance().isValidPropertyType(float.class));
        assertTrue(PropertyTypesHelper.getInstance().isValidPropertyType(Float.class));
        assertNotNull(PropertyTypesHelper.getInstance().convertStringToTypeInstance(Float.class, "99.45", this.omOptions));
    }

    @Test
    public void testDouble() throws Exception {
        assertTrue(PropertyTypesHelper.getInstance().isValidPropertyType(double.class));
        assertTrue(PropertyTypesHelper.getInstance().isValidPropertyType(Double.class));
        assertNotNull(PropertyTypesHelper.getInstance().convertStringToTypeInstance(Double.class, "2348798.32454", this.omOptions));
    }

    @Test
    public void testByte() throws Exception {
        assertTrue(PropertyTypesHelper.getInstance().isValidPropertyType(byte.class));
        assertTrue(PropertyTypesHelper.getInstance().isValidPropertyType(Byte.class));
        assertNotNull(PropertyTypesHelper.getInstance().convertStringToTypeInstance(Byte.class, "23", this.omOptions));
    }

    @Test
    public void testURL() throws Exception {
        assertTrue(PropertyTypesHelper.getInstance().isValidPropertyType(URL.class));
        assertNotNull(PropertyTypesHelper.getInstance().convertStringToTypeInstance(URL.class, "http://www.natusoft.se/", this.omOptions));
    }

    @Test
    public void testDate() throws Exception {
        assertTrue(PropertyTypesHelper.getInstance().isValidPropertyType(Date.class));
        assertNotNull(PropertyTypesHelper.getInstance().convertStringToTypeInstance(Date.class, "2009-12-29 13:41", this.omOptions));
    }

    @Test
    public void testFile() throws Exception {
        assertTrue(PropertyTypesHelper.getInstance().isValidPropertyType(File.class));
        assertNotNull(PropertyTypesHelper.getInstance().convertStringToTypeInstance(File.class, System.getProperty("user.home"), this.omOptions));
    }

    @Test
    public void testEnum() throws Exception {
        assertTrue(PropertyTypesHelper.getInstance().isValidPropertyType(Thread.State.class));
        assertNotNull(PropertyTypesHelper.getInstance().convertStringToTypeInstance(Thread.State.class, "runnable", this.omOptions));

        try {
            PropertyTypesHelper.getInstance().convertStringToTypeInstance(Thread.State.class, "screwed", this.omOptions);
            fail("This should have thrown an OptionsException!");
        }
        catch (OptionsException oe) {
            // OK.
        }
    }

    @Test
    public void testInvalidType() throws Exception {
        assertFalse(PropertyTypesHelper.getInstance().isValidPropertyType(StringBuilder.class));
    }
}
