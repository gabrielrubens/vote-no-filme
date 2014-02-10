package br.com.gabrielrubens.filme.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.proxy.JavassistProxifier;
import br.com.caelum.vraptor.rest.gson.GsonBuilderWrapper;
import br.com.caelum.vraptor.util.test.MockInstanceImpl;
import br.com.caelum.vraptor.util.test.MockSerializationResult;
import br.com.gabrielrubens.filme.helper.XStreamBuilderFactory;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

public class MockResultHelper {

	public static MockSerializationResult criarMockResult() {
		List<JsonSerializer<?>> jsonSerializers = new ArrayList<>();
		List<JsonDeserializer<?>> jsonDeserializers = new ArrayList<>();

		//fazer voltar em json
		return new MockSerializationResult(new JavassistProxifier(),
											new XStreamBuilderFactory().cleanInstance(),
											new GsonBuilderWrapper(new MockInstanceImpl<>(jsonSerializers), 
												new MockInstanceImpl<>(jsonDeserializers)));
	}
}