package com.example.springboot.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class Configuracion {

	@Bean	// Bean para manejar mensages SOAP
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/ws/*");
	}

	@Bean(name = "productos") // Bean para exponer el WSDL que usaran para llamarnos
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema productosSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("ProductosPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://example.com/productos");
		wsdl11Definition.setSchema(productosSchema);
		return wsdl11Definition;
	}

	@Bean // Bean para indicar la localizacion del XSD de origen
	public XsdSchema productosSchema() {
		return new SimpleXsdSchema(new ClassPathResource("productos.xsd"));
	}
	
	
}
