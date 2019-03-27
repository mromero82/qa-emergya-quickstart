package com.emergya.testSets;

import static org.testng.AssertJUnit.assertTrue;

import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emergya.pageObjects.ContactSectionPage;
import com.emergya.pageObjects.GoogleMainPage;
import com.emergya.pageObjects.global.GlobalPage;
import com.emergya.utils.BasicTestSet;

/**
 * A test class contain the tests of a specific page in the application
 * @author Jose Antonio Sanchez <jasanchez@emergya.com>
 * @author Ivan Bermudez <ibermudez@emergya.com>
 * @author Ivan Gomez <igomez@emergya.com>
 */
public class ContactTestSet extends BasicTestSet {

    static Logger log = Logger.getLogger(ContactTestSet.class);

    public ContactTestSet() {
        super();
    }
    
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
    // ------ US-XXX - Emergya Digital works ------ //
    /**
     * Description: Do a search in Google and access to Emergya Digital and check footer has not been updated
     *
     * - Access to the website
     * - Check that footer has not been updated
     * 
     * Post steps:
     * - Close the browser
     *
     */
    @Test(description = "checkFooterHasNotBeenUpdated")
    public void checkFooterHasNotBeenUpdated(Method method) {
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
            
            // Check that main page is ready
            isGlobalPageReady();
            
            // Check footer has not been updated
            assertTrue("Fotter Updated", globalPage.getFooter().hasFooterBeenUpdated());
        }finally {
            
        }
        log.info("[log-TestSet] " + this.getClass().getName()
                + " - End test method: " + method.getName());
    }
    
    /**
     * Description: Do a search in Google and access to Emergya Digital and check header has not been updated
     *
     * - Access to the website
     * - Check that header has not been updated
     * 
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
            
            // Check that main page is ready
            isGlobalPageReady();
            
            // Check footer has not been updated
            assertTrue("Header Updated", globalPage.getHeader().hasHeaderBeenUpdated());
        }finally {
            
        }
        log.info("[log-TestSet] " + this.getClass().getName()
                + " - End test method: " + method.getName());
    }
    
    
    /**
     * Description: Do a search in Google and access to Emergya Digital and access to Contact section
     *
     * - Access to the website
     * - Click on the link CONTACT in the top bar
     * - Fill in the field Email address with a your own email address
     * - Fill in the field About the project
     * - Check the box to agree to Terms and Conditions
     * - Click on the button SEND FORM
     * - Expected Results
     * - Check that Google Catcha is displayed
     * 
     * Post steps:
     * - Close the browser
     *
     */
   @Test(description = "googleDoSearchAndAccessToPageAndContact")
    public void googleDoSearchAndAccessToPage(Method method) {
        log.info("[log-TestSet] " + this.getClass().getName()
                + " - Start test method: " + method.getName());

        // Variable declaration and definition
        isReady(googleMainPage = new GoogleMainPage(driver));

        // Steps to build the stage (Pre steps)

        try {
            // Go to www.google.es
            // Do this search 'www.emergya.digital.com/en/'
            googleMainPage.doSearch("https://www.emergyadigital.com/en/");

            // Access to 'www.emergyadigital.com/en/'
            globalPage = googleMainPage.clickOnEmergyaPage();
            
            // Check that main page is ready
            isGlobalPageReady();
            
            // Check that the logo is displayed
            isEmergyaLogoDisplayed();
            
            // We check if our footer element has been updated
            globalPage.getFooter().hasFooterBeenUpdated();
            
            // We check if our header element has been updated
            globalPage.getHeader().hasHeaderBeenUpdated();
            
            // Access to the 'Contacto' page
            contactSectionPage = globalPage.getHeader().clickOnContact();
            
            //Is contact section reaady
            isContactPageReady();
            
            //We check again if header and footer are displayed
            isGlobalPageReady();
            
            // Fill in the field Email address
            contactSectionPage.fillInMail("aoviedo@emergya.com");
            
            //Fill in the field About the project
            contactSectionPage.fillInAbout("Test project");
            
            //Check the box Privacy
            contactSectionPage.checkPrivacyBox();
            
            //Click on send Form
            contactSectionPage.clickOnSendForm();
             
            //Check that captcha was displayed
            assertTrue("Google Catcha displayed", contactSectionPage.isGoogleCaptchaDisplayed());

        } finally {
            //driver.close();
        }

        log.info("[log-TestSet] " + this.getClass().getName()
                + " - End test method: " + method.getName());
    }
    
    /**
     * Description: Send form in contact section but don't check the box for privacy
     *
     * - Access to the website
     * - Click on the link CONTACT in the top bar
     * - Fill in the field Email address with a your own email address
     * - Fill in the field About the project
     * - Don't check the box to agree to Terms and Conditions
     * - Click on the button SEND FORM
     * - Expected Results
     * - Check that Google Catcha is not displayed
     * 
     * Post steps:
     * - Close the browser
     *
     */
    @Test(description = "contactSectionNoPrivacyCheck")
    public void contactSectionNoPrivacyCheck(Method method) {
        log.info("[log-TestSet] " + this.getClass().getName()
                + " - Start test method: " + method.getName());

        // Variable declaration and definition
        isReady(googleMainPage = new GoogleMainPage(driver));

        // Steps to build the stage (Pre steps)

        try {
            // Go to www.google.es
            // Do this search 'www.emergya.digital.com/en/'
            googleMainPage.doSearch("https://www.emergyadigital.com/en/");

            // Access to 'www.emergyadigital.com/en/'
            globalPage = googleMainPage.clickOnEmergyaPage();
            
            // Check that main page is ready
            isGlobalPageReady();
            
            // Check that the logo is displayed
            isEmergyaLogoDisplayed();
            
            // We check if our footer element has been updated
            globalPage.getFooter().hasFooterBeenUpdated();
            
            // We check if our header element has been updated
            globalPage.getHeader().hasHeaderBeenUpdated();
            
            // Access to the 'Contacto' page
            contactSectionPage = globalPage.getHeader().clickOnContact();
            
            //Is contact section reaady
            isContactPageReady();
            
            //We check again if header and footer are displayed
            isGlobalPageReady();
            
            // Fill in the field Email address
            contactSectionPage.fillInMail("aoviedo@emergya.com");
            
            //Fill in the field About the project
            contactSectionPage.fillInAbout("Test project");
            
            //Click on send Form
            contactSectionPage.clickOnSendForm();
             
            //Check that captcha was displayed
            assertTrue("Google Catcha is displayed", !contactSectionPage.isGoogleCaptchaDisplayed());

        } finally {
            //driver.close();
        }

        log.info("[log-TestSet] " + this.getClass().getName()
                + " - End test method: " + method.getName());
    }
    
    
    /**
     * Description: Do a search in Google and access to Emergya Digital and access to Contact section
     *
     * - Access to the website
     * - Click on the link CONTACT in the top bar
     * - Don't fill in the field Email address (don't even go to that field)
     * - Fill in the field About the project
     * - Check the box to agree to Terms and Conditions
     * - Click on the button SEND FORM
     * - Expected Results
     * - Check that Google Catcha is not displayed
     * 
     * Post steps:
     * - Close the browser
     *
     */
    @Test(description = "contactSectionFormWithoutEmail")
    public void contactSectionFormWithoutEmail(Method method) {
        log.info("[log-TestSet] " + this.getClass().getName()
                + " - Start test method: " + method.getName());

        // Variable declaration and definition
        isReady(googleMainPage = new GoogleMainPage(driver));

        // Steps to build the stage (Pre steps)

        try {
            // Go to www.google.es
            // Do this search 'www.emergya.digital.com/en/'
            googleMainPage.doSearch("https://www.emergyadigital.com/en/");

            // Access to 'www.emergyadigital.com/en/'
            globalPage = googleMainPage.clickOnEmergyaPage();
            
            // Check that main page is ready
            isGlobalPageReady();
            
            // Check that the logo is displayed
            isEmergyaLogoDisplayed();
            
            // We check if our footer element has been updated
            globalPage.getFooter().hasFooterBeenUpdated();
            
            // We check if our header element has been updated
            globalPage.getHeader().hasHeaderBeenUpdated();
            
            // Access to the 'Contacto' page
            contactSectionPage = globalPage.getHeader().clickOnContact();
            
            //Is contact section reaady
            isContactPageReady();
            
            //We check again if header and footer are displayed
            isGlobalPageReady();
            
            //Fill in the field About the project
            contactSectionPage.fillInAbout("Test project");
            
            //Check the box Privacy
            contactSectionPage.checkPrivacyBox();
            
            //Click on send Form
            contactSectionPage.clickOnSendForm();
             
            //Check that captcha is not displayed displayed
            assertTrue("Google Catcha is displayed", !contactSectionPage.isGoogleCaptchaDisplayed());

        } finally {
            //driver.close();
        }

        log.info("[log-TestSet] " + this.getClass().getName()
                + " - End test method: " + method.getName());
    }
    
    /**
     * Description: Do a search in Google and access to Emergya Digital and access to Contact section
     *
     * - Access to the website
     * - Click on the link CONTACT in the top bar
     * - Fill in the field Email address with a your own email address
     * - Don't fill in the field About the project (don't even put the focus there)
     * - Check the box to agree to Terms and Conditions
     * - Click on the button SEND FORM
     * - Expected Results
     * - Check that Google Catcha is not displayed
     * 
     * Post steps:
     * - Close the browser
     *
     */
    @Test(description = "contactSectionFormWithNoAboutProject")
    public void contactSectionFormWithNoAboutProject(Method method) {
        log.info("[log-TestSet] " + this.getClass().getName()
                + " - Start test method: " + method.getName());

        // Variable declaration and definition
        isReady(googleMainPage = new GoogleMainPage(driver));

        // Steps to build the stage (Pre steps)

        try {
            // Go to www.google.es
            // Do this search 'www.emergya.digital.com/en/'
            googleMainPage.doSearch("https://www.emergyadigital.com/en/");

            // Access to 'www.emergyadigital.com/en/'
            globalPage = googleMainPage.clickOnEmergyaPage();
            
            // Check that main page is ready
            isGlobalPageReady();
            
            // Check that the logo is displayed
            isEmergyaLogoDisplayed();
            
            // We check if our footer element has been updated
            globalPage.getFooter().hasFooterBeenUpdated();
            
            // We check if our header element has been updated
            globalPage.getHeader().hasHeaderBeenUpdated();
            
            // Access to the 'Contacto' page
            contactSectionPage = globalPage.getHeader().clickOnContact();
            
            //Is contact section reaady
            isContactPageReady();
            
            //We check again if header and footer are displayed
            isGlobalPageReady();
            
            // Fill in the field Email address
            contactSectionPage.fillInMail("aoviedo@emergya.com");
            
            //Check the box Privacy
            contactSectionPage.checkPrivacyBox();
            
            //Click on send Form
            contactSectionPage.clickOnSendForm();
             
            //Check that captcha is not displayed
            assertTrue("Google Catcha is displayed", !contactSectionPage.isGoogleCaptchaDisplayed());

        } finally {
            //driver.close();
        }

        log.info("[log-TestSet] " + this.getClass().getName()
                + " - End test method: " + method.getName());
    }
    
    /**
     * Description: Do a search in Google and access to Emergya Digital and access to Contact section
     *
     * - Access to the website
     * - Click on the link CONTACT in the top bar
     * - On the browser, click on Back button
     * - Expected Results
     * - Check that globalPage is displayed correctly
     * - Click in the button Forward and check the section contact is displayed correctly
     * 
     * Post steps:
     * - Close the browser
     *
     */
    @Test(description = "backandForthSectionContact")
    public void backandForthSectionContact(Method method) {
        log.info("[log-TestSet] " + this.getClass().getName()
                + " - Start test method: " + method.getName());

        // Variable declaration and definition
        isReady(googleMainPage = new GoogleMainPage(driver));

        // Steps to build the stage (Pre steps)

        try {
            // Go to www.google.es
            // Do this search 'www.emergyadigital.com/en/'
            googleMainPage.doSearch("https://www.emergyadigital.com/en/");

            // Access to 'www.emergyadigital.com/en/'
            globalPage = googleMainPage.clickOnEmergyaPage();
            
            // Check that main page is ready
            isGlobalPageReady();
            
            // Check that the logo is displayed
            isEmergyaLogoDisplayed();
            
            // We check if our footer element has been updated
            globalPage.getFooter().hasFooterBeenUpdated();
            
            // We check if our header element has been updated
            globalPage.getHeader().hasHeaderBeenUpdated();
            
            // Access to the 'Contacto' page
            contactSectionPage = globalPage.getHeader().clickOnContact();
            
            //Is contact section reaady
            isContactPageReady();
            
            //We check again if header and footer are displayed
            isGlobalPageReady();
            
            //We navigate backawards
            driver.navigate().back();
            
            //We check globalPage is ready again
            isGlobalPageReady();
            
            //We navigate forward
            driver.navigate().forward();
            
            //Check that Contact Section is displayed correctly
            assertTrue("Contact Section is not ready", contactSectionPage.isReady());

        } finally {
            //driver.close();
        }

        log.info("[log-TestSet] " + this.getClass().getName()
                + " - End test method: " + method.getName());
    }
    
    /**
     * Description: Do a search in Google and access to Emergya Digital and access to Contact section and send an email where we use ñáéíóú
     *
     * - Access to the website
     * - Click on the link CONTACT in the top bar
     * - Fill in the field Email address with a your own email address
     * - Fill in the field About the project with ñáéíóú
     * - Check the box to agree to Terms and Conditions
     * - Click on the button SEND FORM
     * - Expected Results
     * - Check that Google Catcha is displayed
     * 
     * Post steps:
     * - Close the browser
     *
     */
    @Test(description = "formAboutWithProblematicCharacters")
    public void formAboutWithProblematicCharacters(Method method) {
        log.info("[log-TestSet] " + this.getClass().getName()
                + " - Start test method: " + method.getName());

        // Variable declaration and definition
        isReady(googleMainPage = new GoogleMainPage(driver));

        // Steps to build the stage (Pre steps)

        try {
            // Go to www.google.es
            // Do this search 'www.emergya.digital.com/en/'
            googleMainPage.doSearch("https://www.emergyadigital.com/en/");

            // Access to 'www.emergyadigital.com/en/'
            globalPage = googleMainPage.clickOnEmergyaPage();
            
            // Check that main page is ready
            isGlobalPageReady();
            
            // Check that the logo is displayed
            isEmergyaLogoDisplayed();
            
            // We check if our footer element has been updated
            globalPage.getFooter().hasFooterBeenUpdated();
            
            // We check if our header element has been updated
            globalPage.getHeader().hasHeaderBeenUpdated();
            
            // Access to the 'Contacto' page
            contactSectionPage = globalPage.getHeader().clickOnContact();
            
            //Is contact section reaady
            isContactPageReady();
            
            //We check again if header and footer are displayed
            isGlobalPageReady();
            
            // Fill in the field Email address
            contactSectionPage.fillInMail("aoviedo@emergya.com");
            
            //Fill in the field About the project
            contactSectionPage.fillInAbout("ñáéíóú");
            
            //Check the box Privacy
            contactSectionPage.checkPrivacyBox();
            
            //Click on send Form
            contactSectionPage.clickOnSendForm();
             
            //Check that captcha was displayed
            assertTrue("Google Catcha displayed", contactSectionPage.isGoogleCaptchaDisplayed());

        } finally {
            //driver.close();
        }

        log.info("[log-TestSet] " + this.getClass().getName()
                + " - End test method: " + method.getName());
    }
    
    /**
     * Description: Do a search in Google and access to Emergya Digital and access to Contact section
     *
     * - Access to the website
     * - Click on the link CONTACT in the top bar
     * - Fill in the field Email address with an invalid email address
     * - Change the focus
     *Expected Results
     * - Check an error message is displayed
     * 
     * Post steps:
     * - Close the browser
     *
     */
    @Test(description = "contactSectionWrongMailFormat")
    public void contactSectionWrongMailFormat(Method method) {
        log.info("[log-TestSet] " + this.getClass().getName()
                + " - Start test method: " + method.getName());

        // Variable declaration and definition
        isReady(googleMainPage = new GoogleMainPage(driver));

        // Steps to build the stage (Pre steps)

        try {
            // Go to www.google.es
            // Do this search 'www.emergya.digital.com/en/'
            googleMainPage.doSearch("https://www.emergyadigital.com/en/");

            // Access to 'www.emergyadigital.com/en/'
            globalPage = googleMainPage.clickOnEmergyaPage();
            
            // Check that main page is ready
            isGlobalPageReady();
            
            // Check that the logo is displayed
            isEmergyaLogoDisplayed();
            
            // We check if our footer element has been updated
            globalPage.getFooter().hasFooterBeenUpdated();
            
            // We check if our header element has been updated
            globalPage.getHeader().hasHeaderBeenUpdated();
            
            // Access to the 'Contacto' page
            contactSectionPage = globalPage.getHeader().clickOnContact();
            
            //Is contact section reaady
            isContactPageReady();
            
            //We check again if header and footer are displayed
            isGlobalPageReady();
            
            // Fill in the field Email address
            contactSectionPage.fillInMail("a@p");
            
            
            assertTrue("Error message is not correct", contactSectionPage.isErrorMessageCorrect("Enter a valid Email address."));

        } finally {
            //driver.close();
        }

        log.info("[log-TestSet] " + this.getClass().getName()
                + " - End test method: " + method.getName());
    }
    
    /**
     * Description: Do a search in Google and access to Emergya Digital and access to Contact section
     *
     * - Access to the website
     * - Click on the link CONTACT in the top bar
     * - Fill in the field Email address with an email address with an emoji
     * - Change the focus
     *Expected Results
     * - Check an error message is displayed
     * 
     * Post steps:
     * - Close the browser
     *
     */
    @Test(description = "contactSectionMailWithEmojis")
    public void contactSectionMailWithEmojis(Method method) {
        log.info("[log-TestSet] " + this.getClass().getName()
                + " - Start test method: " + method.getName());

        // Variable declaration and definition
        isReady(googleMainPage = new GoogleMainPage(driver));

        // Steps to build the stage (Pre steps)

        try {
            // Go to www.google.es
            // Do this search 'www.emergya.digital.com/en/'
            googleMainPage.doSearch("https://www.emergyadigital.com/en/");

            // Access to 'www.emergyadigital.com/en/'
            globalPage = googleMainPage.clickOnEmergyaPage();
            
            // Check that main page is ready
            isGlobalPageReady();
            
            // Check that the logo is displayed
            isEmergyaLogoDisplayed();
            
            // We check if our footer element has been updated
            globalPage.getFooter().hasFooterBeenUpdated();
            
            // We check if our header element has been updated
            globalPage.getHeader().hasHeaderBeenUpdated();
            
            // Access to the 'Contacto' page
            contactSectionPage = globalPage.getHeader().clickOnContact();
            
            //Is contact section reaady
            isContactPageReady();
            
            //We check again if header and footer are displayed
            isGlobalPageReady();
            
            // Fill in the field Email address
            contactSectionPage.fillInMail("a👍oviedo@emergya.com");
            
            
            assertTrue("Error message is not correct", contactSectionPage.isErrorMessageCorrect("Enter a valid Email address."));

        } finally {
            //driver.close();
        }

        log.info("[log-TestSet] " + this.getClass().getName()
                + " - End test method: " + method.getName());
    }
    

    // ************************ Methods *************************
    /**
     * Checks if the search return several results
     * @return true if there are several results and false in the opposite case
     */
    /*public boolean checkSeveralResults() {
        String resultClassName = "r";
        List<WebElement> elements = null;
        boolean isSeveral = false;

        driver.wait(By.className(resultClassName), 20);

        if (driver.isElementDisplayed(By.className(resultClassName))) {
            elements = driver.findElements(By.className(resultClassName));

            if (elements.size() > 1) {
                isSeveral = true;
            }
        }

        return isSeveral;
    }

    // ************************ Assertions *************************
    /**
     * This assertion check if emergya logo is displayed
     */
    public void isEmergyaLogoDisplayed() {
        if (globalPage == null) {
            globalPage = new GlobalPage(driver);
        }
        assertTrue("The logo isn't displayed, it should be displayed",
                globalPage.getHeader().isEmergyaLogoDisplayed());
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
     * This assertion checks if contact page is ready, basically checks that the form is displayed
     */
    public void isContactPageReady() {
        if(contactSectionPage == null) {
            contactSectionPage = new ContactSectionPage(driver);
        }
        assertTrue("The contact section is not ready, form should be displayed",
                contactSectionPage.isReady());
    }
}
