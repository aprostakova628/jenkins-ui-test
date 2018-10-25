package org.selenide.uitests;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;


public class JenkinsTest {
  String baseurl = "http://ec2-35-157-74-160.eu-central-1.compute.amazonaws.com:8080";
  String username = "k.sergievskiy";
  String email = "sergievskiy@outlook.com";
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



}