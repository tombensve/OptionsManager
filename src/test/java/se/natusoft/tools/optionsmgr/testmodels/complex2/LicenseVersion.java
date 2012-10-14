package se.natusoft.tools.optionsmgr.testmodels.complex2;

import se.natusoft.tools.optionsmgr.annotations.Option;

public class LicenseVersion {

    @Option
    private float value;

    public void setValue(float value) {
        this.value = value;
    }

    public float getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "LicenseVersion{value=" + value + "}";
    }
}
