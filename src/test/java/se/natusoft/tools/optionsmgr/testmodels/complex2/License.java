package se.natusoft.tools.optionsmgr.testmodels.complex2;

import se.natusoft.tools.optionsmgr.annotations.Option;

/**
 * Test model
 */
public class License {

    @Option(description="Specifies the license type.")
    private LicenseType licenseType;

    @Option(description="Specifies the license version.")
    private LicenseVersion licenseVersion;

    public void setLicenseType(LicenseType licenseType) {
        this.licenseType = licenseType;
    }

    public void setLicenseVersion(LicenseVersion licenseVersion) {
        this.licenseVersion = licenseVersion;
    }

    public LicenseType getLicenseType() {
        return licenseType;
    }

    public LicenseVersion getLicenseVersion() {
        return licenseVersion;
    }
    
    public String toString() {
        return "License {licenceType='" + this.getLicenseType() + "', licenseVersion='" + this.getLicenseVersion() + "'}";
    }

}
