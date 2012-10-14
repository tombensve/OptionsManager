package se.natusoft.tools.optionsmgr.testmodels.complex2;

import java.util.ArrayList;
import java.util.List;
import se.natusoft.tools.optionsmgr.annotations.Option;
import se.natusoft.tools.optionsmgr.annotations.OptionsModel;

/**
 * Test model.
 */
@OptionsModel(name="thirdparty")
public class ThirdpartyLicenses {

    @Option(name="license", type=License.class, description="A license specification.")
    private List<License> licenses = new ArrayList<License>();

    public void addLicense(License license) {
        this.licenses.add(license);
    }

    public List<License> getLicenses() {
        return this.licenses;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ThirdpartyLicenses {\n");
        for (License lic : this.licenses) {
            sb.append("    ");
            sb.append(lic);
            sb.append("\n");
        }
        sb.append("}");

        return sb.toString();
    }
}
