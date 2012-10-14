package se.natusoft.tools.optionsmgr.testmodels.simple;

import se.natusoft.tools.optionsmgr.annotations.Option;
import se.natusoft.tools.optionsmgr.annotations.OptionsModel;
import se.natusoft.tools.optionsmgr.annotations.Required;

/**
 * Test model
 */
@OptionsModel(name="project")
public class Project {

    @Option(description="The project name.")
    @Required
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
