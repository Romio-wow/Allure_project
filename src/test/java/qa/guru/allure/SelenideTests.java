package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTests {
    @BeforeAll
    static void preconditions() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Owner("Romio-wow")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Задача в репозитории Github")
    @Story("Просмор созданных задач")
    @Link(value = "тест",url = "https://github.com")

    @Test
    @DisplayName("Тест Issues")
    public void testGithubIssue() {
        SelenideLogger.addListener("allure",new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("Romio-wow/Allure_project");
        $(".header-search-input").submit();

        $(linkText("Romio-wow/Allure_project")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#1")).shouldBe(Condition.visible);

    }
}
