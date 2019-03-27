package com.emergya.pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.emergya.pageObjects.global.BasePageObjectNew;
import com.emergya.selenium.drivers.EmergyaWebDriver;

public class EmergyaDigitalMainPage extends BasePageObjectNew {
    
    /**
     * Logger class initialization.
     */
    static Logger log = Logger.getLogger(EmergyaDigitalMainPage.class);
    
    /**
     * Items keys selectors.
     */
    private static final String OPENING_TITLE = "openingtitle";
    private static final String BACKGROUND_VIDEO = "backgroundvideo";
    private static final String BUTTON_CALL_US = "buttoncallus";
    private static final String SECTION_LEVERS = "sectionlevers";
    private static final String SECTION_SOLUTIONS = "sectionsolutions";
    private static final String SECTION_SUCCESS = "sectionsuccess";
    private static final String SECTION_BLOG = "sectionblog";
    private static final String SECTION_GETINTOUCH = "sectiongetintouch";
    private static final String LEVERS_COLUMNS = "leverscolumns";
    private static final String SECTION_LEVERS_ITEM = "sectionleversitem";
    
    public EmergyaDigitalMainPage(EmergyaWebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }
    
    /**
     * We check that all sections are displayed correctly
     */
    @Override
    public boolean isReady() {
        boolean res = this.isElementVisibleById(BUTTON_CALL_US) && this.isElementVisibleByXPath(OPENING_TITLE) &&
                this.isElementVisibleByXPath(BACKGROUND_VIDEO) && this.isElementVisibleByXPath(SECTION_LEVERS) &&
                this.isElementVisibleByXPath(SECTION_SOLUTIONS) && this.isElementVisibleByXPath(SECTION_SUCCESS) &&
                this.isElementVisibleByXPath(SECTION_BLOG) && this.isElementVisibleByXPath(SECTION_GETINTOUCH);
        return res;
    }
    
    /** We click in the button Contact Us
     * @return ContactSectionPage
     */
    public ContactSectionPage clickOnCallUs() {
        ContactSectionPage contactSection = null;
        if(this.isElementVisibleById(BUTTON_CALL_US)) {
            this.getElementById(BUTTON_CALL_US).click();
            contactSection = new ContactSectionPage(driver);
        }
        return contactSection;
    }
    
    public List<WebElement> getNumberOfColumnsSectionLevers() {
        List<WebElement> columns = this.getElementsByXPath(LEVERS_COLUMNS);
        return columns;
    }
    
    public void clickOnButtonForColumnXSectionLevers(Integer x) {
        List<WebElement> columns = this.getElementsByXPath(LEVERS_COLUMNS);
        if(x >= columns.size()) {
            throw new IllegalArgumentException("Method clickOnButtonForColumnXSectionLevers exception"
                    + "You asked to get element "+x+" but only "+columns.size()+" elements are available");
        }
        String xpathItemX = this.getPathValue(SECTION_LEVERS_ITEM, "path").replace("x", x.toString());
        driver.findElementByXPath(xpathItemX).click();
        
    }
    
}
