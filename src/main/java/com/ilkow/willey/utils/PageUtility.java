package com.ilkow.willey.utils;

import com.ilkow.willey.Config;
import org.openqa.selenium.support.PageFactory;

public class PageUtility {

    public PageUtility() {
        PageFactory.initElements(TestUtility.driver, this);
    }

    public void navigateTo() {
        TestUtility.driver.get(Config.baseUrl);
    }
}
