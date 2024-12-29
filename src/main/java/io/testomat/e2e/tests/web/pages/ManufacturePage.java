package io.testomat.e2e.tests.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ManufacturePage {

    private final SelenideElement searchedProject = $(byText("Manufacture light"));

    public void checkSearchedProject() {
        searchedProject.click();
        $(byText("Manufacture light")).shouldBe(Condition.visible);
    }

}
