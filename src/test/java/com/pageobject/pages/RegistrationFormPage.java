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
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT))
    }






    }
}
