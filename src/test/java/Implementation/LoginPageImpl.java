package Implementation;

import Connection.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageImpl extends BaseTest {
    @FindBy(id = "email")
    private WebElement USERNAME_INPUT;
    @FindBy(id = "password")
    private WebElement PASSWORD_INPUT;
    @FindBy(id = "loginButton")
    private WebElement LOGIN_BUTTON;
    @FindBy(xpath = "(//div[@class='errorText'])[3]")
    private WebElement EMAIL_REQUIRED;
    @FindBy(xpath = "(//div[@class='errorText'])[4]")
    private WebElement PASSWORD_REQUIRED;
    @FindBy(className = "apple-login-btn")
    private WebElement APPLE_LOGIN;
    @FindBy(className = "quickLogin ")
    private WebElement HIZLI_GIRIS;
    @FindBy(xpath = "//div[@class='facebook_large medium facebookBtn  btnLogin']")
    private WebElement FACEBOOK_LOGIN;

    String appleLoginUrl= "https://appleid.apple.com/auth/authorize?client_id=com.n11.mfwebSign&redirect_uri=https%3A%2F%2Fwww.n11.com%2Fapple%2Fgiris-yap&response_type=code%20id_token&&scope=name+email&response_mode=form_post";
    String hizliGirisUrl= "https://hizligiris.com.tr/hizligiris/generic/login";
    String facebookUrl= "https://www.facebook.com/login.php?skip_api_login=1&api_key=1374274239476709&kid_directed_site=0&app_id=1374274239476709&signed_next=1&next=https%3A%2F%2Fwww.facebook.com%2Fv4.0%2Fdialog%2Foauth%3Fclient_id%3D1374274239476709%26scope%3Demail%252Cpublic_profile%26redirect_uri%3Dhttps%253A%252F%252Fwww.n11.com%252Fsocial%252FWEB_REGULAR_FB%252FfacebookConnectCallback%26display%3Dpopup%26ret%3Dlogin%26fbapp_pres%3D0%26logger_id%3De0484e77-4197-43cc-a0f3-a94110517735%26tp%3Dunspecified&cancel_url=https%3A%2F%2Fwww.n11.com%2Fsocial%2FWEB_REGULAR_FB%2FfacebookConnectCallback%3Ferror%3Daccess_denied%26error_code%3D200%26error_description%3DPermissions%2Berror%26error_reason%3Duser_denied%23_%3D_&display=popup&locale=tr_TR&pl_dbl=0";

    public LoginPageImpl() {
        PageFactory.initElements(driver, this);
    }

    public void isTheElementClickable(String element) {
        switch (element){
            case "Username":
                elementIsClickableForId(USERNAME_INPUT);
                break;
            case "Password":
                elementIsClickableForId(PASSWORD_INPUT);
                break;
            case "loginButton":
                elementIsClickableForId(LOGIN_BUTTON);
                break;
            case "Apple":
                elementIsClickableForClassName(APPLE_LOGIN);
                break;
            case "HızlıGiris":
                elementIsClickableForClassName(HIZLI_GIRIS);
                break;
            case "Facebook":
                elementIsClickableForXpath(FACEBOOK_LOGIN);
                break;
        }

    }

    public void isTheInputOrientedCorrectly(String element) {
        switch (element){
            case "Apple":
                click(APPLE_LOGIN);
                getUrl(appleLoginUrl);
                break;
            case "HızlıGiris":
                click(HIZLI_GIRIS);
                getWindowHandle();
                getUrl(hizliGirisUrl);
                break;
            case "Facebook":
                click(FACEBOOK_LOGIN);
                getWindowHandle();
                break;
        }

    }

    public void enterUsernameAndPassword(String username, String password) {

        if (username == null) {
            sendKey(PASSWORD_INPUT,password);
            click(LOGIN_BUTTON);
            Assert.assertEquals(EMAIL_REQUIRED.getText(), "Lütfen e-posta adresinizi girin.");
        }
        if (password == null) {
            sendKey(USERNAME_INPUT,username);
            click(LOGIN_BUTTON);
            Assert.assertEquals(PASSWORD_REQUIRED.getText(), "Bu alanın doldurulması zorunludur.");
        }
        else{
            sendKey(USERNAME_INPUT,username);
            sendKey(PASSWORD_INPUT,password);
            click(LOGIN_BUTTON);
        }
    }

    public void userNotBeLogin(){
        waitForElementVisible(USERNAME_INPUT);
        getUrl("https://www.n11.com/giris-yap");
    }

    public void errorMessageIsDisplayedForEmail() {
        Assert.assertEquals(EMAIL_REQUIRED.getText(), "Lütfen geçerli bir e-posta adresi girin.");
    }

    public void errorMessageIsDisplayedForPassword(String password) {
        waitForElementVisible(PASSWORD_INPUT);
        Integer size = password.toString().length();
        if(size<6){
            Assert.assertEquals(PASSWORD_REQUIRED.getText(), "Girilen değer en az 6 karakter olmalıdır.");
        }
        else if(size>15){
            Assert.assertEquals(PASSWORD_REQUIRED.getText(), "Girilen değer en fazla 15 karakter olmalıdır.");
        }
    }

}

