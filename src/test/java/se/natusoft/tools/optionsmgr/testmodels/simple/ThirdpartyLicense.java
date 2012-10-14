package se.natusoft.tools.optionsmgr.testmodels.simple;

import se.natusoft.tools.optionsmgr.annotations.Option;
import se.natusoft.tools.optionsmgr.annotations.OptionsModel;

/**
 * Test model.
 */
@OptionsModel(name="thirdparty")
public class ThirdpartyLicense {

    @Option(name="license", description="A license specification.")
    private License license = new License();

    public void setLicense(License license) {
        this.license = license;
    }

    public License getLicense() {
        return this.license;
    }

    @Override
    public String toString() {
        return "ThirdpartyLicense{" + license + "}";
    }
}
