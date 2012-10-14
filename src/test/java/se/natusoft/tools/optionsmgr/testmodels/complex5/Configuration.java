package se.natusoft.tools.optionsmgr.testmodels.complex5;

import se.natusoft.tools.optionsmgr.annotations.Description;
import se.natusoft.tools.optionsmgr.annotations.Option;
import se.natusoft.tools.optionsmgr.annotations.OptionsModel;

@OptionsModel(name="configuration", description="The following XML elements are available in the configuration:")
/**
 * This is the main configuration object holding all the other.
 */
public class Configuration {


    /**
     * Creates a new Configuration instance.
     * 
     * @param project The project information configuration.
     * @param thirdpartyLicenses The thirdparty licenses configuration.
     * @param codeOptions The code update options configuration.
     * @param userData The user data configuration values.
     */
    public Configuration(ProjectConfig project, ThirdpartyLicensesConfig thirdpartyLicenses, CodeOptionsConfig codeOptions, UserDataConfig userData) {
        this.project = project;
        this.thirdpartyLicenses = thirdpartyLicenses;
        this.codeOptions = codeOptions;
        this.installOptions = null;
        this.userData = userData;
        if (this.userData == null) {
            this.userData = new UserDataConfig(); // Provide an empty config.
        }
    }

    /**
     * Creates a new Configuration instance.
     *
     * @param project The project information configuration.
     * @param thirdpartyLicenses The thirdparty licenses configuration.
     * @param installOptions The install options configuration.
     */
    public Configuration(ProjectConfig project, ThirdpartyLicensesConfig thirdpartyLicenses, InstallOptionsConfig installOptions) {
        this.project = project;
        this.thirdpartyLicenses = thirdpartyLicenses;
        this.codeOptions = null;
        this.installOptions = installOptions;
        this.userData = new UserDataConfig();
    }

    /**
     * Used when loading via OptionsManager.
     */
    public Configuration() {}

    //
    // Project
    //

    @Option
    @Description("Supplies project informamtion.")
    private ProjectConfig project;

    /**
     * Sets the project configuration information.
     * 
     * @param project The project config to set.
     */
    public void setProject(ProjectConfig project) {
        this.project = project;
    }

    /**
     * Returns the project configuration information.
     */
    public ProjectConfig getProject() {
        return this.project;
    }

    //
    // ThirdpartyLicenses
    //

    @Option
    @Description("Third party licences.")
    ThirdpartyLicensesConfig thirdpartyLicenses;

    /**
     * Sets the configuration inforamtion for the third party licenses.
     * 
     * @param thirdpartyLicenses The third party license config to set.
     */
    public void setThirdpartyLicenses(ThirdpartyLicensesConfig thirdpartyLicenses) {
        this.thirdpartyLicenses = thirdpartyLicenses;
    }

    /**
     * Returns the configuration inforamtion for the third party licenses.
     */
    public ThirdpartyLicensesConfig getThirdpartyLicenses() {
        return this.thirdpartyLicenses;
    }

    //
    // Install Options
    //

    @Option
    @Description("Provides license file install options.")
    private InstallOptionsConfig installOptions;

    /**
     * Sets the install options configuration information.
     * 
     * @param installOptions The install option configuration information to set.
     */
    public void setInstallOptions(InstallOptionsConfig installOptions) {
        this.installOptions = installOptions;
    }

    /**
     * Returns the install options configuration information.
     */
    public InstallOptionsConfig getInstallOptions() {
        return this.installOptions;
    }

    //
    // Code Options
    //

    @Option
    @Description("Provides source code update options.")
    private CodeOptionsConfig codeOptions;

    /**
     * Sets the code update options configuration information.
     *
     * @param codeOptions The code update option configuration information to set.
     */
    public void setCodeOptions(CodeOptionsConfig codeOptions) {
        this.codeOptions = codeOptions;
    }

    /**
     * Returns the code update options configuration information.
     */
    public CodeOptionsConfig getCodeOptions() {
        return this.codeOptions;
    }

    //
    // User Data
    //

    @Option
    @Description("Provides user information for use in personal source code udaters. A name/value pair can occur multiple times!")
    public UserDataConfig userData;

    /**
     * Sets the user data configuration information.
     * @param userData
     */
    public void setUserData(UserDataConfig userData) {
        this.userData = userData;
    }

    /**
     * Returns the user data configuration information.
     */
    public UserDataConfig getUserData() {
        return this.userData;
    }

    // -------------------------


    @Override
    public String toString() {
        return "project:\n" + this.project + "\nthirdpartyLicenses:\n" + this.thirdpartyLicenses + "\ncodeOptions:\n" + this.codeOptions + "\ninstallOptions:\n" + this.installOptions + "\nuserData:\n" + this.userData;
    }
}
