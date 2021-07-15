package com.curso.bbdd.beans;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empresasenvios")
public class EmpresaEnvio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private long id;	
	private String nombre;
	
//	@OneToMany(mappedBy="id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private Set<Pedido> pedidos;  // 1 Empresa -> N Pedidos


	public EmpresaEnvio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpresaEnvio(long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	

//	public Set<Pedido> getPedidos() {
//		return pedidos;
//	}
//
//	public void setPedidos(Set<Pedido> pedidos) {
//		this.pedidos = pedidos;
//	}

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

	@Override
	public String toString() {
		return "EmpresaEnvio [id=" + id + ", nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpresaEnvio other = (EmpresaEnvio) obj;
		return id == other.id && Objects.equals(nombre, other.nombre);
	}
	
	
	
}
