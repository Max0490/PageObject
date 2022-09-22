package com.pageobject;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.module.Configuration;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;


public class AutoTestPractice {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void formTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Maxim");
        $("#lastName").setValue("Dolgodvorov");
        $("#userEmail").setValue("mail@mail.ru");
        $("#gender-radio-1").$(byText("Male")).click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__month-select").selectOption("1990");
        $(".react-datepicker__day--026").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("hobbies-checkbox-1").click();
        $("uploadPicture").uploadFromClasspath("Slice1.png");
        $("currentAddress").setValue("Samara");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table").$(byText("Student Name")).parent().lastChild().shouldHave(text("Maxim Dolgodvorov"));
        $(".table").$(byText("Student Email")).parent().lastChild().shouldHave(text("Maxim@maxim.ru"));
        $(".table").$(byText("Gender")).parent().lastChild().shouldHave(text("Male"));
        $(".table").$(byText("Mobile")).parent().lastChild().shouldHave(text("1234567890"));
        $(".table").$(byText("Date of Birth")).parent().lastChild().shouldHave(text("26 April,1990"));
        $(".table").$(byText("Subjects")).parent().lastChild().shouldHave(text("Arts"));
        $(".table").$(byText("Hobbies")).parent().lastChild().shouldHave(text("Sports"));
        $(".table").$(byText("Picture")).parent().lastChild().shouldHave(text("pen-test.jpg"));
        $(".table").$(byText("Address")).parent().lastChild().shouldHave(text("Samara"));
        $(".table").$(byText("State and City")).parent().lastChild().shouldHave(text("NCR Noida"));

        $("#closeLargeModal").click();

    }
}
