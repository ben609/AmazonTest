package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.Homepage;
import pages.ProductDesc;
import pages.SigninPage;
import utilty.ExcelData;
import utilty.Reporting;
import utilty.Utility;

public class MainActivity extends Utility {
	Reporting extentreport;
	
	/*Constructor calling Utility Class Constructor 
	 * Created By : Benarji Enamandala
	 */
public MainActivity() {
	
	super();
}

/* Before Test to initialize drivers and Reports
 * Created By : Benarji Enamandala
 */
	@BeforeTest
	public void before() {
		
		MainActivity amazonApp=new MainActivity();  // MainActivity Object created to call  Constructor
		extentreport=new Reporting();  //creating object for Reporting
		extentreport.extentReportInit();
		extentreport.logger=extentreport.report.createTest("AppTest");
		driverIni(extentreport); //passing report object to Utility driver initiating
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	
	/*Main Test Method 
	 * Created By : Benarji Enamandala
	 */
	@Test
	public void amazonTest() throws InterruptedException, IOException {
		
		new SigninPage().skipsignin(extentreport);
		String productName=new ExcelData().getData("productname");
		new Homepage().searcBox(productName,extentreport);
		new Homepage().selectProduct(extentreport);
		String name=new ProductDesc().getProductName(extentreport);
		new ProductDesc().addToCart(extentreport); 
		new ProductDesc().openCart(extentreport);
		new CartPage().compareProduct(name,extentreport);
		new CartPage().checkOut(extentreport);
	
	
			
	}
	/*After Method to get all failed reports
	 * Attributes: result : object of ITestResult
	 * Created By : Benarji Enamandala
	 */
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            
            extentreport.reportfail(result.getThrowable().getMessage());
       }
    }
	/*AfterTest Method to Quit Driver
	 * Created By : Benarji Enamandala
	 */
	@AfterTest
	public void after() {
		extentreport.report.flush();
		driver.quit();
		
	}

}
