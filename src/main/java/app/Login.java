package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Usuario;

public class Login {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		//Usuario u = (Usuario) consulta.getSingleResult();
		Query consulta = em.createNativeQuery("{call usp_validaAcceso(:usuario,:clave)}", Usuario.class);
		consulta.setParameter("usuario", "U001@gmail.com");
		consulta.setParameter("clave", "10001");
		
		
		
		/*if (u == null) {
			System.out.println("USUARIO NO EXISTE...");
			//System.out.println("BIENVENIDOS...");
		} else {
			System.out.println("BIENVENIDOS...");
			//System.out.println("USUARIO NO EXISTE...");
		}*/
		
		try {
			Usuario u = (Usuario) consulta.getSingleResult();
				//System.out.println("USUARIO NO EXISTE...");
			System.out.println("BIENVENIDOS...");
			
		} catch (Exception e) {
			//System.out.println("BIENVENIDOS...");
			System.err.println("USUARIO NO EXISTE...");
		}
		
		em.close();
	}
}
