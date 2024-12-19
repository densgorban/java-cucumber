Tech stack:
- Java 21
- Gradle
- Junit 5
- Cucumber
- Allure 2
- Playwright

Requirements:
1. Install Java (latest) https://www.java.com/download/ie_manual.jsp
2. Install gradle https://gradle.org/install/
3. Clone project from 
```git clone https://github.com/densgorban/java-cucumber.git```
4. Run tests in commandline
```./gradlew test --tests "testrunner.CucumberTests"```
5. Generate Report
```allure serve ```


Run tests:
- Run tests in IntelliJ IDE
- with @tags
```./gradlew test --tests "testrunner.CucumberTests"```
- to see options help 
```gradle test -Dcucumber.options="--help"```
- to run with gradlew
```./gradlew test -Dcucumber.options="--help"```
- generate allure report
```allure generate```
- run allure report
```allure serve ```
- generate UTAM page objects:
```gradle utam```




