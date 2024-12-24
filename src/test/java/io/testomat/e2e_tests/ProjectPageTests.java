package io.testomat.e2e_tests;

import com.codeborne.selenide.*;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectPageTests {

    private final Dotenv dotenv = Dotenv.load();

    @Test
    public void test1() {
        login();
        checkElements();
        doSearch();
    }

    public void login() {
        String envBaseUrl = dotenv.get("BASE_URL");
        open(envBaseUrl);

        String envUsername = dotenv.get("USER_NAME");
        String envPassword = dotenv.get("PASSWORD");

        SelenideElement email = $("#content-desktop #user_email");
        SelenideElement password = $("#content-desktop #user_password");
        SelenideElement rememberMe = $("#content-desktop #user_remember_me");
        SelenideElement signInButton = $x("//div[@id=\"content-desktop\"]//input[@value=\"Sign In\"]");

        email.setValue(envUsername);
        password.setValue(envPassword);

        rememberMe.click();
        signInButton.click();
    }

    public void checkElements() {
        Selenide.$(".common-flash-success").shouldBe(Condition.visible);

        SelenideElement dropdown = $("#company_id.max-w-lg");
        dropdown.click();

        ElementsCollection options = dropdown.getOptions();
        options.shouldHave(exactTexts("Free Projects", "QA Club Lviv"));

        dropdown.selectOption("QA Club Lviv");

        SelenideElement rightSideText = $x("//*[@id=\"container\"]/div[2]/div[1]/span/span");
        rightSideText.shouldHave(text("Enterprise plan"));
    }

    public void doSearch() {
        SelenideElement searchField = $("#search");
        SelenideElement searchValue = searchField.setValue("manufacture light");

        SelenideElement searchedProject = $(byText("Manufacture light"));
        searchedProject.click();
        $(byText("Manufacture light")).shouldBe(Condition.visible);
    }

}
