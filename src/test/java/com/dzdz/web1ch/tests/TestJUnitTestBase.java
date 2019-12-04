package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.SuiteConfiguration;
import com.dzdz.web1ch.appmanager.ApplicationManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.net.URL;

/**
 * Base class for TestJUnit-based test classes
 */
public class TestJUnitTestBase {
    protected final ApplicationManager app = new ApplicationManager();

    @Before
    public void initTestSuite() throws IOException, InterruptedException {
        SuiteConfiguration config = new SuiteConfiguration();
        ApplicationManager.baseUrl = config.getProperty("site.url");
        if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
            ApplicationManager.gridHubUrl = new URL(config.getProperty("grid.url"));
        }
        ApplicationManager.capabilities = config.getCapabilities();
        app.init();
    }

    @After //(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

    public ApplicationManager getApp() {
        return app;
    }

    public static String randomeString() {
        String generatedstring = RandomStringUtils.randomAlphabetic(6);
        return (generatedstring);
    }

    public static String randomeNum() {
        String generatedString2 = RandomStringUtils.randomNumeric(3);
        return (generatedString2);
    }
}