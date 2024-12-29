package io.testomat.e2e_tests;

import io.github.cdimascio.dotenv.Dotenv;
import io.testomat.e2e.tests.web.pages.LoginPage;
import io.testomat.e2e.tests.web.pages.ManufacturePage;
import io.testomat.e2e.tests.web.pages.ProjectsPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class ProjectPageTests {

    private final Dotenv dotenv = Dotenv.load();

    @Test
    public void test1() {
        String envBaseUrl = dotenv.get("BASE_URL");
        open(envBaseUrl);

        String envUsername = dotenv.get("USER_NAME");
        String envPassword = dotenv.get("PASSWORD");
        LoginPage loginPage = new LoginPage();
        loginPage.login(envUsername, envPassword);

        ProjectsPage projectsPage = new ProjectsPage();
        projectsPage.successMessageIsPresent();
        projectsPage.checkDropdownOptions();
        projectsPage.selectDropdownOption();
        projectsPage.checkRightSideElement();
        projectsPage.doSearch();

        ManufacturePage manufacturePage = new ManufacturePage();
        manufacturePage.checkSearchedProject();
    }

}
