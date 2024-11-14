

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
```gradle test -Dcucumber.options="--tags @PDFButler"```
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
- generate UTAM page objects:
```gradle utam```

Structure:
- Application (ContractButler, PDFButler)
- - Folder (Template, Agreement, Opportunity)
- - - Test.feature

#env1 = pdfbuttler
#sales.userName
#env1 = pdfbuttler
#sales.password
#approver.userName = Luke White
#approver.password
#org??
#????? Logo Use


