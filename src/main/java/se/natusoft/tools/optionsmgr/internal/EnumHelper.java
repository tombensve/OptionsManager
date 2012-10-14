package se.natusoft.tools.optionsmgr.internal;

import se.natusoft.tools.codelicmgr.annotations.*;
import se.natusoft.tools.codelicmgr.enums.Source;

/**
 * Helps extract information from enums.
 */
@Project(
    name="OptionsManager",
    description="Manages application/tool options. Options are mapped to Java Bean properties" +
                "using annotations. Help texts can be specified for options also using" +
                "annotations and a complete help text can be generated by the options manager." +
                "Options can be loaded from command line arg String[] array, an XML file, or a" +
                "java properties file."
)
@Copyright(year="2009", holder="Natusoft AB", rights="All rights reserved.")
@License(
    type="Apache",
    version="2.0",
    description="Apache Software License",
    source=Source.OPEN,
    text={
        "Licensed under the Apache License, Version 2.0 (the 'License');",
        "you may not use this file except in compliance with the License.",
        "You may obtain a copy of the License at",
        "",
        "  http://www.apache.org/licenses/LICENSE-2.0",
        "",
        "Unless required by applicable law or agreed to in writing, software",
        "distributed under the License is distributed on an 'AS IS' BASIS,",
        "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.",
        "See the License for the specific language governing permissions and",
        "limitations under the License."
    }
)
@Authors({
    @Author(
        name="tommy",
        email="",
        changes={
            @Change(when="2009-12-29", description="Created")
        }
    )
})
public class EnumHelper {

    //
    // Private Members
    //
    
    /** The type of the enum we are supporting */
    private Class enumType;

    //
    // Constructors
    //

    /**
     * Creates a new EnumHelper.
     *
     * @param enumType The Class of the enum to support.
     */
    /*package*/ EnumHelper(Class<? extends Enum> enumType) {
        this.enumType = enumType;
    }

    //
    // Methods
    //

    /**
     * Checks if the specified type is an enum.
     * 
     * @param type
     */
    /*package*/ static boolean isEnum(Class type) {
        return type.isEnum();
    }

    /**
     * Returns the enum matching the value or null if none matches. 
     * <p>
     * This will first match the value as is, and if that fails convert the value to uppercase
     * and try again. 
     * 
     * @param value The value to get an enum for.
     */
    public Enum getEnumForValue(String value) {
        Enum enm = null;

        Object[] enums = this.enumType.getEnumConstants();

        for (Object enumObj : enums) {
            if (enumObj.toString().toLowerCase().equals(value.toLowerCase())) {
                enm = (Enum)enumObj;
            }
        }

//        try {
//            enm = Enum.valueOf(this.enumType, value);
//        }
//        catch (IllegalArgumentException iae) {/* OK */}
//
//        if (enm == null) {
//            try {
//                enm = Enum.valueOf(this.enumType, value.toUpperCase());
//            }
//            catch (IllegalArgumentException iae) {/* OK */}
//        }

        return enm;
    }

    /**
     * Returns the enum constant names, but in lowercase.
     */
    public String[] getEnumNames() {
        Object[] enums = this.enumType.getEnumConstants();
        String[] names = new String[enums.length];
        for (int i = 0; i < enums.length; i++) {
            names[i] = enums[i].toString().toLowerCase();
        }

        return names;
    }

    /**
     * Returns a string with each defined enum converted to lowercase, quoted and comma separated.
     * This is for use in error messages to show valid values. 
     */
    public String getAvailableEnumsAsQuotedList() {
        Object[] enums = this.enumType.getEnumConstants();

        StringBuilder sb = new StringBuilder();
        String comma = "";
        for (Object enm : enums) {
            sb.append(comma);
            sb.append('"');
            sb.append(enm.toString().toLowerCase());
            sb.append('"');
            comma = ", ";
        }

        return sb.toString();
    }
}
