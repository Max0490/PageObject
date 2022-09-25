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

     private final CalendarComponent calendarComponent = new CalendarComponent();
     private final ResultsModal resultsTableComponent =new ResultsModal();
     private final SelenideElement
             firstNameInput = $("#firstName"),
             lastNameInput = $("#lastName"),
             emailInput = $("#userEmail"),
             genderSelect = $("#genterWrapper"),
             numberInput = $("#userNumber"),
             birthDateInput = $("#dateOfBirthInput"),
             hobbiesInput = $("#hobbiesWrapper"),
             subjectsInput = $("#subjectsInput"),
             pictureUpload = $("#uploadPicture"),
             adressInput = $("#currentAddress"),
             stateInput = $("#react-select-3-input"),
             cityInput = $("#react-select-4-input"),
             submitButton = $("#submit");

     public RegistrationFormPage openPage(){
         open("/automation-practice-form");

         return this;
     }

     public RegistrationFormPage setFirstName(String value) {
         firstNameInput.setValue(value);

         return this;
     }

     public RegistrationFormPage setLastName(String value) {
         lastNameInput.setValue(value);

         return this;
     }
     public RegistrationFormPage setEmail(String value) {
         emailInput.setValue(value);

         return this;
     }
     public RegistrationFormPage setGender(String value) {
         genderSelect.$(byText(value)).click();

         return this;
     }

     public RegistrationFormPage setNumber(String value) {
         numberInput.setValue(value);

         return this;
     }
     public RegistrationFormPage setBirthDate(String day, String month,String year) {
         birthDateInput.click();
         calendarComponent.setDate(day,month,year);

         return this;

     }
     public RegistrationFormPage setHobbies(String value) {
         hobbiesInput.$(byText(value)).click();

         return this;

     }
     public RegistrationFormPage setSubjects(String value) {
         subjectsInput.setValue(value).pressEnter();

         return this;

     }
     public RegistrationFormPage setUploadPicture(String fileName) {
         pictureUpload.uploadFromClasspath(fileName);

         return this;

     }
     public RegistrationFormPage setAddress(String value) {
         adressInput.setValue(value);

         return this;

     }
     public RegistrationFormPage setState(String state) {
         $(stateInput).setValue(state).pressEnter();

         return this;

     }
     public RegistrationFormPage setCity(String city) {
         $(cityInput).setValue(city).pressEnter();

         return this;

     }
     public void setSubmit() {
         submitButton.click();

     }
     public RegistrationFormPage checkResultsTableVisible() {
         resultsTableComponent.checkVisible();

         return this;

     }
     public RegistrationFormPage checkResult(String key, String value) {
         resultsTableComponent.checkResult(key, value);

         return this;

     }

 }