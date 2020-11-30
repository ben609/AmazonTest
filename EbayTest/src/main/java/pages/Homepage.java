package pages;




import java.util.concurrent.TimeUnit;

import utilty.Reporting;
import utilty.Utility;

public class Homepage extends Utility {
	
	String searchBox="com.amazon.mShop.android.shopping:id/rs_search_src_text";
	String productName="com.amazon.mShop.android.shopping:id/item_title";
	
	/*Method to Search for a Product By Entering Text in Search box
	 * Attributes: Object of Reporting event  passed , product name from Exceldata
	 * Created By : Benarji Enamandala
	 *
	 */
public void searcBox(String product ,Reporting report) throws InterruptedException {
	
		
		

	clickElement("id", searchBox, report);
	sendkeys("id", searchBox,product,report);
	enter(report);
	
	Thread.sleep(15000);
// Repeating Above Code again due to App Redirection to Amazon Home page again  
	clickElement("id", searchBox,report);
	System.out.println();
	sendkeys("id", searchBox,product,report);
	enter(report);
}
	
	

/*Method to Select random Product From Search  List
 * Attributes: Object of Reporting event  passed 
 * Created By : Benarji Enamandala
 */
	
public void selectProduct(Reporting report) {

	randSelection("id",productName ,report);
	report.reportpass("Selected Random Product Success");
	


	
}
	
}
