package se.natusoft.tools.optionsmgr.testmodels.complex5;

import java.util.ArrayList;
import java.util.List;
import se.natusoft.tools.optionsmgr.annotations.Description;
import se.natusoft.tools.optionsmgr.annotations.Name;
import se.natusoft.tools.optionsmgr.annotations.Option;
import se.natusoft.tools.optionsmgr.annotations.Type;

/**
 * Holds a list of copyright information.
 */
public class CopyrightsConfig {

    @Option
    @Name("copyright")
    @Type(CopyrightConfig.class)
    @Description("Specifies the copyrights.")
    private List<CopyrightConfig> copyrights = new ArrayList<CopyrightConfig>();

    /**
     * Adds a copyright to the list.
     *
     * @param copyright The copyright to add.
     */
    public void addCopyright(CopyrightConfig copyright) {
        this.copyrights.add(copyright);
    }

    /**
     * Returns the list of copyrights.
     */
    public List<CopyrightConfig> getCopyrights() {
        return this.copyrights;
    }

    /**
     * Returns the first copyright entry. This is a convenience for when hasMoreThanOneCopyright() returns false.
     */
    public CopyrightConfig getCopyright() {
        return this.copyrights.get(0);
    }

    /**
     * Returns true if there is more than one copyright in the list.
     */
    public boolean hasMoreThanOneCopyright() {
        return this.copyrights.size() > 1;
    }

    // -------------------------

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("copyrights = {\n");
        for (CopyrightConfig copyright : this.copyrights) {
            sb.append("    ");
            sb.append(copyright);
            sb.append("\n");
        }
        sb.append("}\n");

        return sb.toString();
    }
}
