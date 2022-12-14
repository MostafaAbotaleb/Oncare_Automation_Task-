package org.oncare.cucumber.hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import org.oncare.cucumber.runner.TestState;
import org.oncare.selenium.driver.BrowserFactory;
import org.oncare.selenium.driver.CustomWebDriver;






public class GlobalHooks {
    private static final Logger logger = Logger.getLogger(GlobalHooks.class.getName());

    private static boolean executed = false;

    private static CustomWebDriver globalDriver;

    private final TestState localState;

    public GlobalHooks(TestState localState) {
        this.localState = localState;
    }


    @Before(order = 0)
    public void startBrowser() {
        if (!executed) {
            logger.info("start browser");
            // Create the shared selenium web driver
            globalDriver = BrowserFactory.getBrowser();

            executed = true;
        }

        // Register the afterAll() method
        Runtime.getRuntime().addShutdownHook(new Thread(this::stopBrowser));

        logger.info("set driver");
        localState.setDriver(globalDriver);
        logger.info("driver set");
    }

    private void stopBrowser() {
        logger.info("stop browser");
        if (localState.getDriver() != null) {
            localState.getDriver().quit();
        }
    }

    @After(order = 4)
    public void restartBrowserOnFailure() {
        if (localState.getDriver() != null) {
            globalDriver = localState.getDriver();
        }
    }
}
