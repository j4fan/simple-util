package com.j4fan.simpleutils.service;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

@Log4j2
public class TestSeleniumClass {

    private static final String ORIGIN_URL = "https://www.damai.cn/";
    private static final String LOGIN_URL = "https://passport.damai.cn/login";
    private static final String LOGIN_MARK = "登录";
    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";

    public static void main(String[] args) throws InterruptedException {

        //prepare environment
        System.setProperty("webdriver.gecko.driver", "/Applications/Firefox.app/Contents/MacOS/geckodrivermac");
        System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox");

        WebDriver driver = new FirefoxDriver();
        driver.get(ORIGIN_URL);

        WebElement element = driver.findElement(By.className("login-user"));
        if (element.isDisplayed()) {
            if (LOGIN_MARK.equals(element.getText())) {
                log.info("需要登录");
                //跳转至登录页
                 driver.navigate().to(LOGIN_URL);
                //填充账号密码
                Thread.sleep(3000L);
                WebElement username = driver.findElement(By.id("fm-login-id"));
                WebElement password = driver.findElement(By.id("fm-login-password"));
                WebElement submit = driver.findElement(By.className("password-login")).findElement(By.linkText(LOGIN_MARK));
                username.sendKeys(USERNAME);
                password.sendKeys(PASSWORD);
                submit.submit();
            }
        }
    }
}
