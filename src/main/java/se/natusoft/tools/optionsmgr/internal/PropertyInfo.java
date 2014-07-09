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

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Wraps a field or a method and provides JavaBean property information.
 */
public class PropertyInfo {

    //
    // Private Members
    //
    
    /** Holds a method. If this is set then field must be null. */
    private Method method = null;

    /** Holds a field. If this is set then method must be null. */
    private Field field = null;

    /** Holds the propertys annotation helper. */
    private OptionsAnnotationHelper annotationHelper = null;

    //
    // Constructors
    //

    /**
     * Creates a new PropertyInfo instance wrapping a Method.
     *
     * @param method The method to wrap.
     */
    public PropertyInfo(Method method) {
        this.method = method;
    }

    /**
     * Creates a new PropertyInfo wrapping a Field.
     *
     * @param field The field to wrap.
     */
    public PropertyInfo(Field field) {
        this.field = field;
    }

    //
    // Methods
    //

    /**
     * Returns the property name.
     */
    public String getName() {
        String name = null;

        if (this.method != null) {
            name = this.method.getName().substring(3);
            name = name.substring(0,1).toLowerCase() + name.substring(1);
        }
        else {
            name = this.field.getName();
        }

        return name;
    }

    /**
     * Returns the property type.
     */
    public Class<?> getType() {
        Class type = null;

        if (this.method != null) {
            type = this.method.getParameterTypes()[0];
        }
        else {
            type = this.field.getType();
        }

        return type;
    }

    /**
     * Sets the propertys annotation helper.
     * 
     * @param annotationHelper The annotation helper to set.
     */
    public void setAnnotationHelper(OptionsAnnotationHelper annotationHelper) {
        this.annotationHelper = annotationHelper;
    }

    /**
     * Returns the propertys annotation helper.
     */
    public OptionsAnnotationHelper getAnnotationHelper() {
        return this.annotationHelper;
    }

    /**
     * Returns the specified annotation.
     *
     * @param <T> The annotation type.
     * @param clazz The annotation class.
     */
    public <T extends Annotation> T getAnnotation(Class<T> clazz) {
        T ann = null;

        if (this.method != null) {
            ann = this.method.getAnnotation(clazz);
        }
        else {
            ann = this.field.getAnnotation(clazz);
        }

        return ann;
    }

    /**
     * Returns true if this property represents a leaf.
     */
    public boolean isLeaf() {
        PropertyTypesHelper pth = PropertyTypesHelper.getInstance();
        boolean leaf = false;

        if (pth.isCollection(getType())) {
            if (getAnnotationHelper().hasType()) {
                Class realType = getAnnotationHelper().getType();
                if (pth.isValidPropertyType(realType)) {
                    leaf = true;
                }
            }
        }
        else {
            leaf = pth.isValidPropertyType(getType());
        }

        return leaf;
    }

    /**
     * Returns true if this property represents a branch.
     */
    public boolean isBranch() {
        PropertyTypesHelper pth = PropertyTypesHelper.getInstance();
        boolean branch = false;

        if (pth.isCollection(getType())) {
            if (getAnnotationHelper().hasType()) {
                Class realType = getAnnotationHelper().getType();
                if (!pth.isValidPropertyType(realType)) {
                    branch = true;
                }
            }
        }
        else {
            branch = !pth.isValidPropertyType(getType());
        }

        return branch;
    }

    @Override
    public String toString() {
        return "{name='" + getName() + "', type='" + getType() + "'}";
    }
}
