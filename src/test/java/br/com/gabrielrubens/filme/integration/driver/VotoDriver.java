package br.com.gabrielrubens.filme.integration.driver;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VotoDriver {
	private final String URL_BASE = "http://localhost:8080/vote-no-filme/";
	private WebDriver browser;

	public VotoDriver(WebDriver browser) {
		this.browser = browser;
	}

	public void paginaInicial() {
		browser.get(URL_BASE);
	}

	public void deveApresentarOsCondidatos() {
		
		WebElement form = browser.findElement(By.id("formVotos"));
		
		assertTrue(form.findElement(By.id("btnFilme1")).isDisplayed());
		assertTrue(form.findElement(By.id("btnFilme2")).isDisplayed());

		//assertThat(msg.getText(), containsString(mensagem));
	}
}
