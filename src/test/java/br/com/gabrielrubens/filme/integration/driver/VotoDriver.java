package br.com.gabrielrubens.filme.integration.driver;

import static org.junit.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VotoDriver {
	private final String URL_BASE = "http://localhost:8080/vote-no-filme/";
	private final String URL_INSERIR_FILMES_TESTE = "http://localhost:8080/vote-no-filme/filme/inserirBaseDeTeste";
	private WebDriver browser;

	public VotoDriver(WebDriver browser) {
		this.browser = browser;
	}

	public void paginaInicial() {
		browser.get(URL_INSERIR_FILMES_TESTE);
		browser.get(URL_BASE);
	}

	public void deveApresentarOsCondidatos() {
		
		WebElement form = getForm();
		
		assertTrue(form.findElement(By.id("btnFilme1")).isDisplayed());
		assertTrue(form.findElement(By.id("btnFilme2")).isDisplayed());
	}

	public void votarEmUmFilme() {
		WebElement form = getForm();
		form.findElement(By.id("btnFilme1")).click();
	}
	
	public void votarEmTodosOsFilmes() {
		
		Random r = new Random(2);
		WebElement form = getForm();
		
		for (int i = 0; i < 10; i++) {
			int umOuDois = r.nextInt(2)+1;
			form.findElement(By.id("btnFilme"+umOuDois)).click();
			browser.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		}
		
		browser.findElement(By.id("nome")).sendKeys("Gabriel Rubens");
		browser.findElement(By.id("email")).sendKeys("gabriel@gabriel.com.br");
		browser.findElement(By.id("btnSalvarUsuario")).click();
	}
	
	private WebElement getForm() {
		WebElement form = browser.findElement(By.id("formVotos"));
		return form;
	}
}
