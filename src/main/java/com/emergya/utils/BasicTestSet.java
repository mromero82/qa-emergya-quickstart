package com.emergya.utils;

import com.emergya.pageObjects.ContactSectionPage;
import com.emergya.pageObjects.EmergyaDigitalMainPage;
import com.emergya.pageObjects.EmergyaMainPage;
import com.emergya.pageObjects.GoogleMainPage;
import com.emergya.pageObjects.global.GlobalPage;
import com.emergya.selenium.testSet.DefaultTestSet;

/**
 * PageObjects variable references
 * @author Jose Antonio Sanchez <jasanchez@emergya.com>
 */
public abstract class BasicTestSet extends DefaultTestSet {
    protected GoogleMainPage googleMainPage;
    protected EmergyaMainPage emergyaMainPage;
    protected EmergyaDigitalMainPage emergyaDigitalMainPage;
    protected ContactSectionPage contactSectionPage;
    protected GlobalPage globalPage;

}
