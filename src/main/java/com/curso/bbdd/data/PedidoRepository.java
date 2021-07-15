package com.curso.bbdd.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.bbdd.beans.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
