package resource;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface GenericTable {
	
	//Define all methods signatures
	
	WebElement getTable1();
	WebElement getTable2();
	List<WebElement> getHeaderTable1();
	List<WebElement> getHeaderTable2();
	List<WebElement> getAllRowsOfTable1();
	List<WebElement> getAllRowsOfTable2();
	WebElement getSortByFirstNameTable1();
	WebElement getSortByLastNameTable2();

}
