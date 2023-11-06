@After
public void tearDown(Scenario scenario) {
if(scenario.isFailed()){
byte [] screenshot = ((TakesScreenshot) Driver.getDriver())
.getScreenshotAs(OutputType.BYTES);
scenario.attach(screenshot, "image/png", "screenshot");
}
Driver.quitDriver();
}


@RunWith(Cucumber.class)//This line will force this class to run with Cucumber
@CucumberOptions(
 # plugin = {"html:target/cucumber-report.html"},

------------------------------------------

What are hooks?
Cucumber hooks
Hooks is the class which holds before and after scenario logic, 
in the before we can have login and after scenario done is done we will take a screenshot
in case test failed and then will close the browser

------------------
in order to generate report we can add a plugin
plugin = {"html:target/cucumber-report.html"},
USing this plugin we can generate a file with the results, which will be overwritten by the next run

The file can be open using any browser and it will show the results and all steps which pass or failed


------------------
Background is keyword in cucumber file that allows to add duplicates steps
for starting for each scenario in one usage

The order should be in consecutive order, we can not reuse in background steps which are in random
order but same

Scenario Outline:
------------
--> It allows to use different data set for the scenario 
--> Scenario Outline with close to data driven development

Given an user is on login page
When user types"<username>"
When user types"<password>"
Then the user should see the "<username>" displayed

Examples:(it will go throw as table)
|username|password|
|user123|pass123|
|user1234|pass987|

