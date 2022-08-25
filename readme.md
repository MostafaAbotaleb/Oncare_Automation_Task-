**How To Run:**

* Make sure Java 8 is installed
* Make sure Maven is installed
* Can change the browser and URL from system.properties file
* Can run the TC from the feature file
* I used IntelliJ IDEA for the development this project
  
**Frame Work Architecture:**
* This framework combination between Page Object Model and BDD
* Hook has been split into 2 files (GlobalHooks-ScenarioHooks) to run some code before/After the test is start and the other before each Scenario
* For the locator we use ENUM
* For the Runner we use Junit
* The Cucumber report is generated in target folder
