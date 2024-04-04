package delivery.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPageTest {
    @Test
    public void insertIncorrectLoginAndPasswordAndCheckErrorMessage(){


        Selenide.open("http://35.208.34.242:3000/signin");
       // step 1

//        SelenideElement inputUsername = $(By.xpath("//*[@data-name=\"username-input\"]"));
//        inputUsername.sendKeys("dummyusername");

        $x("//*[@data-name=\"username-input\"]").sendKeys("dummyusername");

        // step 2
//        SelenideElement inputPassword = $(By.xpath("//*[@data-name=\"password-input\"]"));
//        inputPassword.sendKeys("dummypassword");

        $x("//*[@data-name=\"password-input\"]").sendKeys("dummypassword");

        // step 3

//        SelenideElement signIn = $x("//*[@data-name=\"signIn-button\"]");
//        signIn.click();

        $x("//*[@data-name=\"signIn-button\"]").click();

        // step 4

//        SelenideElement errorInvalidCredentials = $x("//*[@data-name = 'authorizationError-popup-close-button']");
////        errorInvalidCredentials.shouldBe(Condition.visible);

        $x("//*[@data-name='authorizationError-popup-close-button']").shouldBe(Condition.visible);






    }
}
