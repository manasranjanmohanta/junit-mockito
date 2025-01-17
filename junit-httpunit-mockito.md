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
// we can mention @TestMethodOrder in both class or method
@TestMethodOrder(value=OrderAnnotation.class) // MethodOrder.MethodName.class or MethodOrder.DisplayName.class
@Order(0) / @Order(1) / @Order(-10)
```
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
### Assertions

### Asset API:
- It is used to validate Test, IS CURRENT TEST PASS/FAIL?
- Expected value is compared with Actual value. (If values are matching TEST PASS, else TEST FAIL.
- JUnit 5 has provided clas : `Assetions` (org.junit.jupiter.api) - which contains all static methods "assert methods"
- 

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

3. **assertEquals**: Used to compare expected value with actual value (equals or not) - compares two objects data
```java
assertEquals(expected, actual, "Custom error message");
```

4. **assertTrue/assertFalse**: Check boolean condition/expression/value.
   - **assertTrue()**: boolean value is expected as TRUE, else TEST FAIL.
   - **assetFalse()**: boolean value is expected as FALSE, else TEST FAIL.
6. **assertNull/assertNotNull**: Checks whether given object is null (assertNull) or not null (assertNotNull).
7. **assertSame/assertNotSame**: Verify references point to the same object. (compares two object references)
8. **assertDoesNotThrow** : Check if the method does not throw exception.

---
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

4. **fail()**: This is used for multiple checking conditions, if they are not met manually FAIL TEST CASE.
- If you want to write custom failure message while checking then use fail method
```java
if (obj == null) {
    Assertions.fail("Object should not be null");
}
```


# Mockito Framework

Mockito is a mocking framework built on top of the JUnit tool. It is primarily used to perform unit testing by creating mock objects for local or external dependencies. This allows developers to test the business logic of a service class independently, without requiring the completion of dependent components.

---

## Key Concepts of Mockito

### Why Mockito?
In a typical application structure:
```
Service Class (Business Logic) -> DAO Class (Persistence Logic) -> Database
```
If the DAO class implementation is incomplete but the service class is ready, Mockito enables us to:
- Create a **mock object** (fake or dummy object) for the DAO class.
- Inject the mock object into the service class.
- Write and execute unit tests for the service class without needing a functional DAO class.

### Types of Mocking in Mockito
1. **Mock Object / Fake Object**:
   - A temporary object created for testing purposes.
   - Primarily used to mock dependencies.

2. **Stub Object**:
   - Adds some predefined functionality to the mock object.
   - For example, it specifies certain outputs for specific inputs.

3. **Spy Object**:
   - A partial mock object or half-mock object.
   - It uses real object functionality where available and predefined behavior otherwise.
   - Requires a real object in addition to the spy.

### Key Note:
- **In-memory Class / Proxy Class**:
  These are classes generated at runtime to mock or stub the behavior of real objects.

---

## How to Implement Mockito in Your Project

### Step 1: Add Mockito Dependency
Include the Mockito library in your project. For a Maven project, add the following dependency:
```xml
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>5.x.x</version>
    <scope>test</scope>
</dependency>
```
For Gradle:
```groovy
testImplementation 'org.mockito:mockito-core:5.x.x'
```

### Step 2: Create a Mock Object
```java
import static org.mockito.Mockito.*;

// Create mock object
DAOClass daoMock = mock(DAOClass.class);
```

### Step 3: Define Behavior of Mock Object
```java
// Specify behavior for mock methods
when(daoMock.getData()).thenReturn("Mock Data");
```

### Step 4: Inject Mock into Service Class
```java
ServiceClass service = new ServiceClass();
service.setDAOClass(daoMock); // Dependency Injection
```

### Step 5: Write and Execute Test Cases
```java
@Test
public void testServiceMethod() {
    String result = service.businessMethod();
    assertEquals("Expected Data", result);
}
```

---

## Mockito with Annotations

### Common Annotations in Mockito
- `@Mock`: Creates a mock object.
- `@InjectMocks`: Injects mock objects into the dependent object.
- `@Spy`: Creates a spy object.
- `@Captor`: Captures argument values passed to a mock method.
- `@RunWith(MockitoJUnitRunner.class)`: Enables Mockito annotations in test classes.

### Example: Using Mockito Annotations
```java
@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    private DAOClass daoMock;

    @InjectMocks
    private ServiceClass service;

    @Test
    public void testBusinessMethod() {
        // Define mock behavior
        when(daoMock.getData()).thenReturn("Mock Data");

        // Call service method
        String result = service.businessMethod();

        // Assert the result
        assertEquals("Expected Data", result);
    }
}
```

---

## Popular Mockito Frameworks

1. **Mockito**: The most commonly used mocking library.
2. **JMockito**: Provides a fluent interface for mocking.
3. **EasyMock**: An alternative mocking framework.
4. **PowerMock**: Extends Mockito to handle static, final, and private methods.

---

## Working with Mockito without Annotations
```java
@Test
public void testList() {
	// Mock object
	List<String> listMock = Mockito.mock(ArrayList.class); // Mock
	listMock.add("Table");

	// Spy object
	// List<String> listSpy = Mockito.spy(ArrayList.class); // Spy
	List<String> listSpy = Mockito.spy(new ArrayList()); // Spy
	listSpy.add("Table");

	Mockito.when(listMock.size()).thenReturn(10); // Stub on Mock obj
	Mockito.when(listSpy.size()).thenReturn(10); // Stub on Spy obj

	System.out.println(listMock.size() + " " + listSpy.size());
}

// Result: 
// 10 10 (If Mockito.when(...) statements are not commented)
// 0 1 (If Mockito.when(...) statements are commented)
```
### Note: 
- Spy objects are useful to check how many time methods are called. Whether they are called or not because spy object is always linked with real object. (For this we can use Mockito.verify(...) method)

---

## Working with Mockito with Annotations
```java
public class LoginAppTest {
  @InjectMocks
  private LoginAppServiceImpl loginAppService; // mocking to service class

  @Mock
  private LoginAppDAO loginAppDAOMock; // mock object

  // @Spy
  // private LoginAppDAO loginAppDAOSpy; // spy object

  @BeforeAll
  public void init() {
      MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testLoginApp() {
  // stub
    ...
    ...
  }  
```

- **Mock**: To generate mock objects.
- **Spy**: To generate spy objects.
- **InjectMocks**: To inject mock or spy object to service.
- **`MockitoAnnotation.openMocks(this);`**: Call this method in @BeforeAll or constructor testcase class in order to activate Mockito Annotations




