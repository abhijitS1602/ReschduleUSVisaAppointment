package com.qa.usvisa.factory;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    public Page initBrowser(String browserName){
        System.out.println("Browser is : "+ browserName);

        playwright = Playwright.create();
        switch (browserName.toLowerCase()){
            case "chromium":
                playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            case "firefox":
                playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari":
                playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                System.out.println("Wrong browser Option");
                break;
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate("www.google.com");

        return page;
    }
}