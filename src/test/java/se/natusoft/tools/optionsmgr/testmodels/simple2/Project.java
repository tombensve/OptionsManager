package se.natusoft.tools.optionsmgr.testmodels.simple2;

import se.natusoft.tools.optionsmgr.annotations.Option;
import se.natusoft.tools.optionsmgr.annotations.OptionsModel;

/**
 * Test model
 */
// Having a blank name on the top level model mean it can be omitted when loading, which is usually
// what you want when loading from comman line arguments.
@OptionsModel(name="")
public class Project {

    @Option(description="The project name.")
    private String name;

    @Option(description="A description of the project")
    private String description;
    
    @Option(description="The project license.")
    private License projectLicense;

    @Option(description="The third party license")
    private ThirdpartyLicense thirdpartyLicense;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public License getProjectLicense() {
        return projectLicense;
    }

    public void setProjectLicense(License projectLicense) {
        this.projectLicense = projectLicense;
    }

    public ThirdpartyLicense getThirdpartyLicense() {
        return thirdpartyLicense;
    }

    public void setThirdpartyLicense(ThirdpartyLicense thirdpartyLicense) {
        this.thirdpartyLicense = thirdpartyLicense;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Project {\n");
        sb.append("  name='" + name + "'\n");
        sb.append("  description='" + description + "'\n");
        sb.append("  projectLicense=" + projectLicense + "\n");
        sb.append("  thirdpartyLicense=" + thirdpartyLicense + "\n");
        sb.append("}\n");
        return sb.toString();
    }
}
