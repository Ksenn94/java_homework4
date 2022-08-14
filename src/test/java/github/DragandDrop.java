package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.actions;
import static java.lang.Thread.sleep;


public class DragandDrop {
    @BeforeAll
    static void Configure() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void useActions() throws InterruptedException {
        //open the website
        open("/drag_and_drop");
        //do the drug and drop (this command shouldn't work)
        actions().moveToElement($("#column-a")).clickAndHold().
                moveToElement($("#column-b")).release().perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        }

    @Test
    void useDragAndDrop() {
        open("/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

}
