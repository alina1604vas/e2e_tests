package io.testomat.e2e_tests;

import com.codeborne.selenide.*;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectPageTests {

    @Test
    public void login() {
        Configuration.baseUrl = "https://app.testomat.io";
        open("/");

        SelenideElement email = $("#content-desktop #user_email");
        SelenideElement password = $("#content-desktop #user_password");
        SelenideElement rememberMe = $("#content-desktop #user_remember_me");
        SelenideElement signInButton = $x("//div[@id=\"content-desktop\"]//input[@value=\"Sign In\"]");

        email.setValue("alina1604vas@gmail.com");
        password.setValue("Manufacture!123");

        rememberMe.click();
        signInButton.click();

        Selenide.$(".common-flash-success").shouldBe(Condition.visible);

        SelenideElement searchField = $("#search");
        SelenideElement searchValue = searchField.setValue("manufacture light");

        SelenideElement searchedProject = $(byText("Manufacture light"));
        searchedProject.click();
        $(byText("Manufacture light")).shouldBe(Condition.visible);
    }

}
