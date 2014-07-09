/* 
 * 
 * PROJECT
 *     Name
 *         OptionsManager
 *     
 *     Description
 *         Manages application/tool options. Options are mapped to Java Bean properties
 *         using annotations. Help texts can be specified for options also using
 *         annotations and a complete help text can be generated by the options manager.
 *         Options can be loaded from command line arg String[] array, an XML file, or a
 *         java properties file.
 *         
 * COPYRIGHTS
 *     Copyright (C) 2009 by Natusoft AB All rights reserved.
 *     
 * LICENSE
 *     Apache 2.0 (Open Source)
 *     
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *     
 *       http://www.apache.org/licenses/LICENSE-2.0
 *     
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *     
 * AUTHORS
 *     tommy ()
 *         Changes:
 *         2014-07-09: Created!
 *         
 */
package se.natusoft.tools.optionsmgr.internal;

import se.natusoft.tools.optionsmgr.annotations.*;

/**
 * Wraps a Field object and supplies information about the annotations.
 */
public class OptionsAnnotationHelper {

    //
    // Private Members
    //

    /** Set to true if the handled field is an option field. */
    private boolean option = false;

    /** The option description. */
    private String description = null;

    /** The option name. */
    private String name = null;

    /** The option field type. Only used with Collections of fields. */
    private Class type = null;

    /** If true the option is required. */
    private boolean required = false;

    /** Provides validation of properties. */
    PropertyValueValidator pvv = new PropertyValueValidator();

    /** If true, argument is always 'true' and does not need to be specified. */
    private boolean flag = false;

    //
    // Constructors
    //

    /**
     * Creates a new OptionsAnnotationHelper for the specified possibly annotated field.
     *
     * @param annotatedProp The property info to supply annotation help for.
     */
    public OptionsAnnotationHelper(PropertyInfo annotatedProp) {
        Option optionAnn = annotatedProp.getAnnotation(Option.class);
        if (optionAnn != null) {
            option = true;
            this.description = optionAnn.description();
            this.name = optionAnn.name();
            this.type = optionAnn.type();
            this.required = optionAnn.required();
            if (optionAnn.validate().trim().length() > 0) {
                this.pvv = new PropertyValueValidator(optionAnn.validate());
            }
            else if (optionAnn.validValues().length > 0) {
                this.pvv = new PropertyValueValidator(optionAnn.validValues());
            }
            this.flag = optionAnn.flag();
        }

        Description descriptionAnn = annotatedProp.getAnnotation(Description.class);
        if (descriptionAnn != null) {
            this.description = descriptionAnn.value();
        }

        Name nameAnn = annotatedProp.getAnnotation(Name.class);
        if (nameAnn != null) {
            this.name = nameAnn.value();
        }

        Type typeAnn = annotatedProp.getAnnotation(Type.class);
        if (typeAnn != null) {
            this.type = typeAnn.value();
        }

        Required requiredAnn = annotatedProp.getAnnotation(Required.class);
        if (requiredAnn != null) {
            this.required = requiredAnn.value();
        }

        Validate validateAnn = annotatedProp.getAnnotation(Validate.class);
        if (validateAnn != null) {
            this.pvv = new PropertyValueValidator(validateAnn.value());
        }

        ValidValues validValuesAnn = annotatedProp.getAnnotation(ValidValues.class);
        if (validValuesAnn != null) {
            this.pvv = new PropertyValueValidator(validValuesAnn.value());
        }

        Flag flagAnn = annotatedProp.getAnnotation(Flag.class);
        if (flagAnn != null) {
            this.flag = flagAnn.value();
        }
    }

    //
    // Methods
    //

    /**
     * Returns true if this field is an option field.
     */
    public boolean isOption() {
        return this.option;
    }

    /**
     * Returns true if there is a name available.
     */
    public boolean hasName() {
        return this.name != null && this.name.trim().length() > 0;
    }

    /**
     * Returns the option name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns true if there is a description available.
     */
    public boolean hasDescription() {
        return this.description != null && this.description.trim().length() > 0;
    }

    /**
     * Returns the description of the option.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns true if there is a type available.
     */
    public boolean hasType() {
        return this.type != null && !this.type.equals(Option.class);
    }

    /**
     * Returns the type of the field.
     */
    public Class getType() {
        return this.type;
    }

    /**
     * Returns true if this option is required.
     */
    public boolean isRequired() {
        return this.required;
    }

    /**
     * Returns the PropertyValueValidator reflecting the annotated validation values.
     */
    public PropertyValueValidator getPropertyValueValidator() {
        return this.pvv;
    }

    /**
     * Returns true if this is a boolean flag.
     */
    public boolean isFlag() {
        return this.flag;
    }
}
