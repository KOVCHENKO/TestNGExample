package com.ilkow.willey.utils;

import org.openqa.selenium.support.PageFactory;

public class PageUtility {

    public PageUtility() {
        PageFactory.initElements(TestUtility.driver, this);
    }
}
