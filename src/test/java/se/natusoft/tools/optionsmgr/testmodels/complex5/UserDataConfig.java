package se.natusoft.tools.optionsmgr.testmodels.complex5;

import java.util.Properties;
import se.natusoft.tools.optionsmgr.annotations.Description;
import se.natusoft.tools.optionsmgr.annotations.Option;

/**
 * Holds user supplied information that can be used in update scripts.
 */
public class UserDataConfig {

    /** The properties to populate. */
    private Properties userProps = new Properties();

    /** The current property name. */
    private String currPropName = null;

    /**
     * Sets a property.
     * 
     * @param name The name of the property.
     * @param value The value of the property.
     */
    public void setProperty(String name, String value) {
        this.userProps.setProperty(name, value);
    }

    /**
     * Sets the current property name.
     *
     * @param name The name to set.
     */
    @Option
    @Description("Specifies a name for the data.")
    public void setName(String name) {
        this.currPropName = name;
    }

    /**
     * Sets the current property value.
     *
     * @param value The value to set.
     */
    @Option
    @Description("Specifies a data value.")
    public void setValue(String value) {
        if (this.currPropName == null) {
            throw new RuntimeException("UserDataConfig: A name needs to be provided before a value can be set!");
        }
        this.userProps.setProperty(this.currPropName, value);
        this.currPropName = null;
    }

    /**
     * Returns the set properties.
     */
    public Properties getProperties() {
        return this.userProps;
    }

    /**
     * A convenience for getProperties().getProperty(key).
     *
     * @param key The property key to get.
     */
    public String getProperty(String key) {
        return this.userProps.getProperty(key);
    }

    @Override
    public String toString() {
        return "User properties:" + this.userProps;
    }
}
