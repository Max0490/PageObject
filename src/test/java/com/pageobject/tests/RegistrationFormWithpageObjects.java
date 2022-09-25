package com.pageobject.tests;

import com.pageobject.pages.RegistrationFormPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

    public class RegistrationFormWithpageObjects {
        RegistrationFormPage practiceFormPage = new RegistrationFormPage();
        @BeforeAll
        static void configuration() {
            Configuration.browser = "Chrome";
            Configuration.baseUrl = "https://demoqa.com";
        }

        @Test
        void fillTests() {
            RegistrationFormPage.openPage()
                    .setFirstName("Maxim")
                    .setLastName("Dolgodvorov")
                    .setEmail("maxim@maxim.ru")
                    .setGender("Male")
                    .setNumber("0123456789")
                    .setBirthDate("26","April","1990" )
                    .setHobbies("Sports")
                    .setSubjects("Arts")
                    .setUploadPicture("Slice1.png")
                    .setAddress("Samara")
                    .setState("NCR")
                    .setCity("Noida")
                    .setSubmit();

            RegistrationFormPage.checkResultsTableVisible()
                    .checkResult("Student Name","Maxim Dolgodvorov")
                    .checkResult("Student Email","maxim@maxim.ru")
                    .checkResult("Gender","Male")
                    .checkResult("Mobile","0123456789")
                    .checkResult("Date of Birth","26 April,1990")
                    .checkResult("Subjects","Arts")
                    .checkResult("Hobbies","Sports")
                    .checkResult("Picture","Slice1.png")
                    .checkResult("Address","Samara")
                    .checkResult("State and City","NCR Noida");

        }

        @Test
        void fillFormWithMunimumTestes() {
            practiceFormPage.openPage()
                    .setFirstName("Maxim")
                    .setLastName("Dolgodvorov")
                    .setEmail("maxim@maxim.ru")
                    .setGender("Male")
                    .setNumber("0123456789")
                    .setSubmit();
            practiceFormPage.checkResultsTableVisible()
                    .checkResult("Student Name","Maxim Dolgodvorov")
                    .checkResult("Student Email","maxim@maxim.ru")
                    .checkResult("Gender","Male")
                    .checkResult("Mobile","0123456789");

        }
    }
