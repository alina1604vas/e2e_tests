package io.testomat.e2e_tests;

import io.github.cdimascio.dotenv.Dotenv;
import io.testomat.e2e.tests.web.pages.LoginPage;
import io.testomat.e2e.tests.web.pages.ProjectPage;
import io.testomat.e2e.tests.web.pages.ProjectsListPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class ProjectPageTests {

    private static final Dotenv dotenv = Dotenv.load();

    @BeforeAll
    public static void setUp() {
        String baseUrl = dotenv.get("BASE_URL");
        open(baseUrl);
    }

    @Test
    public void checkProjectsPage() {
        String envUsername = dotenv.get("USER_NAME");
        String envPassword = dotenv.get("PASSWORD");

        LoginPage loginPage = new LoginPage();
        loginPage.setEmail(envUsername);
        loginPage.setPassword(envPassword);
        loginPage.clickRememberMe();
        loginPage.clickSignInButton();

        ProjectsListPage projectsPage = new ProjectsListPage();
        projectsPage.isSuccessMessagePresent();
        projectsPage.checkSuccessMessageText("Signed In successfully");
        projectsPage.checkDropdownOptions(List.of("Free Projects", "QA Club Lviv"));
        projectsPage.selectDropdownOption("QA Club Lviv");
        projectsPage.checkSubscriptionPlan("Enterprise plan");
        projectsPage.search("Manufacture light");

        ProjectPage projectPage = new ProjectPage();
        projectPage.checkSearchedProject("Manufacture light");
    }

}
