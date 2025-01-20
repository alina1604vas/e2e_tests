package io.testomat.e2e_tests;

import com.codeborne.selenide.junit5.TextReportExtension;
import io.testomat.e2e.tests.web.pages.ProjectsListPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

@ExtendWith({TextReportExtension.class})
public class ProjectPageTests extends BaseTest {

    @Test
    public void checkProjectsPage() {
        ProjectsListPage projectsPage = new ProjectsListPage();
        projectsPage.isSuccessMessagePresent();
        projectsPage.checkSuccessMessageText("Signed In successfully");
        projectsPage.checkDropdownOptions(List.of("Free Projects", "QA Club Lviv"));
        projectsPage.selectDropdownOption("QA Club Lviv");
        projectsPage.checkSubscriptionPlan("Enterprise plan");
        projectsPage.search("Manufacture light");
        projectsPage.checkSearchedProject("Manufacture light");

    }

}
