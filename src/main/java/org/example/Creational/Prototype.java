package org.example.Creational;

import java.util.HashMap;
import java.util.Map;

interface TestCasePrototype {
    TestCasePrototype cloneTestCase();
}

abstract class AbstractTestCase implements TestCasePrototype {
    String testName;
    String expectedResult;
}

class ApiTestCase extends AbstractTestCase {
    String endpoint;
    String payload;

    ApiTestCase(String testName, String endpoint, String payload, String expectedResult) {
        this.testName = testName;
        this.endpoint = endpoint;
        this.payload = payload;
        this.expectedResult = expectedResult;
    }

    @Override
    public TestCasePrototype cloneTestCase() {
        return new ApiTestCase(
                this.testName,
                this.endpoint,
                this.payload,
                this.expectedResult
        );
    }

    @Override
    public String toString() {
        return "ApiTestCase{" +
                "endpoint='" + endpoint + '\'' +
                ", payload='" + payload + '\'' +
                ", testName='" + testName + '\'' +
                ", expectedResult='" + expectedResult + '\'' +
                '}';
    }
}

class UiTestCase extends AbstractTestCase {
    String browser;
    String screen;

    UiTestCase(String testName, String browser, String screen, String expectedResult) {
        this.testName = testName;
        this.browser = browser;
        this.screen = screen;
        this.expectedResult = expectedResult;
    }

    @Override
    public TestCasePrototype cloneTestCase() {
        return new UiTestCase(
                this.testName,
                this.browser,
                this.screen,
                this.expectedResult
        );
    }

    @Override
    public String toString() {
        return "UiTestCase{" +
                "browser='" + browser + '\'' +
                ", screen='" + screen + '\'' +
                ", testName='" + testName + '\'' +
                ", expectedResult='" + expectedResult + '\'' +
                '}';
    }
}

class TestCaseRegistry {
    Map<String, TestCasePrototype> testCases = new HashMap<>();

    void addPrototype(String name, TestCasePrototype prototype) {
        testCases.put(name, prototype);
    }

    TestCasePrototype getPrototype(String name) {
        return testCases.getOrDefault(name, null);
    }
}

public class Prototype {
    public static void main(String[] args) {
        TestCaseRegistry registry = new TestCaseRegistry();
        registry.addPrototype(
                "login-api",
                new ApiTestCase(
                        "Login API Test",
                        "/api/login",
                        "{username: 'admin', password: '1234'}",
                        "200 OK"
                )
        );

        registry.addPrototype(
                "user-api",
                new ApiTestCase(
                        "Get User API Test",
                        "/api/users/1",
                        "{}",
                        "User Data Returned"
                )
        );
        registry.addPrototype(
                "chrome-ui",
                new UiTestCase(
                        "Homepage UI Test",
                        "Chrome",
                        "1920x1080",
                        "Homepage Loads"
                )
        );

        registry.addPrototype(
                "firefox-ui",
                new UiTestCase(
                        "Dashboard UI Test",
                        "Firefox",
                        "1366x768",
                        "Dashboard Visible"
                )
        );

        ApiTestCase clonedLoginTest = (ApiTestCase) registry.getPrototype("login-api").cloneTestCase();

        System.out.println("Cloned API Test:");
        System.out.println(clonedLoginTest);

        ApiTestCase clonedUserTest = (ApiTestCase) registry.getPrototype("user-api").cloneTestCase();

        System.out.println("\nCloned User API Test:");
        System.out.println(clonedUserTest);

        UiTestCase clonedChromeUiTest = (UiTestCase) registry.getPrototype("chrome-ui").cloneTestCase();

        System.out.println("\nCloned Chrome UI Test:");
        System.out.println(clonedChromeUiTest);

        UiTestCase modifiedUiTest = (UiTestCase) registry.getPrototype("firefox-ui").cloneTestCase();

        modifiedUiTest.browser = "Edge";

        System.out.println("\nModified Cloned UI Test:");
        System.out.println(modifiedUiTest);
    }
}