package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Basic Auth')]")
	private WebElement link_BasicAuth;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'A/B Testing')]")
	private WebElement link_ABTesting;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Form Authentication')]")
    private WebElement link_FormAuthentication;
	
	@FindBy(how=How.XPATH, using="//*[@id='username']")
    private WebElement textbox_username;
	
	@FindBy(how=How.XPATH, using="//*[@id='password']")
    private WebElement textbox_password;
	
	@FindBy(how=How.XPATH, using="//button[@class='radius']")
    private WebElement button_Login;
	
    @FindBy(how=How.XPATH, using="//a[contains(text(),'Dropdown')]")
	private WebElement link_Dropdown;
	
	@FindBy(how=How.XPATH, using="//*[@id='dropdown']")
	private WebElement dropdown_select;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Checkboxes')]")
	private WebElement link_checkboxes;
	
	@FindBy(how=How.XPATH, using="//*[@id='checkboxes']/input[1]")
	private WebElement checkbox1;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"checkboxes\"]/input[2]")
	private WebElement checkbox2;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"content\"]/div/h3")
	private WebElement checkboxHeader;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'JavaScript Alerts')]")
	private WebElement link_alerts;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Click for JS Alert')]")
	private WebElement button_JSalerts;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Frames')]")
	private WebElement link_Frame;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'iFrame')]")
	private WebElement link_iFrame;
	
	@FindBy(how=How.XPATH, using="//body[@id='tinymce']/p")
	private WebElement iframe_elt;
	
	public WebElement getIframe_elt() {
		return iframe_elt;
	}
	public WebElement getLink_iFrame() {
		return link_iFrame;
	}
	public WebElement getLink_Frame() {
		return link_Frame;
	}
	
	public WebElement getButton_JSalerts() {
		return button_JSalerts;
	}
	
	public WebElement getLink_alerts() {
		return link_alerts;
	}

	public WebElement getCheckboxHeader() {
		return checkboxHeader;
	}
	
	public WebElement getLink_BasicAuth() {
		return link_BasicAuth;
	}
	
	public WebElement getLink_ABTesting() {
		return link_ABTesting;
	}
	
	public WebElement getLink_Dropdown() {
		return link_Dropdown;
	}
	
	public WebElement getDropdown_select() {
		return dropdown_select;
	}
	
	public WebElement getLink_checkboxes() {
		return link_checkboxes;
	}
	
	public WebElement getCheckbox1() {
		return checkbox1;
	}
	
	public WebElement getCheckbox2() {
		return checkbox2;
	}
	
	public WebElement getLink_FormAuthentication() {
        return link_FormAuthentication;
    }
	
    public WebElement getTextbox_username() {
        return textbox_username;
    }
    
    public WebElement getTextbox_password() {
        return textbox_password;
    }
    
    public WebElement getButton_Login() {
        return button_Login;
    }
}
