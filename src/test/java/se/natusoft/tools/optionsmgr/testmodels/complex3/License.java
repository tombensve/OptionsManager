package se.natusoft.tools.optionsmgr.testmodels.complex3;

import se.natusoft.tools.optionsmgr.annotations.Option;

/**
 * Test model
 */
public class License {

    @Option(description="Specifies the license type.", validate="[AGL][SPG][FLP]*")
    private String licenseType;

    @Option(description="Specifies the license version.")
    private int licenseVersion;

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public void setLicenseVersion(int licenseVersion) {
        this.licenseVersion = licenseVersion;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public int getLicenseVersion() {
        return licenseVersion;
    }
    
    public String toString() {
        return "License {licenceType='" + this.getLicenseType() + "', licenseVersion='" + this.getLicenseVersion() + "'}";
    }

}
