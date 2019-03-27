package com.emergya.pageObjects.global;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.emergya.pageObjects.ContactSectionPage;
import com.emergya.pageObjects.GoogleMainPage;
import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class Header extends BasePageObject{
    
    /**
     * Constructor method
     * @param driver selenium webdriver
     */
    public Header(EmergyaWebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }
    
    /**
     * Logger class initialization.
     */
    static Logger log = Logger.getLogger(GoogleMainPage.class);

    /**
     * Items keys selectors.
     */
    private static final String IMG_LOGO_EMERGYA = "imgLogoEmergya";
    private static final String LINK_CONTACT = "linkContact";
    
    /**
     * Checks that the PO is ready
     * @param pageObject page object to be used
     */
    @Override
    public boolean isReady() {
        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start isReady method");
        
        boolean status = isEmergyaLogoDisplayed();
        
        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - End isReady method");

        return status;
    }
    /**
     * Checks if emergya logo is displayed in the header
     * @return
     */
    public boolean isEmergyaLogoDisplayed() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start isEmergyaLogoDisplayed method");
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- End isEmergyaLogoDisplayed method");

        return this.isElementVisibleByXPath(IMG_LOGO_EMERGYA);
    }
    
    /**
     * Goes to section CONTACT
     * @return object of type ContactSectionPage
     */
    
    public ContactSectionPage clickOnContact() {
        log.info("[log-pageObjects]" + this.getClass().getSimpleName()
                + "]- Start ContactSectionPage method");
        if(this.isElementVisibleByXPath(LINK_CONTACT)) {
                this.getElementByXPath(LINK_CONTACT).click();
            }
        return new ContactSectionPage(driver);
    }
    
    /**
     * This checks if header has been updated, to do see it checks a previously stored html of header element in file footer.txt
     * then gets our current header, parses both to html and compare if they are equal
     * in case, they are not the same, a warning is logged and we return false
     * @return boolean
     */
    public boolean hasHeaderBeenUpdated() {
        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start hasHeaderBeenUpdated method");
        //From the page source, we get a parsed HTML of the global page
        Document currentDoc = Jsoup.parse(driver.getPageSource());
        //We get all elements that belong to header, which forms our current header
        Elements elementsCurrent = currentDoc.getElementsByAttributeValue("class", "site-header");
        //Now get get to the file that has stored the previous HTML
        String data = "";
        String dataCurrent = "";
        try {
            File previousHeaderFile = new File("./src/main/resources/files/software/header.txt");
            Scanner myReader = new Scanner(previousHeaderFile);
            while (myReader.hasNextLine()) {
                String nextLine = myReader.nextLine();
                //This element is not a static constant so we don't take it
                if(!nextLine.contains("<input type=\"hidden\" name=\"csrfmiddlewaretoken\"")) {
                    data += nextLine;
                }
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("File header.txt was not found, it should be in /src/main/resources/files/software/.");
            e.printStackTrace();
          }
        //From the elements in element, we remove the element that is not constant
        String[] lines = elementsCurrent.toString().split("\n");
        for(String line: lines) {
           if(!line.contains("<input type=\"hidden\" name=\"csrfmiddlewaretoken\"")) {
               dataCurrent += line; 
           }
        }
        
        //We compare both headers
        boolean equals = dataCurrent.equals(data);
        //If they are not equal to each other, we display a warning that this was updated
        if(!equals) {
            log.warn("[log-PageObjects] " + this.getClass().getSimpleName() + " Header might have been updated recently");
        }
        return equals;
    }

}
