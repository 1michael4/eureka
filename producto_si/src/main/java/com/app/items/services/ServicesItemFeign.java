package com.app.items.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.app.items.clientes.ProductoClienteRest;
import com.app.items.models.Items;

@Service
@Primary
public class ServicesItemFeign implements IServicesItem {
	
	@Autowired
	private ProductoClienteRest clientFeign;
	
	@Override
	public List<Items> findAll(){
		return clientFeign.listar().stream().map(p -> new Items(p,1)).collect(Collectors.toList());
	}
	
	@Override
	public Items findById(Long id, Integer cantidad){
		return new Items(clientFeign.ver(id), cantidad);
	}
}
