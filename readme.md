**How To Run the cucumber scenarios:**
* Make sure Java 8 is installed
* Make sure Maven is installed
* Can change the browser type and URL from system.properties file
* Can run the TC from the "features" file "\src\test\resources\features"
* I used IntelliJ IDEA for the development this project

**How To Run the RestAssured scenarios:**
* Can run the TCs of automation api by using Java compiler in the "scenarios" class "\src\test\java\org\oncare\restassured\apis"

**Frame Work Architecture:**
* This framework combination between Page Object Model , BDD, and Restassured for automation APIs
* Hook has been split into 2 files (GlobalHooks-ScenarioHooks) to run some code before/After the test is start and the other before each Scenario
* For the locator we use ENUM
* For the Runner we use Junit
* The Cucumber report is generated in target folder or online on the  https://reports.cucumber.io/reports/ (the link is generated in the console)
* There are 2 classes in the restassured one for the scenarios of the testing api and the another for the using body
