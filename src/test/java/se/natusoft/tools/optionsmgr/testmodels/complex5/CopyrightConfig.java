package se.natusoft.tools.optionsmgr.testmodels.complex5;

import se.natusoft.tools.optionsmgr.annotations.Description;
import se.natusoft.tools.optionsmgr.annotations.Option;

/**
 * Holds copyright information. There can be more than one of these for a project.
 */
public class CopyrightConfig {

    //
    // Year
    //

    @Option
    @Description("The copyright year.")
    private String year = null;

    /**
     * Returns the copyright year.
     */
    public String getYear() {
        return this.year;
    }

    /**
     * Sets the copyright year.
     *
     * @param year The year to set.
     */
    public void setYear(String year) {
        this.year = year;
    }

    //
    // Holder
    //

    @Option
    @Description("The copyright holder.")
    private String holder = null;

    /**
     * Returns The name of the copyright holder.
     */
    public String getHolder() {
        return holder;
    }

    /**
     * Sets the copyright holder.
     *
     * @param holder The name of the copyright holder.
     */
    public void setHolder(String holder) {
        this.holder = holder;
    }

    //
    // Rights
    //

    @Option
    @Description("Is meant to holds the string \"All rights reserved.\", but it must be specified. Default is \"\".")
    private String rights = "";

    /**
     * Returns The rights string.
     */
    public String getRights() {
        return this.rights;
    }

    /**
     * Sets the rights string.
     *
     * @param rights The rights string to set.
     */
    public void setRights(String rights) {
        this.rights = rights;
    }

    // -------------------------

    @Override
    public String toString() {
        return "Copyright: year='" + this.year + "', holder='" + this.holder + "'";
    }
}
