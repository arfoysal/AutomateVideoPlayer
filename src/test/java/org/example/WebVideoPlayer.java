package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.DriverSetup.getDriver;

public class WebVideoPlayer {

    WebDriverWait wait;

    By PLAY_BUTTON = By.xpath("//button[@title='Play']");
    By PAUSE_BUTTON = By.xpath("//button[@title='Pause']");
    By CURRENT_TIME = By.className("vjs-current-time-display");
    By DURATION_TIME = By.className("vjs-duration-display");
    By SOUND_BUTTON = By.xpath("//button[@title='Mute']");
    By SOUND_MUTE_BUTTON = By.xpath("//button[@title='Unmute']");
    By FULLSCREEN = By.xpath("//button[@title='Fullscreen']");
    By EXIT_FULLSCREEN = By.xpath("//button[@title='Exit Fullscreen']");


    public WebElement getElement(By locator){
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void clickOnElement(By locator){
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public String getElementText(By locator){
        return getElement(locator).getText();
    }

    public boolean isElementVisible(By locator){
        try {
            return getElement(locator).isDisplayed();
        }catch (Exception e){
            return false;
        }

    }

    public void hoverAndClick(By locator) {
        Actions action = new Actions(getDriver());
        action.clickAndHold(getElement(locator)).click().build().perform();
    }

    public void hoverOnElement(By locator) {
        Actions action = new Actions(getDriver());
        action.clickAndHold(getElement(locator)).build().perform();
    }

    public void waitForPageLoad() {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
                .executeScript("return document.readyState;").equals("complete"));
    }
}
