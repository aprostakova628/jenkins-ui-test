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
}
