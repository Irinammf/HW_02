package pages.components;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class CalendarComponent {

    public void setDate(String day, String month, String year){

        String dayLocator = format(".react-datepicker__day--%s:not(.react-datepicker__day--outside-month)",day);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(dayLocator).click();
    }


}
