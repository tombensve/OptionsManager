package se.natusoft.tools.optionsmgr.testmodels.complex5;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import se.natusoft.tools.optionsmgr.annotations.Description;
import se.natusoft.tools.optionsmgr.annotations.Option;
import se.natusoft.tools.optionsmgr.annotations.OptionsModel;

@OptionsModel(name="codeOptions", description="Holds all the options for the source code update.")
public class CodeOptionsConfig {

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
    // CodeLanguage
    //

    @Option
    @Description("The language in which to process source code for.")
    private String codeLanguage = "";

    /**
     * Sets the language in which to process source code for.
     * <p>
     * If this property is not set and remains blank then the extension of the source files
     * will determine the code language and thus also supports more than one langugae in one
     * run. So use this property carefully.
     * 
     * @param codeLanguage The language to set.
     */
    public void setCodeLanguage(String codeLanguage) {
        this.codeLanguage = codeLanguage;
    }

    /**
     * Returns true if this property has been set to something else than the default.
     */
    public boolean haveCodeLanguage() {
        return this.codeLanguage != null && this.codeLanguage.trim().length() > 0;
    }

    /**
     * Returns The code language.
     */
    public String getCodeLanguage() {
        return this.codeLanguage;
    }

    //
    // UpdateLicenseInfo
    //

    @Option
    @Description("If true the license information in the source will be updated.")
    private boolean updateLicenseInfo = true;

    /**
     * Set to true to update the license information in source files. Defaults to true.
     *
     * @param updateLicenseInfo true or false.
     */
    public void setUpdateLicenseInfo(boolean updatelicenseInfo) {
        this.updateLicenseInfo = updatelicenseInfo;
    }

    /**
     * Returns Returns true if license information should be updated in source files.
     */
    public boolean isUpdateLicenseInfo() {
        return this.updateLicenseInfo;
    }

    //
    // UpdateCopyright
    //

    @Option
    @Description("If true the Copyright information in the source will be updated.")
    private boolean updateCopyright = false;

    /**
     * Set to true to update the copyright information in source files. Defaults to false.
     *
     * @param updateCopyright true or false.
     */
    public void setUpdateCopyright(boolean updateCopyright) {
        this.updateCopyright = updateCopyright;
    }

    /**
     * Returns Returns true if copyright information should be updated in source files.
     */
    public boolean isUpdateCopyright() {
        return this.updateCopyright;
    }

    //
    // UpdateProject
    //

    @Option
    @Description("If true the Project information will be updated with the information specified.")
    private boolean updateProject = false;

    /**
     * Set to true to update the project information in source files. Defaults to false;
     * 
     * @param updateProject true or false.
     */
    public void setUpdateProject(boolean updateProject) {
        this.updateProject = updateProject;
    }

    /**
     * Returns true of project information should be updated in source files.
     */
    public boolean isUpdateProject() {
        return updateProject;
    }

    //
    // AddAuthorsBlock
    //

    @Option
    @Description("If true The Authors information will be added if it does not exist.")
    private boolean addAuthorsBlock = false;

    /**
     * If set to true a block of information about authors are added if they do not exist. If they
     * exist nothing is done. Not all source code updaters will support this. It wont make sense
     * in all cases. This defaults to false.
     * 
     * @param addAuthorsBlock true or false.
     */
    public void setAddAuthorsBlock(boolean addAuthorsBlock) {
        this.addAuthorsBlock = addAuthorsBlock;
    }

    /**
     * Returns the addAuthorsBlock
     */
    public boolean isAddAuthorsBlock() {
        return addAuthorsBlock;
    }

    //
    // SourceCodeDirs
    //

    @Option
    @Description("The source code directory.")
    private String sourceCodeDirs;

    /**
     * Sets a comma separated list of directories to scan for source files. There is a special format for each 
     * directory specification:
     * <p>
     * <pre>
     *    &lt;root path&gt;[/recursive][/filename filter]
     * </pre>
     * <p>
     * The root path is where it should start scanning for source files. 
     * <p>
     * The recursive part determines if under
     * directories should also be scanned or only the specified directory. It is specified by the path "/**". 
     * <p>
     * The filename filter part is a regular expression that will be applied to each file found. Only matches
     * will of course be used. 
     * <p>
     * Here are some examples:
     * <pre>
     *     .../myproj/src/main/java/** /.*.java      - All java files under .../src/main/java and below.
     *     .../myproj/src/main/java/very/special     - All files in the special directory.
     *     .../myproj/src/main/resources/help/.*.hlp - All .hlp files in the help directory.
     *     .../myproj/src/main/**                    - All files in the main directory and below.
     * </pre>
     * 
     * @param sourceCodeDirs The source code directories to set.
     */
    public void setSourceCodeDirs(String sourceCodeDirs) {
        this.sourceCodeDirs = sourceCodeDirs;
    }

    /**
     * Returns The specified source code directories as a List of string for convenience.
     */
    public List<String> getSourceCodeDirs() {
        StringTokenizer dirTokenizer = new StringTokenizer(this.sourceCodeDirs, ",");
        List dirs = new ArrayList<String>();
        while (dirTokenizer.hasMoreTokens()) {
            dirs.add(dirTokenizer.nextToken().trim());
        }

        return dirs;
    }

    // -------------------------
    
    @Override
    public String toString() {
        return "Options: updateCopyright='" + this.updateCopyright + "', " +
               "updateProject='" + this.updateProject + "', " +
               "addAuthorsBlock='" + this.addAuthorsBlock +  "', " +
               "sourceCodeDirs='" + this.sourceCodeDirs + "'";
    }

}
