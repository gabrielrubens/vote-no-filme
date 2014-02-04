package br.com.gabrielrubens.filme;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.gabrielrubens.filme.controller.FilmeControllerTest;
import br.com.gabrielrubens.filme.controller.VotoControllerTest;
import br.com.gabrielrubens.filme.integration.page.FilmePage;
import br.com.gabrielrubens.filme.integration.page.VotoPage;
import br.com.gabrielrubens.filme.model.DisputaTest;
import br.com.gabrielrubens.filme.repositorio.FilmeRepositoryImplTest;
import br.com.gabrielrubens.filme.repositorio.VotoRepositoryImplTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	FilmeControllerTest.class, 
	VotoControllerTest.class,
	FilmePage.class,
	VotoPage.class,
	DisputaTest.class,
	FilmeRepositoryImplTest.class,
	VotoRepositoryImplTest.class
	})
public class AllTests {

}
