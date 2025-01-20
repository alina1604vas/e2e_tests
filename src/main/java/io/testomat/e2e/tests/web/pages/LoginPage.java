package io.testomat.e2e.tests.web.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.github.cdimascio.dotenv.Dotenv;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static final Dotenv dotenv = Dotenv.load();

    private final SelenideElement emailInput = $("#content-desktop #user_email");
    private final SelenideElement passwordInput = $("#content-desktop #user_password");
    private final SelenideElement rememberMeCheckbox = $("#content-desktop #user_remember_me");
    private final SelenideElement signInButton = $("#content-desktop .common-btn-primary.common-btn-lg");

    public LoginPage open() {
        String url = dotenv.get("BASE_URL");
        Selenide.open(url);
        return this;
    }

    public LoginPage login(String email, String password) {
        emailInput.setValue(email);
        passwordInput.setValue(password);
        rememberMeCheckbox.click();
        signInButton.click();
        return this;
    }

}
