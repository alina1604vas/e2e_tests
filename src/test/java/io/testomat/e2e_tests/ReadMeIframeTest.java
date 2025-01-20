package io.testomat.e2e_tests;

import com.codeborne.selenide.junit5.TextReportExtension;
import io.testomat.e2e.tests.web.pages.ProjectPage;
import io.testomat.e2e.tests.web.pages.ProjectsListPage;
import io.testomat.e2e.tests.web.pages.ReadMePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({TextReportExtension.class})
public class ReadMeIframeTest extends BaseTest {

    private final ReadMePage readMePage = new ReadMePage();

    @Test
    public void updateReadMeTextInIframe() {
        projectsPage.search("Manufacture light")
                .checkSearchedProject("Manufacture light");

        projectPage.clickReadMeButton()
                .clickEditButton();

        String updated = "Readme test message";
        readMePage.clickEditButton()
                .setText(updated)
                .clickUpdateButton()
                .checkSuccessMessage("Readme has been saved")
                .reloadPage()
                .clickEditButton()
                .checkText(updated)
                .clickCancelButton();
    }

}
