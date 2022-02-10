package tables;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.TableData;
import resource.Base;

public class TableTest extends Base {

	public WebDriver driver;
	TableData tableData;
	List<WebElement> headerTable1;
	List<WebElement> headerTable2;
	List<WebElement> allRowsOfTable1;
	List<WebElement> allRowsOfTable2;
	WebElement table1;
	WebElement table2;

	ArrayList<String> list1;
	ArrayList<String> list2;

	@BeforeTest
	private void initializeDriver() throws IOException {
		driver = initialization();
		driver.get(getUrl());
		tableData = new TableData(driver);
	}

	@AfterTest
	private void tearDown() {
		driver.quit();
	}

	@Test
	private void verifyHeaderOfTable1AndTable2() {

		Assert.assertSame(tableData.getHeaderTable1().size(), tableData.getHeaderTable2().size());

	}

	@Test
	private void verifyHeaderNameAndOrder() {

		headerTable1 = tableData.getHeaderTable1();

		headerTable2 = tableData.getHeaderTable2();

		// Verify the Table1 Header Row Size with Table2 Header Row Size
		Assert.assertTrue(headerTable1.size() == headerTable2.size());

		for (int i = 0; i < headerTable1.size(); i++) {

			// Verify the Table1 Header Row Data and Order is same as Table2 Header Row Data
			// and Order
			Assert.assertTrue(headerTable1.get(i).getText().equalsIgnoreCase(headerTable2.get(i).getText()));

		}
	}

	@Test
	private void verifyNumberOfDataRows() {

		// Verify number of Rows in Table 1 is same as number of Rows in Table 2
		Assert.assertSame(tableData.getAllRowsOfTable1().size(), tableData.getAllRowsOfTable2().size());

	}

	@Test
	private void verifyRowData() {

		allRowsOfTable1 = tableData.getAllRowsOfTable1();
		allRowsOfTable2 = tableData.getAllRowsOfTable2();

		for (int i = 0; i < allRowsOfTable1.size(); i++) {

			Assert.assertTrue(allRowsOfTable1.get(i).getText().equalsIgnoreCase(allRowsOfTable2.get(i).getText()));

		}

	}

	//use dependsOnMethod because if data is not same in both table rows there is not do sort and verify. If verifyRowData method pass 
	//then verifyRowDataWithSort will execute else this method will skipped
	
	@Test(dependsOnMethods = { "verifyRowData" })
	private void verifyRowDataWithSort() throws InterruptedException {

		allRowsOfTable1 = tableData.getAllRowsOfTable1();
		allRowsOfTable2 = tableData.getAllRowsOfTable2();

		list1 = new ArrayList<String>();
		list2 = new ArrayList<String>();

		// Table1 will sort as First Name
		tableData.getSortByFirstNameTable1().click();

		// Table2 will sort as Last Name
		tableData.getSortByLastNameTable2().click();

		for (WebElement row1 : allRowsOfTable1) {

			List<WebElement> cells1 = row1.findElements(By.tagName("td"));

			for (int j = 0; j < cells1.size() - 1; j++) {

				// each row's column will extract and add in list1 (except Action column)

				list1.add(cells1.get(j).getText());
			}

			for (WebElement row2 : allRowsOfTable2) {

				List<WebElement> cells2 = row2.findElements(By.tagName("td"));

				for (int i = 0; i < cells2.size() - 1; i++) {

					// each row's column will extract and add in list2 (except Action column)
					list2.add(cells2.get(i).getText());

				}
				if (list1.equals(list2)) {
					// this list2 and list1 will compare so if data in list1 is same as list2 it
					// Assert will assert it 
					Assert.assertTrue(list1.containsAll(list2));

					// for other row we need to clear both list1 and list2
					list1.clear();
					list2.clear();

				} else {
					list2.clear();
				}

			}
		}

	}

}
