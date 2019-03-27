package com.emergya.pageObjects.global;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.emergya.pageObjects.GoogleMainPage;
import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class Footer extends BasePageObject {

    /**
     * Logger class initialization.
     */
    static Logger log = Logger.getLogger(GoogleMainPage.class);

    /**
     * Items keys selectors.
     */
    private static final String FOOTER_CONTAINER = "footercontainer";
    private static final String SPAIN_IMAGE = "spainimage";
    private static final String UK_IMAGE = "ukimage";
    private static final String SWIZTERLAND_IMAGE = "swizterlandimage";
    
    public Footer(EmergyaWebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }
    
    /**
     * This checks that the footer container and the images for the different locations are displayed
     * @return boolean
     */
    @Override
    public boolean isReady() {
        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start isReady method");
        boolean status = this.isElementVisibleByXPath(FOOTER_CONTAINER) && this.isElementVisibleByXPath(SPAIN_IMAGE) && this.isElementVisibleByXPath(UK_IMAGE) && this.isElementVisibleByXPath(SWIZTERLAND_IMAGE);  
        
        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - End isReady method");
        
        return status;
    
    }
    /**
     * This checks if footer has been updated, to do see it checks a previously stored html of footer element in file footer.txt
     * then gets our current footer, parses both to html and compare if they are equal
     * in case, they are not the same, a warning is logged and we return false
     * @return boolean
     */
    public boolean hasFooterBeenUpdated() {
        log.info("[log-PageObjects] " + this.getClass().getSimpleName()
                + " - Start hasFooterBeenUpdated method");
        //From the page source, we get a parsed HTML of the global page
        Document currentDoc = Jsoup.parse(driver.getPageSource());
        //We get all elements that belong to footer, which forms our current header
        Elements elementsCurrent = currentDoc.getElementsByAttributeValue("class", "site-footer");
        //Now get get to the file that has stored the previous HTML
        String data = "";
        try {
            File previousFooterFile = new File("./src/main/resources/files/software/footer.txt");
            Scanner myReader = new Scanner(previousFooterFile);
            while (myReader.hasNextLine()) {
              data += myReader.nextLine();
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("File footer.txt was not found, it should be in /src/main/resources/files/software/.");
            e.printStackTrace();
          }
        //We parse the previous HTML
        Document previousDoc = Jsoup.parse(data);
        //We get the footer from the previous HTML that was saved
        Elements elementsPrevious =  previousDoc.getElementsByAttributeValue("class", "site-footer");
        //We compare both footers
        boolean equals = elementsCurrent.toString().equals(elementsPrevious.toString());
        //If they are not equal to each other, we display a warning that this was updated
        if(!equals) {
            log.warn("[log-PageObjects] " + this.getClass().getSimpleName() + " Footer might have been updated recently");
        }
        return equals;
    }

}
