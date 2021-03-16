package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	private WebDriver driver;

	@Given("I have entered {int} into the calculator")
	public void i_have_entered_int1_into_the_calculator(Integer int1) {

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.marshu.com/articles/calculate-addition-calculator-add-two-numbers.php");
		WebElement field1 = driver.findElement(By.name("n01"));
		field1.sendKeys("70");
	}

	@Given("I have also entered {int} into the calculator")
	public void i_have_entered_int2_into_the_calculator(Integer int2) {
		WebElement field2 = driver.findElement(By.name("n02"));
		field2.sendKeys("50");
	}

	@When("I press Find Addition")
	public void i_press_FindAdd() {
		WebElement button = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/form/p[4]/input"));
		button.click();
	}

	@Then("the result should be {int} on the screen")
	public void the_result_should_be_on_the_screen(Integer int1) {
		WebElement fieldAns = driver.findElement(By.name("answer"));
		String sum = fieldAns.getAttribute("value");
		System.out.println(sum);
		assertEquals(sum, "120");
	}

}
