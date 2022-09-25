package com.pageobject.pages;

import com.codeborne.selenide.SelenideElement;
import com.pageobject.pages.components.CalendarComponent;
import com.pageobject.pages.components.ResultsModal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.module.Configuration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

 public class RegistrationFormPage {

     private final static String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsModal resultsModal = new ResultsModal();

    private SelenideElement
            firstNameInput = $("#firstName");
            lastNameInput = $("#lastName");
            emailInput = $("#userEmail");

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));

        return this
    }
    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this
    }
     public RegistrationFormPage clearFirstName() {
         firstNameInput.clear();

         return this
     }
     public RegistrationFormPage setLastName(String value) {
         lastNameInput.setValue(value);

         return this
     }
     public RegistrationFormPage setEmail(String value) {
         emailInput.setValue(value);

         return this
     }
     public RegistrationFormPage setGender(String value) {
         $("#genterWrapper").$(byText(value)).click();

         return this
     }
     public RegistrationFormPage setNumber(String value) {
         $("#userNumber").setValue(value);

         return this
     }
     public RegistrationFormPage setBirthDate(String day, String month, String year) {
         $("#dateOfBirthInput").click();
         calendarComponent.setDate(day, month, year);

         return this;
     }
     public RegistrationFormPage checkResultsTableVisible() {
         resultsModal.checkVisible();

         return this;
     }

     public RegistrationFormPage checkResult(String key, String value) {
         resultsModal.checkResult(key, value);

         return this;
     }
}
