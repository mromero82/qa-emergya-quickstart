package com.emergya.pageObjects.global;

import org.apache.log4j.Logger;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;
import com.emergya.selenium.utils.PropertiesHandler;
import com.emergya.testSets.EmergyaDigitalMainTestSet;

public class BasePageObjectNew extends BasePageObject {

    static Logger log = Logger.getLogger(BasePageObjectNew.class);
    
    public BasePageObjectNew(EmergyaWebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isReady() {
        // TODO Auto-generated method stub
        return false;
    }
    
    /**
     * Method to obtain a path value
     *
     * @param key  Constant name
     * @param type The type of the property (xpath, id,...)
     * @return Path value
     */
    protected String getPathValue(String key, String type) {
        log.info(this.getClass().getSimpleName()
                + " - Start getPathValue method");

        PropertiesHandler handler = PropertiesHandler.getInstance();
        handler.load(this.getSelectorsFilePath(key + "." + type));

        log.info(this.getClass().getSimpleName()
                + " - Start getPathValue method");

        return handler.get(key + "." + type);
    }

}
