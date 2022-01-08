package hw5;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import static com.codeborne.selenide.Selenide.$;
import static hw5.TestData.*;

public class FormTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userMail = faker.internet().emailAddress(),
            address =faker.address().toString(),
            mobileNumber = faker.number().digits(10);



    @Test
    void successTest(){

        Configuration.holdBrowserOpen = true;

        String dayResult = day.substring(1),
                filePath = path.substring(4);
        SelenideElement submit = $("#submit");

        registrationPage.openPage()
                        .setFirstNameInput(firstName)
                        .setLastNameInput(lastName)
                        .setMail(userMail)
                        .setGender(gender)
                        .setNumber(mobileNumber)
                        .inputSubjects(subject)
                        .checkHobbies(hobbies)
                        .setAddress(address)
                        .uploadPicture(path)
                        .calendarComponent.setDate(day,month,year);
        registrationPage.cityComponent.checkCity(state, city);
        submit.click();

//        CHECK

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                        .checkResult("Student Email",userMail)
                        .checkResult("Gender",gender)
                        .checkResult("Mobile",mobileNumber)
                        .checkResult("Date of Birth",dayResult + " " + month + "," + year)
                        .checkResult("Subjects",subject)
                        .checkHobbiesResult("Hobbies",hobbies)
                        .checkResult("Picture",filePath)
                        .checkResult("Address",address)
                        .checkResult("State and City",state + " " + city);

    }

}

