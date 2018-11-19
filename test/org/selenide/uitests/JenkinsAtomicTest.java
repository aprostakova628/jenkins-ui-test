package org.selenide.uitests;

import org.junit.Ignore;
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
    public void JenkinsDescriptionIsPresentPositive()
    {
        LogInPositive();
        $(By.id("description")).shouldHave
                (text("Jenkins VICTIM"));
        LogOutPositive();
    }
    @Test
    public void JenkinsSidePanelWithTextPositive()
    {
        LogInPositive();
        $(By.id("tasks")).shouldHave(
                        text("New Item"),
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
        $(By.id("tasks")).findElement(By.linkText("New Item")).click();
        $(By.className("add-item-name")).shouldHave(text("Enter an item name"));
        LogOutPositive();

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
        $(By.id("tasks")).findElement(By.linkText("People")).click();
        $(By.id("person-admin")).shouldHave(text("admin"));
        LogOutPositive();
    }


    @Test
    public void JenkinsSidePanelUsersByIconPositive() {
        LogInPositive();
        $(By.className("icon-user")).click();
        $(By.id("person-admin")).shouldHave(text("admin"));
        LogOutPositive();
    }

    @Test
    public void JenkinsSidePanelBuildHistoryPositive() {
        LogInPositive();
        $(By.id("tasks")).findElement(By.linkText("Build History")).click();
        $(By.id("projectStatus")).shouldHave(text("Build"));
        LogOutPositive();
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
        $(By.id("tasks")).findElement(By.linkText("Manage Jenkins")).click();
        $(By.id("main-panel")).shouldHave(text("Manage Jenkins"));
        LogOutPositive();
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
        $(By.id("tasks")).findElement(By.linkText("My Views")).click();
        $(By.className("header")).shouldHave(text("Name"));
        LogOutPositive();
        // If no jobs created this check shoudnt work
    }


    @Test
    @Ignore
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
        $(By.id("tasks")).findElement(By.linkText("Credentials")).click();
        $(By.className("bigtable")).shouldHave(text("Store"));
        LogOutPositive();
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
        $(By.id("tasks")).findElement(By.linkText("Credentials")).click();
        $(By.id("tasks")).findElement(By.linkText("System")).click();
        $(By.className("bigtable")).shouldHave(
                text("Domain"),
                text("Description"));
        LogOutPositive();
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
        $(By.id("tasks")).findElement(By.linkText("Credentials")).click();
        $(By.id("tasks")).findElement(By.linkText("System")).click();
        $(By.id("tasks")).findElement(By.linkText("Add domain")).click();
        $(By.name("newDomain")).shouldHave(text("Domain Name"));
        LogOutPositive();
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
    @Test
    public void JenkinsUserInHeaderPositive(){
        LogInPositive();
        $(By.className("login")).click();
        $(By.id("main-panel")).shouldHave(text(username));
        $(By.id("main-panel")).shouldHave(text("admin"));
        $(By.id("description-link")).shouldHave(text("add description")).click();
        $(By.name("description")).should(exist);
        LogOutPositive();
    }

    @Test
    public void JenkinsUserInHeaderDropDownBuildsPositive() {
        LogInPositive();
        $(By.className("login")).hover();
        $(By.id("menuSelector")).click();
        $(By.linkText("Builds")).click();
        $(By.id("main-panel")).shouldHave(text("Builds for " + username));
        $(By.id("projectStatus")).shouldHave(text("Build"));
        LogOutPositive();
    }
//TODO create tests for NewView (Broken in Jenkins ver. 2.138.1)

    @Test
    public void JenkinsUserInHeaderDropDownConfigurePositive() {
        LogInPositive();
        $(By.className("login")).hover();
        $(By.id("menuSelector")).click();
        $(By.linkText("Configure")).click();
        $(By.name("_.fullName")).shouldHave(value(username));
        $(By.name("_.description")).should(exist);
        $(By.name("email.address")).shouldHave(value(email));
        $(By.name("_.primaryViewName")).should(exist);
        $(By.name("_.authorizedKeys")).should(exist);
        LogOutPositive();
    }

     @Test
     @Ignore
    public void JenkinsSidePanelNewViewPositive() {
        LogInPositive();
        LogOutPositive();
    }


    @Test
    @Ignore
    public void JenkinsSidePanelNewViewByIconPositive() {
        LogInPositive();
        LogOutPositive();
    }

}
