package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {
	public static void main(String[] args) {
		// eliminar versión 2 --> usando búsqueda
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		//empezo la transacción 
		em.getTransaction().begin();
		// proceso --> eliminar un usuario
		// Forma 1. borrado lógico --> no lo borras, sólo cambias algún estado flag
		
		// Forma 2. borrado físico --> borra
		Usuario u = em.find(Usuario.class, 13);
		if (u == null)
			System.out.println("CÓDIGO NO EXISTE");
		else {
			em.remove(u);
			System.out.println("USUAARIO ELIMINADO........");
		}
		
		
		//confirmar la transacción
		em.getTransaction().commit();
		em.close();
	}
}
