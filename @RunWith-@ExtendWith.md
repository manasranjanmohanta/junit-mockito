# Difference between `@RunWith` vs `@ExtendWith`
The primary difference between @RunWith and @ExtendWith lies in their use within different testing frameworks and their associated testing paradigms.

---

## `@RunWith` (JUnit 4)
- **Purpose**: Used in JUnit 4 to specify a custom test runner class that controls how the test methods are executed.

- **Common Use Cases**:
  - Running tests with custom runners (e.g., MockitoJUnitRunner for enabling Mockito annotations).
  - Parameterized tests using Parameterized runner.
  - Spring tests using SpringJUnit4ClassRunner.
- **Syntax**:
  ```java
    @RunWith(MockitoJUnitRunner.class)
    public class MyTest {
        @Mock
        private MyService service;
  
        @Test
        public void testMethod() {
            // Test logic
        }
    }
  ```
- **Limitation**:
  - Only one runner can be used per test class because a test class can only have one @RunWith annotation.

---

## `@ExtendWith` (JUnit 5 - Jupiter)
- **Purpose**: Used in JUnit 5 to register extensions that provide additional behavior for test methods or classes.
- **Common Use Cases**:
  - Replacing JUnit 4's runners with more flexible and composable extensions.
  - Registering Mockito extension (MockitoExtension) to enable Mockito annotations.
  - Integrating with Spring using SpringExtension.
  - Implementing custom extensions for pre-test/post-test actions, parameter resolvers, or custom lifecycle management.
- **Syntax**:
  ```java
    @ExtendWith(MockitoExtension.class)
    public class MyTest {
        @Mock
        private MyService service;
  
        @Test
        public void testMethod() {
          // Test logic
        }
    }
  ```
- **Advantages**:
  - Supports multiple extensions for a single test class by combining them using the @ExtendWith annotation.
  - Part of the more modern and flexible JUnit 5 framework.

---

## Key Differences
| Feature                     | @RunWith (JUnit 4)         | @ExtendWith (JUnit 5)        |
|-----------------------------|----------------------------|------------------------------|
| **Framework**               | JUnit 4                   | JUnit 5 (Jupiter API)        |
| **Purpose**                 | Specifies a custom test runner | Registers extensions for tests |
| **Multiple Runners/Extensions** | Only one per test class     | Supports multiple extensions |
| **Flexibility**             | Less flexible             | Highly flexible and composable |
| **Modernity**               | Deprecated in JUnit 5     | Recommended for JUnit 5      |

---

### Transition from `@RunWith` to `@ExtendWith`
- If you are migrating from JUnit 4 to JUnit 5, replace @RunWith annotations with equivalent @ExtendWith extensions.
- For example:
  - `@RunWith(MockitoJUnitRunner.class)` → `@ExtendWith(MockitoExtension.class)`
  - `@RunWith(SpringJUnit4ClassRunner.class)` → `@ExtendWith(SpringExtension.class)`

---

In summary, `@ExtendWith` is the modern, flexible, and composable approach introduced in JUnit 5, while `@RunWith` is a legacy annotation from JUnit 4. If you're starting a new project, it's recommended to use JUnit 5 and @ExtendWith.
