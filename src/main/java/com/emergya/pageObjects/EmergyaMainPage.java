package com.emergya.pageObjects;

import org.apache.log4j.Logger;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

/**
 * A Page Object (PO) contain the behavior of a specific page in the application
 * EmergyaMainPage: This PO contain the methods to interact with the emergya main page
 * @author Ivan Bermudez <ibermudez@emergya.com>
 * @author Jose Antonio Sanchez <jasanchez@emergya.com>
 * @author Ivan Gomez <igomez@emergya.com>
 */
public class EmergyaMainPage extends BasePageObject {

    /**
     * Logger class initialization.
     */
    static Logger log = Logger.getLogger(GoogleMainPage.class);

    /**
     * Items keys selectors.
     */
    private static final String IMG_LOGO_EMERGYA = "imgLogoEmergya";

    /**
     * Constructor method
     * @param driver selenium webdriver
     */
    public EmergyaMainPage(EmergyaWebDriver driver) {
        super(driver);
        this.isReady();
    }

    /**
     * Checks that the PO is ready
     * @param pageObject page object to be used
     */
    @Override
    public boolean isReady() {
        log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");

        boolean status = this.isElementVisibleByXPath(IMG_LOGO_EMERGYA);

        log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");

        return status;
    }

    // Page object methods
}
