package com.emergya.pageObjects.global;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class GlobalPage extends BasePageObject {
    
    /**
     * This class has these two attributes that represent the footer and header in all pages
     */
    protected Header header;
    protected Footer footer;
    
    /**
     * This builds class GlobalPage, take into account that this class has two paramters header and footer
     * @param driver
     */
    public GlobalPage(EmergyaWebDriver driver) {
        super(driver);
        header = new Header(driver);
        footer = new Footer(driver);
        // TODO Auto-generated constructor stub
    }

    /**
     * This returns true if all common elements to the site are ready, in this case header and footer
     * @return boolean
     */
    @Override
    public boolean isReady() {
        return header.isReady() && footer.isReady();
    }
    
    /**
     * This method returns the header common to all sections
     * @return Header
     */
    public Header getHeader() { 
        return header;
    }
    

    /**
     * This method returns the footer common to all sections
     * @return Footer
     */
    public Footer getFooter() {
        return footer;
    }
}
