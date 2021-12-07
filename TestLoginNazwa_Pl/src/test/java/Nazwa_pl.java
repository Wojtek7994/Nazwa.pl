import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Nazwa_pl {
    private WebDriver wd;
    private final String url = "https://nazwa.pl";
    private final String positiveLogin = "wojtek234";
    private final String positivePassword = "Qwerty!@#";
    private final String negativeLogin = "zaaq12wsx";
    private final String negativePassword = "wojtek";

    private final String messageName = "message-text";
    private final String asd = "Aby się zalogować, zaznacz opcję: ";

    @Before
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.get(url);
    }

    private void clearData() {
        WebElement loginName = wd.findElement(By.name("clientLogin"));
        loginName.clear();
        WebElement passName = wd.findElement(By.name("clientPass"));
        passName.clear();
    }

    private void setLoginAndPassword(String login, String password) {
        wd.findElement(By.id("clientLogin")).sendKeys(login);
        wd.findElement(By.id("clientPass")).sendKeys(password);
    }

    private void loginClick() {
        wd.findElement(By.id("__submit_PK_M0118")).click();
    }

    private void customerPanelClick() {
        wd.findElement(By.className("login_pk_link")).click();
    }

    @Test
    public void loginPositive() {
        customerPanelClick();
        clearData();
        setLoginAndPassword(positiveLogin, positivePassword);
        loginClick();
        boolean positiveLoginWithoutDualVerification = wd.findElement(By.className("n21-header__miniCartDisabled")).isDisplayed();
        String textMessage = wd.findElement(By.className("loginHeader")).getText();
        String dualVerificationTextMessage = "Weryfikacja dwuetapowa";
        boolean positiveLoginWithDualVerification = textMessage.contains(dualVerificationTextMessage);
        String proofYourHumanityMessageText = "Aby się zalogować, zaznacz opcję: ";
        boolean positiveLoginWithRecapture = textMessage.contains(proofYourHumanityMessageText);
        assertTrue(positiveLoginWithDualVerification || positiveLoginWithoutDualVerification || positiveLoginWithRecapture);
    }


    @Test
    public void loginNegativeWithWrongLoginAndWrongPassword() {
        customerPanelClick();
        clearData();
        setLoginAndPassword(negativeLogin, negativePassword);
        loginClick();
        String textMessage = wd.findElement(By.className("message-text")).getText();
        String wrongLoginOrPasswordTextMessage = "Nieprawidłowy login lub hasło.";
        assertTrue(textMessage.contains(wrongLoginOrPasswordTextMessage));
    }

    @Test
    public void loginPositiveWithoutDualVerification() {
        customerPanelClick();
        clearData();
        setLoginAndPassword(positiveLogin, positivePassword);
        loginClick();
        String textComunicat = wd.findElement(By.className("loginHeader")).getText();
        String DualVeryfication = "Weryfikacja dwuetapowa";
        assertTrue(textComunicat.contains(DualVeryfication));
    }


    @Test
    public void loginNegativeWithWrodgLoginAndCorrectPassword() {
        customerPanelClick();
        clearData();
        setLoginAndPassword(negativeLogin, positivePassword);
        loginClick();
        String textMessage = wd.findElement(By.className("message-text")).getText();
        String wrongLoginOrPasswordTextMessage = "Nieprawidłowy login lub hasło.";
        assertTrue(textMessage.contains(wrongLoginOrPasswordTextMessage));
    }

    @After
    public void tearDown() {
        wd.quit();
    }


}
