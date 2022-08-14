package github;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HW4 {
    @Test
    void chooseThePlan() {
        //open github
        open("https://github.com/");
        //select the pricing menu and bring the mouse over it
        $(byText("Pricing")).hover();
        //open compare plans
        $(byText("Compare plans")).click();
        //check the header
        $(".h2-mktg").shouldHave(text("Choose the plan that’s right for you."));
        sleep(6000);
    }


}