package se.natusoft.tools.optionsmgr.testmodels.complex5;

import java.util.ArrayList;
import java.util.List;
import se.natusoft.tools.optionsmgr.annotations.Description;
import se.natusoft.tools.optionsmgr.annotations.Name;
import se.natusoft.tools.optionsmgr.annotations.Option;
import se.natusoft.tools.optionsmgr.annotations.OptionsModel;
import se.natusoft.tools.optionsmgr.annotations.Type;

/**
 * Holds information about third party licenses used.
 */
@OptionsModel(name="thirdpartyLicenses")
public class ThirdpartyLicensesConfig {

    //
    // License list
    //

    @Option
    @Name("license")
    @Type(LicenseConfig.class)
    @Description("Specifies licenses of used third party products.")
    private List<LicenseConfig> licenses = new ArrayList<LicenseConfig>();


    /**
     * Setter for license entries. Please note that this setter can be called
     * several times and will add the entries to a list. This ofcourse breaks normal
     * bean behaviour, but is done this way to be compatible with maven. Maven does
     * not accept add{Property}() methods, but happily calls a setter over and over
     * for each matching entry it finds in the mojo configuration block.
     * <p>
     * These config models are designed to be reusable for maven, ant, and command
     * line usage.
     *
     * @param license
     */
    public void setLicense(LicenseConfig license) {
        addLicense(license);
    }

    /**
     * Adds a license.
     *
     * @param license The license to add.
     */
    public void addLicense(LicenseConfig license) {
        this.licenses.add(license);
    }


    /**
     * Returns The specified licenses.
     */
    public List<LicenseConfig> getLicenses() {
        return this.licenses;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Third party licenses {\n");
        for (LicenseConfig license : this.licenses) {
            sb.append("    " + license + "\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
