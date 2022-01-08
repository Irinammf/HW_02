package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CityComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class RegistrationPage {

    SelenideElement firstNameInput = $("#firstName"),
                    lastNameInput = $("#lastName"),
                    mailInput = $("#userEmail"),
                    numberInput = $("#userNumber"),
                    subjectsInput = $("#subjectsInput"),
                    addressInput = $("#currentAddress"),
                    uploadPictureInput = $("#uploadPicture"),
                    resultsTable = $(".table-responsive");

    public CalendarComponent calendarComponent = new CalendarComponent();
    public CityComponent cityComponent = new CityComponent();

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage setFirstNameInput(String firstName){
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastNameInput(String lastName){
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setMail(String mail){
        mailInput.setValue(mail);
        return this;
    }

    public RegistrationPage setGender(String value){
        if (value == "Other") {
            $("label[for=gender-radio-3]").click();
        } else {
            if (value == "Female") {
                $("label[for=gender-radio-2]").click();
            } else {
                $("label[for=gender-radio-1]").click();
            }
        }
        return this;
    }


    public RegistrationPage setNumber(String number){
        numberInput.setValue(number);
        return this;
    }

    public RegistrationPage inputSubjects(String subject){
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }


    public  RegistrationPage checkHobbies(String[] hobby){

        for (int i = 0; i < hobby.length; i++) {
        if (hobby[i] == "Sports") {
            $("label[for=hobbies-checkbox-1]").click();
        } else {
            if (hobby[i] == "Reading") {
            $("label[for=hobbies-checkbox-2]").click();
            } else {
                if (hobby[i] == "Music") {
                    $("label[for=hobbies-checkbox-3]").click();
                }
            }

            }
        }
        return this;
    }

    public RegistrationPage setAddress(String address){
        addressInput.setValue(address);
        return this;
    }

    public RegistrationPage uploadPicture(String path){
        uploadPictureInput.uploadFromClasspath(path);
        return this;
    }

    public RegistrationPage checkResult(String key, String value){
        resultsTable.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }

    public  RegistrationPage checkHobbiesResult(String key, String[] hobbies){
        String hobbiesResult = new String();
        if (hobbies.length == 1) {
            resultsTable.$(byText(key)).parent().shouldHave(text(hobbies[0]));
        } else {
            for (int i = 0; i < hobbies.length; i++) {
                   hobbiesResult = hobbiesResult + hobbies[i] + ", ";
            }
            resultsTable.$(byText(key)).parent().shouldHave(text(hobbiesResult.substring(0, hobbies.length-2)));
        }
        return this;
    }


}
