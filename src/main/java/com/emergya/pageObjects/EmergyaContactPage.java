package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class EmergyaContactPage extends BasePageObject {

    /**
     * Logger class initialization.
     */
    static Logger log = Logger.getLogger(GoogleMainPage.class);

    /**
     * Items keys selectors.
     */
    private static final String LINK_SEVILLA = "link_sevilla";
    private static final String DIRECCION = "direccion";
    private static final String TITLE_CONTACT = "title_contact";
    private static final String SECTION_SPAIN = "sectionSpain";

    /**
     * Constructor method
     * @param driver selenium webdriver
     */
    public EmergyaContactPage(EmergyaWebDriver driver) {
        super(driver);
    }

    /**
     * Checks that the PO is ready
     * @param pageObject page object to be used
     */
    @Override
    public boolean isReady() {
        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start isReady method");

        boolean status = this.isElementVisibleById(TITLE_CONTACT);

        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - End isReady method");

        return status;
    }

    // Page object methods

    /**
     * Check if its visible the address
     * of Sevilla
     * @return
     */
    public boolean isAddressSevillaDisplayed() {

        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isAddressSevillaDisplayed method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isAddressSevillaDisplayed method");

        return this.isElementVisibleByXPath(DIRECCION);

    }

    /**
     * Do it click on the url of Sevilla
     * @return
     */
    public void clickOnAddressSevilla() {

        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickOnAddressSevilla method");

        WebElement field = this.getElementByXPath(LINK_SEVILLA);

        WebElement sectionSpain = this.getElementByXPath(SECTION_SPAIN);

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        executor.executeScript("arguments[0].setAttribute('target','_self');",
                field);

        this.scrollTo(sectionSpain);

        field.click();

        this.waitForByXPath(DIRECCION);

        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOnAddressSevilla method");

    }

}
