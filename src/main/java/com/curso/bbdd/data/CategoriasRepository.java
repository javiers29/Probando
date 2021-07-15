package com.curso.bbdd.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.bbdd.beans.Categoria;


@Repository
public interface CategoriasRepository extends JpaRepository<Categoria, Long> {
	


}
