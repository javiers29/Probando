package com.curso.bbdd.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ClaveDetalle implements Serializable {
	@Column(name = "idproducto")
	Long productoId;
	
	@Column(name = "idpedido")
	Long pedidoId;
}
