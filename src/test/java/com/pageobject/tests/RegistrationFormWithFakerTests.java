package com.pageobject.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import com.pageobject.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Month;

public class RegistrationFormWithFakerTests {

    Faker faker = new Faker();

    String name = faker.name().fullName();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress() ;
    String phone = faker.phoneNumber().subscriberNumber(10) ;
    String gender = faker.demographic().sex();
    String day = String.valueOf(faker.number().numberBetween(1, 31));
    String month = String.valueOf(faker.number().numberBetween(1,12));
    String year = String.valueOf(faker.number().numberBetween(1980, 1995));
    String pic = "Slice1.png";
    String hobby = "Arts";
    String subject = "English";
    String address = String.valueOf(faker.address().fullAddress());
    String state = "NCR";
    String city = "Noida";
    String date = "day + "" + month + "" + year;

    RegistrationFormPage practiceFormPage = new RegistrationFormPage();
    @BeforeAll
    static void configuration() {
        Configuration.browser = "Chrome";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillTests() {
        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(phone)
                .setBirthDate(day, month, year)
                .setHobbies(hobby)
                .setSubjects(subject)
                .setUploadPicture(pic)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .setSubmit();

        practiceFormPage.checkResultsTableVisible()
                .checkResult(firstName,lastName,email,phone,gender,pic,address,subject,hobby,state,city,day);

    }

    @Test
    void fillFormWithMunimumTestes() {
        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(phone)
                .setSubmit();
        practiceFormPage.checkResultsTableVisible()
                .checkResult(firstName,lastName,email,gender,phone);

    }
}
