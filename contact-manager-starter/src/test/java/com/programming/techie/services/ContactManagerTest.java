package com.programming.techie.services;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContactManagerTest {
    ContactManager contactManager;

    @BeforeAll
    public void setupAll() {
        System.out.println("Should Print Before All Tests");
    }

    @BeforeEach
    public void setup() {
        contactManager = new ContactManager();

    }

    @Test
    @DisplayName("Should Create Contact")
    public void shouldCreateContact() {
        contactManager.addContact("Prangya", "Pattanayak", "0123456789");
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
//        Assertions.assertTrue(contactManager.getAllContacts().stream()
//                .filter(contact -> contact.getFirstName().equals("Prangya") &&
//                        contact.getLastName().equals("Pattanayak") &&
//                        contact.getPhoneNumber().equals("0123456789"))
//                .findAny()
//                .isPresent());
        Assertions.assertTrue(contactManager.getAllContacts().stream()
                .anyMatch(contact -> contact.getFirstName().equals("Prangya") &&
                        contact.getLastName().equals("Pattanayak") &&
                        contact.getPhoneNumber().equals("0123456789")));
    }

    @Test
    @DisplayName("Should Not Create Contact When First Name Is Null")
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact(null, "Pattanayak", "0123456789");
        });
    }

    @Test
    @DisplayName("Should Not Create Contact When Last Name Is Null")
    public void shouldThrowRuntimeExceptionWhenLastNameIsNull() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("Prangya", null, "0123456789");
        });
    }

    @Test
    @DisplayName("Should Not Create Contact When Phone Number Is Null")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("Prangya", "Pattanayak", null);
        });
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Should Execute After Each Tests");
    }

    @AfterAll
    public void tearDownAll() {
        System.out.println("Should be executed at the end of the Test");
    }

    @Test
    @DisplayName("Should Create Contact On MAC OS")
    @EnabledOnOs(value = OS.MAC, disabledReason = "Enabled only on MAC OS")
    public void shouldCreateContactOnlyOnMAC() {
        contactManager.addContact("Prangya", "Pattanayak", "0123456789");
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
//        Assertions.assertTrue(contactManager.getAllContacts().stream()
//                .filter(contact -> contact.getFirstName().equals("Prangya") &&
//                        contact.getLastName().equals("Pattanayak") &&
//                        contact.getPhoneNumber().equals("0123456789"))
//                .findAny()
//                .isPresent());
        Assertions.assertTrue(contactManager.getAllContacts().stream()
                .anyMatch(contact -> contact.getFirstName().equals("Prangya") &&
                        contact.getLastName().equals("Pattanayak") &&
                        contact.getPhoneNumber().equals("0123456789")));
    }

    @Test
    @DisplayName("Should Create Contact Only On Windows OS")
    @EnabledOnOs(value = OS.WINDOWS, disabledReason = "Enabled only on Windows OS")
    public void shouldCreateContactOnlyOnWindows() {
        contactManager.addContact("Prangya", "Pattanayak", "0123456789");
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
//        Assertions.assertTrue(contactManager.getAllContacts().stream()
//                .filter(contact -> contact.getFirstName().equals("Prangya") &&
//                        contact.getLastName().equals("Pattanayak") &&
//                        contact.getPhoneNumber().equals("0123456789"))
//                .findAny()
//                .isPresent());
        Assertions.assertTrue(contactManager.getAllContacts().stream()
                .anyMatch(contact -> contact.getFirstName().equals("Prangya") &&
                        contact.getLastName().equals("Pattanayak") &&
                        contact.getPhoneNumber().equals("0123456789")));
    }

    @Test
    @DisplayName("Test Contact Creation Only on Developer Machine")
    public void shouldTestContactCreationOnlyOnDEV() {
        Assumptions.assumeTrue("TEST".equals(System.getProperty("ENV")));
        contactManager.addContact("Prangya", "Pattanayak", "0123456789");
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }

    @DisplayName("Repeat Contact Creation Test 5 Times")
    @RepeatedTest(value = 5, name = "Repeat Contact Creation Test {currentRepetition} of {totalRepetitions}")
    public void shouldTestContactCreationRepeatedly() {
        contactManager.addContact("Prangya", "Pattanayak", "0123456789");
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }

    @DisplayName("Value Source Case - Phone Number should match the required format")
    @ParameterizedTest
    @ValueSource(strings = {"0123456789", "0231245678"})
    public void shouldTestContactCreationUsingValueSource(String phoneNumber) {
        contactManager.addContact("Prangya", "Pattanayak", phoneNumber);
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }

    @DisplayName("Method Source Case - Phone Number should match the required format")
    @ParameterizedTest
    @MethodSource("phoneNumberLists")
    public void shouldTestContactCreationUsingMethodSource(String phoneNumber) {
        contactManager.addContact("Prangya", "Pattanayak", phoneNumber);
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }

    public static List<String> phoneNumberLists() {
        return Arrays.asList("0123456789", "0987654321");
    }

    @DisplayName("CSV(Comma Separated Values) Source Case - Phone Number should match the required format")
    @ParameterizedTest
    @CsvSource({"0123456789", "0231245678"})
    public void shouldTestContactCreationUsingCSVSource(String phoneNumber) {
        contactManager.addContact("Prangya", "Pattanayak", phoneNumber);
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }

    @DisplayName("CSV(Comma Separated Values) Source Case - Phone Number should match the required format")
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    public void shouldTestContactCreationUsingCSVFileSource(String phoneNumber) {
        contactManager.addContact("Prangya", "Pattanayak", phoneNumber);
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }
}