package pages;

import utilty.Reporting;
import utilty.Utility;


public class ProductDesc extends Utility{
	
	
	String cart="com.amazon.mShop.android.shopping:id/action_bar_cart";
	String nameText="Add to Cart";
	String addToCart="//android.widget.Button[@text='Add to Cart']";
	String id="add-to-cart-button";
	String productName="com.amazon.mShop.android.shopping:id/item_title";
	String product="//*[@resource-id='title_feature_div']//*[@class='android.view.View']";
	
	
	/*Method to get Product Details  from Product Description page
	 * Attributes: Object of generating  Html Reports and screenshots
	 * Created By : Benarji Enamandala
	 */
	
public String getProductName(Reporting report) throws InterruptedException {

String name=null;

		name=getText("xpath", product, report);
	

	return name;
}


/*Method to Add product to Cart by clicking on Add to Cart Button
 * Attributes: Object of generating  Html Reports and screenshots
 * Created By : Benarji Enamandala
 */
public  void addToCart(Reporting report) throws InterruptedException {
	scroll(nameText,report);
	waitForElementToBeClickable("xpath", addToCart, report);
	clickElement("xpath", addToCart,report);

	 
	
	
}
/*Method to click on Cart Button to Open Cart
 * Attributes: Object of generating  Html Reports and screenshots
 * Created By : Benarji Enamandala
 */
public void openCart(Reporting report) throws InterruptedException {
	
		clickElement("id", cart,report);
		report.reportpass("cart clicked");
}

}
