package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {
	public static void main(String[] args) {
		// actualizar los datos de un usuario
		Usuario u = new Usuario(33,"Carla", "Toro", "U0022@gmail.com", "10002", "2022/03/24",2,1);
		
		// --> JPA
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		//empezo la transacción 
		em.getTransaction().begin();
		// proceso --> actualizar en la tabla entidad
		em.merge(u); //actualiza el código, sino lo inserta
		//confirmar la transacción
		em.getTransaction().commit();
		em.close();
	}
}
