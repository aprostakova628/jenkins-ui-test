package org.selenide.uitests;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;



public class JenkinsTest {
  public static String baseurl = "http://ec2-18-195-89-228.eu-central-1.compute.amazonaws.com:8080";
  public static String username = "k.sergievskiy";
  public static String email = "sergievskiy@outlook.com";
  public static String login = "admin";
  public static String password = "Defaultpassw0rd";


    public void LogInPositive(){
        open(baseurl);
        $(By.name("j_username")).val(login);
        $(By.name("j_password")).val(password);
        $(By.name("Submit")).click();
    }
    public void LogInNegative(){
        open(baseurl);
        $(By.name("j_username")).val(login);
        $(By.name("j_password")).val("2123");
        $(By.name("Submit")).click();
    }
    public void LogOutPositive(){
        open(baseurl + "/logout");
    }

}