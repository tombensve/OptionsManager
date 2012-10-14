package se.natusoft.tools.optionsmgr.testmodels.complex4;

import java.util.ArrayList;
import java.util.List;
import se.natusoft.tools.optionsmgr.annotations.Option;
import se.natusoft.tools.optionsmgr.annotations.OptionsModel;

/**
 * Test model.
 */
@OptionsModel(name="thirdparty")
public class ThirdpartyLicenses {

    @Option(name="licenses", type=License.class, description="A set of license specifications.")
    private ArrayList<License> licenses = new ArrayList<License>();

    public void setLicenses(ArrayList<License> licenses) {
        this.licenses = licenses;
    }
    public List<License> getLicenses() {
        return this.licenses;
    }

    @Override
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
