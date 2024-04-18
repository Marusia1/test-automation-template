package delivery.ui;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class LoginPageWithPageObjectTest extends BaseTest {


    LoginPage loginPage = new LoginPage();


    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
//        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.remote = "http://34.70.221.142:4444" + "/wd/hub";
        Configuration.browserSize = "1920x1080";
       // Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");

        Configuration.browserCapabilities.setCapability("selenoid:options",
                Map.<String, Object>of(
                        "enableVNC", true,
                        "enableVideo", true
                ));
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://fe-delivery.tallinn-learning.ee/signin");
    }
    @Test
    public void loginAndCreateOrder(){
        OrderPage orderPage = loginPage.login(BaseTest.username, BaseTest.password);

        orderPage.usernameInput.setValue("Name");
        orderPage.phoneInput.setValue("444455555");
        orderPage.commentInput.setValue("comment");
        orderPage.createOrderButton.click();
        orderPage.createPopupElement.shouldBe(Condition.visible);


//        loginPage.usernameInput.setValue("maria");
//        loginPage.passwordInput.setValue("pd2V7wYbfT2n");
//        loginPage.signInButton.click();

    }
    @Test
    public void orderSearchAndCheckStatus(){
        OrderPage orderPage = loginPage.login(BaseTest.username, BaseTest.password);
        orderPage.openStatusPopupButton.click();
        orderPage.searchOrderInput.setValue("51");
        orderPage.searchOrderSubmitButton.click();
        orderPage.orderStatuses.shouldHave(CollectionCondition.size(4));

    }
}
