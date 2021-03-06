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
package se.natusoft.tools.optionsmgr;

import se.natusoft.tools.optionsmgr.internal.*;

/**
 * Loads the options from a command line string array. Please note that arguments mapping to options are
 * expected to have 0 (only if boolean and annotated with 'flag=true') or 1 value!
 * <p>
 * Even though it is possible to map command line arguments to simple structured models without lists
 * of options you should strongly consider keeping the model structure for command line arguments very
 * simple. If you really need a complex structured config and combine it with command line consider
 * the following commnd line argument: "--config file" and then load the specified config file using
 * one of the XML variants of OptionsManager.
 * <p>
 * This class is thread safe even though the very unlikely need for that!
 * <p>
 * The &lt;T&gt; is the top level option model to manage. Due to limitations in Java Generics the
 * Class object of this model class must also be passed to the constructor.
 */
public class CommandLineOptionsManager<T> extends OptionsManager<T> {

    //
    // Arguments
    //

    /**
     * The CommandLineOptionsManagers arguments.
     */
    private static class CLOMArguments implements Arguments {

        /** The prefix used to indicate an option. */
        private String argPrefix = "--";

        /** The command line args. */
        private String[] args;

        /** The start argument to parse. */
        private int startArg= 0;

        /** The delimeter of a component argument name that maps to a model structure. */
        private String modelSeparator = "-";

    }

    //
    // Constructors
    //

    /**
     * Creates a new CommandLineOptionsManager.
     * 
     * @param modelClass The class of the top model to load options into. An instance of this will be returned on loadOptions().
     *
     * @throws OptionsModelException on failure to parse the specified model class.
     */
    public CommandLineOptionsManager(Class modelClass) throws OptionsModelException {
        super(modelClass, OptionsManagerType.RANDOM);
        setModelPathSeparator("-");
    }

    //
    // Methods
    //

    /**
     * Loads the options and returns a populated model.
     * <p>
     * This defaults the model separator to "-" and the arguments prefix to "--".
     *
     * @param args The arguments to parse and load into the config models.
     *
     * @throws OptionsException on failure or bad arguments.
     */
    public T loadOptions(String[] args) throws OptionsException {
        CLOMArguments arguments = new CLOMArguments();
        arguments.args = args;
        return loadOptionsNoIO(arguments);
    }

    /**
     * Loads the options and returns a populated model.
     * <p>
     * This defaults the model separator to "-" and the arguments prefix to "--".
     *
     * @param args The arguments to parse and load into the config models.
     * @param startArg The first argument in the argument array to start at.
     *
     * @throws OptionsException on failure or bad arguments.
     */
    public T loadOptions(String[] args, int startArg) throws OptionsException {
        CLOMArguments arguments = new CLOMArguments();
        arguments.args = args;
        arguments.startArg = startArg;
        return loadOptionsNoIO(arguments);
    }


    /**
     * Loads the options and returns a populated model.
     * <p>
     * This defaults the model separator to "-".
     *
     * @param argPrefix The expected prefix for arguments.
     * @param args The arguments to parse and load into the config models.
     *
     * @throws OptionsException on failure or bad arguments.
     */
    public T loadOptions(String argPrefix, String[] args) throws OptionsException {
        CLOMArguments arguments = new CLOMArguments();
        arguments.argPrefix = argPrefix;
        arguments.args = args;
        return loadOptionsNoIO(arguments);
    }

    /**
     * Loads the options and returns a populated model.
     * <p>
     * This defaults the model separator to "-".
     *
     * @param argPrefix The expected prefix for arguments.
     * @param args The arguments to parse and load into the config models.
     * @param startArg The first argument in the argument array to start at.
     *
     * @throws OptionsException on failure or bad arguments.
     */
    public T loadOptions(String argPrefix, String[] args, int startArg) throws OptionsException {
        CLOMArguments arguments = new CLOMArguments();
        arguments.argPrefix = argPrefix;
        arguments.args = args;
        arguments.startArg = startArg;
        return loadOptionsNoIO(arguments);
    }

    /**
     * Loads the options and returns a populated model.
     *
     * @param argPrefix The expected prefix for arguments.
     * @param modelSeparator The delimeter of a compnent argument that maps to a model structure.
     * @param args The arguments to parse and load into the config models.
     *
     * @throws OptionsException on failure or bad arguments.
     */
    public T loadOptions(String argPrefix, String modelSeparator, String[] args) throws OptionsException {
        CLOMArguments arguments = new CLOMArguments();
        arguments.argPrefix = argPrefix;
        arguments.modelSeparator = modelSeparator;
        arguments.args = args;
        return loadOptionsNoIO(arguments);
    }

    /**
     * Loads the options and returns a populated model.
     *
     * @param argPrefix The expected prefix for arguments.
     * @param modelSeparator The delimeter of a compnent argument that maps to a model structure.
     * @param args The arguments to parse and load into the config models.
     * @param startArg The first argument in the argument array to start at.
     *
     * @throws OptionsException on failure or bad arguments.
     */
    public T loadOptions(String argPrefix, String modelSeparator, String[] args, int startArg) throws OptionsException {
        CLOMArguments arguments = new CLOMArguments();
        arguments.argPrefix = argPrefix;
        arguments.modelSeparator = modelSeparator;
        arguments.args = args;
        arguments.startArg = startArg;
        return loadOptionsNoIO(arguments);
    }

    /**
     * Implements the populating of the model from the command line arguments.
     *
     * @param optionInfos Extracted information about the specified options model to populate.
     * @param arguments The same arguments as passed to loadOptions(Arguments).
     *
     * @throws Exception on any failure.
     */
    @Override
    protected void loadOptions(OptionInfos optionInfos, Arguments arguments) throws Exception {
        CLOMArguments loadArguments = (CLOMArguments)arguments;

        int argp = loadArguments.startArg;
        while (argp < loadArguments.args.length) {
            String arg = loadArguments.args[argp];
            if (!arg.startsWith(loadArguments.argPrefix)) {
                throw new OptionsException("Expected an argument prefixed with '" + loadArguments.argPrefix + "', but found '" + arg + "'! This is a bad argument.");
            }
            arg = arg.substring(loadArguments.argPrefix.length());
            OptionInfo optionInfo = optionInfos.getOptionInfoByPublicPath(Path.fromStringSeparatedBy(arg, loadArguments.modelSeparator));
            if (optionInfo == null) {
                throw new OptionsException("'" + loadArguments.argPrefix + arg + "' is not a known argument!");
            }
            optionInfo.assureModelInstance();
            String argValue = null;
            if (optionInfo.isFlag()) {
                if ((argp + 1) < loadArguments.args.length) {
                    String checkArg = loadArguments.args[argp + 1];
                    if (!checkArg.startsWith(loadArguments.argPrefix)) {
                        argValue = checkArg;
                        ++argp;
                    }
                }
            }
            else {
                argValue = loadArguments.args[++argp];
            }
            optionInfo.setValueAsString(argValue);

            ++argp;
        }
    }

}
