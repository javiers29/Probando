package com.curso.bbdd.beans;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;


@Entity
public class DetallePedido {
		
	@EmbeddedId
		ClaveDetalle id;
	
	@ManyToOne
	@MapsId("productoId")
	@JoinColumn(name = "idproducto")
	Producto producto;
	
	@ManyToOne
	@MapsId("pedidoId")
	@JoinColumn(name = "idpedido")
	Pedido pedido;
	
	private float precio;
	private int unidades;
	private float descuento;
	
	
	public DetallePedido(ClaveDetalle id, Producto producto, Pedido pedido, float precio, int unidades,
			float descuento) {
		super();
		this.id = id;
		this.producto = producto;
		this.pedido = pedido;
		this.precio = precio;
		this.unidades = unidades;
		this.descuento = descuento;
	}


	public DetallePedido() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ClaveDetalle getId() {
		return id;
	}


	public void setId(ClaveDetalle id) {
		this.id = id;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public int getUnidades() {
		return unidades;
	}


	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}


	public float getDescuento() {
		return descuento;
	}


	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}


	@Override
	public String toString() {
		return "DetallePedido [id=" + id + ", producto=" + producto + ", pedido=" + pedido + ", precio=" + precio
				+ ", unidades=" + unidades + ", descuento=" + descuento + "]";
	}
	
	
	
	
}
