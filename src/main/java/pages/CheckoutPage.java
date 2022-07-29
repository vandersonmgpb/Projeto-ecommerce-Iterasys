package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	private WebDriver driver;
	
<<<<<<< HEAD
	private By totalTaxInclTotal = By.cssSelector("div.cart-total span.value");
	
=======
	private By totalTaxIncTotal = By.cssSelector("div.cart-total span.value");
>>>>>>> de43395c741d7848a1fdedba116b8bd03f324bf6
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
<<<<<<< HEAD
	public String obter_totalTaxInclTotal() {
		return driver.findElement(totalTaxInclTotal).getText();
=======
	public String obter_totalTaxIncTotal() {
		return driver.findElement(totalTaxIncTotal).getText();
>>>>>>> de43395c741d7848a1fdedba116b8bd03f324bf6
	}

}
