package io.testomat.e2e.tests.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage {

    private final SelenideElement readMeButton = $(By.id("ember40"));
    private final SelenideElement editButton = $(By.id("ember64"));

    public ProjectPage checkProjectName(String projectName) {
        SelenideElement project = $x("//h2[text()=\"" + projectName + "\"]");
        project.shouldBe(Condition.visible);
        return this;
    }

    public ProjectPage clickReadMeButton() {
        readMeButton.click();
        return this;
    }

    public ProjectPage clickEditButton() {
        editButton.click();
        return this;
    }

}
