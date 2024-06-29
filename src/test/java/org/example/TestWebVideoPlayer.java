package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestWebVideoPlayer extends DriverSetup{
    WebVideoPlayer webVideoPlayer = new WebVideoPlayer();

    @BeforeTest
    public void openPlayer(){
        getDriver().get("https://www.mahfil.net");
        webVideoPlayer.clickOnElement(By.xpath("//h5/parent::a"));
        webVideoPlayer.waitForPageLoad();

    }

    @Test(priority = 0)
    public void testUserIsAbleToPauseTheVideo() {
        webVideoPlayer.hoverAndClick(webVideoPlayer.PAUSE_BUTTON);
        Assert.assertTrue(webVideoPlayer.isElementVisible(webVideoPlayer.PLAY_BUTTON));
        Assert.assertFalse(webVideoPlayer.isElementVisible(webVideoPlayer.PAUSE_BUTTON));
    }

    @Test(priority = 1)
    public void testUserIsAbleToPlayTheVideo() {
        webVideoPlayer.hoverAndClick(webVideoPlayer.PLAY_BUTTON);
        Assert.assertTrue(webVideoPlayer.isElementVisible(webVideoPlayer.PAUSE_BUTTON));
        Assert.assertFalse(webVideoPlayer.isElementVisible(webVideoPlayer.PLAY_BUTTON));
    }

    @Test(priority = 2)
    public void testUserIsAbleToMuteVolume() {
        webVideoPlayer.hoverAndClick(webVideoPlayer.SOUND_BUTTON);
        Assert.assertTrue(webVideoPlayer.isElementVisible(webVideoPlayer.SOUND_MUTE_BUTTON));
        Assert.assertFalse(webVideoPlayer.isElementVisible(webVideoPlayer.SOUND_BUTTON));
    }

    @Test(priority = 3)
    public void testUserIsAbleToUnmuteVolume() {
        webVideoPlayer.hoverAndClick(webVideoPlayer.SOUND_MUTE_BUTTON);
        Assert.assertTrue(webVideoPlayer.isElementVisible(webVideoPlayer.SOUND_BUTTON));
        Assert.assertFalse(webVideoPlayer.isElementVisible(webVideoPlayer.SOUND_MUTE_BUTTON));
    }

    @Test(priority = 4)
    public void testUserIsAbleToMaximizeTheVideo() {
        webVideoPlayer.hoverAndClick(webVideoPlayer.FULLSCREEN);
        Assert.assertTrue(webVideoPlayer.isElementVisible(webVideoPlayer.EXIT_FULLSCREEN));
        Assert.assertFalse(webVideoPlayer.isElementVisible(webVideoPlayer.FULLSCREEN));
    }

    @Test(priority = 5)
    public void testUserIsAbleToMinimizeTheVideo() {
        webVideoPlayer.hoverOnElement(webVideoPlayer.EXIT_FULLSCREEN);
        webVideoPlayer.clickOnElement(webVideoPlayer.EXIT_FULLSCREEN);
        Assert.assertTrue(webVideoPlayer.isElementVisible(webVideoPlayer.FULLSCREEN));
        Assert.assertFalse(webVideoPlayer.isElementVisible(webVideoPlayer.EXIT_FULLSCREEN));

    }

    @Test(priority = 5)
    public void testUserIsAbleToSeetheDurationOfTheVideo() {
        webVideoPlayer.hoverOnElement(webVideoPlayer.DURATION_TIME);
        Assert.assertTrue(webVideoPlayer.isElementVisible(webVideoPlayer.DURATION_TIME));
        Assert.assertTrue(webVideoPlayer.getElementText(webVideoPlayer.DURATION_TIME).length() > 3);

    }

    @Test(priority = 5)
    public void testUserIsAbleToSeetheCurrentPlayTimeOfTheVideo() {
        webVideoPlayer.hoverOnElement(webVideoPlayer.CURRENT_TIME);
        Assert.assertTrue(webVideoPlayer.isElementVisible(webVideoPlayer.CURRENT_TIME));
        Assert.assertTrue(webVideoPlayer.getElementText(webVideoPlayer.CURRENT_TIME).length() > 3);
    }

}
