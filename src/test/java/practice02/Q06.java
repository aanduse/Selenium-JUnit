package practice02;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Q06 extends TestBase {

    @Test
    public void test() {
        //Verify that we have pom.xml file in our project => please try in 4 min s
        String homePath = System.getProperty("user.home");
        String filePath = homePath + "\\IdeaProjects\\myseleniumprojectwinter2022\\pom.xml";
        String absoultePath = "C:\\Users\\pc\\IdeaProjects\\myseleniumprojectwinter2022\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }
}
