package com.emergya.testSets;

import com.emergya.pageObjects.EmergyaDigitalMainPage;
import com.emergya.pageObjects.GoogleMainPage;
import com.emergya.pageObjects.global.GlobalPage;
import com.emergya.utils.BasicTestSet;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmergyaDigitalMainTestSet extends BasicTestSet {
    static Logger log = Logger.getLogger(EmergyaDigitalMainTestSet.class);
    
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
    // ------ USXXX - Emergya Digital Main Page works as expected //
    /**
     * Description: 
     *
     * Pre steps:
     * - Open the browser
     *
     * Steps:
     * - Access the site
     * 
     * Expected Results:
     *  - Check that all elements in page are displayed correctly (background video, opening title,
     *  button Call Us, section levers, section solutions, section success, section blog, section get in touch)
     * Post steps:
     * - Close the browser
     *
     */
   @Test(description = "checkHeaderHasNotBeenUpdated")
    public void checkHeaderHasNotBeenUpdated(Method method) {
        log.info("[log-TestSet] " + this.getClass().getName()
                + " - Start test method: " + method.getName());

        // Variable declaration and definition
        isReady(googleMainPage = new GoogleMainPage(driver));
        
        try {
            // Go to www.google.es
            // Do this search 'www.emergya.digital.com/en/'
            googleMainPage.doSearch("https://www.emergyadigital.com/en/");

            // Access to 'www.emergyadigital.com/en/'
            globalPage = googleMainPage.clickOnEmergyaPage();
            
            //We get emergya digital main page
            emergyaDigitalMainPage = new EmergyaDigitalMainPage(driver);
            
            // Check that main page is ready
            isGlobalPageReady();
            
            // Check footer has not been updated
            assertTrue("Main page has not been displayed properly, elements missing", emergyaDigitalMainPage.isReady());
        }finally {
            
        }
        log.info("[log-TestSet] " + this.getClass().getName()
                + " - End test method: " + method.getName());
    }
    
    /**
     * Description: 
     *
     * Pre steps:
     * - Open the browser
     *
     * Steps:
     * - Access the site
     * - Click on button CALL US
     * 
     * Expected Results:
     *  - Check that we are redirected to section Contact Us
     *  - Check that all elements in that section are displayed correctly
     * Post steps:
     * - Close the browser
     *
     */
   /* @Test(description = "clickOnCallUs")
    public void clickOnCallUs(Method method) {
        log.info("[log-TestSet] " + this.getClass().getName()
                + " - Start test method: " + method.getName());

        // Variable declaration and definition
        isReady(googleMainPage = new GoogleMainPage(driver));
        
        try {
            // Go to www.google.es
            // Do this search 'www.emergya.digital.com/en/'
            googleMainPage.doSearch("https://www.emergyadigital.com/en/");

            // Access to 'www.emergyadigital.com/en/'
            globalPage = googleMainPage.clickOnEmergyaPage();
            
            //We get emergya digital main page
            emergyaDigitalMainPage = new EmergyaDigitalMainPage(driver);
            
            // Check that main page is ready
            isGlobalPageReady();
            
            //Check that emergya digital is ready
            isEmergyaDigitalReady();
            
            contactSectionPage = emergyaDigitalMainPage.clickOnCallUs();
            
            // Check footer has not been updated
            assertTrue("Contact Us section is not displayed properly", contactSectionPage.isReady());
        }finally {
            
        }
        log.info("[log-TestSet] " + this.getClass().getName()
                + " - End test method: " + method.getName());
    }
    
    
    /**
     * Description: 
     *
     * Pre steps:
     * - Open the browser
     *
     * Steps:
     * - Access the site
     * - Check that section Levers has two columns
     * - Click on the button Learn More for the first column
     * 
     * Expected Results:
     *  - We are redirected
     *  - Go back
     *  - Click on the button for the second column
     *  - We are redirected
     * Post steps:
     * - Close the browser
     *
     */
    @Test(description = "sectionLevers")
    public void sectionLevers(Method method) {
        log.info("[log-TestSet] " + this.getClass().getName()
                + " - Start test method: " + method.getName());

        // Variable declaration and definition
        isReady(googleMainPage = new GoogleMainPage(driver));
        
        try {
            // Go to www.google.es
            // Do this search 'www.emergya.digital.com/en/'
            googleMainPage.doSearch("https://www.emergyadigital.com/en/");

            // Access to 'www.emergyadigital.com/en/'
            globalPage = googleMainPage.clickOnEmergyaPage();
            
            //We get emergya digital main page
            emergyaDigitalMainPage = new EmergyaDigitalMainPage(driver);
            
            // Check that main page is ready
            isGlobalPageReady();
            
            //Check we have two columns in section levers
            assertEquals(emergyaDigitalMainPage.getNumberOfColumnsSectionLevers(), 2);
            
            emergyaDigitalMainPage.clickOnButtonForColumnXSectionLevers(1);
            
            
            // Check footer has not been updated
            assertTrue("Main page has not been displayed properly, elements missing", emergyaDigitalMainPage.isReady());
        }finally {
            
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
    
    /**
     * This assertion checks if main page is ready, basically checks that footer and header are displayed
     */
    public void isGlobalPageReady() {
        if (globalPage == null) {
            globalPage = new GlobalPage(driver);
        }
        assertTrue("The global page is not ready, header and footer should be displayed",
                globalPage.isReady());
    }
    
    /**
     * This assertion checks if main page is ready, basically checks that footer and header are displayed
     */
    public void isEmergyaDigitalReady() {
        if (emergyaDigitalMainPage == null) {
            emergyaDigitalMainPage = new EmergyaDigitalMainPage(driver);
        }
        assertTrue("Emergya digital page is not ready",
                emergyaDigitalMainPage.isReady());
    }
}
