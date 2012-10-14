package se.natusoft.tools.optionsmgr.testmodels.complex2;

import se.natusoft.tools.optionsmgr.annotations.Option;

public class LicenseType {

    @Option
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "LicenseType{value=" + value + "}";
    }
}
