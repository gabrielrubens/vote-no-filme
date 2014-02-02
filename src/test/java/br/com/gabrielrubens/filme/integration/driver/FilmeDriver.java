package br.com.gabrielrubens.filme.integration.driver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilmeDriver {

	private final String URL_BASE = "http://localhost:8080/vote-no-filme/";
	private WebDriver browser;

	public FilmeDriver(WebDriver browser) {
		this.browser = browser;
	}

	public void deveIrNaUrlDeInserirFilmesDeTeste() {
		browser.get(URL_BASE+"filme/inserirBaseDeTeste");
		
		Assert.assertEquals("Filmes incluidos com sucesso!", browser.findElement(By.id("mensagem")).getText());
	}

}
