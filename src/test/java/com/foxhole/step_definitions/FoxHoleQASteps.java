package com.foxhole.step_definitions;

import com.foxhole.pages.FoxHoleQAPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class FoxHoleQASteps {

    FoxHoleQAPage foxHoleQAPage = new FoxHoleQAPage();
    @Given("user navigates to FoxHole Homepage")
    public void user_navigates_to_fox_hole_homepage() {
        foxHoleQAPage.navigateToHomePage();
    }
    @When("user hovers over red banner")
    public void user_hovers_over_red_banner() {
        Assert.assertTrue(foxHoleQAPage.verifyBannerIsVisible());
    }
    @Then("user should see the red banner expand with the link")
    public void user_should_see_the_red_banner_expand_with_the_link() {
        foxHoleQAPage.hoverOverLinkOnBannerAndClick();
    }

    @When("user clicks on the link on red banner")
    public void user_clicks_on_the_link_on_red_banner() {
        foxHoleQAPage.clickOnLink();
    }

    @Then("user should land on the {string} sign in page")
    public void user_should_land_on_the_sign_in_page(String str0) {
        Assert.assertEquals("Title does not match!", str0,
                foxHoleQAPage.verifyNewProjectRequestFormIsDisplayed());
    }

    @When("user clicks on the {string} above from the menu")
    public void user_clicks_on_the_service_tab_from_the_menu(String tab) {
        foxHoleQAPage.clickOnTabFromMenu(tab);
    }
    @Then("user hovers over the cards and validates effects")
    public void user_hovers_over_the_cards_and_validates_effects() {
        Assert.assertEquals(FoxHoleQAPage.expectedCardEffectColor,
                foxHoleQAPage.validateHoverOverCardAccessibilityEffects());
        Assert.assertEquals(FoxHoleQAPage.expectedCardEffectColor,
                foxHoleQAPage.validateHoverOverCardBackEndTestingEffects());
        Assert.assertEquals(FoxHoleQAPage.expectedCardEffectColor,
                foxHoleQAPage.validateHoverOverCardAutomationEffects());
    }
    @And("user validates show more button color")
    public void userValidatesShowMoreButtonValue(){
        Assert.assertEquals("Css Value Does Not Match", FoxHoleQAPage.expectedShowMoreButtonColor,
                foxHoleQAPage.validateShowMoreButton());
    }

}
