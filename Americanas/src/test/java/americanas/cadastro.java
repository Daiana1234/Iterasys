package americanas;

import static org.junit.Assert.assertEquals;

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
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class cadastro {
	String url;
	WebDriver driver;
	String nomePasta = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());
	//Funcoes e metodos de apoio
    // Tirar print da tela

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
	driver = new ChromeDriver();
	//driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
	driver.manage().window().maximize();
}

@After
public void Finalizar() {
 
 driver.quit();
 
}


@Given("^que acessa o site Americanas$")
public void que_acessa_o_site_Americanas() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
	driver.get(url);

	Print("Passo 1 - Acessei o site do Americanas");

	System.out.println("Passo 1 - Acessei o site do Americanas");

}

@When("^pesquiso novo cadastro$")
public void pesquiso_novo_cadastro() throws Throwable {
    // Write code here that turns the phrase above into concrete actions

	driver.findElement(By.cssSelector(".usr-act-text")).click();
	driver.findElement(By.linkText("Cliente novo? Cadastrar")).click();

	Print("Passo 2 - Pesquiso novo cadastro");
    
	System.out.println("Passo 2 - Pesquiso o site");

}

@Then("^preencho os dados solicitados$")
public void preencho_os_dados_solicitados() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.id("email-input")).click();
    driver.findElement(By.id("email-input")).sendKeys("iosdaiana@gmail.com");
    driver.findElement(By.id("name-input")).sendKeys("Daiana de Cássia Silva Tenoury");
    driver.findElement(By.id("phone-input")).sendKeys("(11) 97511-9257");
    driver.findElement(By.id("password-input")).click();
    driver.findElement(By.id("password-input")).sendKeys("000000");
    driver.findElement(By.id("Rectangle-5")).click();
    driver.findElement(By.id("eye")).click();
    driver.findElement(By.id("cpf-input")).click();
    driver.findElement(By.id("cpf-input")).sendKeys("325.267.488-28");
    driver.findElement(By.id("birthday-input")).click();
    driver.findElement(By.id("name-input")).click();
    driver.findElement(By.id("name-input")).sendKeys("Daiana de Cássia Silva Tenoury22051990");
    driver.findElement(By.id("birthday-input")).click();
    driver.findElement(By.cssSelector(".radio:nth-child(3) > label")).click();
    driver.findElement(By.id("birthday-input")).click();
    driver.findElement(By.id("birthday-input")).sendKeys("22/05/1990");
    driver.findElement(By.id("phone-input")).click();
    driver.findElement(By.cssSelector(".inputGroup:nth-child(9) .checkbox-check")).click();
    driver.findElement(By.cssSelector(".btn")).click();
   
	Print("Passo 3 - Preencho como solicitado");
	
	System.out.println("Passo 3 - Preencho os dados solicitados");

	assertEquals("Daiana", driver.findElement(By.cssSelector(".usr-act-text")).getText());
}
}