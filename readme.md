

Tech stack:
- Java 21
- Gradle
- Junit 5
- Cucumber
- Allure 2
- Playwright
- Retrofit


Run tests:
- with @tags
```gradle test -Dcucumber.options="--tags @smoke"```
- with Test runner
```gradle test -Dcucumber.options="src/test/resources/features/Parallel.feature"```
- to see options help 
```gradle test -Dcucumber.options="--help"```
- to run with gradlew
```./gradlew test -Dcucumber.options="--help"```
- generate allure report
```allure generate```
- run allure report
```allure serve ```

