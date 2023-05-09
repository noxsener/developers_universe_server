package com.codenfast.developersuniverse.browserbot.service;

import com.codenfast.developersuniverse.model.OpenGraph;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrowserUtils {

    private final static String CONTENT="content";
    private final static String PROPERTY="property";

    public static OpenGraph getOpenGraph(WebDriver webDriver) {
        List<WebElement> metaList = webDriver.findElements(By.tagName("meta"));
        OpenGraph openGraph = new OpenGraph();
        for(WebElement meta : metaList) {
            String propertyValue = meta.getAttribute(PROPERTY);
            if(StringUtils.isBlank(propertyValue)) {
                continue;
            }
            if(propertyValue.equalsIgnoreCase("og:image")) {
                openGraph.setImage(meta.getAttribute(CONTENT));
            } else if(propertyValue.equalsIgnoreCase("og:url")) {
                openGraph.setUrl(meta.getAttribute(CONTENT));
            } else if(propertyValue.equalsIgnoreCase("og:title")) {
                openGraph.setTitle(meta.getAttribute(CONTENT));
            } else if(propertyValue.equalsIgnoreCase("og:description")) {
                openGraph.setDescription(meta.getAttribute(CONTENT));
            } else if(propertyValue.equalsIgnoreCase("og:site_name")) {
                openGraph.setSiteName(meta.getAttribute(CONTENT));
            } else if(propertyValue.equalsIgnoreCase("og:type")) {
                openGraph.setType(meta.getAttribute(CONTENT));
            } else if(propertyValue.equalsIgnoreCase("twitter:site")) {
                openGraph.setTwitterSite(meta.getAttribute(CONTENT));
            } else if(propertyValue.equalsIgnoreCase("twitter:title")) {
                openGraph.setTwitterTitle(meta.getAttribute(CONTENT));
            } else if(propertyValue.equalsIgnoreCase("twitter:description")) {
                openGraph.setTwitterDescription(meta.getAttribute(CONTENT));
            } else if(propertyValue.equalsIgnoreCase("twitter:image:src")) {
                openGraph.setTwitterImage(meta.getAttribute(CONTENT));
            }
        }
        if(StringUtils.isBlank(openGraph.getUrl())) {
            openGraph.setUrl(webDriver.getCurrentUrl());
        }
        if(StringUtils.isBlank(openGraph.getTitle())) {
            openGraph.setTitle(webDriver.getTitle());
        }
        if(StringUtils.isBlank(openGraph.getSiteName())) {
            openGraph.setSiteName(openGraph.getTitle());
        }
        return openGraph;
    }

    public static void scrollToWebElement(WebDriver webDriver, WebElement webElement) {
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView({ block: 'start',  behavior: 'smooth' })", webElement);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.interrupted();
        }
    }

    public static void scrollToBottom(WebDriver webDriver) {
        ((JavascriptExecutor)webDriver).executeScript(" window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.interrupted();
        }
    }
}
