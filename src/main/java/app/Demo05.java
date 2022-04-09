package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {
	public static void main(String[] args) {
		// eliminar versi�n 2 --> usando b�squeda
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		//empezo la transacci�n 
		em.getTransaction().begin();
		// proceso --> eliminar un usuario
		// Forma 1. borrado l�gico --> no lo borras, s�lo cambias alg�n estado flag
		
		// Forma 2. borrado f�sico --> borra
		Usuario u = em.find(Usuario.class, 13);
		if (u == null)
			System.out.println("C�DIGO NO EXISTE");
		else {
			em.remove(u);
			System.out.println("USUAARIO ELIMINADO........");
		}
		
		
		//confirmar la transacci�n
		em.getTransaction().commit();
		em.close();
	}
}
