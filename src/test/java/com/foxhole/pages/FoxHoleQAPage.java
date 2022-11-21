package com.foxhole.pages;

import com.foxhole.utilities.CommonFunctions;
import com.foxhole.utilities.ConfigurationReader;
import com.foxhole.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class FoxHoleQAPage extends CommonFunctions{

    boolean flag = false;

    // Locators
    @FindBy(xpath = "//header[@id='header']/following-sibling::div[2][starts-with(@class,'d-banner')]")
    private WebElement banner;
    @FindBy(xpath = "//a[normalize-space()='Click this banner!']")
    private WebElement linkOnRedBanner;
    @FindBy(xpath = "//i[@alt='Automation Icon']/..")
    private WebElement cardAutomation;
    @FindBy(xpath = "//i[@alt='Back End Testing Icon']/..")
    private WebElement cardBackEndTesting;
    @FindBy(xpath = "//i[@alt='Accessibility Icon']/..")
    private WebElement cardAccessibility;
    @FindBy(id = "more-btn")
    private WebElement buttonShowMore;

    public final static String expectedCardEffectColor = "rgba(14, 27, 77, 1)";
    public final static String expectedShowMoreButtonColor = "rgba(255, 255, 255, 1)";

    public String returnCssValue(WebElement element, String str0){
        return element.getCssValue(str0);
    }

    public void navigateToHomePage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    public FoxHoleQAPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public boolean verifyBannerIsVisible(){
        if(banner.isDisplayed()){
            flag = true;
        }else{
            flag = false;
        }
        return flag;
    }
    public void hoverOverLinkOnBannerAndClick(){
        if (banner.isDisplayed()){
            hoverOver(banner);
        }

    }
    public void clickOnLink(){
        linkOnRedBanner.click();
        waitFor(3);
    }
    public String verifyNewProjectRequestFormIsDisplayed(){
        ArrayList<String> handles = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(handles.get(1));
        String childWindowTitleName = Driver.getDriver().getTitle().trim();
        System.out.println("Child Window Tile " + childWindowTitleName);
        return childWindowTitleName;
    }

    public void clickOnTabFromMenu(String tab){
        String xpath = "//*[@id='nav-menu-container']/ul/li/a[normalize-space()='" + tab + "']";
        WebElement target = Driver.getDriver().findElement(By.xpath(xpath));
        target.click();
        waitFor(2);
    }

    public String validateHoverOverCardAutomationEffects(){
        hoverOver(cardAutomation);
        String cssColor = returnCssValue(cardAutomation, "background-color");
        System.out.println("Card Automation Css Value: " + cssColor);
        return cssColor;
    }
    public String validateHoverOverCardBackEndTestingEffects(){
        hoverOver(cardBackEndTesting);
        String cssColor = returnCssValue(cardBackEndTesting, "background-color");
        System.out.println("Card BackEndTesting Css Value: " + cssColor);
        return cssColor;
    }

    public String validateHoverOverCardAccessibilityEffects(){
        hoverOver(cardAccessibility);
        String cssColor = returnCssValue(cardAccessibility,"background-color");
        System.out.println("Card Accessibility Css Value: " + cssColor);
        return cssColor;
    }

    public String validateShowMoreButton(){
        hoverOver(buttonShowMore);
        String cssValue = returnCssValue(buttonShowMore, "background-color");
        System.out.println("Show More Css Value: " + cssValue);
        return cssValue;
    }




}
