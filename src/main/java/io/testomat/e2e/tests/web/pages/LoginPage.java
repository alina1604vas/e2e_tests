package io.testomat.e2e.tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement emailInput = $("#content-desktop #user_email");
    private final SelenideElement passwordInput = $("#content-desktop #user_password");
    private final SelenideElement rememberMeCheckbox = $("#content-desktop #user_remember_me");
    private final SelenideElement signInButton = $("#content-desktop .common-btn-primary.common-btn-lg");

    public void setEmail(String email) {
        emailInput.setValue(email);
    }

    public void setPassword(String password) {
        passwordInput.setValue(password);
    }

    public void clickRememberMe() {
        rememberMeCheckbox.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

}
