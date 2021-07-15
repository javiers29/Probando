package com.curso.bbdd;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.curso.bbdd.beans.Categoria;
import com.curso.bbdd.beans.Cliente;
import com.curso.bbdd.beans.Pedido;
import com.curso.bbdd.beans.Producto;
import com.curso.bbdd.configuracion.Configuracion;
import com.curso.bbdd.data.CategoriasRepository;
import com.curso.bbdd.data.ClienteRepository;
import com.curso.bbdd.data.PedidoRepository;
import com.curso.bbdd.data.ProductoRepository;


@SpringBootApplication
public class BbddSpringJpa2Application {

	public static void main(String[] args) {
		ApplicationContext contexto;
		
		contexto = new AnnotationConfigApplicationContext(Configuracion.class);
		
		//Inicializamos los repositorios
		CategoriasRepository repositorioCat = contexto.getBean(CategoriasRepository.class);
		ProductoRepository repositorioProd = contexto.getBean(ProductoRepository.class);
		PedidoRepository repositorioPed = contexto.getBean(PedidoRepository.class);
		ClienteRepository repositorioCli = contexto.getBean(ClienteRepository.class);
		
		Optional <Categoria> cat = repositorioCat.findById((long) 2);
		System.out.println(cat);
		
		Categoria cat2 = null;
		Producto produc = null;
		Optional <Pedido> ped = null;
		
		
		//CATEGORIA
		try {
			cat2 = new Categoria(0,"embutidos");
			repositorioCat.save(cat2);
			System.out.println("Nueva categoria guardada en la BBDD correctamente");
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		
		
		//PRODUCTO
		try {
			produc = new Producto(0,"Salchichon",5F,100,cat2);
			
			repositorioProd.save(produc);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		
		repositorioCat.delete(cat2);
		System.out.println(produc.toString());
		List<Producto> productPrecio =  repositorioProd.findByPrecioBetween(0F,5F);	
		for(Producto pr : productPrecio)
			System.out.println("Los productos con el precio entre 0 y 5 euros son: " +pr);
			
		
		List<Producto> productExistencias =  repositorioProd.findByExistencias(0);	
		for(Producto prEx : productExistencias)
			System.out.println("No hay existencias de los siguientes productos: " + prEx);
		
		
		//pruebas consultas con nombre dentro de entity
//		EntityManager em = (EntityManager) Persistence.createEntityManagerFactory("es.curso.bbdd.beans.Producto");
//		TypedQuery<Producto> query = em.createNamedQuery("Producto.getProductosRango", Producto.class);
//		query.setParameter(1,20);
//		query.setParameter(2,50);
//		
//		List<Producto> produ = query.getResultList();
//		
//		for(Producto p : produ)
//			System.out.println("PRODUCTOS RANGO: " +p);
//		
		
		
		
		
		//PEDIDO
		try {
			
			System.out.println("PEDIDO 10248: " + repositorioPed.findById(10248L));
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		
		//CLIENTE
		try {
			
			List<Cliente> ClientePaises = repositorioCli.findByOrderByPaisAsc();
//			System.out.println("ORDENADO POR PAIS (ASC): " + repositorioCli.findByOrderByPaisAsc());
			for(Cliente pais : ClientePaises)
				System.out.println("ORDENADO POR PAIS (ASC): " + pais);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		
		
		try {
			
					
			List<Order> ordenacion =  Arrays.asList((new Order(Direction.ASC,"nombre")),( new Order(Direction.DESC,"pais")));
			
			List <Cliente> ordenacionDoble = repositorioCli.findAll(Sort.by(ordenacion));
			for(Cliente doble : ordenacionDoble)
				System.out.println("ORDENADO POR NOMBRE(ASC) Y PAIS(DESC): " + doble);
			Pageable pag = (Pageable) PageRequest.of(49, 2); 
			//pagina 49 de tamaño 2 en cada pagina (hay son 98 registros en BBDD)
			
			Page<Cliente> clientes = repositorioCli.findAll(pag);
			//hasContent() para ver si la pagina tiene contenido
			System.out.println("PAGINACION CLIENTES: " + clientes.getContent());
			
			
			//El metodo le hemos creado en el repository mediante una query
			//y filtra por idCliente o nombre (por eso puede haber uno de los dos 
			//parametros vacios y lo filtra igualmente
			System.out.println("BUSQUEDAS FILTRADAS POR ID O NOMBRE: " + repositorioCli.findByIdClienteOrNombre("SIMOB", ""));
			
			
			//nuevo
			System.out.println("BUSQUEDAS FILTRADAS POR PAIS: " + repositorioCli.findByPais("Canada"));
			
			//Filtrar con query nativa
			List <Cliente> FiltradoNoPedido = repositorioCli.findClienteNoPedido();
			for(Cliente noPedi : FiltradoNoPedido)
			System.out.println("CLIENTES SIN PEDIDOS: " + noPedi);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
			
			((AnnotationConfigApplicationContext)contexto).close();
	}
	
	

}
