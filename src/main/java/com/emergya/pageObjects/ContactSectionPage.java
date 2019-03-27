package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class ContactSectionPage extends BasePageObject{
    
    /**
     * Logger class initialization.
     */
    static Logger log = Logger.getLogger(GoogleMainPage.class);
    
    private static final String FIELD_EMAIL = "emailaddress";
    private static final String FIELD_ABOUT = "aboutproject";
    private static final String BOX_PRIVACY = "privacycheckbox";
    private static final String SEND_FORM = "sendformbutton";
    private static final String GOOGLE_CAPTCHA_BUTTON = "googlecaptchabutton";
    private static final String GOOGLE_CAPTCHA_IFRAME = "googlecaptchaiframe";
    private static final String FORM = "form";
    private static final String EMAIL_ERROR_MESSAGE = "emailErrorMessage";
    
    public ContactSectionPage(EmergyaWebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }
    
    /***
     * This checks is the form is visible
     * @return boolean
     */
    @Override
    public boolean isReady() {
        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start isReady method");
        boolean status = this.isElementVisibleById(FORM);  
        
        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - End isReady method");
        
        return status;
    }
    
    /**
     * This sends text to the field Email Address in the form
     * @param mail
     */
    public void fillInMail(String mail){
        if(this.isElementVisibleById(FIELD_EMAIL))
            this.getElementById(FIELD_EMAIL).sendKeys(mail);
    }
    
    /**
     * This sends text to the field About in the form
     * @param about
     */
    public void fillInAbout(String about){
        if(this.isElementVisibleById(FIELD_ABOUT))
            this.getElementById(FIELD_ABOUT).sendKeys(about);
    }
    
    /**
     * This checks the privacy box 
     */
    public void checkPrivacyBox(){
        if(this.isElementVisibleById(BOX_PRIVACY))
            this.getElementById(BOX_PRIVACY).click();
    }
    
    /**
     * This click on Send Form button
     */
    public void clickOnSendForm(){
        if(this.isElementVisibleById(SEND_FORM))
            this.getElementById(SEND_FORM).click();
    }
    
    /**
     * This click on Send Form button
     */
    public boolean isErrorMessageCorrect(String message){
        boolean res = false;
        if(this.isElementVisibleByXPath(EMAIL_ERROR_MESSAGE)) {
            res = this.getElementByXPath(EMAIL_ERROR_MESSAGE).getText().equals(message);
        }
        return res;
    }
    
    /**
     * This checks if the google captcha has been displayed (usually use after clickOnSendForm())
     * @return boolean
     */
    public boolean isGoogleCaptchaDisplayed() {
        driver.sleep(5);
        boolean res = driver.isElementDisplayed(By.xpath("//iframe[@title='recaptcha challenge']"));
        return res;
    }

}
