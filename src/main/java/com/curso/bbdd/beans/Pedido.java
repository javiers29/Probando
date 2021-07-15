package com.curso.bbdd.beans;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {

	@Id
	private long idPedido;
	
	private float importe;
	private String pais;
	
	@ManyToOne(fetch= FetchType.LAZY, optional= false)
	@JoinColumn(name="idpedido", nullable = false)
	private Pedido pedido;
	
	@ManyToOne(fetch= FetchType.LAZY, optional= false)
	@JoinColumn(name="idcliente", nullable = false)
	private Cliente cliente;
	
	@ManyToOne(fetch= FetchType.LAZY, optional= false)
	@JoinColumn(name="idempresaenvio", nullable = false)
	private EmpresaEnvio empresaenvio;

	
	
	
	public Pedido(long idPedido, float importe, String pais) {
		super();
		this.idPedido = idPedido;
		this.importe = importe;
		this.pais = pais;
	}
	
	

	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}



	public long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public EmpresaEnvio getEmpresaenvio() {
		return empresaenvio;
	}

	public void setEmpresaenvio(EmpresaEnvio empresaenvio) {
		this.empresaenvio = empresaenvio;
	}




	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", importe=" + importe + ", pais=" + pais + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(cliente, empresaenvio, idPedido, importe, pais, pedido);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(empresaenvio, other.empresaenvio)
				&& Objects.equals(idPedido, other.idPedido)
				&& Float.floatToIntBits(importe) == Float.floatToIntBits(other.importe)
				&& Objects.equals(pais, other.pais) && Objects.equals(pedido, other.pedido);
	}
	
	
	
	
}
