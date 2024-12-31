# Unit Testing and Peer Testing

### Unit Testing
The test done by a programmer on their own piece of code is called **unit testing**.

### Peer Testing
The unit testing done by one programmer's code/task by their colleague is called **peer testing**.

---

## Key Concepts

### Testing
- Matching **expected results** with **actual results**.
  - If matched: Test succeeded (positive result).
  - If not matched: Test failed (negative result).

### Development
- Unit/Peer testing should be performed continuously by programmers until test results are positive.

---

## Types of Unit Testing
1. **Manual Unit Testing**
2. **Automated Unit Testing**

### Automated Testing Tools
- **JUnit**
- **HttpUnit** (for web applications)
- **Mockito**
- **TestNG**

---

## Test Results
Possible responses:
1. **Success**
2. **Failure**
3. **Error**

### Components of JUnit Testing
1. **Service Class/Main Class**: The class to be tested.
2. **Test Case Class**: Contains one or more test methods.
3. **Test Suite**: Combines multiple test case classes to generate a test report.

### JUnit Versions
- **Vintage**: JUnit3, JUnit4
- **Jupiter**: JUnit5

### JUnit5 Runtime Libraries
1. **JUnit Jupiter**: JUnit5 libraries.
2. **JUnit Vintage**: Backward compatibility with JUnit 3/4.
3. **JUnit Integration**: Allows integration with tools like TestNG, Mockito, etc.

---

## JUnit5 Jupiter Features

### Annotations
- **@Test**
- **@DisplayName**
- **@BeforeEach**
- **@AfterEach**
- **@BeforeAll**
- **@AfterAll**
- **@Tag**
- **@ParameterizedTest**
- **@ValueSource**
- **@NullSource**
- **@NullAndEmptySource**
- **@TestMethodOrder**
- **@Order**

### Comparison: JUnit4 vs. JUnit5
| **JUnit4**       | **JUnit5**       | **Feature**                                  |
|------------------|------------------|---------------------------------------------|
| @Test           | @Test           | Declare a test method                       |
| @BeforeClass    | @BeforeAll      | Execute before all test methods in a class  |
| @AfterClass     | @AfterAll       | Execute after all test methods in a class   |
| @Before         | @BeforeEach     | Execute before each test method             |
| @After          | @AfterEach      | Execute after each test method              |
| @Ignore         | @Disabled       | Disable a test method/class                 |
| NA              | @TestFactory    | Test factory for dynamic tests              |
| NA              | @Nested         | Nested tests                                |
| @Category       | @Tag            | Tagging and filtering                       |
| NA              | @ExtendWith     | Register custom extensions                  |
|                 | @DisplayName    | Assign custom test names                    |
|                 | @ParameterizedTest | Parameterized testing                      |
|                 | @ValueSource    | Pass values for testing                     |
|                 | @EmptySource    | Test empty values                           |
|                 | @NullAndEmptySource | Test null and empty values                |
|                 | @TestMethodOrder | Specify execution order of tests           |
|                 | @Order          | Specify order for individual tests          |

### Assertions Comparison
| **JUnit4**       | **JUnit5**       |
|------------------|------------------|
| fail            | fail            |
| assertTrue      | assertTrue      |
| assertThat      | NA              |
| assertSame      | assertSame      |
| assertNull      | assertNull      |
| assertNotSame   | assertNotSame   |
| assertNotEquals | assertNotEquals |
| assertNotNull   | assertNotNull   |
| assertFalse     | assertFalse     |
| assertEquals    | assertEquals    |
| assertArrayEquals | assertArrayEquals |
|                  | assertAll       |
|                  | assertThrows    |

---

## Naming Conventions for Test Classes and Methods
- **Class Names**: Start or end with "Test".
- **Method Names**: Generally start with "test".
- Focus on **variety** of tests, not just quantity.

---

## Example Test Scenarios
### Example 1: Login Application
1. Test with valid credentials.
2. Test with invalid credentials.
3. Test with no credentials.

### Example 2: Sum of Two Numbers
1. Test with positive numbers.
2. Test with negative numbers.
3. Test with mixed values.
4. Test with zeroes.
5. Test with floating-point numbers.
6. Test with characters/strings.

---

## Required Dependencies for JUnit
1. **JUnit Jupiter API**
2. **JUnit Jupiter Params**

---

## Key JUnit5 Annotations and Assertions methods

### Annotations
1. **@BeforeEach**
```java
@BeforeEach
public void setUp() {
    // Code to execute before each test
}
```

2. **@AfterEach**
```java
@AfterEach
public void clear() {
    // Code to execute after each test
}
```

3. **@BeforeAll**
```java
@BeforeAll
public static void setUpOnce() {
    service = new BankLoanService();
}
```

4. **@AfterAll**
```java
@AfterAll
public static void clearOnce() {
    // Code to execute after all tests
}
```

5. **@Disabled**: Marked test method as skipped/disabled/ignored test method.
6. **@DisplayName**: o give programmer choice non-technical names to test case class and test methods.
7. **@TestMethodOrder**: Useful to specify execution order of test methods with different possibilities (While working with we should add @Order(n) while working with Order Annotation class)
```java
@TestMethodOrder(value=OrderAnnotation.class) // MethodOrder.MethodName.class or MethodOrder.DisplayName.class
@Order(0) / @Order(1) / @Order(-10)
```

### Assertions
1. **assertThrows**: Check if the expected exception is thrown.
```java
Assertions.assertThrows(IllegalArgumentException.class, () -> {
    service.calcSimpleAmount(0, 0, 0);
});
```

2. **assertTimeout**: Check if a method completes within a specified time.
```java
assertTimeout(Duration.ofMillis(20000), () -> {
    service.calcSimpleInterestAmount(10000, 2, 2);
});
```

3. **assertEquals**: Verify expected and actual results.
```java
assertEquals(expected, actual, "Custom error message");
```

4. **assertTrue/assertFalse**: Check boolean conditions.
5. **assertNull/assertNotNull**: Checks whether given object is null (assertNull) or not null (assertNotNull).
6. **assertSame/assertNotSame**: Verify references point to the same object.
7. **assertDoesNotThrow** : Check if the method does not throw exception.

---

## Environment-Based Testing
Applications are typically executed in these environments:
| **Environment** | **Description** |
|------------------|------------------|
| Dev             | Development      |
| Test            | Testing          |
| UAT             | User Acceptance Testing |
| Prod            | Production       |

### Example: Using @Tag
```java
@Tag("dev")
@Tag("uat")
```

### Example: Maven Surefire Plugin
```xml
<plugin>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>3.0.0-M5</version>
    <configuration>
        <groups>dev</groups>
        <excludedGroups>uat</excludedGroups>
    </configuration>
</plugin>
```

---

## Additional JUnit Features

1. **@RepeatedTest**
```java
@RepeatedTest(value = 10, name = "Execution of {displayName} - {currentRepetition}/{totalRepetitions}")
```

2. **@ParameterizedTest**
```java
@ParameterizedTest
@ValueSource(ints={10, 21, 34, 56, 11, 78}) // @ValueSource(strings={"", " ", "k"})
```

3. **@EmptySource, @NullSource, @NullAndEmptySource**
- Test empty, null, and both null and empty values.

4. **fail()**: If you want to write custom failure message while checking then use fail method
```java
if (obj == null) {
    Assertions.fail("Object should not be null");
}
```

