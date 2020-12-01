package pages;

import utilty.Reporting;
import utilty.Utility;

public class SigninPage extends Utility{

	String skipSignin = "com.amazon.mShop.android.shopping:id/skip_sign_in_button";
	

/*Method for Skipping Signing in
 * Attributes: Object of generating  Html Reports and screenshots
 * Created by Benarji Enamandala
 */

public void skipsignin(Reporting report) {
	
	clickElement("id",skipSignin,report);
	report.reportpass("skipped sign in");
	
	

}

}