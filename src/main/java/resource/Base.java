package resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	private WebDriver driver;
	private String browserName;
	private String projectPath;
	private String url;

	public WebDriver initialization() throws IOException {

		projectPath = System.getProperty("user.dir");

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(projectPath + "\\src\\main\\java\\resource\\data.properties");
		prop.load(fis);

		browserName = prop.getProperty("browser");
		setUrl(prop.getProperty("url"));

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\main\\java\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\src\\main\\java\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\main\\java\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();

		return driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
