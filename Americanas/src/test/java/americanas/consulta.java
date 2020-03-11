package americanas;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class consulta {
	String url;
	WebDriver driver;
	String nomePasta = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());

	// Funcoes e metodos de apoio
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
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}

	@After
	public void Finalizar() {
		driver.quit();
	}

	@Given("^que acesso o site do Americanas$")
	public void que_acesso_o_site_do_Americanas() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		driver.get(url);

		Print("Passo 1 - Acessei o site do Submarino");

		System.out.println("Passo 1 - Acessei o site do Extra");
	}

	@When("^preencho o termo \"([^\"]*)\" e clico na lupa$")
	public void preencho_o_termo_e_clico_na_lupa(String termo) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		Thread.sleep(10000);
		driver.findElement(By.id("h_search-input")).sendKeys(termo);
		Print("Passo 2 - Preenchi o termode busca");
		driver.findElement(By.id("h_search-imput")).sendKeys(Keys.ENTER);

		System.out.println("Passo 2 - Preenchi o termo e cliquei na lupa");

	}

	@Then("^exibe a lista de produtos$")
	public void exibe_a_lista_de_produtos() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		//verifica se esta igual (algo que eu quero comparar, algo que tem no site);
		assertEquals("Smartphone em Promoção nas Lojas Americanas.com", driver.getTitle());
		Print("Passo 3.p - Exibiu a lista de produtos");

	}

}
