package com.curso.bbdd.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.bbdd.beans.Producto;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
	List <Producto> findByPrecioBetween (float float1, float float2) ;
	
	List <Producto> findByExistencias (int existencias) ;
}
