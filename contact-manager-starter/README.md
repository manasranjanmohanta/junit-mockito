# contact-manager-starter
# JUnit 5 Annotations in ContactManagerTest


This document explains the JUnit 5 annotations used in the `ContactManagerTest` class, along with their typical use cases.

## @TestInstance(TestInstance.Lifecycle.PER_CLASS)
- **Explanation:** Specifies the lifecycle of the test instance. When set to `PER_CLASS`, a single test instance will be used for all test methods in the test class.
- **Use Case:** Use this annotation when you want to share the state across test methods within the same test class.

## @Test
- **Explanation:** Marks a method as a test method.
- **Use Case:** Use this for any method that you want to be executed as a test.

## @DisplayName
- **Explanation:** Sets a custom display name for the test class or test method.
- **Use Case:** Useful for providing more readable or descriptive names for your test methods.



# Junit Test Lifecycle:

## @BeforeAll
- **Explanation:** Denotes that the annotated method should be executed before all tests in the current test class.
- **Use Case:** Commonly used for expensive or time-consuming setup tasks that need to be done only once.

## @BeforeEach
- **Explanation:** Denotes that the annotated method should be executed before each test in the current test class.
- **Use Case:** Use this to set up or initialize objects that are needed before every test method.

## @AfterEach
- **Explanation:** Denotes that the annotated method should be executed after each test in the current test class.
- **Use Case:** Use this to clean up resources or reset states after every test method.

## @AfterAll
- **Explanation:** Denotes that the annotated method should be executed after all tests in the current test class.
- **Use Case:** Commonly used for tasks that need to be done once after all tests are finished, such as closing a database connection.

**Note** :
1. `@BeforeAll` and `@BeforeEach` used to perform initialization tasks for tests.
2. `@AfterAll` and `@AfterEach` used to perform cleanup tasks for tests.



# Conditional Executions:

## @EnabledOnOs
- **Explanation:** Enables the annotated test method only on specified operating systems.
- **Use Case:** Use this to run tests conditionally based on the operating system.

## @DisabledOnOs
- **Explanation:** Disables the annotated test method on specified operating systems.
- **Use Case:** Use this to skip tests conditionally based on the operating system.



# Assumptions:

## Assumptions.assumeTrue
- **Explanation:** If the assumption is not met, the test will be aborted.
- **Use Case:** Use this when you want to run tests only if certain conditions are true, such as a specific environment setting.



# Repeated Tests:

- Used when there is functionality with Randomness
- Using `@RepeatedTest` test can be executed for multiple repetitions
- Substitutes `@Test`

## @RepeatedTest
- **Explanation:** Indicates that the annotated method is a test template that should be repeated a specified number of times.
- **Use Case:** Useful for running the same test multiple times to ensure consistent behavior.



# Parameterized Tests:

- Tests are executed with different set of input
- Data is provided using different annotations: `@ValueSource`, `@CsvSource`
- Substitutes `@Test`

## @ParameterizedTest
- **Explanation:** Marks a method as a parameterized test, which can run multiple times with different parameters.
- **Use Case:** Use this to run the same test logic with different inputs.

## @ValueSource
- **Explanation:** Specifies a set of literal values to be passed to a parameterized test method.
- **Use Case:** Use this to provide a simple list of values to the parameterized test.

## @MethodSource
- **Explanation:** Specifies a method that returns a stream, an array, or an iterable of arguments to be passed to the parameterized test method.
- **Use Case:** Use this to supply complex or dynamically generated arguments to the parameterized test.

## @CsvSource
- **Explanation:** Specifies a set of comma-separated values to be passed to a parameterized test method.
- **Use Case:** Use this to provide multiple sets of arguments to the parameterized test in a concise way.

## @CsvFileSource
- **Explanation:** Specifies a CSV file from which to read a set of comma-separated values to be passed to the parameterized test method.
- **Use Case:** Use this to supply arguments to the parameterized test from a CSV file.


# Nested Tests

- Used to group Tests together into a logical group 
- Makes the test class more organized 
- @Nested used on top of the class 
- Can only use @BeforeEach and @AfterEach 
- Cannot user @BeforeAll and @AfterAll by default

```java
    @Nested
    class RepeatedNestedTests {
        // codes
    }
```



# Disabled Tests

- Use `@Disabled` annotation to disable test cases from executing. (Not recommended)
