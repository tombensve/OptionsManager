package se.natusoft.tools.optionsmgr.testmodels.simple2;

import se.natusoft.tools.optionsmgr.annotations.Option;
import se.natusoft.tools.optionsmgr.annotations.OptionsModel;

/**
 * Test model
 */
@OptionsModel
public class License {

    @Option(description="Specifies the license type.")
    private String licenseType;

    @Option(description="Specifies the license version.")
    private int licenseVersion;

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public String getLicenseType() {
        return this.licenseType;
    }

    public void setLicenseVersion(int licenseVersion) {
        this.licenseVersion = licenseVersion;
    }

    public int getLicenseVersion() {
        return this.licenseVersion;
    }

    public String toString() {
        return "License {licenceType='" + this.licenseType + "', licenseVersion='" + this.licenseVersion + "'}";
    }
}
