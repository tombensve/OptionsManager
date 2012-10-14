package se.natusoft.tools.optionsmgr.testmodels.complex5;

import java.util.ArrayList;
import java.util.List;
import se.natusoft.tools.optionsmgr.annotations.Description;
import se.natusoft.tools.optionsmgr.annotations.Option;
import se.natusoft.tools.optionsmgr.annotations.Type;

/**
 * Holds license information. Used for both project license and third party licenses.
 * <p>
 * Please note that for each license type and version a ${type}-${version}.properties
 * is expected to be found in a codelicmgr.licenses package.
 */
public class LicenseConfig {

    //
    // Type
    //

    @Option
    @Description("The license type. Example \"LGPL\" or \"Apache\".")
    private String type = null;

    /**
     * Sets the license type.
     *
     * @param licenseType The license type to set.
     */
    public void setType(String licenseType) {
        this.type = licenseType;
    }

    /**
     * Returns the license type.
     */
    public String getType() {
        return type;
    }

    //
    // Version
    //

    @Option
    @Description("The version of the license. Example \"v3\" or \"2.0\".")
    private String version = null;

    /**
     * Sets the license version.
     *
     * @param version The version to set.
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Returns the license version.
     */
    public String getVersion() {
        return version;
    }

    //
    // Product(s)
    //

    @Option
    @Type(String.class)
    @Description("The used third party product using this license. This is only relevant for thirdparty licenses!")
    private ArrayList<String> products = new ArrayList<String>();

    public void setProducts(ArrayList<String> products) {
        this.products = products;
    }

    public List<String> getProducts() {
        return this.products;
    }

    // -------------------------


    @Override
    public String toString() {
        return "Licence: licenceType='" + this.type + "', licenceVersion='" + this.version + "', products='" + this.products + "'";
    }
}
