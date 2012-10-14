package se.natusoft.tools.optionsmgr.testmodels.complex5;

import se.natusoft.tools.optionsmgr.annotations.Description;
import se.natusoft.tools.optionsmgr.annotations.Option;
import se.natusoft.tools.optionsmgr.annotations.OptionsModel;

@OptionsModel(name="installOptions")
/**
 * Holds all the options for how to install licenses in build.
 */
public class InstallOptionsConfig {

    //
    // Verbose
    //

    @Option
    @Description("If true verbose output is provided.")
    private boolean verbose = false;

    /**
     * Set to true for verbose output. Defaults to false.
     *
     * @param verbose true or false.
     */
    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    /**
     * Returns true if verbose output should be done.
     */
    public boolean isVerbose() {
        return this.verbose;
    }

    //
    // LicenseDir
    //

    @Option
    @Description("The directory to where the licence text should be copied. Defaults to 'license'.")
    private String licenseDir = "license";

    /**
     * Sets the directory in which the project license text file should be copied. 
     * What this path is relative to depends on how this is run. From ant and maven
     * it will be relative to ${basedir}, and from commandline it will be relative
     * the the path of execution. Defaults to "license".
     * 
     * @param licenseDir The dir to copy the license text to.
     */
    public void setLicenseDir(String licenseDir) {
        this.licenseDir = licenseDir;
    }

    /**
     * Returns The directory to copy the project license text to.
     */
    public String getLicenseDir() {
        return licenseDir;
    }

    //
    // ThirdpartyLicenseDir
    //

    @Option
    @Description("The directory to where the thirdparty licence texts are copied. Defaults to 'licnese/thridparty'.")
    private String thirdpartyLicenseDir = "license/thirdparty";

    /**
     * Sets the directory in which license texts for third party licenses will be copied.
     * What this path is relative to depends on how this is run. From ant and maven
     * it will be relative to ${basedir}, and from commandline it will be relative
     * the the path of execution. Defaults to "license/thirdparty".
     * 
     * @param thirdpartyLicenseDir The directory to copy third party license texts to.
     */
    public void setThirdpartyLicenseDir(String thirdpartyLicenseDir) {
        this.thirdpartyLicenseDir = thirdpartyLicenseDir;
    }

    /**
     * Returns The directory to copy third party license texts to.
     */
    public String getThirdpartyLicenseDir() {
        return thirdpartyLicenseDir;
    }

    // -------------------------
    
    @Override
    public String toString() {
        return "InstallOptions: licenceDir='" + this.licenseDir + "', " +
               "thirdPartyLicenceDir='" + this.thirdpartyLicenseDir + "'";
    }

}
