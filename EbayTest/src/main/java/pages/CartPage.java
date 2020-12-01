package pages;

import utilty.Reporting;
import utilty.Utility;

public class CartPage extends Utility{
	String productName= "//*[@resource-id='activeCartViewForm']//*[@class='android.widget.Image']";
	String checkOut="//android.widget.Button[@text='Proceed to checkout']";
	
	
	/*Method to compare Products Added in Cartpage equals Product Selected
	 * Attributes: Object of Reporting event  passed , xpath of Product name as String
	 * Created By : Benarji Enamandala
	 */
	public void compareProduct(String product,Reporting report) {
		
		
		String cartProductName=getText("xpath", productName, report);
			verifyText(cartProductName,product , report);
			report.reportpass("Product matched");
		
	}
	
	/*Method to Click on Checkout Button
	 * Attributes: Object of Reporting event  passed 
	 * Created By : Benarji Enamandala
	 */
	
	public void checkOut(Reporting report) {
		
		clickElement("xpath", checkOut, report);
		report.reportpass("Navigated to checkout");
		
	}
	
}
