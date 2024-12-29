package io.testomat.e2e.tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final SelenideElement emailElement = $("#content-desktop #user_email");
    private final SelenideElement passwordElement = $("#content-desktop #user_password");
    private final SelenideElement rememberMe = $("#content-desktop #user_remember_me");
    private final SelenideElement signInButton = $x("//div[@id=\"content-desktop\"]//input[@value=\"Sign In\"]");

    public void login(String email, String password) {
        emailElement.setValue(email);
        passwordElement.setValue(password);

        rememberMe.click();
        signInButton.click();
    }

}
