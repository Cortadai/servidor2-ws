package com.example.springboot.repositorio;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.productos.Producto;
import com.example.productos.Tipo;

@Component	// Registra la clase como un componente de Springboot
public class ProductosRepository {

	private static final Map<String, Producto> productos = new HashMap<>();
	
	public ProductosRepository() {

		Producto teclado = new Producto();
		teclado.setNombre("teclado");
		teclado.setDescripcion("teclado chulisimo");
		teclado.setEstado(true);
		teclado.setTipo(Tipo.VENTA);
		
		Producto raton = new Producto();
		raton.setNombre("raton");
		raton.setDescripcion("raton chulisimo");
		raton.setEstado(true);
		raton.setTipo(Tipo.VENTA);
		
		Producto monitor = new Producto();
		monitor.setNombre("monitor");
		monitor.setDescripcion("monitor chulisimo");
		monitor.setEstado(false);
		monitor.setTipo(Tipo.COMPRA);
		
		productos.put(teclado.getNombre(), teclado);
		productos.put(raton.getNombre(), raton);
		productos.put(monitor.getNombre(), monitor);
		
	}
	
	
	public Producto buscarProducto(String nombreProducto) {
		return productos.get(nombreProducto);
	}
	
	
}
