package com.example.springboot.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.productos.GetProductosRequest;
import com.example.productos.GetProductosResponse;
import com.example.springboot.repositorio.ProductosRepository;

@Endpoint
public class ProductosEndPoint {

	private static final String NAMESPACE_URI = "http://example.com/productos";
	
	private ProductosRepository productosRepository;

	@Autowired
	public ProductosEndPoint(ProductosRepository productosRepository) {
		super();
		this.productosRepository = productosRepository;
	}

	// @PayloadRoot = El punto de entrada de las peticiones para "getProductos"
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductosRequest")
	@ResponsePayload
	public GetProductosResponse getProductos(@RequestPayload GetProductosRequest peticion) {
		GetProductosResponse respuesta = new GetProductosResponse();
		respuesta.setProducto(productosRepository.buscarProducto(peticion.getNombre()));
		return respuesta;
	}
	
	
}
