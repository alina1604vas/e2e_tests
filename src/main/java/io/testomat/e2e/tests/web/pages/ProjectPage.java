package io.testomat.e2e.tests.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {

    public void checkSearchedProject(String projectName) {
        SelenideElement project = $(byText(projectName));
        project.click();
        project.shouldBe(Condition.visible);
    }

}
