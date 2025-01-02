package io.testomat.e2e.tests.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProjectsListPage {

    private final SelenideElement successMessage = $(".common-flash-success");
    private final SelenideElement projectsDropdown = $("#company_id.max-w-lg");
    private final SelenideElement subscriptionPlanLabel = $("span.tooltip-project-plan");
    private final SelenideElement searchField = $("#search");

    public void isSuccessMessagePresent() {
        successMessage.shouldBe(Condition.visible);
    }

    public void checkSuccessMessageText(String text) {
        successMessage.shouldBe(text(text));
    }

    public void checkDropdownOptions(List<String> expectedProjectsNames) {
        projectsDropdown.click();
        ElementsCollection options = projectsDropdown.getOptions();
        options.shouldHave(exactTexts(expectedProjectsNames));
    }

    public void selectDropdownOption(String option) {
        projectsDropdown.selectOption(option);
    }

    public void checkSubscriptionPlan(String plan) {
        subscriptionPlanLabel.shouldBe(text(plan));
    }

    public void search(String query) {
        searchField.setValue(query);
    }

}
