package hw2;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CheckForm2 {



    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "CHROME";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successTest(){

//        File testFile = new File("src/test/resources/img/test.png");

        open("/automation-practice-form");

        $("#firstName").setValue("TestName");
        $("#lastName").setValue("TestLastname");
        $("#userEmail").setValue("test@emal.ru");

//        $(byText("Other")).click(); //bad practice, but works
//        $("#genderWrapper").$(byText("Other")).click(); // from video, doesn't work
//        $("gender-radio-3").parent().click(); //from video, doesn't work
        $("label[for=gender-radio-3]").click();

        $("#userNumber").setValue("9112223344");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)").click();
//        $$(".react-datepicker__day--001")
//                .filter(not(cssClass(".react-datepicker__day--outside-month")))
//                .first()   //or .get(0)
//                .click();
//        $("[aria-label$='July 1st, 1991]").click();  // from video, doesn't work
//        $("//*[contains(@aria-label, \"July 1st, 1991\")]").click();  // from video, doesn't work

        $("#subjectsInput").setValue("Math").pressEnter();
        $("label[for=hobbies-checkbox-2]").click();

//        $("#uploadPicture").uploadFile(new File(testFile));
        $("#uploadPicture").uploadFromClasspath("img/test.png");

        $("#currentAddress").setValue("TestAddress");

        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        $("#submit").click();

//        CHECK

        $(".table-responsive").shouldHave(
                text("Student Name"), text("TestName TestLastname"),
                text("Student Email"), text("test@emal.ru"),
                text("Gender"), text("Other"),
                text("Mobile"), text("9112223344"),
                text("Date of Birth"), text("01 July,1991"),
                text("Subjects"), text("Math"),
                text("Hobbies"), text("Reading"),
                text("Picture"), text("test.png"),
                text("Address"), text("TestAddress"),
                text("State and City"), text("Haryana Karnal"));

//        sleep(Long.parseLong("5000"));



    }
}
