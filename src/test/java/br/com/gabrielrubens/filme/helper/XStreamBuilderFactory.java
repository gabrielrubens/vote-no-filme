package br.com.gabrielrubens.filme.helper;

import javax.enterprise.inject.Instance;

import br.com.caelum.vraptor.interceptor.DefaultTypeNameExtractor;
import br.com.caelum.vraptor.serialization.xstream.XStreamBuilder;
import br.com.caelum.vraptor.serialization.xstream.XStreamBuilderImpl;
import br.com.caelum.vraptor.serialization.xstream.XStreamConverters;
import br.com.caelum.vraptor.util.test.MockInstanceImpl;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.SingleValueConverter;

public class XStreamBuilderFactory {
	public XStreamBuilder cleanInstance(Converter...converters) {
		Instance<Converter> convertersInst = new MockInstanceImpl<>(converters);
		Instance<SingleValueConverter> singleValueConverters = new MockInstanceImpl<>();
		XStreamConverters xStreamConverters = new XStreamConverters(convertersInst, singleValueConverters);
		return new XStreamBuilderImpl(xStreamConverters, new DefaultTypeNameExtractor());
	}
}
