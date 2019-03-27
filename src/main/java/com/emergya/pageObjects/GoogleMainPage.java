package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.emergya.pageObjects.global.GlobalPage;
import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

/**
 * A Page Object (PO) contain the behavior of a specific page in the application
 * GoogleMainPage: This PO contain the methods to interact with the google main page
 * @author Jose Antonio Sanchez <jasanchez@emergya.com>
 * @author Ivan Bermudez <ibermudez@emergya.com>
 * @author Ivan Gomez <igomez@emergya.com>
 */
public class GoogleMainPage extends BasePageObject {

    /**
     * Logger class initialization.
     */
    static Logger log = Logger.getLogger(GoogleMainPage.class);

    /**
     * Items keys selectors.
     */
    //private static final String SEARCH_FIELD = "searchField";
    private static final String SEARCH_FIELD_XPATH = "searchField";
    private static final String SEARCH_BUTTON = "searchButton";
    private static final String LUCK_BUTTON = "luckButton";
    private static final String IMG_LOGO = "imgLogo";
    private static final String NEW_SEARCH_BUTTON = "newSearchButton";
    private static final String EMERGYA_LINK_GOOGLE = "emergyaLink";

    /**
     * Constructor method
     * @param driver selenium webdriver
     */
    public GoogleMainPage(EmergyaWebDriver driver) {
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

        boolean status = this.isElementVisibleById(IMG_LOGO);

        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - End isReady method");

        return status;
    }

    // Page object methods
    /**
     * This method do a search in google by a string search
     * @param stringSearch
     */
    public void doSearch(String stringSearch) {
        log.info("[log-" + this.getClass().getSimpleName()
                + "]- Start doSearch -[" + this.getClass().getSimpleName()
                + "- method]");

        if (this.isElementVisibleByXPath(SEARCH_FIELD_XPATH)) {
            this.getElementByXPath(SEARCH_FIELD_XPATH).sendKeys(stringSearch);
            this.getElementByXPath(SEARCH_FIELD_XPATH).sendKeys(Keys.ENTER);

            /*if (this.isElementVisibleByXPath(SEARCH_BUTTON)) {
                this.getElementByXPath(SEARCH_BUTTON).click();
            }*/
        }

        log.info(
                "[log-" + this.getClass().getSimpleName() + "]- End doSearch -["
                        + this.getClass().getSimpleName() + "- method]");
    }

    /**
     * This method click on Emergya page
     * @return
     */
    public GlobalPage clickOnEmergyaPage() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start clickOnPage method");
        
        
        this.getElementByXPath(EMERGYA_LINK_GOOGLE).click();
        

        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End clickOnPage method");
        return new GlobalPage(driver);
    }

    /**
     * Check if google logo is displayed
     * @return
     */
    public boolean isLogoDisplayed() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isLogoDisplayed method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isLogoDisplayed method");

        return this.isElementVisibleById(IMG_LOGO);
    }

    /**
     * Check if google search button is displayed
     * @return
     */
    public boolean isSearchButtonDisplayed() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isSearchButtonDisplayed method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isSearchButtonDisplayed method");

        return this.isElementVisibleByName(SEARCH_BUTTON);
    }

    /**
     * Check if google luck button is displayed
     * @return
     */
    public boolean isLuckButtonDisplayed() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isLuckButtonDisplayed method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isLuckButtonDisplayed method");

        return this.isElementVisibleByName(LUCK_BUTTON);
    }

    /**
     * Check if google search field is displayed
     * @return
     */
    public boolean isSearchFieldDisplayed() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isSearchFieldDisplayed method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isSearchFieldDisplayed method");

        return this.isElementVisibleById(SEARCH_FIELD_XPATH);
    }
}