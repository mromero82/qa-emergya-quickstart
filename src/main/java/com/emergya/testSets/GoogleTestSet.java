package com.emergya.testSets;

import com.emergya.pageObjects.GoogleMainPage;
import com.emergya.utils.BasicTestSet;

import static org.testng.AssertJUnit.assertTrue;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTestSet extends BasicTestSet {
    static Logger log = Logger.getLogger(GoogleTestSet.class);
    
    @Override
    @BeforeMethod(description = "startTest")
    public void before() {
        super.before();
    }

    @Override
    @AfterMethod(description = "endTest")
    public void afterAllIsSaidAndDone() {
        super.afterAllIsSaidAndDone();
    }
    
 // **************** TESTS ****************
    // ------ EMERGYA QA SAMPLE TEST ------ //
    // ------ US00001 - Check google main page and do a search ------ //
    /**
     * Description: TO-DO
     *
     * Pre steps:
     * - Open the browser
     *
     * Steps:
     * - To-DO
     * Post steps:
     * - Close the browser
     *
     */
    @Test(description = "emergyaDigitalGoToContact")
    public void googleMainPageSearch(Method method) {
        log.info("[log-TestSet] " + this.getClass().getName()
                + " - Start test method: " + method.getName());

        // Variable declaration and definition
        isReady(googleMainPage = new GoogleMainPage(driver));

        // Steps to build the stage (Pre steps)

        try {
            // Go to www.google.es
            // Check that the google logo is displayed
            /**isLogoDisplayed();

            // Check that the 'Buscar con Google' button is displayed
            isSearchButtonDisplayed();

            // Check that the 'Voy a tener suerte' button is displayed
            isLuckButtonDisplayed();

            // Check that the search field is displayed
            isSearchFieldDisplayed();

            // Do this search 'Hello world!'
            googleMainPage.doSearch("Hello world");

            // Check that several results are displayed
            areSeveralResults();**/

        } finally {
            // Steps to clear the stage (Post steps)
        }

        log.info("[log-TestSet] " + this.getClass().getName()
                + " - End test method: " + method.getName());
    }
    
    // ************************ Methods *************************
    /**
     * Checks if the search return several results
     * @return true if there are several results and false in the opposite case
     */
    
    // ************************ Assertions *************************

    /**
     * This assertion check if logo is displayed
     */
    public void isLogoDisplayed() {
        if (googleMainPage == null) {
            googleMainPage = new GoogleMainPage(driver);
        }
        assertTrue("The logo isn't displayed, it should be displayed",
                googleMainPage.isLogoDisplayed());
    }
    
}
