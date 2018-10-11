Jenkins ui selenide tests
================================


### How to run with Gradle

Type from command line for running tests in different browsers:

```
./gradlew chrome
./gradlew firefox
./gradlew chrome-headless
./gradlew firefox--headless
```

### How to run with Maven

Type from command line for running tests in different browsers:

```
mvn clean test -P chrome
mvn clean test -P firefox
mvn clean test -P chrome-headless
mvn clean test -P firefox-headless

```
