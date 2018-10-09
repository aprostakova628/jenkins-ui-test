package org.selenide.uitests;
import static java.lang.String.*;
import org.junit.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class JenkinsTest {

  String baseurl = "http://ec2-18-184-229-190.eu-central-1.compute.amazonaws.com:8080";

    public void LogInPositive(){
        open(baseurl);
        $(By.name("j_username")).val("admin");
        $(By.name("j_password")).val("Defaultpassw0rd");
        $(By.name("Submit")).click();
    }
    public void LogInNegative(){
        open(baseurl);
        $(By.name("j_username")).val("admin");
        $(By.name("j_password")).val("2123");
        $(By.name("Submit")).click();
    }
    public void LogOutPositive(){
        open(baseurl + "/logout");
    }
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
            (text("Создать Item"),
            text("Пользователи"),
            text("История сборок"),
            text("Настроить Jenkins"),
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
      $(By.className("add-item-name")).shouldHave(text("Введите имя Item'а"));
      LogOutPositive();
      //TODO find xpath workaround

  }
    @Test
    public void JenkinsSidePanelCreateItemByIconPositive()
    {
        LogInPositive();
        $(By.className("task-icon-link")).click();
        $(By.className("add-item-name")).shouldHave(text("Введите имя Item'а"));
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