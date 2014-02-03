package br.com.gabrielrubens.filme.integration.page;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.gabrielrubens.filme.integration.driver.VotoDriver;

public class VotoPage {
	private static WebDriver browser;
	private VotoDriver voto;

	@BeforeClass
	public static void abreBrowser() {
		browser = new FirefoxDriver();
	}

	@Before
	public void setUp() throws Exception {
		voto = new VotoDriver(browser);
		voto.paginaInicial();
	}

	@AfterClass
	public static void teardown() {
		//browser.close();
	}
	
	//@Test
	public void naTelaInicialDeveAparacerDoisFilmesParaVoto(){
		voto.deveApresentarOsCondidatos();
	}
	
	@Test
	public void deveVotarEmUmFilme(){
		voto.votar();
		voto.deveApresentarOsCondidatos();
	}
}
