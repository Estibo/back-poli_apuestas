package dao;

import modelo.Usuario;
import jakarta.persistence.*;

import java.util.List;

public class UsuarioDAO {

   private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("poli_apuestasPU");

    public void insertar(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public List<Usuario> listar() {
        EntityManager em = emf.createEntityManager();
        List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
        em.close();
        return usuarios;
    }

    public void actualizar(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public void eliminar(int id) {
        EntityManager em = emf.createEntityManager();
        Usuario usuario = em.find(Usuario.class, id);
        if (usuario != null) {
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
        }
        em.close();
    }
}