package com.curso.bbdd.beans;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Producto.getProductosRango ", query = "FROM Producto p where p.precio>= ?1 and p.precio<=?2")
@Table(name= "productos")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	
	private String nombre;
	private float precio;
	private int existencias;
	
	@ManyToOne(fetch= FetchType.LAZY, optional= false)
	@JoinColumn(name="idcategoria", nullable = false)
	
	private Categoria categoria;

	
	
	public Producto(long id, String nombre, float precio, int existencias, Categoria categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.existencias = existencias;
		this.categoria = categoria;
	}
	
	

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getExistencias() {
		return existencias;
	}

	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", existencias=" + existencias
				+ ", categoria=" + categoria + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(categoria, existencias, id, nombre, precio);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(categoria, other.categoria) && existencias == other.existencias && id == other.id
				&& Objects.equals(nombre, other.nombre) && precio == other.precio;
	}
	
	
	
	
	

}
