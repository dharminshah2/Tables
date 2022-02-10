package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resource.Base;
import resource.GenericTable;


public class HomePage extends Base implements GenericTable {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By table1 = By.id("table1");
	
	private By table2 = By.id("table2");

	private By headerTable1 = By.cssSelector("table[id='table1'] th");
	
	private By headerTable2 = By.cssSelector("table[id='table2'] th");

	private By allRowsOfTable1 = By.cssSelector("table[id='table1'] tbody tr");
	
	private By allRowsOfTable2 = By.cssSelector("table[id='table2'] tbody tr");
	
	private By sortByFirstNameTable1 = By.cssSelector("table[id='table1'] th:nth-child(2)");
	
	private By sortByLastNameTable2 = By.cssSelector("table[id='table2'] th:nth-child(1)");
	

	@Override
	public WebElement getTable1() {
		return driver.findElement(table1);
	}
	
	@Override
	public WebElement getTable2() {
		return driver.findElement(table2);
	}
	
	@Override
	public List<WebElement> getHeaderTable1() {
		return driver.findElements(headerTable1);
	}
	
	@Override
	public List<WebElement> getHeaderTable2() {
		return driver.findElements(headerTable2);
	}
	
	@Override
	public List<WebElement> getAllRowsOfTable1() {
		return driver.findElements(allRowsOfTable1);
	}
	
	@Override
	public List<WebElement> getAllRowsOfTable2() {
		return driver.findElements(allRowsOfTable2);
	}
	
	@Override
	public WebElement getSortByFirstNameTable1() {
		return driver.findElement(sortByFirstNameTable1);
	}

	@Override
	public WebElement getSortByLastNameTable2() {
		return driver.findElement(sortByLastNameTable2);
	}


	
}
