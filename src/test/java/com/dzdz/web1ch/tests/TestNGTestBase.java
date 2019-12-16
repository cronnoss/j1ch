package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.SuiteConfiguration;
import com.dzdz.web1ch.appmanager.ApplicationManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Arrays;

/**
 * Base class for TestJUnit-based test classes
 */
@Listeners(MyTestListener.class)
public class TestNGTestBase {

    Logger logger = LoggerFactory.getLogger(TestNGTestBase.class);

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

    @BeforeMethod
    public void logTestStart(Method m, Object[] p) {
        logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m) {
        logger.info("Stop test " + m.getName());
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