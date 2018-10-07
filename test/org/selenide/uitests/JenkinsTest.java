package org.selenide.uitests;
import org.junit.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class JenkinsTest {
  @Test
  public void JenkinsLogInVisibility()
  {
    open("http://ec2-18-184-229-190.eu-central-1.compute.amazonaws.com:8080");
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
    open("http://ec2-18-184-229-190.eu-central-1.compute.amazonaws.com:8080");
    $(By.name("j_username")).val("admin");
    $(By.name("j_password")).val("Defaultpassw0rd");
    $(By.name("Submit")).click();
    $(By.id("jenkins-home-link")).shouldBe(visible);




  }
}