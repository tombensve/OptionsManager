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
package se.natusoft.tools.optionsmgr.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Alternative to Option.flag.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface Flag {
    boolean value() default true;
}

