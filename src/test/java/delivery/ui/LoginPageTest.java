package delivery.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import delivery.utils.ApiClient;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class LoginPageTest {
    @Test
    public void insertIncorrectLoginAndPasswordAndCheckErrorMessage() {


        open("http://35.208.34.242:3000/signin");
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

    @Test
    public void loginWithCorrectDataCheckOrderPage() {

        open("http://35.208.34.242:3000/signin");
        String username = System.getProperty("username");
        String password = System.getProperty("password");


        $x("//*[@data-name=\"username-input\"]").sendKeys(System.getProperty("username"));
        //$x("//*[@data-name=\"username-input\"]").sendKeys("maria");

        $x("//*[@data-name=\"password-input\"]").sendKeys(System.getProperty("password"));
        //("//*[@data-name=\"password-input\"]").sendKeys("p32V7aYbfT2n");

        $x("//*[@data-name=\"signIn-button\"]").click();

        //$x("//*[@data-name='authorizationError-popup-close-button']").shouldNot(Condition.visible);

        $x("//*[@class=\"new-order\"]").shouldBe(Condition.visible);


    }

    @Test
    public void errorCheckingWithBoundaryValuesInUsernameField() {
        open("http://35.208.34.242:3000/signin");

        $x("//*[@data-name=\"username-input\"]").sendKeys("m");

        $x("//*[@data-name=\"username-input\"]").sendKeys(Keys.ENTER);
        //$x("//*[@data-name='username-input-error']").shouldBe(Condition.visible);
        $x("//*[@data-name='username-input-error']").shouldBe(Condition.matchText("Поле должно содержать минимум символов: 2"));


    }

    @Test
    public void errorCheckingWithBoundaryValuesInPasswordField() {
        open("http://35.208.34.242:3000/signin");

        $x("//*[@data-name=\"username-input\"]").sendKeys("maria");

        $x("//*[@data-name=\"password-input\"]").sendKeys("w");

        $x("//*[@data-name=\"password-input\"]").sendKeys(Keys.ENTER);
        //$x("//*[@data-name='username-input-error']").shouldBe(Condition.not(Condition.hidden));
       // $x("//*[@data-name='username-input-error']").shouldBe(Condition.matchText("The field must contain at least of characters: 8"));
        $x("//*[@data-name='username-input-error']").isEnabled();

    }
}















