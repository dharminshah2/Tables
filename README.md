# Tables
 
 First clone this project and this is Maven project so Maven will download all necessary dependencies and driver binary is also attached in project.
 You can run all the test from TestNG.xml as well as pom.xml(Maven)

  Once execution is done you will see report in $project_path\report\report.html (which will also include logs if any test fails)
  You can also check the TestNG default report in $project_path\test-output\index.html (which will also include logs if any test fails)
 
------------------------------------------------

I have created Maven Project in which I used TDD Framework TestNG with Page Object Model and Data-Driven from properties files.

By default all tests will run in "chrome", if you want to change the browser go to $project_path\src\main\java\resources\data.properties and change the browser to "firefox"

Binary used for the ChromeDriver.exe is "ChromeDriver 98.0.4758.80" so use Chrome Version 98.0.4758.82
            for the geckoDriver.exe is "geckodriver-v0.29.1" so use FireFox Version 96.0.2

---------------src\main\java -------------------------------- 
I have created multiple packages such as:
  1) "driver" which contains binary of Chrome Driver, Firefox Driver, and Edge Driver
  2)  "pageObject" package contains TableData class in which I defined all object of the same class in 1 file. (So it will be easy to change those at 1 place if any Object's locator got changed. Table Data is extending Base class (Inheritance)
  3)  "resources" package contains Base class which has driver initialize method, and I defined all variables as private and use getter, setter method where necessary. (Encapsulation) and browser name and url we can change from data.properties file (Data-Driven Approach)
      in the same package defined Interface "GenericTable" which is defining the method signatures. (Abstraction)
  4)  "utilities" package contains ExtentReporterNG to generate a good report.
  
---------------src\test\java---------------------------
  1) There is TableTest which include all Unit test. BeforeTest method invokes the driver and navigates to url. (Extending from Base class) (Inheritance)
  2) Listener class is Implemented from ITestLustener (From TestNG) so when a test starts it took method name and when test pass in report you will see Test.Pass and if Test fails you will see Test.Fail with fail logs
  
  ------------------
  
  Reports got generated in report package with name report.html
  
  -------------------------------

Jars version aand Dependencies: (Maven wil download automatically)

selenium 3.141.59
testng 6.14.3
extentreports 5.0.9
apache commons-io 2.6

