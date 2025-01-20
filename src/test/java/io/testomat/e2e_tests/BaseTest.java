package io.testomat.e2e_tests;

import io.github.cdimascio.dotenv.Dotenv;
import io.testomat.e2e.tests.web.pages.LoginPage;
import io.testomat.e2e.tests.web.pages.ProjectPage;
import io.testomat.e2e.tests.web.pages.ProjectsListPage;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    private static final Dotenv dotenv = Dotenv.load();

    protected static ProjectsListPage projectsPage = new ProjectsListPage();
    protected static ProjectPage projectPage = new ProjectPage();

    @BeforeAll
    public static void setUp() {
        String envBaseUrl = dotenv.get("BASE_URL");
        open(envBaseUrl);

        String envUsername = dotenv.get("USER_NAME");
        String envPassword = dotenv.get("PASSWORD");

        new LoginPage().open().login(envUsername, envPassword);
        projectsPage.isSuccessMessagePresent();
    }

}
