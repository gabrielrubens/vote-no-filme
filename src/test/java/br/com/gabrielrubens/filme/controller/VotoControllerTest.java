package br.com.gabrielrubens.filme.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;




//import javax.enterprise.inject.Instance;
import javax.servlet.http.HttpServletRequest;

import org.hamcrest.text.IsEmptyString;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;




//import br.com.caelum.vraptor.interceptor.DefaultTypeNameExtractor;
import br.com.caelum.vraptor.interceptor.TypeNameExtractor;
import br.com.caelum.vraptor.ioc.Container;
import br.com.caelum.vraptor.proxy.JavassistProxifier;
import br.com.caelum.vraptor.rest.gson.GsonBuilderWrapper;
/*import br.com.caelum.vraptor.serialization.xstream.XStreamBuilder;
import br.com.caelum.vraptor.serialization.xstream.XStreamBuilderImpl;
import br.com.caelum.vraptor.serialization.xstream.XStreamConverters;*/
import br.com.caelum.vraptor.util.test.MockInstanceImpl;
import br.com.caelum.vraptor.util.test.MockSerializationResult;
import br.com.caelum.vraptor.view.Results;
import br.com.gabrielrubens.filme.model.Candidatos;
import br.com.gabrielrubens.filme.model.Disputa;
import br.com.gabrielrubens.filme.model.Filme;
import br.com.gabrielrubens.filme.model.Voto;
import br.com.gabrielrubens.filme.repository.FilmeRepository;
import br.com.gabrielrubens.filme.repository.VotoRepository;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
/*import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.SingleValueConverter;*/

public class VotoControllerTest {
	//private Result result;
	private MockSerializationResult result;
	@Mock private HttpServletRequest request;
	@Mock private Container container;
	@Mock private TypeNameExtractor extractor;
	private VotoController controller;
	@Mock private Disputa disputa;
	@Mock private FilmeRepository filmeRepository;
	@Mock private VotoRepository votoRepository;
	private Filme filme1;
	private Filme filme2;
	private Candidatos candidatos;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		//result = spy(new DefaultResult(request, container, null, extractor));
		
		List<JsonSerializer<?>> jsonSerializers = new ArrayList<>();
		List<JsonDeserializer<?>> jsonDeserializers = new ArrayList<>();

		//fazer voltar em json
		result = new MockSerializationResult(new JavassistProxifier(), null,
				new GsonBuilderWrapper(new MockInstanceImpl<>(jsonSerializers), new MockInstanceImpl<>(jsonDeserializers)));
		result.use(Results.json());
		
		filme1 = new Filme(1L, "Filme 1");
		filme2 = new Filme(2L, "Filme 2");
		candidatos = new Candidatos(filme1, filme2);
		when(disputa.temCandidatos()).thenReturn(true);
		when(disputa.proximosCandidatos()).thenReturn(candidatos);
		controller = new VotoController(result, disputa, votoRepository);
	}

	@Test
	public void deveApresentarOsCondidatos() throws Exception {
		controller.index();
		verificaSeAhUmaDisputaComDoisFilmes();
	}

	@Test
	public void deveVotarEmUmFilme() throws Exception{
		
		controller = new VotoController(result, disputa, votoRepository);
		
		controller.votar(candidatos, filme1);
		
		verify(votoRepository).votar(any(Voto.class));
		verificaSeAhUmaDisputaComDoisFilmes();
	}
	
	@Test
	public void deveVotarNoUltimoDuelo() throws Exception{
		controller = new VotoController(result, disputa, votoRepository);
		
		controller.votar(candidatos, filme1);
		
		verify(votoRepository).votar(any(Voto.class));
		verify(spy(controller),  never()).index();
	}

	@Test
	public void naoDeveRetornarNemhumadisputaPorSerOUltimoVoto() throws Exception{
		
		when(disputa.temCandidatos()).thenReturn(false);
		controller = new VotoController(result, disputa, votoRepository);
		
		controller.votar(candidatos, filme1);
		
		verify(votoRepository).votar(any(Voto.class));
		verify(spy(controller), never()).index();
		
		assertThat(result.serializedResult(), IsEmptyString.isEmptyOrNullString());
	}

	private void verificaSeAhUmaDisputaComDoisFilmes() throws Exception {
		assertThat(result.serializedResult(), is(equalTo(jsonEsperado())));
	}
	
	private String jsonEsperado() {
		return "{\"candidatos\":{\"filme1\":{\"id\":1,\"nome\":\"Filme 1\"},\"filme2\":{\"id\":2,\"nome\":\"Filme 2\"}}}";
	}
}
