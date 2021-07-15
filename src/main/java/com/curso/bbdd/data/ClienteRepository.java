package com.curso.bbdd.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.curso.bbdd.beans.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
	
	List<Cliente> findByOrderByPaisAsc();
	
	//select c from Clase where atributo=:
	
	@Query("select c from Cliente c where c.idCliente=:idcliente or c.nombre=:nombre")
	Cliente findByIdClienteOrNombre(@Param("idcliente") String idCliente, @Param("nombre") String nombre);
	
	
	//Obtener una lista de clientes de un pais
	@Query(value = "SELECT * FROM CLIENTES WHERE PAIS = ?",nativeQuery = true)
	List<Cliente> findByPais (String pais );
	
	//Obtener los categoria que NO tenga productos con query nativa:
	@Query (value= "select c.idcliente, c.nombre, c.pais from CLIENTES c where c.idcliente not in (select distinct idcliente from pedidos)",nativeQuery=true)
	List<Cliente> findClienteNoPedido();
	
}
