# Testing the API
This is a mirror of the `main/` directory used for testing all of its source files. We use the [Vert.x Unit Testing Framework](https://vertx.io/docs/vertx-unit/java/#vertx_integration) with Mockito to mock the server in order to accomplish this. The naming convention we use is `...Test.java`

## Running Tests:
In another terminal tab, navigate to the root `api/` directory. In `api/`, if you haven't already, run `mvn clean install` to set up your dependencies. Run `mvn clean test` to see your tests in action.

## Writing Tests:
The best way to go about them is to reference `ApiMainTest.java` under this directory and `rest/RestFunctionsTest.java`, the former of which tests the main api routing and the latter the REST API functions. They both include a lot of boilerplate code for mocking request and response objects that is best explained by just looking at them.

## Issues:
If you run `mvn clean install` or `mvn clean test` under the top level directory, some tests fail under the `service/` module. For now, we'll just stick with running `mvn clean <test/install> -pl \!service`, which tells Maven to ignore it.

*If you have more questions, please reach out to Brandon Liang on the Testing/Security Team or Luke Boyer on the Development Team.*