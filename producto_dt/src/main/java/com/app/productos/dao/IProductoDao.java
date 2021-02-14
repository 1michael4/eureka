package com.app.productos.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.productos.entities.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long> {

}