package io.testomat.e2e.tests.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectsPage {

    private final SelenideElement successMessage = $(".common-flash-success").shouldBe(Condition.visible);
    private final SelenideElement dropdown = $("#company_id.max-w-lg");
    private final SelenideElement rightSideText = $x("//*[@id=\"container\"]/div[2]/div[1]/span/span");
    private final SelenideElement searchField = $("#search");

    public void successMessageIsPresent() {
        successMessage.shouldBe(Condition.visible);
        successMessage.shouldHave(text("Signed in successfully"));
    }

    public void checkDropdownOptions() {
        dropdown.click();
        ElementsCollection options = dropdown.getOptions();
        options.shouldHave(exactTexts("Free Projects", "QA Club Lviv"));
    }

    public void selectDropdownOption() {
        dropdown.selectOption("QA Club Lviv");
    }

    public void checkRightSideElement() {
        rightSideText.shouldHave(text("Enterprise plan"));
    }

    public void doSearch() {
        searchField.setValue("manufacture light");
    }

}
