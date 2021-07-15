package com.curso.bbdd.beans;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String idCliente;
	
	private String nombre;
	private String pais;
	
	
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Cliente(String idCliente, String nombre, String pais) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.pais = pais;
	}



	public String getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getPais() {
		return pais;
	}



	public void setPais(String pais) {
		this.pais = pais;
	}



	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", pais=" + pais + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(idCliente, nombre, pais);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(idCliente, other.idCliente) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(pais, other.pais);
	}
	
	

}
