package com.myfirstproject;

import org.junit.Assert;
import org.junit.Test;

public class Day03_Assertions {
    @Test
    public void assertions(){
        /*
         * *****ASSERTIONS*****
         * if expected = actual
         * if assertion fails we see red error
         * if assertion pass we see green checkmark
         *
         * What is difference between Assertion and Verification?
         * -When assertion fails, test stops execution. Assertion means Hard Assert
         * -Verification means, test continue to execute even after verification fails
         * In TestNG there is SoftAssert. It means verification.
         * -In verification, we can mark more than one result as failed or passed
         *
         * */
//       1.assertEquals("MESSAGE WHEN FAILS", "EXPECTED", "ACTUAL")
//        Assert.assertEquals("TEST CASE IS FAILEd!!!","java","javascript");
//        org.junit.ComparisonFailure: TEST CASE IS FAILEd!!!
//        Expected :java
//        Actual   :javascript
        Assert.assertEquals(5,5);
        //2. assertTrue(BOOLEAN)
//        Assert.assertTrue("JAVA".contains("E"));
//        java.lang.AssertionError
        Assert.assertTrue("SELENIUM".contains("E"));//PASS
        //3. assertFalse(BOOLEAN)
        Assert.assertFalse("JAVA".contains("E"));//PASS
        Assert.assertFalse("SELENIUM".contains("E"));//FAIL
    }
}










