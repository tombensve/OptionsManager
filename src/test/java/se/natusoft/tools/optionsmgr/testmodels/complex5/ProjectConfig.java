package se.natusoft.tools.optionsmgr.testmodels.complex5;

import se.natusoft.tools.optionsmgr.annotations.Description;
import se.natusoft.tools.optionsmgr.annotations.Name;
import se.natusoft.tools.optionsmgr.annotations.Option;
import se.natusoft.tools.optionsmgr.annotations.OptionsModel;
import se.natusoft.tools.optionsmgr.annotations.Type;

@OptionsModel(name="project")
public class ProjectConfig {

    //
    // Name
    //

    @Option
    @Description("The name of the project.")
    private String name;

    /**
     * Sets the name of the project.
     * 
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns The name of the project.
     */
    public String getName() {
        return name;
    }

    //
    // Description
    //

    @Option
    @Description("A description of the project.")
    private String description = "";

    /**
     * Sets the project description.
     *
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns The description of the project.
     */
    public String getDescription() {
        return this.description;
    }

    //
    // CodeVersion
    //

    @Option
    @Description("The current version of the project code.")
    private String codeVersion = "";

    /**
     * Sets the version of the project code.
     * 
     * @param codeVersion The version to set.
     */
    public void setCodeVersion(String codeVersion) {
        this.codeVersion = codeVersion;
    }

    /**
     * Returns The current version of the project code.
     */
    public String getCodeVersion() {
        return this.codeVersion;
    }

    //
    // SubProjectOf
    //

    @Option
    @Description("A project of which this is a subproject of.")
    private String subProjectOf = "";

    /**
     * Sets the project this project is a subproject of.
     * 
     * @param subProjectOf The name of the parent project.
     */
    public void setSubProjectOf(String subProjectOf) {
        this.subProjectOf = subProjectOf;
    }

    /**
     * Returns The project this is a subproject of.
     */
    public String getSubProjectOf() {
        return this.subProjectOf;
    }

    //
    // License
    //

    @Option
    @Description("The license of the project.")
    private LicenseConfig license = null;

    /**
     * Sets a license specificaiton.
     *
     * @param license the licenseSpec to set
     */
    public void setLicense(LicenseConfig license) {
        this.license = license;
    }

    /**
     * Returns the license specification.
     */
    public LicenseConfig getLicense() {
        return this.license;
    }

    //
    // Copyrights
    //

    @Option
    @Name("copyright")
    @Type(CopyrightConfig.class)
    @Description("Copyright(s) held by the code.")
    private CopyrightsConfig copyrights = new CopyrightsConfig();

    /**
     * Sets a copyright specificaiton. Please note that this setter can be called
     * several times and will add the entries to a list. This ofcourse breaks normal
     * bean behaviour, but is done this way to be compatible with maven. Maven does
     * not accept add{Property}() methods, but happily calls a setter over and over
     * for each matching entry it finds in the mojo configuration block.
     * <p>
     * These config models are designed to be reusable for maven, ant, and command
     * line usage.
     *
     * @param copyright The copyright specification to set.
     */
    public void setCopyright(CopyrightConfig copyright) {
        addCopyright(copyright);
    }

    /**
     * Adds a copyright specifiecation.
     *
     * @param copyright The copyright specification to add.
     */
    public void addCopyright(CopyrightConfig copyright) {
        this.copyrights.addCopyright(copyright);
    }

    /**
     * Returns the copyright specification.
     */
    public CopyrightsConfig getCopyrights() {
        return this.copyrights;
    }

    @Override
    public String toString() {
        return "Project: name='" + this.name + "', description='" + this.description + "', subProjectOf='" + this.subProjectOf + 
                "', license'" + this.license + "', " + this.copyrights;
    }
}
