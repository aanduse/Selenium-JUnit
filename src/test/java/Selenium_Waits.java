public class Selenium_Waits {

    /*
1. Hard Wait : Thread.sleep(millisecond)
Java wait.
Waits for the given time. NO MORE NO LESS.
We should avoid using this wait. Avoid especially putting too many hard wait.
This will make the test execution time longer.
2. Dynamic Wait
Implicit Wait: driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
Selenium wait
Wait UP TO the given time.
We should use dynamic wait
Global wait. When you use implicit wait once, then whenever driver is called, then implicit wait applies.
ExplicitWait:
Selenium wait. Dynamic
wait UP TO the given time.
We should use dynamic wait
Local wait. We will apply the wait on to the specific elements
We must create a WebDriverWait object
This sometime handles wait isse BETTER THAN IMPLICIT WAIT
Element is not visible
Element no clickable
Text not displayed
….
Fluent Wait:
This is a type of Explicit wait.
We can put polling number.
We can ignore exception


1. What are the selenium waits?
Implicit wait
Explicit wait
Fluent wait
2. Which one do you prefer? Why?
It depends on the test case. I already use implicit wait in my driver class.  But explicit wait works better.
So I prefer explicit wait in some cases. For example, when I work with dynamically loaded elements,
then explicit wait works better for waiting and locating the elements.
3. What might be the reason of test case failure?
Wrong locator-typo, wrong values,…
Not synchronized. Timing issue.
Page is too slow, internet is slow, database is slow, hosting problem,…
Element may not be visible
Iframe
Multiple window
Alert, pop-ups, cookies
Captcha code
4. What do you do when your test case fails?
Read error message on the console. I see the error message and the line of the error. Then I can read which part of the code is fails.
Error message gives me which class, which line, what error, …
Check the locators, time issue, element visibility, iframe, pop-ups, …
Manual testing again to see my automation logic is correct. To also check the functional is working
5. Can you use implicit wait and explicit wait together?
Yes. Implicit wait is in driver class. When implicit doesn’t work, then I can use explicit wait. I have reusable methods for explicit waits
6. What is the difference between implicit and explicit wait?
Implicit is global(applies wait to the driver whenever driver is used), explicit is local(I have to call explicit wait every time for new element)
Explicit wait works with expected condition. We have to create WebDriverWait object. Has more option such as visibility, clickibility, text be


     */
}
