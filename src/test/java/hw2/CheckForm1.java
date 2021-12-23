package hw2;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckForm1 {



    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successTest(){

        open("/automation-practice-form");

        $("#firstName").setValue("TestName");
        $("#lastName").setValue("TestLastname");
        $("#userEmail").setValue("test@emal.ru");
        $("label[for=gender-radio-3]").click();
        $("#userNumber").setValue("9112223344");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("label[for=hobbies-checkbox-2]").click();
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
    }
}

