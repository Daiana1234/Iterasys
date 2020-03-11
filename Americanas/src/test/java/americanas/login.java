package americanas;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class login {
	String url;
	WebDriver driver;
	String nomePasta = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());
	
	public void Print(String nomePrint) throws IOException {
		// Vamos fazer uma especializacao do Selenium trazendo um acessorio
		File foto = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(foto, new File(
				"C:\\Eclipe Projeto\\Americanas\\target\\evidencias\\" + nomePasta + "\\" + nomePrint + ".png"));
	}
		
		@Before
		public void Iniciar() {
			url = "https://www.americanas.com.br/";
			System.setProperty("webdriver.chrome.driver",
					"C:\\Eclipe Projeto\\Americanas\\drivers\\chrome\\80\\chromedriver.exe");

}

		@After
		public void Finalizar() {
			driver.quit();
		}

		
		@Given("^que acesso o site da Americanas$")
		public void que_acesso_o_site_da_Americanas() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
			driver.get(url);

			Print("Passo 1 - Acessei o site do Submarino");

			System.out.println("Passo 1 - Acessei o site do Extra");
		}

		@When("^verifica cadastro$")
		public void verifica_cadastro() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			driver.findElement(By.linkText("Cliente novo? Cadastrar")).click();
			driver.findElement(By.id("email-input")).sendKeys();
			driver.findElement(By.id("passaword-imput")).sendKeys("000000");
		}

		@Then("^verificar usuario logado$")
		public void verificar_usuario_logado() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    driver.findElement(By.id("h_search-input")).sendKeys("cama box");
		    driver.findElement(By.cssSelector(".-hover")).click();
		    
		    //colocar assert
		    
		}

	}
