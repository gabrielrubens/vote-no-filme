package br.com.gabrielrubens.filme.integration.page;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.gabrielrubens.filme.integration.driver.FilmeDriver;

public class FilmePage {
	private static WebDriver browser;
	private FilmeDriver filme;

	@BeforeClass
	public static void abreBrowser() {
		browser = new FirefoxDriver();
	}

	@Before
	public void setUp() throws Exception {
		filme = new FilmeDriver(browser);
	}

	@AfterClass
	public static void teardown() {
		browser.close();
	}
	
	@Test
	public void deveInserirFilmesParaTeste(){
		filme.deveIrNaUrlDeInserirFilmesDeTeste();
	}
}
