package org.selenide.uitests;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItems;

@RunWith(Suite.class)
@SuiteClasses({JenkinsAtomicTest.class})
public class JenkinsSuite extends JenkinsTest{

    @BeforeClass
    public static void setUp() {

        System.out.println("Setting up");

        //Test if LogIn Possible
        given().contentType("application/json").auth().preemptive().
                basic(login, password).
                when().get(baseurl + "/api/json").
                then().statusCode(200);

        //Test if job exist
        given().contentType("application/json").auth().preemptive().
                basic(login, password).
                when().get(baseurl + "/api/json").
                then().body("jobs.name", hasItems("test"));
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Tearing down");
    }
}
