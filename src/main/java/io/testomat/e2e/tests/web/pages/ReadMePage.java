package io.testomat.e2e.tests.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class ReadMePage {

    private final SelenideElement editReadMeButton = $(Selectors.byText("Edit Readme"));
    private final SelenideElement frameElement = $("#modal-overlays iframe[src='/ember-monaco/frame.html']");
    private final SelenideElement rootTextElement = $(".view-lines");
    private final SelenideElement textAreaElement = $("textarea");
    private final SelenideElement updateButton = $(Selectors.byText("Update"));
    private final SelenideElement cancelButton = $(Selectors.byText("Cancel"));
    private final SelenideElement successMessage = $("#ember75");

    public ReadMePage reloadPage() {
        Selenide.refresh();
        return this;
    }

    public ReadMePage clickEditButton() {
        editReadMeButton.click();
        Selenide.switchTo().frame(frameElement);
        return this;
    }

    public ReadMePage setText(String text) {
        rootTextElement.click();
        textAreaElement.sendKeys(Keys.CONTROL + "a");
        textAreaElement.sendKeys(Keys.DELETE);
        textAreaElement.sendKeys(text);
        return this;
    }

    public ReadMePage clickUpdateButton() {
        Selenide.switchTo().defaultContent();
        updateButton.click();
        return this;
    }

    public ReadMePage clickCancelButton() {
        Selenide.switchTo().defaultContent();
        cancelButton.click();
        return this;
    }

    public ReadMePage checkSuccessMessage(String message) {
        successMessage.shouldBe(Condition.text(message));
        return this;
    }

    public ReadMePage checkText(String text) {
        String currentText = textAreaElement.getAttribute("value");
        assert (text.equals(currentText));
        return this;
    }

}
