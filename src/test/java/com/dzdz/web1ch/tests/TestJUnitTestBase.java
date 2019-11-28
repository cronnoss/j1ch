package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.SuiteConfiguration;
import com.dzdz.web1ch.appmanager.ApplicationManager;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.net.URL;

/**
 * Base class for TestJUnit-based test classes
 */
public class TestJUnitTestBase {
    protected final ApplicationManager app = new ApplicationManager(); //extends ApplicationManager

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
}