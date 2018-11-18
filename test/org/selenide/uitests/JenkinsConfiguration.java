package org.selenide.uitests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

@SuiteClasses({JenkinsAtomicTest.class})
public class JenkinsConfiguration extends JenkinsTest {

    @BeforeClass
    public static void setUp() {
        System.out.println("setting up");
    }


    @AfterClass
    public static void tearDown() {
        System.out.println("tearing down");
    }

}
