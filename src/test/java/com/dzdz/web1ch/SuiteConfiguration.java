package com.dzdz.web1ch;


import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * Loads test suite configuration from resource files.
 */
public class SuiteConfiguration {

    private static final java.lang.String DEBUG_PROPERTIES = "/debug.properties";

    private Properties properties;

    public SuiteConfiguration() throws IOException {
        this(System.getProperty("application.properties", DEBUG_PROPERTIES));
    }

    public SuiteConfiguration(String fromResource) throws IOException {
        properties = new Properties();
        properties.load(SuiteConfiguration.class.getResourceAsStream(fromResource));
    }

    public Capabilities getCapabilities() throws IOException {
        java.lang.String capabilitiesFile = properties.getProperty("capabilities");

        Properties capsProps = new Properties();
        capsProps.load(SuiteConfiguration.class.getResourceAsStream(capabilitiesFile));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        for (java.lang.String name : capsProps.stringPropertyNames()) {
            java.lang.String value = capsProps.getProperty(name);
            if (value.toLowerCase().equals("true") || value.toLowerCase().equals("false")) {
                capabilities.setCapability(name, Boolean.valueOf(value));
            } else if (value.startsWith("file:")) {
                capabilities.setCapability(name, new File(".", value.substring(5)).getCanonicalFile().getAbsolutePath());
            } else {
                capabilities.setCapability(name, value);
            }
        }

        return capabilities;
    }

    public boolean hasProperty(String name) {
        return properties.containsKey(name);
    }

    public String getProperty(String name) {
        return properties.getProperty(name);
    }
}