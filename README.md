Jenkins ui selenide tests
================================


### How to run with Gradle

Type from command line for running tests in different browsers:

```
./gradle chrome
./gradle firefox
./gradle chrome-headless
./gradle firefox-headless
```
### How to run with Gradle only one test
```
gradle chrome --tests JenkinsAtomicTest.JenkinsLogInPositive
```

### How to run with Maven

Type from command line for running tests in different browsers:

```
mvn clean test -P chrome
mvn clean test -P firefox
mvn clean test -P chrome-headless
mvn clean test -P firefox-headless

```
### How to run with Maven only one test
```
mvn clean test -P chrome -Dtest=JenkinsAtomicTest#JenkinsLogInPositive
```
###How to run with Maven BeforeChecks

```
mvn clean test -Dtest=JenkinsSuite -P chrome
```