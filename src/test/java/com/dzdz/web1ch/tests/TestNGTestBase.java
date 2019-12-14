package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.SuiteConfiguration;
import com.dzdz.web1ch.appmanager.ApplicationManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.net.URL;

/**
 * Base class for TestJUnit-based test classes
 */
@Listeners(MyTestListener.class)
public class TestNGTestBase {
    protected static final ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void initTestSuite(ITestContext context) throws IOException, InterruptedException {
        SuiteConfiguration config = new SuiteConfiguration();
        ApplicationManager.baseUrl = config.getProperty("site.url");
        if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
            ApplicationManager.gridHubUrl = new URL(config.getProperty("grid.url"));
        }
        ApplicationManager.capabilities = config.getCapabilities();
        app.init();
        context.setAttribute("app", app);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
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