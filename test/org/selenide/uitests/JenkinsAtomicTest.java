package org.selenide.uitests;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class JenkinsAtomicTest extends JenkinsTest {
    @Test
    public void JenkinsLogInVisibility()
    {
        open(baseurl);
        $(By.name("j_username")).shouldBe(visible);
        $(By.name("j_password")).shouldBe((visible));
        $("#loginIntroDefault").shouldBe(visible).shouldHave(
                text("Welcome to Jenkins!")
        );
        $(By.name("Submit")).shouldBe(visible).shouldHave(
                value("Sign in")
        );
    }

    @Test
    public void JenkinsLogInPositive()
    {
        LogInPositive();
        $(By.id("jenkins-home-link")).shouldBe(visible);
        LogOutPositive();

    }

    @Test
    public void JenkinsLogInNegative()
    {
        LogInNegative();
        $(By.className("alert alert-danger"));
        $(By.name("login")).shouldHave(text("Invalid username or password"));
        $(By.className("danger")).should(exist);

        //TODO add check for danger class login\password separately

    }

    //TODO add check for "Keep me signed in" (without cookie)

    @Test
    public void JenkinsSidePanelWithTextPositive()
    {
        LogInPositive();
        $(By.id("tasks")).shouldHave
                (text("New Item"),
                        text("People"),
                        text("Build History"),
                        text("Manage Jenkins"),
                        text("My Views"),
                        text("Credentials"),
                        text("New View")
                );
        LogOutPositive();
    }
    @Test
    public void JenkinsSidePanelCreateItemPositive()
    {
        LogInPositive();
        $(By.cssSelector("#tasks > div:nth-child(1) > a.task-link")).click();
        $(By.className("add-item-name")).shouldHave(text("Enter an item name"));
        LogOutPositive();
        //TODO find xpath workaround

    }
    @Test
    public void JenkinsSidePanelCreateItemByIconPositive()
    {
        LogInPositive();
        $(By.className("task-icon-link")).click();
        $(By.className("add-item-name")).shouldHave(text("Enter an item name"));
        LogOutPositive();

    }

    @Test
    public void JenkinsSidePanelUsersPositive() {
        LogInPositive();
        $(By.cssSelector("#tasks > div:nth-child(2) > a.task-link")).click();
        $(By.id("person-root")).shouldHave(text("root"));
        LogOutPositive();
        //TODO find xpath workaround
    }


    @Test
    public void JenkinsSidePanelUsersByIconPositive() {
        LogInPositive();
        $(By.className("icon-user")).click();
        $(By.id("person-root")).shouldHave(text("root"));
        LogOutPositive();
    }

    @Test
    public void JenkinsSidePanelBuildHistoryPositive() {
        LogInPositive();
        $(By.cssSelector("#tasks > div:nth-child(3) > a.task-link")).click();
        $(By.id("projectStatus")).shouldHave(text("Build"));
        LogOutPositive();
        //TODO find xpath workaround
    }


    @Test
    public void JenkinsSidePanelBuildHistoryByIconPositive() {
        LogInPositive();
        $(By.className("icon-notepad")).click();
        $(By.id("projectStatus")).shouldHave(text("Build"));
        LogOutPositive();
    }

    @Test
    public void JenkinsSidePanelManageJenkinsPositive() {
        LogInPositive();
        $(By.cssSelector("#tasks > div:nth-child(4) > a.task-link")).click();
        $(By.id("main-panel")).shouldHave(text("Manage Jenkins"));
        LogOutPositive();
        //TODO find xpath workaround
    }


    @Test
    public void JenkinsSidePanelManageJenkinsByIconPositive() {
        LogInPositive();
        $(By.className("icon-gear2")).click();
        $(By.id("main-panel")).shouldHave(text("Manage Jenkins"));
        LogOutPositive();
    }

    @Test
    public void JenkinsSidePanelMyViewsPositive() {
        LogInPositive();
        $(By.cssSelector("#tasks > div:nth-child(5) > a.task-link")).click();
        $(By.className("header")).shouldHave(text("Name"));
        LogOutPositive();
        //TODO find xpath workaround
    }


    @Test
    public void JenkinsSidePanelMyViewsByIconPositive() {
        LogInPositive();
        $(By.cssSelector("#tasks > div:nth-child(5) > a.task-icon-link > img")).click();
        $(By.className("header")).shouldHave(text("Name"));
        LogOutPositive();
        //TODO find xpath workaround
    }

    @Test
    public void JenkinsSidePanelCredentialsPositive() {
        LogInPositive();
        $(By.cssSelector("#tasks > div:nth-child(6) > a.task-link")).click();
        $(By.className("bigtable")).shouldHave(text("Store"));
        LogOutPositive();
        //TODO find xpath workaround
    }


    @Test
    public void JenkinsSidePanelCredentialsByIconPositive() {
        LogInPositive();
        $(By.className("icon-credentials-credentials")).click();
        $(By.className("bigtable")).shouldHave(text("Store"));
        LogOutPositive();
    }

    @Test
    public void JenkinsSidePanelCredentialsSystemPositive() {
        LogInPositive();
        $(By.cssSelector("#tasks > div:nth-child(6) > a.task-link")).click();
        $(By.cssSelector("#tasks > div:nth-child(6) > div > div > a.task-link")).click();
        $(By.className("bigtable")).shouldHave(text("Domain"));
        LogOutPositive();
        //TODO find xpath workaround
    }


    @Test
    public void JenkinsSidePanelCredentialsSystemByIconPositive() {
        LogInPositive();
        $(By.className("icon-credentials-credentials")).click();
        $(By.className("icon-credentials-system-store")).click();
        $(By.className("bigtable")).shouldHave(text("Domain"));
        LogOutPositive();
    }

    @Test
    public void JenkinsSidePanelCredentialsSystemAddDomainPositive() {
        LogInPositive();
        $(By.cssSelector("#tasks > div:nth-child(6) > a.task-link")).click();
        $(By.cssSelector("#tasks > div:nth-child(6) > div > div > a.task-link")).click();
        $(By.cssSelector("#tasks > div:nth-child(6) > div > div > div > div > a.task-link")).click();
        $(By.name("newDomain")).shouldHave(text("Domain Name"));
        LogOutPositive();
        //TODO find xpath workaround
    }


    @Test
    public void JenkinsSidePanelCredentialsSystemAddDomainByIconPositive() {
        LogInPositive();
        $(By.className("icon-credentials-credentials")).click();
        $(By.className("icon-credentials-system-store")).click();
        $(By.className("icon-credentials-new-domain")).click();
        $(By.name("newDomain")).shouldHave(text("Domain Name"));
        LogOutPositive();
    }
//TODO create tests for NewView (Broken in Jenkins ver. 2.138.1)
/*
     @Test
    public void JenkinsSidePanelNewViewPositive() {
        LogInPositive();
        LogOutPositive();
    }


    @Test
    public void JenkinsSidePanelNewViewByIconPositive() {
        LogInPositive();
        LogOutPositive();
    }
*/
}
